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

public class CrearParqueadero {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^da clic en Parqueaderos$")
    public void daClicEnParqueaderos() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^da clic en crear Parqueadero$")
    public void daClicEnCrearParqueadero() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Crear Parqueadero$")
    public void elSistemaPresentaFormularioCrearParqueadero() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza el formulario$")
    public void enCrearParqueaderoVisualizaElFormulario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza campo tipo de parqueadero$")
    public void enCrearParqueaderoVisualizaCampoTipoDeParqueadero() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza campo agrupacion$")
    public void enCrearParqueaderoVisualizaCampoAgrupacion() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza campo unidad independiente$")
    public void enCrearParqueaderoVisualizaCampoUnidadIndependiente() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza campo numero de parqueadero$")
    public void enCrearParqueaderoVisualizaCampoNumeroDeParqueadero() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza campo tipo de vehiculo$")
    public void enCrearParqueaderoVisualizaCampoTipoDeVehiculo() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En crear Parqueadero visualiza boton de guardar bloqueado$")
    public void enCrearParqueaderoVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""), isNotEnabled()));
    }

    @When("^En crear Parqueadero da clic en (.*)$")
    public void enCrearParqueaderoDaClicEnCampo_requerido(String campo) {
        switch (campo) {
            case "tipo":
                actor.attemptsTo(Click.on(""));
                break;
            case "agrupacion":
                actor.attemptsTo(Click.on(" "));
                break;
            case "unidad independiente":
                actor.attemptsTo(Click.on("  "));
                break;
            case "numero de parqueadero":
                actor.attemptsTo(Click.on("   "));
                break;
            case "tipo de vehiculo":
                actor.attemptsTo(Click.on("     "));
                break;
        }
    }

    @And("^En crear Parqueadero da clic en el boton guardar$")
    public void enCrearParqueaderoDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En crear Parqueadero se presenta mensaje indicando que el campo es requerido$")
    public void enCrearParqueaderoSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @When("^En crear Parqueadero ingresa o selecciona informacion en los campos (.*) (.*) (.*) (.*) y (.*)$")
    public void seleccionaInformacionEnTipoAgrupacionUnidadNumeroYVehiculo(String tipo, String agrupacion, String unidad, String numero, String vehiculo) {

        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(tipo)));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(agrupacion)));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(unidad)));
        actor.attemptsTo(Enter.theValue(numero).into(""));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(vehiculo)));
    }

    @Then("^En crear Parqueadero sistema presenta (.*) el boton de guardar$")
    public void enCrearParqueaderoSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado) {
            case "si":
                actor.should(seeThat(the(""), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""), isNotEnabled()));
                break;
        }
    }

    @When("^En crear Parqueadero Ingresa o selecciona en el (.*) del formulario un (.*)$")
    public void enCrearParqueaderoIngresaOSeleccionaEnElCampoDelFormularioUnValor(String campo, String valor) {
        switch (campo) {
            case "tipo":
                actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(valor)));
                break;
            case "agrupacion":
                actor.attemptsTo(Click.on(By.cssSelector(" "), By.linkText(valor)));
                break;
            case "unidad independiente":
                actor.attemptsTo(Click.on(By.cssSelector("  "), By.linkText(valor)));
                break;
            case "numero de parqueadero":
                actor.attemptsTo(Enter.theValue(valor).into(""));
                break;
            case "tipo de vehiculo":
                actor.attemptsTo(Click.on(By.cssSelector("   "), By.linkText(valor)));
                break;
        }
    }

    @Then("^En crear Parqueadero El sistema muestra el (.*)$")
    public void enCrearParqueaderoElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^En crear Parqueadero da clic en boton guardar$")
    public void enCrearParqueaderoDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En crear Parqueadero sistema presenta el (.*) de exito o error$")
    public void enCrearParqueaderoSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje) {
            case "exito":
                actor.should(new QuestionValidate("Parqueadero creado exitosamente").Execute(new GeneralParams(
                        "Parqueadero creada exitosamente",
                        "//p[contains(text(),'correo')] "
                )));
                break;
            case "existente":
                actor.should(new QuestionValidate("Parqueadero existente").Execute(new GeneralParams(
                        "Parqueadero ya existente",
                        "/)] "
                )));
                break;
        }
    }
}
