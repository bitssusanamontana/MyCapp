package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class Footer {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @When("^El usuario se ubica al final de la pantalla$")
    public void elUsuarioSeUbicaAlFinalDeLaPantalla() {
        actor.attemptsTo(Scroll.to(By.cssSelector("//button[@name='action']")));
    }

    @Then("^Visualiza la informacion del Footer$")
    public void visualizaLaInformacionDelFooter() {
        actor.should(new QuestionValidate("Todos los derechos reservados").Execute(new GeneralParams(
                "Todos los derechos reservados",
                "Todos los derechos reservados",
                "//button[@name='action']"
        )));
        actor.should(new QuestionValidate("Creado por").Execute(new GeneralParams(
                "Creado por",
                "Creado por",
                "//button[@name='action']"
        )));
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @When("^Da clic sobre el logo de Bits Américas$")
    public void daClicSobreElLogoDeBitsAmericas() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en logo",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema debe abrir una nueva ventana$")
    public void elSistemaDebeAbrirUnaNuevaVentana() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^El sistema presenta la página de Bits Américas$")
    public void elSistemaPresentaLaPaginaDeBitsAmericas() {
        actor.should(new QuestionValidate("Bits Americas").Execute(new GeneralParams(
                "Página de Bits",
                "nueva ventana Bits",
                "//button[@name='action']"
        )));
    }
}
