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

public class CrearAgrupador {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Se visualiza la pagina Administracion de Unidades Inmobiliarias$")
    public void seVisualizaLaPaginaAdministracionDeUnidadesInmobiliarias() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Se da clic en el nombre de la Unidad Bits$")
    public void seDaClicEnElNombreDeLaUnidadBits() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^da clic en Crear agrupador$")
    public void daClicEnCrearAgrupador() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Crear Agrupador$")
    public void elSistemaPresentaFormularioCrearAgrupador() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear agrupador visualiza el formulario$")
    public void enCrearAgrupadorVisualizaElFormulario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear agrupador visualiza campo nombre agrupador$")
    public void enCrearAgrupadorVisualizaCampoNombreAgrupador() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear agrupador visualiza campo numero de unidades independientes$")
    public void enCrearAgrupadorVisualizaCampoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear agrupador visualiza boton de guardar bloqueado$")
    public void enCrearAgrupadorVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""),isNotEnabled()));
    }

    @When("^En crear agrupador da clic en (.*)$")
    public void enCrearAgrupadorDaClicEnCampo_requerido(String campo) {
        actor.attemptsTo(Click.on(campo));
    }

    @And("^En crear agrupador da clic en el boton guardar$")
    public void enCrearAgrupadorDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En crear agrupador se presenta mensaje indicando que el campo es requerido$")
    public void enCrearAgrupadorSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(new QuestionValidate("Campo Obligatorio").Execute(new GeneralParams(
                "Campo Obligatorio",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En crear agrupador ingresa al campo (.*) agrupacion$")
    public void enCrearAgrupadorIngresaAlCampoNombreAgrupacion(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
    }

    @And("^En crear agrupador ingresa al campo (.*) de unidades$")
    public void enCrearAgrupadorIngresaAlCampoNumeroDeUnidades(String numero) {
        actor.attemptsTo(Enter.theValue(numero).into(""));
    }

    @Then("^En crear agrupador sistema presenta (.*) el boton de guardar$")
    public void enCrearAgrupadorSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(""), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""), isNotEnabled()));
                break;
        }

    }

    @When("^En crear agrupador Ingresa un (.*) para el campo numero de unidades independientes$")
    public void enCrearAgrupadorIngresaUnValorParaElCampoNumeroDeUnidadesIndependientes(String valor) {
        actor.attemptsTo(Enter.theValue(valor).into(""));
    }

    @Then("^En crear agrupador El sistema muestra el (.*)$")
    public void enCrearAgrupadorElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^En crear agrupador el usuario Da clic en el campo Nombre Agrupador$")
    public void enCrearAgrupadorElUsuarioDaClicEnElCampoNombreAgrupador() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^En crear agrupador Ingresa un (.*) para el campo nombre de agrupador$")
    public void enCrearAgrupadorIngresaUnValorParaElCampoNombreDeAgrupador(String valor) {
        actor.attemptsTo(Enter.theValue(valor).into(""));
    }

    @Then("^En crear agrupador El sistema muestra (.*)$")
    public void enCrearAgrupadorElSistemaMuestraResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En crear agrupador ingresa al campo (.*) y (.*) de agrupador$")
    public void enCrearAgrupadorIngresaAlCampoNombreYNumeroDeAgrupador(String nombre, String numero) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(numero).into(""));
    }

    @And("^En crear agrupador da clic en boton guardar$")
    public void enCrearAgrupadorDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En crear agrupador sistema presenta el (.*) de éxito o error$")
    public void enCrearAgrupadorSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje){
            case "exito":
                actor.should(new QuestionValidate("Agrupación creada exitosamente").Execute(new GeneralParams(
                        "Agrupación creada exitosamente",
                        "//p[contains(text(),'correo')] "
                )));
                break;
            case "existente":
                actor.should(new QuestionValidate("Agrupación existente").Execute(new GeneralParams(
                        "Agrupación ya existente",
                        "/)] "
                )));
                break;
        }
    }
}
