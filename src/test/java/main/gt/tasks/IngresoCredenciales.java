package main.gt.tasks;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.function.Predicate;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class IngresoCredenciales {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @When("^Usuario ingresar información de usuario de (.*) y (.*)$")
    public void ingresarUsuario(String usuario, String contrasena) throws InterruptedException {

        actor.attemptsTo(Enter.theValue(usuario).into("//input[@id='userName']"));
        actor.attemptsTo(Enter.theValue(contrasena).into("//input[@id='password']"));
        Thread.sleep(5000);
    }

    @Then("El sistema (.*) presenta habilitado el botón de ingresar")
    public void botonHabilitado(String habilitado) {

        switch (habilitado) {
            case "no":
                actor.should(seeThat(WebElementQuestion.the("//input[@id='buttonLogin']"), WebElementStateMatchers.isNotCurrentlyEnabled()));
                break;
            case "si":
                actor.should(seeThat(WebElementQuestion.the("//input[@id='buttonLogin']"), WebElementStateMatchers.isEnabled()));
                break;
        }

    }

    @And("^Ingresa$")
    public void ingresar() throws InterruptedException {
        actor.attemptsTo(
                MoveMouse.to("//input[@id='buttonLogin']").andThen(Actions::click));
        Thread.sleep(5000);
    }


    @Then("^El sistema presenta la página después del ingreso con la (.*)$")
    public void ingresoExitoso(String informacion) {
        switch (informacion) {
            case "Selector de Unidades":
                actor.should(seeThat(the("//h2[@id='sesion']"),hasValue("Selector de Unidades")));

                break;
            case "Pagina principal":
                actor.should(seeThat(the("//h1[@id='h--title-name-rol']"),hasValue("Administración de Roles")));
                break;
        }

    }

    @When("Ingresa 5 veces información de usuario y de contrasena errada")
    public void ingresoCredencialesErradas() throws InterruptedException {

        actor.attemptsTo(Enter.keyValues("abloquear").into("//input[@id='userName']"));

        actor.attemptsTo(Enter.keyValues("contrasenaerrada").into("//input[@id='password']"));

        for (int i = 0; i <= 5; i++) {
            try {
                actor.attemptsTo(MoveMouse.to("//input[@id='buttonLogin']").andThen(Actions::click));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            Thread.sleep(2000);
        }
        Thread.sleep(5000);
    }

    @Then("Visualmente se informa que el usuario está bloqueado")
    public void usuarioBloqueado() {
        actor.should(seeThat(the("//div[@id='locked_user_lock']"),isVisible()));
    }


    @Then("^El sistema un mensaje de error (.*)$")
    public void elSistemaUnMensajeDeErrorMensaje(String mensaje) {
        switch (mensaje) {
            case ("Inactivo"):
                actor.should(seeThat(the("//div[@id='locked_user_inactive']"), isVisible()));
                break;
            case ("Invalido"):
                actor.should(seeThat(the("//mat-error[@id='error_login_1_bad_credentials']"), isVisible()));
                break;
            case ("Bloqueado"):
                actor.should(seeThat(the("//div[@id='locked_user_lock']"), isVisible()));
                break;
        }
    }


    @Then("^El sistema presenta la página Administracion de roles$")
    public void elSistemaPresentaLaPaginaAdministracionDeRoles() {
        actor.should(seeThat(the("//h1[@id='h--title-name-rol']"), isVisible()));
        actor.should(seeThat(the("//h1[@id='h--title-name-rol']"), Predicate.isEqual("Administración de Roles")));
    }

}
