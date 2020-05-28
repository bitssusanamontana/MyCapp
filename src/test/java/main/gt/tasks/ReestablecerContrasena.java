package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ReestablecerContrasena {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Given("^Un usuario en la página de reestablecer contrasena$")
    public void ingresarAPaginaReestablecer() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.attemptsTo(Open.url("https://app-frontresidentialcomplex-dev-001.azurewebsites.net/account/restore-password/7T%2BmX1gJSUaj12NLEvtP4lFmJwPcuAYbEpiOilgqTvqyvsV0Dxv6VHQHcVlKK6bc"));
    }

    @When("^En formulario de restablecer contrasena Da clic en el campo requerido (.*) y da clic$")
    public void campoRequerido(String Campo) {
        switch (Campo) {
            case "Nueva contrasena":
                actor.attemptsTo(Enter.theValue("").into("#password"));
                actor.attemptsTo(Enter.theValue("").into("#confirmPassword"));
                break;
            case "Confirmacion contrasena":
                actor.attemptsTo(Enter.theValue("").into("#confirmPassword"));
                actor.attemptsTo(Enter.theValue("").into("#password"));
                break;
        }

    }

    @And("^No ingresa informacion en el campo y da clic por fuera$")
    public void clicFueraCampo() {
        actor.attemptsTo(
                Click.on("//button[@id='restore']"));
    }

    @Then("^Se muestra un mensaje de error del campo requerido (.*)$")
    public void mensajeCampoRequerido(String requerido) {
        switch (requerido) {
            case "contrasena requerida":
                actor.should(new QuestionValidate("* El campo es requerido.").Execute(new GeneralParams(
                        "campo requerido",
                        "campo requerido",
                        "#text3"
                )));
                break;
            case "confirmacion requerida":
                actor.should(new QuestionValidate("* El campo es requerido.").Execute(new GeneralParams(
                        "campo requerido",
                        "campo requerido",
                        "#text9"
                )));
                break;
        }

    }

    @When("^Ingresa la (.*) en el campo nueva contrasena$")
    public void ingresaNuevaContrasena(String nuevaContrasena) {
        actor.attemptsTo(Enter.keyValues(nuevaContrasena).into("//input[@id='password']"));

    }

    @Then("^El sistema informa que la nueva contraseña ingresada cumple con las reglas$")
    public void cumpleReglas() {
        actor.should(seeThat(the("#text1"), isVisible()));
    }

    @When("^Ingresa (.*) y la confirmación (.*)$")
    public void ingresaContrasenaYConfirmacionContrasena(String contrasena, String confirmacionContrasena) {
        actor.attemptsTo(Enter.keyValues(contrasena).
                into("#password"));
        actor.attemptsTo(Enter.keyValues(confirmacionContrasena).
                into("#confirmPassword"));

    }

    @Then("^El sistema informa que la confirmación de la contraseña ingresada cumple con las reglas$")
    public void cumpleReglasConfirmacion() {

        actor.should(seeThat(the("#text6"), isVisible()));
    }

    @When("Coloca el cursor encima del icono de check o x")
    public void clicIcono() {
        actor.attemptsTo(
                MoveMouse.to("#text6"));
    }

    @Then("^El sistema muestra el mensaje de restablecimiento exitoso$")
    public void mensajeIcono() {
        actor.should(seeThat(the("#text12"), isVisible()));
    }

    @When("^Da clic en el botón reestablecer$")
    public void clicBotonReestablecer() {
        actor.attemptsTo(
                Click.on(" //button[@id='restore']"));
    }

    @And("^Da clic en el botón Finalizar$")
    public void clicBotonFinalizar() {
        actor.attemptsTo(
                Click.on("//button[@class='button']"));
    }


    @Then("^Se muestra un mensaje de error de ingreso de la contraseña (.*)$")
    public void seMuestraUnMensajeDeErrorDeIngresoDeLaContrasenaMensaje(String mensaje) {
        switch (mensaje) {
            case "cumplen":
                actor.should(seeThat(the("#text6"), isVisible()));
                break;
            case "no coinciden":
                actor.should(seeThat(the("#text7"), isVisible()));
                break;
            case "no cumplen":
                actor.should(seeThat(the("#text2"), isVisible()));
                break;
        }
    }
}
