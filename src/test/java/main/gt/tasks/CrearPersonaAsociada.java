package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
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
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en agrupador",
                "Agrupador",
                "//button[@name='action']"
        )));
    }

    @And("^da clic en la unidad independiente$")
    public void daClicEnLaUnidadIndependiente() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en unidad independiente",
                "Unidad Independiente",
                "//button[@name='action']"
        )));
    }

    @And("^da clic en el boton crear persona asociada$")
    public void daClicEnElBotonCrearPersonaAsociadaUnidad() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en crear persona asociada",
                "Crear persona asociada",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta el formulario crear persona asociada$")
    public void elSistemaPresentaElFormularioCrearPersonaAsociada() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Ruta de navegacion$")
    public void rutaDeNavegacion() {

        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo selector Tipo persona$")
    public void campoSelectorTipoPersona() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Selector Tipo de Documento$")
    public void campoSelectorTipoDeDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Número de Documento$")
    public void campoNumeroDeDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Nombres$")
    public void campoNombres() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Apellidos$")
    public void campoApellidos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Correo Electrónico$")
    public void campoCorreoElectronico() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Telefono Fijo$")
    public void campoTelefonoFijo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Teléfono Celular$")
    public void campoTelefonoCelular() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El boton de guardar bloqueado$")
    public void elBotonDeGuardarBloqueado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
    }


    @When("^(.*)toda la informacion en los campos requeridos$")
    public void ingresaTodaLaInformacionEnLosCamposRequeridos(String ingresa) {
        if (ingresa.equals("si")){
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en Tipo de Persona",
                    "Tipo de persona",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en Propietario",
                    "propietario",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en Tipo de documento",
                    "Tipo de documento",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da clic en documento",
                    "documento",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new EnterTextAction("874438743").Execute(new GeneralParams(
                    "Usuario Ingresa el campo documento",
                    "campo documento",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new EnterTextAction("Jose Arturo").Execute(new GeneralParams(
                    "Usuario Ingresa el campo Nombre",
                    "campo Nombre",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new EnterTextAction("Barbosa").Execute(new GeneralParams(
                    "Usuario Ingresa el campo apellido",
                    "campo Apellido",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new EnterTextAction("jabarbosa@gmail.com").Execute(new GeneralParams(
                    "Usuario Ingresa el campo email",
                    "campo email",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new EnterTextAction("3454545").Execute(new GeneralParams(
                    "Usuario Ingresa el campo teléfono fijo",
                    "campo teléfono fijo",
                    "//button[@name='action']"
            )));
            actor.attemptsTo(new EnterTextAction("3214555555").Execute(new GeneralParams(
                    "Usuario Ingresa el campo celular",
                    "campo celular",
                    "//button[@name='action']"
            )));
        }

    }

    @Then("^(.*) habilitado el boton guardar$")
    public void se_muestraHabilitadoElBotonGuardar(String habilitado) {
        if (habilitado.equals("si")){
            actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
        }
        else actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
    }

    @When("^Ingresa en el email la informacion (.*)$")
    public void ingresaEnElEmailLaInformacionInformacion(String informacion) {
        actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                "Usuario Ingresa el campo email",
                "campo email",
                "//button[@name='action']"
        )));
    }

    @Then("^Visualiza el mensaje de error$")
    public void visualizaElMensajeDeError() {
        actor.should(new QuestionValidate("El correo electrónico no es válido. Ejemplo ususario@h.com").Execute(new GeneralParams(
                "Mensaje de error correo",
                "error correo eléctronico",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa toda información en cada uno de los campos requeridos de forma correcta$")
    public void ingresaTodaInformacionEnCadaUnoDeLosCamposRequeridosDeFormaCorrecta() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Tipo de Persona",
                "Tipo de persona",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Propietario",
                "propietario",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Tipo de documento",
                "Tipo de documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en documento",
                "documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new EnterTextAction("874438743").Execute(new GeneralParams(
                "Usuario Ingresa el campo documento",
                "campo documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new EnterTextAction("Jose Arturo").Execute(new GeneralParams(
                "Usuario Ingresa el campo Nombre",
                "campo Nombre",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new EnterTextAction("Barbosa").Execute(new GeneralParams(
                "Usuario Ingresa el campo apellido",
                "campo Apellido",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new EnterTextAction("jabarbosa@gmail.com").Execute(new GeneralParams(
                "Usuario Ingresa el campo email",
                "campo email",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new EnterTextAction("3454545").Execute(new GeneralParams(
                "Usuario Ingresa el campo teléfono fijo",
                "campo teléfono fijo",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new EnterTextAction("3214555555").Execute(new GeneralParams(
                "Usuario Ingresa el campo celular",
                "campo celular",
                "//button[@name='action']"
        )));
    }


    @Then("^Muestra el mensaje creacion exitosa de persona$")
    public void muestraElMensajeCreacionExitosaDePersona() {
        actor.should(new QuestionValidate("Persona asociada creada exitosamente").Execute(new GeneralParams(
                "Mensaje de creación exitosa de persona asociada",
                "creación exitosa de persona asociada",
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
