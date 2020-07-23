package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.function.Predicate;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class HeaderCambiarContrasena {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @Given("^Un usuario da clic sobre la foto de perfil$")
    public void unUsuarioDaClicSobreLaFotoDePerfil() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^Da clic en la opcion Cambiar contrasena$")
    public void daClicEnLaOpcionCambiarContrasena() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta una ventana emergente$")
    public void elSistemaPresentaUnaVentanaEmergente() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Presenta el campo Nueva contrasena habilitado sin informacion$")
    public void presentaElCampoNuevaContrasenaHabilitadoSinInformacion() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo Contrasena actual habilitado sin informacion$")
    public void presentaElCampoContrasenaActualHabilitadoSinInformacion() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo Confirmar contrasena habilitado sin informacion$")
    public void presentaElCampoConfirmarContrasenaHabilitadoSinInformacion() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el boton de Cambiar bloqueado$")
    public void presentaElBotonDeCambiarBloqueado() {
        actor.should(seeThat(the("//button[@name='action']"), isNotEnabled()));
    }

    @And("^Presenta la opcion de Cerrar la ventana emergente$")
    public void presentaLaOpcionDeCerrarLaVentanaEmergente() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el boton de Cancelar$")
    public void presentaElBotonDeCancelar() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @When("^Da clic sobre la opción de cerrar$")
    public void daClicSobreLaOpcionDeCerrar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en botón cerrar",
                "Boton cerrar",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema cierra la ventana emergente$")
    public void elSistemaCierraLaVentanaEmergente() {
        actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
    }

    @And("^No actualiza la información de la contraseña$")
    public void noActualizaLaInformacionDeLaContrasena() {
        actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
    }

    @And("^Deja al usuario en la página actual$")
    public void dejaAlUsuarioEnLaPaginaActual() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @When("^Da clic en (.*) y No ingresa información$")
    public void daClicEnCampo_requerido(String campo_requerido) {
        switch (campo_requerido) {
            case "Contrasena actual":
                actor.attemptsTo(Enter.theValue("").into(""));
                break;
            case "Nueva Contrasena":
                actor.attemptsTo(Enter.theValue("").into(" "));
                break;
            case "Confirmacion Contrasena":
                actor.attemptsTo(Enter.theValue("").into("  "));
                break;
        }
    }

    @Then("^El sistema presenta un indicando que el campo es requerido$")
    public void elSistemaPresentaUnIndicandoQueElCampoEsRequerido() {
        actor.should(new QuestionValidate("Campo requerido").Execute(new GeneralParams(
                "Mensaje de campo obligatorio",
                "campo obligatorio",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^Da clic en contrasena actual$")
    public void daClicEnContrasenaActual() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^Ingresa una (.*)$")
    public void ingresaUnaContrasenaActual(String contrasenaActual) {
        actor.attemptsTo(Enter.theValue(contrasenaActual).into(""));
    }

    @Then("^El sistema muestra un (.*) y se muestra un mensaje$")
    public void elSistemaMuestraUnResultado(String resultado) {
        if (resultado.equals("Check correcto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(Click.on(""));
            actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("La contrasena actual es correcta")));
        } else if (resultado.equals("Check incorrecto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(Click.on(""));
            actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("La contrasena actual es incorrecta")));
        }
    }

    @When("^Ingresa nueva contrasena (.*)$")
    public void ingresaNuevaContrasenaNuevaContrasena(String nuevaContrasena) {
        actor.attemptsTo(Enter.theValue(nuevaContrasena).into(""));
    }

    @Then("^El sistema muestra el (.*) y se muestra un mensaje$")
    public void elSistemaMuestraElResultadoYSeMuestraUnMensaje(String resultado) {
        if (resultado.equals("Check correcto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(Click.on(""));
            actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("La nueva contrasena cumple las reglas")));
        } else if (resultado.equals("Check incorrecto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(Click.on(""));
            actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("La nueva contrasena no cumple con las reglas")));
        }
    }

    @And("^Confirmacion de contrasena ingresada (.*)$")
    public void ingresaLaConfirmacionContrasena(String confirmacionContrasena) {
        actor.attemptsTo(Enter.theValue(confirmacionContrasena).into(""));
    }

    @Then("^Se muestra el (.*) y Se pasa el cursor por el check y se muestra un mensaje$")
    public void seMuestraElResultadoYSePasaElCursorPorElCheckYSeMuestraUnMensaje(String resultado) {
        if (resultado.equals("Check correcto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(Click.on(""));
            actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("Las contraseñas coinciden")));
        } else if (resultado.equals("Check incorrecto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(Click.on(""));
            actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("Las contraseñas no coinciden")));
        }
    }

    @When("^Se ingresan datos correctos para cambiar la contrasena$")
    public void seIngresanDatosCorrectosParaCambiarLaContrasena() {
        //Ingresa contraseña actual
        actor.attemptsTo(Enter.theValue("").into(""));
        //Ingresa contraseña nueva
        actor.attemptsTo(Enter.theValue("").into(""));
        //Ingresa confirmación de contraseña
        actor.attemptsTo(Enter.theValue("").into(""));
    }

    @Then("^Se habilita el boton de guardar$")
    public void seHabilitaElBotonDeGuardar() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Se da clic en el boton guardar$")
    public void seDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^Se muestra el mensaje de cambio exitoso$")
    public void seMuestraElMensajeDeCambioExitoso() {
        actor.should(new QuestionValidate("Cambio de Contraseña Exitoso").Execute(new GeneralParams(
                "Mensaje de Cambio de Contraseña Exitoso",
                "Cambio de Contraseña Exitoso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^(.*) Se habilita el boton guardar$")
    public void sionoSeHabilitaElBotonGuardar(String SioNo) {
        switch (SioNo){
            case "Si":
                actor.should(seeThat(the("//button[@name='action']"), isVisible()));
                break;
            case "No":
                actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
                break;
        }
    }
}



