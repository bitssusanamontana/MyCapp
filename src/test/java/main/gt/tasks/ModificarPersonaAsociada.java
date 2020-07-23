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

public class ModificarPersonaAsociada {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^da clic en el boton Modificar persona asociada$")
    public void daClicEnElBotonModificarPersonaAsociada() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta el formulario Modificar persona asociada$")
    public void elSistemaPresentaElFormularioModificarPersonaAsociada() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @When("^En modificar persona Borra la informacion en el campo (.*)$")
    public void borraLaInformacionEnElCampoCampo_requerido(String campo) {
        switch (campo) {
            case "Tipo de Persona":
                actor.attemptsTo(Enter.theValue("").into(""));
                break;
            case "Tipo de documento":
                actor.attemptsTo(Enter.theValue("").into("t"));
                break;
            case "Numero de Documento":
                actor.attemptsTo(Enter.theValue("").into("nm"));
                break;
            case "Nombre":
                actor.attemptsTo(Enter.theValue("").into("n"));
                break;
            case "Apellidos":
                actor.attemptsTo(Enter.theValue("").into("a"));
                break;
            case "Correo Electronico":
                actor.attemptsTo(Enter.theValue("").into("c"));
                break;
            case "Telefono Fijo":
                actor.attemptsTo(Enter.theValue("").into("tf"));
                break;
            case "Telefono Celular":
                actor.attemptsTo(Enter.theValue("").into("tc"));
                break;
        }
    }

    @Then("^En modificar persona Persona asociada Visualiza el resultado esperado (.*)$")
    public void visualizaElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "resultado de ingreso",
                "//p[con tains(text()] "
        )));
    }


    @Then("^En modificar persona Muestra el mensaje modificación exitosa de persona$")
    public void muestraElMensajeModificacionExitosaDePersona() {
        actor.should(new QuestionValidate("Persona asociada modificada exitosamente").Execute(new GeneralParams(
                "Mensaje de modificación exitosa de persona asociada",
                "modificación exitosa de persona asociada",
                "//p[contain s(text()] "
        )));
    }

    @And("^En modificar persona Ruta de navegacion$")
    public void enModificarPersonaRutaDeNavegacion() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo selector Tipo persona$")
    public void enModificarPersonaCampoSelectorTipoPersona() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Selector Tipo de Documento$")
    public void enModificarPersonaCampoSelectorTipoDeDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Número de Documento$")
    public void enModificarPersonaCampoNumeroDeDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Nombres$")
    public void enModificarPersonaCampoNombres() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Apellidos$")
    public void enModificarPersonaCampoApellidos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Correo Electrónico$")
    public void enModificarPersonaCampoCorreoElectronico() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Telefono Fijo$")
    public void enModificarPersonaCampoTelefonoFijo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona Campo Teléfono Celular$")
    public void enModificarPersonaCampoTelefonoCelular() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar persona El boton de guardar bloqueado$")
    public void enModificarPersonaElBotonDeGuardarBloqueado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
    }

    @When("^En modificar persona (.*) toda la informacion en los campos requeridos$")
    public void enModificarPersonaCambiaTodaLaInformacionEnLosCamposRequeridos(String cambia) {
        switch (cambia) {

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

    @Then("^En modificar persona (.*) habilitado el boton guardar$")
    public void enModificarPersonaSe_muestraHabilitadoElBotonGuardar(String habilitado) {
        switch (habilitado) {
            case "si":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
                break;
        }
    }

    @When("^En modificar persona Ingresa en el campo (.*) la informacion (.*)$")
    public void enModificarPersonaIngresaEnElCampoCampo_requeridoLaInformacionInformacion(String campo, String informacion) {
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

    @Then("^En modificar persona Visualiza el resultado esperado (.*)$")
    public void enModificarPersonaVisualizaElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "resultado",
                "resultado",
                "//p[contains(text()] "
        )));
    }

    @When("^En modificar persona Ingresa en el email la informacion (.*)$")
    public void enModificarPersonaIngresaEnElEmailLaInformacionInformacion(String informacion) {
        actor.attemptsTo(Enter.theValue(informacion).into(""));

    }

    @Then("^En modificar persona Visualiza el mensaje de error$")
    public void enModificarPersonaVisualizaElMensajeDeError() {
        actor.should(new QuestionValidate("El correo electrónico no es válido. Ejemplo ususario@h.com").Execute(new GeneralParams(
                "Mensaje de error correo",
                "error correo eléctronico",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En modificar persona Ingresa toda información en cada uno de los campos requeridos de forma correcta$")
    public void enModificarPersonaIngresaTodaInformacionEnCadaUnoDeLosCamposRequeridosDeFormaCorrecta() {
        actor.attemptsTo(Click.on(By.cssSelector("#tipoPersona"), By.linkText("")));
        actor.attemptsTo(Click.on(By.cssSelector("#tipoDocumento"), By.linkText("")));
        actor.attemptsTo(Enter.theValue("35435345").into("#documento"));
        actor.attemptsTo(Enter.theValue("Jose").into("#nombre"));
        actor.attemptsTo(Enter.theValue("Barbosa").into("#apellido"));
        actor.attemptsTo(Enter.theValue("jbarbosa@gmail.com").into("#correo"));
        actor.attemptsTo(Enter.theValue("35435345").into("#telefonoFijo"));
        actor.attemptsTo(Enter.theValue("35435345989").into("#telefonoCelular"));
    }

    @And("^En modificar persona Da clic en el boton Guardar$")
    public void enModificarPersonaDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }
}
