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

public class ModificarUnidadIndependiente {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @And("^da clic en Modificar unidad independiente$")
    public void daClicEnModificarUnidadIndependiente() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Modificar unidad independiente$")
    public void elSistemaPresentaFormularioModificarUnidadIndependiente() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar unidad independiente visualiza el formulario$")
    public void enModificarUnidadIndependienteVisualizaElFormulario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar unidad independiente visualiza campo nombre unidad independiente$")
    public void enModificarUnidadIndependienteVisualizaCampoNombreUnidadIndependiente() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar unidad independiente visualiza campo numero de catastro$")
    public void enModificarUnidadIndependienteVisualizaCampoNumeroDeCatastro() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar unidad independiente visualiza campo numero de metros cuadrados$")
    public void enModificarUnidadIndependienteVisualizaCampoNumeroDeMetrosCuadrados() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar unidad independiente visualiza boton de guardar bloqueado$")
    public void enModificarUnidadIndependienteVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""),isNotEnabled()));
    }

    @When("^En Modificar unidad independiente borra la informacion del (.*)$")
    public void enModificarUnidadIndependienteBorraLaInformacionDelCampo_requerido(String campo) {
       switch (campo){
           case "nombre":
               actor.attemptsTo(Enter.theValue("").into(""));
               break;
           case "catastro":
               actor.attemptsTo(Enter.theValue("").into("  "));
               break;
           case "metros":
               actor.attemptsTo(Enter.theValue("").into(" "));
               break;
       }
    }

    @And("^En Modificar unidad independiente da clic en el boton guardar$")
    public void enModificarUnidadIndependienteDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En Modificar unidad independiente se presenta mensaje indicando que el campo es requerido$")
    public void enModificarUnidadIndependienteSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @When("^En Modificar unidad independiente ingresa al campo (.*) unidad independiente$")
    public void enModificarUnidadIndependienteIngresaAlCampoNombreUnidadIndependiente(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
    }

    @And("^En Modificar unidad independiente ingresa al campo (.*) de catastro$")
    public void enModificarUnidadIndependienteIngresaAlCampoNumeroDeCatastro(String catastro) {
        actor.attemptsTo(Enter.theValue(catastro).into(""));
    }

    @And("^En Modificar unidad independiente ingresa al campo (.*) cuadrados$")
    public void enModificarUnidadIndependienteIngresaAlCampoMetrosCuadrados(String metros) {
        actor.attemptsTo(Enter.theValue(metros).into(""));
    }

    @Then("^En Modificar unidad independiente sistema presenta (.*) el boton de guardar$")
    public void enModificarUnidadIndependienteSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(""),isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""),isNotEnabled()));
                break;
        }
    }

    @When("^En Modificar unidad independiente Ingresa en el (.*) del formulario un (.*)$")
    public void enModificarUnidadIndependienteIngresaEnElCampoDelFormularioUnValor(String campo, String valor) {
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

    @Then("^En Modificar unidad independiente El sistema muestra el (.*)$")
    public void enModificarUnidadIndependienteElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "muestra resultado",
                ""
        )));
    }

    @When("^En Modificar unidad independiente ingresa al campo (.*), (.*) y (.*) de unidad independiente$")
    public void enModificarUnidadIndependienteIngresaAlCampoNombreCatastroYMetrosDeUnidadIndependiente(String nombre, String catastro, String metros) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(catastro).into(""));
        actor.attemptsTo(Enter.theValue(metros).into(""));
    }

    @And("^En Modificar unidad independiente da clic en boton guardar$")
    public void enModificarUnidadIndependienteDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En Modificar unidad independiente sistema presenta el (.*) de éxito o error$")
    public void enModificarUnidadIndependienteSistemaPresentaElMensajeDeExitoOError(String mensaje) {
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
}
