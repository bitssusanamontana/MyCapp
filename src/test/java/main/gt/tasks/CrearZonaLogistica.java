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
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class CrearZonaLogistica {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @And("^Da clic en Administrar Zonas Logisticas$")
    public void daClicENAdministrarZonasLogisticas() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Da clic sobre Crear Zona Logistica$")
    public void daClicSobreCrearZonaLogistica() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^El usuario visualiza el label de Zona Logistica$")
    public void elUsuarioVisualizaElLabelDeZonaLogistica() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo Selector Tipo Unidad Logistica$")
    public void elUsuarioVisualizaElCampoSelectorTipoUnidadLogistica() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo Nombre Unidad Logistica$")
    public void elUsuarioVisualizaElCampoNombreUnidadLogistica() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo Ubicacion Unidad Logistica$")
    public void elUsuarioVisualizaElCampoUbicacionUnidadLogistica() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @Then("^El usuario visualiza el mensaje de salir de Crear Unidad Logistica$")
    public void elUsuarioVisualizaElMensajeDeSalirDeCrearUnidadLogistica() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @When("^En Unidad Logistica Da clic en el (.*)$")
    public void enUnidadLogisticaDaClicEnElCampo_requerido(String campo_requerido) {
        switch (campo_requerido) {
            case "Tipo Unidad Logistica":
                actor.attemptsTo(Click.on(""));
                break;
            case "Nombre":
                actor.attemptsTo(Click.on(" "));
                break;
            case "Ubicacion":
                actor.attemptsTo(Click.on("  "));
                break;
        }
    }

    @Then("^En unidad logistica el sistema presenta mensaje de Campo requerido$")
    public void enUnidadLogisticaElSistemaPresentaMensajeDeCampoRequerido() {
        actor.should(new QuestionValidate("Campo requerido").Execute(new GeneralParams(
                "Mensaje de Campo requerido",
                "Campo requerido",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En unidad logistica ingresa el (.*) en el campo$")
    public void enUnidadLogisticaIngresaElNombreEnElCampo(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
    }

    @Then("^En unidad logistica el sistema muestra un (.*)$")
    public void enUnidadLogisticaElSistemaMuestraUnResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "resultado",
                "resultado",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En unidad logistica ingresa informacion en el campo (.*) y (.*)$")
    public void enUnidadLogisticaIngresaInformacionEnElCampoNombreYUbicacion(String nombre, String ubicacion) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(ubicacion).into(""));
    }

    @And("^Selecciona del campo (.*)$")
    public void seleccionaDelCampoTipo(String tipo) {
        actor.attemptsTo(Click.on(By.cssSelector("#menuTipo"), By.linkText(tipo)));
    }

    @And("^En unidad logistica Selecciona el campo (.*)$")
    public void enUnidadLogisticaSeleccionaElCampoTipo(String tipo) {
        actor.attemptsTo(Click.on(By.cssSelector("#menuTipo"), By.linkText(tipo)));
    }

    @Then("^En unidad logistica se presenta un (.*)$")
    public void enUnidadLogisticaSePresentaUnResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "resultado",
                "resultado",
                "//p[contains(text(),'correo')] "
        )));
    }
}
