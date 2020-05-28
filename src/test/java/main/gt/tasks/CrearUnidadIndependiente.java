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
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class CrearUnidadIndependiente {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^clic en agrupador deseado$")
    public void clicEnAgrupadorDeseado() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^da clic en crear unidad independiente$")
    public void daClicEnCrearUnidadIndependiente() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Crear unidad independiente$")
    public void elSistemaPresentaFormularioCrearUnidadIndependiente() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear unidad independiente visualiza el formulario$")
    public void enCrearUnidadIndependienteVisualizaElFormulario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear unidad independiente visualiza campo nombre unidad independiente$")
    public void enCrearUnidadIndependienteVisualizaCampoNombreUnidadIndependiente() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear unidad independiente visualiza campo numero de catastro$")
    public void enCrearUnidadIndependienteVisualizaCampoNumeroDeCatastro() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear unidad independiente visualiza campo numero de metros cuadrados$")
    public void enCrearUnidadIndependienteVisualizaCampoNumeroDeMetrosCuadrados() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear unidad independiente visualiza boton de guardar bloqueado$")
    public void enCrearUnidadIndependienteVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""),isNotEnabled()));
    }

    @When("^En crear unidad independiente ingresa al campo (.*) unidad independiente$")
    public void enCrearUnidadIndependienteIngresaAlCampoNombreUnidadIndependiente(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
    }

    @And("^En crear unidad independiente ingresa al campo (.*) de catastro$")
    public void enCrearUnidadIndependienteIngresaAlCampoNumeroDeCatastro(String numero) {
        actor.attemptsTo(Enter.theValue(numero).into(""));
    }

    @And("^En crear unidad independiente ingresa al campo (.*) cuadrados$")
    public void enCrearUnidadIndependienteIngresaAlCampoMetrosCuadrados(String metros) {
        actor.attemptsTo(Enter.theValue(metros).into(""));
    }

    @Then("^En crear unidad independiente sistema presenta (.*) el boton de guardar$")
    public void enCrearUnidadIndependienteSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(""),isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""),isNotEnabled()));
                break;
        }
    }

    @When("^En crear unidad independiente Ingresa en el (.*) del formulario un (.*)$")
    public void enCrearUnidadIndependienteIngresaEnElCampoDelFormularioUnValor(String campo, String valor) {
        switch (campo){
            case "nombre":
                actor.attemptsTo(Enter.theValue(valor).into(""));
                break;
            case "catastro":
                actor.attemptsTo(Enter.theValue(valor).into(" "));
                break;
            case "metros":
                actor.attemptsTo(Enter.theValue(valor).into("  "));
                break;
        }
    }

    @Then("^En crear unidad independiente El sistema muestra el (.*)$")
    public void enCrearUnidadIndependienteElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "muestra resultado",
                ""
        )));
    }

    @When("^En crear unidad independiente ingresa al campo (.*), (.*) y (.*) de unidad independiente$")
    public void enCrearUnidadIndependienteIngresaAlCampoNombreCatastroYMetrosDeUnidadIndependiente(String nombre, String catastro, String metros) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(catastro).into(""));
        actor.attemptsTo(Enter.theValue(metros).into(""));
    }

    @And("^En crear unidad independiente da clic en boton guardar$")
    public void enCrearUnidadIndependienteDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En crear unidad independiente sistema presenta el (.*) de éxito o error$")
    public void enCrearUnidadIndependienteSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje){
            case "exito":
                actor.should(new QuestionValidate("Unidad Independiente Creada exitosamente").Execute(new GeneralParams(
                        "muestra resultado",
                        ""
                )));
                break;
            case "existente":
                actor.should(new QuestionValidate("Unidad Independiente ya existente").Execute(new GeneralParams(
                        "muestra resultado",
                        ""
                )));
                break;
        }
    }

    @When("^En crear unidad independiente da clic en (.*)$")
    public void enCrearUnidadIndependienteDaClicEnCampo_requerido(String campo) {
        switch (campo){
            case "nombre":
                actor.attemptsTo(Click.on(""));
                break;
            case "catastro":
                actor.attemptsTo(Click.on(" "));
                break;
            case "metros":
                actor.attemptsTo(Click.on("  "));
                break;
        }
    }

    @And("^En crear unidad independiente da clic en el boton guardar$")
    public void enCrearUnidadIndependienteDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on("  "));
    }

    @Then("^En crear unidad independiente se presenta mensaje indicando que el campo es requerido$")
    public void enCrearUnidadIndependienteSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(seeThat(the(""), isVisible()));
    }
}
