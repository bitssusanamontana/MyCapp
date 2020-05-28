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
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en modificar persona asociada",
                "Modificar persona asociada",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta el formulario Modificar persona asociada$")
    public void elSistemaPresentaElFormularioModificarPersonaAsociada() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @When("^Borra la informacion en el campo (.*)$")
    public void borraLaInformacionEnElCampoCampo_requerido(String campo) {
        if (campo.equals("tipo de persona")){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Tipo de Persona",
                "Tipo de persona",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en tipo de persona",
                "propietario",
                "//button[@name='action']"
        )));}
        if (campo.equals("tipo de documento")){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Tipo de documento",
                "Tipo de documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en documento",
                "documento",
                "//button[@name='action']"
        )));}
        if (campo.equals("# documento")){
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "Usuario Ingresa el campo documento",
                "campo documento",
                "//button[@name='action']"
        )));}
        if (campo.equals("nombre")){
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "Usuario Ingresa el campo Nombre",
                "campo Nombre",
                "//button[@name='action']"
        )));}
        if (campo.equals("apellido")){
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "Usuario Ingresa el campo apellido",
                "campo Apellido",
                "//button[@name='action']"
        )));}
        if (campo.equals("correo")){
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "Usuario Ingresa el campo email",
                "campo email",
                "//button[@name='action']"
        )));}
        if (campo.equals("teléfono fijo")){
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "Usuario Ingresa el campo teléfono fijo",
                "campo teléfono fijo",
                "//button[@name='action']"
        )));}
        if (campo.equals("celular")){
        actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                "Usuario Ingresa el campo celular",
                "campo celular",
                "//button[@name='action']"
        )));}
    }

    @Then("^Persona asociada Visualiza el resultado esperado (.*)$")
    public void visualizaElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "resultado de ingreso",
                "//p[con tains(text()] "
        )));
    }


    @Then("^Muestra el mensaje modificación exitosa de persona$")
    public void muestraElMensajeModificacionExitosaDePersona() {
        actor.should(new QuestionValidate("Persona asociada modificada exitosamente").Execute(new GeneralParams(
                "Mensaje de modificación exitosa de persona asociada",
                "modificación exitosa de persona asociada",
                "//p[contain s(text()] "
        )));
    }
}
