package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RecuperarContrasena {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }
    @When("Da clic en el enlace ¿Olvidaste tu contrasena?")
    public void clicOlvitasteContrasena() throws InterruptedException {
        actor.attemptsTo(Click.on("#forget"));
        Thread.sleep(1000);
    }
    @When("Da clic en el botón volver")
    public void clicBotonVolver(){
        actor.attemptsTo(Click.on("//div[@class='align_icon_content']"));
    }
    @Then("El sistema presenta la página de autenticación de la aplicación")
    public void paginaAtenticacion(){

        actor.should(seeThat(the("#sesion"), isVisible()));
    }
    @And("Ingresa información de (.*) en el campo de usuario")
    public void ingresaUsuario(String usuario) {
        actor.attemptsTo(Enter.keyValues(usuario).into("#mailOrDocument"));

    }
    @Then("El sistema presenta habilitado el botón Enviar")
    public void botonEnviarHabilitado(){

        actor.should(seeThat(the("#buttonRecover"), isEnabled()));
    }


    @When("Da clic en el boton Enviar")
    public void clicBotonEnviar() throws InterruptedException {
        actor.attemptsTo(
                MoveMouse.to("#buttonRecover").andThen(Actions::click));
        Thread.sleep(3000);
    }
    @Then("El sistema presenta el mensaje (.*)")
    public void mensajeEnvio(String mensaje) throws InterruptedException {
        switch (mensaje){
            case ("Invalido"):

                actor.should(new QuestionValidate("Documento o correo electrónico invalido").Execute(new GeneralParams(
                        "usuario invalido",
                        "#error_recovery_docu_mail_error"
                )));

                break;
            case ("Inactivo"):

                actor.should(new QuestionValidate("El usuario no se encuentra activo.").Execute(new GeneralParams(
                    "usuario inactivo",
                    "#error_recovery_user_inactive"
            )));

            case ("Exitoso"):
                Thread.sleep(2000);
                actor.should(new QuestionValidate("Debes tener un nuevo email en tu correo electrónico susana.montana@bitsamericas.com para que puedas restablecer la contraseña").Execute(new GeneralParams(
                        "usuario inactivo",
                        "#recover_description_2"
                )));

                break;
        }
    }
    @And("El sistema borra la información del campo usuario")
    public void campoUsuarioVacio(){
        actor.should(seeThat(the("#mailOrDocument"), hasValue("")));

    }
    @And("El usuario visualiza el mensaje de exito")
    public void mensajeExito() throws InterruptedException {
        Thread.sleep(2000);
        actor.should(new QuestionValidate("Debes tener un nuevo email en tu correo electrónico susana.montana@bitsamericas.com para que puedas restablecer la contraseña").Execute(new GeneralParams(
                "usuario inactivo",
                "#recover_description_2"
        )));
    }


    @And("^El sistema presenta inhabilitado el botón Enviar$")
    public void elSistemaPresentaInhabilitadoElBotonEnviar() {
        actor.should(seeThat(the("#buttonRecover"), isNotEnabled()));
    }

    @When("^Da clic en usuario$")
    public void daClicEnUsuario() {
        actor.attemptsTo(
                MoveMouse.to("#mailOrDocument").andThen(Actions::click));
    }


    @And("^Visualiza Label Recuperar contraseña$")
    public void visualizaLabelRecuperarContrasena() {

        actor.should(seeThat(the("#recoverpasssword"), isVisible()));
    }

    @And("^Visualiza Label Ingresa tu documento o correo$")
    public void visualizaLabelIngresaTuDocumentoOCorreo() {
        actor.should(seeThat(the("#recover_description_1"), isVisible()));
    }

    @And("^Visualiza Campo tipo texto$")
    public void visualizaCampoTipoTexto() {

        actor.should(seeThat(the("#mailOrDocument"), isVisible()));
    }

    @And("^Visualiza Icono de ayuda$")
    public void visualizaIconoDeAyuda() {

        actor.should(seeThat(the("#help"), isVisible()));
    }

    @And("^Visualiza El boton Enviar$")
    public void visualizaElBotonEnviar() {

        actor.should(seeThat(the("#buttonRecover"), isVisible()));
    }

    @And("^Visualiza Boton volver$")
    public void visualizaBotonVolver() {

        actor.should(seeThat(the("#return"), isVisible()));
    }

    @When("^Da clic en icono de ayuda$")
    public void daClicEnIconoDeAyuda() {
        actor.attemptsTo(
                MoveMouse.to("#help").andThen(Actions::click));
    }

    @Then("^Se muestra un pop up con el mensaje de ayuda$")
    public void seMuestraUnPopUpConElMensajeDeAyuda() {
        actor.should(seeThat(the("//div[@class='tooltip_content']"), isVisible()));
    }
}
