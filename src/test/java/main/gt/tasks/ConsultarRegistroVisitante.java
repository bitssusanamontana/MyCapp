package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ConsultarRegistroVisitante {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @When("^Da clic en Consultar registro de visitante$")
    public void daClicEnConsultarRegistroVisitante() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'Ingresar')]").andThen(Actions::click));
    }

    @Then("^Se visualiza formulario consultar persona asociada$")
    public void seVisualizaFormularioConsultarPersonaAsociada() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^El sistema presenta la informacion del visitante en los campos$")
    public void elSistemaPresentaLaInformacionDelVisitanteEnLosCampos() {
        // tipo de documento
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("CC")));
        // número de documento
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("5435334")));
        // Nombres
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("Jose")));
        // Apellidos
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("Barbosa")));
        // ARL
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("SURA")));
        // EPS
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("COMPENSAR")));
        // tipo de Ingreso
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("Vehicular")));
        // ID tarjeta
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("003")));
        // agrupación
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("T2")));
        // unidad independiente
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("102")));
        // placa
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("URT857")));
        // parqueadero asignado
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("H2")));
        // Motivo de ingreso
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("VISITA FAMILIAR")));
    }
}
