package main.gt.tasks;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AgregarAnotacion {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic sobre el botón Agregar Anotación$")
    public void daClicAgregarAnotacion() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'agregar anotacion')]").andThen(Actions::click));
    }

    @Then("^Se visualiza formulario agregar anotacion$")
    public void seVisualizaFormularioAgregarAnotacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Label AGREGAR ANOTACION$")
    public void visualizaLabelAGREGARANOTACION() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Tipo$")
    public void visualizaCampoTipo() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Historial de anotaciones$")
    public void visualizaCampoHistorialDeAnotaciones() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo de texto Agregar anotacion$")
    public void visualizaCampoDeTextoAgregarAnotacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Foto del Usuario del registro$")
    public void fotoDelUsuarioDelRegistro() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @When("^Ingresa (.*) en el campo anotacion$")
    public void ingresaInformacionEnElCampoAnotacion(String informacion) {
        actor.attemptsTo(Enter.keyValues(informacion).into("//input[@id='anotacion']"));
    }

    @And("^Se da clic por fuera del campo$")
    public void seDaClicPorFueraDelCampo() {
        MoveMouse.to("//a[contains(text(),'clic fuera')]").andThen(Actions::click);
    }

    @Then("^se presenta el (.*)$")
    public void sePresentaElResultado(String resultado) {
        actor.should(seeThat(the("//input[@id='idEmail']"), Predicate.isEqual(resultado)));
           }

    @And("^el boton guardar (.*)$")
    public void elBotonGuardarHabilitado(String habilitado) {
        switch (habilitado) {
            case ("si"):
                actor.should(seeThat(the("/button[@name='action']"), isEnabled()));
                break;
            case ("no"):
                actor.should(seeThat(the("/button[@name='action']"), isNotEnabled()));
                break;
        }
    }

    @When("^El usuario ingresa una anotacion$")
    public void elUsuarioIngresaUnaAnotacion() {
        actor.attemptsTo(Enter.keyValues("Anotación 1").into("//input[@id='anotacion']"));
    }

    @Then("^Se visualiza el mensaje de anotacion exitosa$")
    public void seVisualizaElMensajeDeAnotacionExitosa() {
        actor.should(seeThat(the("//input[@id='idEmail']"), Predicate.isEqual("Anotación exitosa")));
    }
}
