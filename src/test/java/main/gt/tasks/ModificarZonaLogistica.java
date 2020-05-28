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
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModificarZonaLogistica {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic sobre Modificar Zona Logistica$")
    public void daClicSobreModificarZonaLogistica() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en modificar zonas logísticas",
                "modificar zonas logísticas",
                "//button[@name='action']"
        )));
    }

    @Then("^El usuario visualiza el mensaje de salir de Modificar Unidad Logistica$")
    public void elUsuarioVisualizaElMensajeDeSalirDeModificarUnidadLogistica() {
        actor.should(new QuestionValidate("¿Está seguro de que desea salir de la página modificar Unidad Logística?").Execute(new GeneralParams(
                "Mensaje de salir de Modificar Unidad Logistica",
                "salir de Modificar Unidad Logistica",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En Unidad Logistica borra la informacion del (.*)$")
    public void enUnidadLogisticaBorraLaInformacionDelCampo_requerido(String campo_requerido) {
        switch (campo_requerido){
            case "Tipo Unidad Logistica":
                actor.attemptsTo(Click.on(By.cssSelector("#menuTipo"), By.linkText("")));
                break;
            case "Nombre":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Usuario da Clic en nombre unidad logistica",
                        "nombre unidad logistica",
                        "//button[@name='action']"
                )));
                break;
            case "Ubicacion":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Usuario da Clic en ubicacion unidad logistica",
                        "ubicacion unidad logistica",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @Then("^En unidad logistica modificacion se presenta un (.*)$")
    public void enUnidadLogisticaModificacionSePresentaUnResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "resultado",
                "resultado",
                "//p[contains(text(),'correo')] "
        )));
    }
}

