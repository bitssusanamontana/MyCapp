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

public class ModificarAgrupador {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^da clic en Modificar agrupador$")
    public void daClicEnModificarAgrupador() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Modificar Agrupador$")
    public void elSistemaPresentaFormularioModificarAgrupador() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar agrupador visualiza el formulario$")
    public void enModificarAgrupadorVisualizaElFormulario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar agrupador visualiza campo nombre agrupador$")
    public void enModificarAgrupadorVisualizaCampoNombreAgrupador() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar agrupador visualiza campo numero de unidades independientes$")
    public void enModificarAgrupadorVisualizaCampoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar agrupador visualiza boton de guardar bloqueado$")
    public void enModificarAgrupadorVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""),isNotEnabled()));
    }

    @When("^En Modificar agrupador borra la informacion del (.*)$")
    public void enModificarAgrupadorDaClicEnCampo_requerido(String campo) {
        actor.attemptsTo(Enter.theValue("").into(campo));
    }

    @And("^En Modificar agrupador da clic en el boton guardar$")
    public void enModificarAgrupadorDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En Modificar agrupador se presenta mensaje indicando que el campo es requerido$")
    public void enModificarAgrupadorSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(new QuestionValidate("Campo Obligatorio").Execute(new GeneralParams(
                "Campo Obligatorio",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En Modificar agrupador ingresa al campo (.*) agrupacion$")
    public void enModificarAgrupadorIngresaAlCampoNombreAgrupacion(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
    }

    @And("^En Modificar agrupador ingresa al campo (.*) de unidades$")
    public void enModificarAgrupadorIngresaAlCampoNumeroDeUnidades(String numero) {
        actor.attemptsTo(Enter.theValue(numero).into(""));
    }

    @Then("^En Modificar agrupador sistema presenta (.*) el boton de guardar$")
    public void enModificarAgrupadorSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(""), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""), isNotEnabled()));
                break;
        }
    }

    @When("^En Modificar agrupador Ingresa un (.*) para el campo numero de unidades independientes$")
    public void enModificarAgrupadorIngresaUnValorParaElCampoNumeroDeUnidadesIndependientes(String valor) {
        actor.attemptsTo(Enter.theValue(valor).into(""));
    }

    @Then("^En Modificar agrupador El sistema muestra el (.*)$")
    public void enModificarAgrupadorElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^En Modificar agrupador el usuario Da clic en el campo Nombre Agrupador$")
    public void enModificarAgrupadorElUsuarioDaClicEnElCampoNombreAgrupador() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^En Modificar agrupador Ingresa un (.*) para el campo nombre de agrupador$")
    public void enModificarAgrupadorIngresaUnValorParaElCampoNombreDeAgrupador(String valor) {
        actor.attemptsTo(Enter.theValue(valor).into(""));
    }

    @Then("^En Modificar agrupador El sistema muestra (.*)$")
    public void enModificarAgrupadorElSistemaMuestraResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En Modificar agrupador ingresa al campo (.*) y (.*) de agrupador$")
    public void enModificarAgrupadorIngresaAlCampoNombreYNumeroDeAgrupador(String nombre, String numero){
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(numero).into(""));
    }

    @And("^En Modificar agrupador da clic en boton guardar$")
    public void enModificarAgrupadorDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En Modificar agrupador sistema presenta el (.*) de éxito o error$")
    public void enModificarAgrupadorSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje){
            case "exito":
                actor.should(new QuestionValidate("Agrupación modificada exitosamente").Execute(new GeneralParams(
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

