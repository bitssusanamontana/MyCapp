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

public class CrearPersonaAsociada {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Ingresa al agrupador deseado$")
    public void ingresaAlAgrupadorDeseado() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^da clic en la unidad independiente$")
    public void daClicEnLaUnidadIndependiente() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^da clic en el boton crear persona asociada$")
    public void daClicEnElBotonCrearPersonaAsociadaUnidad() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta el formulario crear persona asociada$")
    public void elSistemaPresentaElFormularioCrearPersonaAsociada() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Ruta de navegacion$")
    public void rutaDeNavegacion() {

        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo selector Tipo persona$")
    public void campoSelectorTipoPersona() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Selector Tipo de Documento$")
    public void campoSelectorTipoDeDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Número de Documento$")
    public void campoNumeroDeDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Nombres$")
    public void campoNombres() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Apellidos$")
    public void campoApellidos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Correo Electrónico$")
    public void campoCorreoElectronico() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Telefono Fijo$")
    public void campoTelefonoFijo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada Campo Teléfono Celular$")
    public void campoTelefonoCelular() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear persona asociada El boton de guardar bloqueado$")
    public void elBotonDeGuardarBloqueado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
    }


    @When("^En crear persona asociada (.*)toda la informacion en los campos requeridos$")
    public void ingresaTodaLaInformacionEnLosCamposRequeridos(String ingresa) {
        switch (ingresa) {

            case "si":
                actor.attemptsTo(Click.on(By.cssSelector("#tipoPersona"), By.linkText("")));
                actor.attemptsTo(Click.on(By.cssSelector("#tipoDocumento"), By.linkText("")));
                actor.attemptsTo(Enter.theValue("35435345").into("#documento"));
                actor.attemptsTo(Enter.theValue("Jose").into("#nombre"));
                actor.attemptsTo(Enter.theValue("Barbosa").into("#apellido"));
                actor.attemptsTo(Enter.theValue("jbarbosa@gmail.com").into("#correo"));
                actor.attemptsTo(Enter.theValue("35435345").into("#telefonoFijo"));
                actor.attemptsTo(Enter.theValue("35435345989").into("#telefonoCelular"));

                break;
            case "no":

                break;
        }

    }

    @Then("^En crear persona asociada (.*) habilitado el boton guardar$")
    public void se_muestraHabilitadoElBotonGuardar(String habilitado) {
        switch (habilitado) {
            case "si":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
                break;
        }
    }

    @When("^En crear persona asociada Ingresa en el email la informacion (.*)$")
    public void ingresaEnElEmailLaInformacionInformacion(String informacion) {
        actor.attemptsTo(Enter.theValue(informacion).into(""));
    }

    @Then("^En crear persona asociada Visualiza el mensaje de error$")
    public void visualizaElMensajeDeError() {
        actor.should(new QuestionValidate("El correo electrónico no es válido. Ejemplo ususario@h.com").Execute(new GeneralParams(
                "Mensaje de error correo",
                "error correo eléctronico",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En crear persona asociada Ingresa toda información en cada uno de los campos requeridos de forma correcta$")
    public void ingresaTodaInformacionEnCadaUnoDeLosCamposRequeridosDeFormaCorrecta() {
        actor.attemptsTo(Click.on(By.cssSelector("#tipoPersona"), By.linkText("")));
        actor.attemptsTo(Click.on(By.cssSelector("#tipoDocumento"), By.linkText("")));
        actor.attemptsTo(Enter.theValue("35435345").into("#documento"));
        actor.attemptsTo(Enter.theValue("Jose").into("#nombre"));
        actor.attemptsTo(Enter.theValue("Barbosa").into("#apellido"));
        actor.attemptsTo(Enter.theValue("jbarbosa@gmail.com").into("#correo"));
        actor.attemptsTo(Enter.theValue("35435345").into("#telefonoFijo"));
        actor.attemptsTo(Enter.theValue("35435345989").into("#telefonoCelular"));
    }


    @Then("^En crear persona asociada Muestra el mensaje creacion exitosa de persona$")
    public void muestraElMensajeCreacionExitosaDePersona() {
        actor.should(new QuestionValidate("Persona asociada creada exitosamente").Execute(new GeneralParams(
                "Mensaje de creación exitosa de persona asociada",
                "creación exitosa de persona asociada",
                "//p[contains(text()] "
        )));
    }

    @When("^En crear persona asociada Da clic en el (.*)$")
    public void enCrearPersonaAsociadaDaClicEnElCampo_requerido(String campo) {
        switch (campo){
            case "Tipo de Persona":
                actor.attemptsTo(Click.on(""));
                break;
            case "Tipo de documento":
                actor.attemptsTo(Click.on("t"));
                break;
            case "Numero de Documento":
                actor.attemptsTo(Click.on("n"));
                break;
            case "Nombre":
                actor.attemptsTo(Click.on("nm"));
                break;
            case "Apellidos":
                actor.attemptsTo(Click.on("ap"));
                break;
            case "Correo Electronico":
                actor.attemptsTo(Click.on("ce"));
                break;
            case "Telefono Fijo":
                actor.attemptsTo(Click.on("tf"));
                break;
            case "Telefono Celular":
                actor.attemptsTo(Click.on("tc"));
                break;
        }
    }

    @And("^En crear persona asociada Da clic en el boton Guardar$")
    public void enCrearPersonaAsociadaDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^En crear persona asociada Ingresa en el campo (.*) la informacion (.*)$")
    public void enCrearPersonaAsociadaIngresaEnElCampoCampo_requeridoLaInformacionInformacion(String campo, String informacion) {
        switch (campo){
            case "Tipo de Persona":
                actor.attemptsTo(Enter.theValue(informacion).into(""));
                break;
            case "Tipo de documento":
                actor.attemptsTo(Enter.theValue(informacion).into("t"));
                break;
            case "Numero de Documento":
                actor.attemptsTo(Enter.theValue(informacion).into("nm"));
                break;
            case "Nombre":
                actor.attemptsTo(Enter.theValue(informacion).into("n"));
                break;
            case "Apellidos":
                actor.attemptsTo(Enter.theValue(informacion).into("a"));
                break;
            case "Correo Electronico":
                actor.attemptsTo(Enter.theValue(informacion).into("c"));
                break;
            case "Telefono Fijo":
                actor.attemptsTo(Enter.theValue(informacion).into("tf"));
                break;
            case "Telefono Celular":
                actor.attemptsTo(Enter.theValue(informacion).into("tc"));
                break;
        }
    }

    @Then("^En crear persona asociada Visualiza el resultado esperado (.*)$")
    public void enCrearPersonaAsociadaVisualizaElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "resultado",
                "resultado",
                "//p[contains(text()] "
        )));
    }

    @And("^redirige al usuario a la página de Administrar Unidad independiente$")
    public void redirigeAlUsuarioALaPaginaDeAdministrarUnidadIndependiente() {
        actor.should(new QuestionValidate("Administración de Unidad Independiente").Execute(new GeneralParams(
                "Página de Administración de Unidad Independiente",
                "Administración de Unidad Independiente",
                "//p[contains(text()] "
        )));
    }
}
