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


public class ModificarParqueadero {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^da clic en Modificar Parqueadero x$")
    public void daClicEnModificarParqueaderoX() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Modificar Parqueadero x$")
    public void elSistemaPresentaFormularioModificarParqueaderoX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza el formulario x$")
    public void enModificarParqueaderoVisualizaElFormularioX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza campo tipo de parqueadero x$")
    public void enModificarParqueaderoVisualizaCampoTipoDeParqueaderoX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza campo agrupacion x$")
    public void enModificarParqueaderoVisualizaCampoAgrupacionX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza campo unidad independiente x$")
    public void enModificarParqueaderoVisualizaCampoUnidadIndependienteX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza campo numero de parqueadero x$")
    public void enModificarParqueaderoVisualizaCampoNumeroDeParqueaderoX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza campo tipo de vehiculo x$")
    public void enModificarParqueaderoVisualizaCampoTipoDeVehiculoX() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En Modificar Parqueadero visualiza boton de guardar bloqueado$")
    public void enModificarParqueaderoVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""),isNotEnabled()));
    }

    @When("^En Modificar Parqueadero borra la información en (.*)$")
    public void enModificarParqueaderoBorraLaInformacionEnCampo_requerido(String campo) {
        switch (campo){
            case "tipo":
                actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText("")));
                break;
            case "agrupacion":
                actor.attemptsTo(Click.on(By.cssSelector(" "), By.linkText("")));
                break;
            case "unidad independiente":
                actor.attemptsTo(Click.on(By.cssSelector("  "), By.linkText("")));
                break;
            case "numero de parqueadero":
                actor.attemptsTo(Enter.theValue("").into(""));
                break;
            case "tipo de vehiculo":
                actor.attemptsTo(Click.on(By.cssSelector("   "), By.linkText("")));
                break;
        }
    }

    @And("^En Modificar Parqueadero da clic en el boton guardar$")
    public void enModificarParqueaderoDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En Modificar Parqueadero se presenta mensaje indicando que el campo es requerido$")
    public void enModificarParqueaderoSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @When("^En Modificar Parqueadero ingresa o selecciona informacion en los campos (.*) (.*) (.*) (.*) y (.*)$")
    public void enModificarParqueaderoIngresaOSeleccionaInformacionEnLosCamposTipoAgrupacionUnidadNumeroYVehiculo(String tipo, String agrupacion, String unidad, String numero, String vehiculo) {
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(tipo)));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(agrupacion)));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(unidad)));
        actor.attemptsTo(Enter.theValue(numero).into(""));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(vehiculo)));
    }

    @Then("^En Modificar Parqueadero sistema presenta (.*) el boton de guardar$")
    public void enModificarParqueaderoSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(""), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""), isNotEnabled()));
                break;
        }
    }

    @When("^En Modificar Parqueadero Ingresa o selecciona en el (.*) del formulario un (.*)$")
    public void enModificarParqueaderoIngresaOSeleccionaEnElCampoDelFormularioUnValor(String campo, String valor) {
        switch (campo){
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

    @Then("^En Modificar Parqueadero El sistema muestra el (.*)$")
    public void enModificarParqueaderoElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^En Modificar Parqueadero da clic en boton guardar$")
    public void enModificarParqueaderoDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En Modificar Parqueadero sistema presenta el (.*) de exito o error$")
    public void enModificarParqueaderoSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje){
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
