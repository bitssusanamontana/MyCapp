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

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ModificarID {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic sobre Modificar ID$")
    public void daClicSobreModificarID() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en modificar ID",
                "modificar ID",
                "//button[@name='action']"
        )));
    }

    @Then("^Se muestra un mensaje de confirmacion para salir de Modificar ID$")
    public void seMuestraUnMensajeDeConfirmacionParaSalirDeModificarID() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
        actor.should(new QuestionValidate("¿Está seguro de que desea salir de la página modificar ID?").Execute(new GeneralParams(
                "Mensaje de salir página de modificar ID",
                "salir página de modificar ID",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En Modificar ID Da clic en el (.*)$")
    public void enModificarIDDaClicEnElCampo_requerido(String campo) {
        switch (campo) {
            case "numero de tarjeta":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en numero de tarjeta",
                        "numero de tarjeta",
                        "//button[@name='action']"
                )));
                break;
            case "tipo":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en tipo de tarjeta",
                        "tipo de tarjeta",
                        "//butto n[@name='action']"
                )));
                break;
            case "ingreso":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en ingreso",
                        "ingreso",
                        "//button[@name='action']"
                )));
                break;
            case "tecnologia":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en tecnologia",
                        "tecnologia de tarjeta",
                        "//button[@name='action']"
                )));
                break;
        }

    }

    @Then("^En modificar El sistema presenta mensaje de Campo requerido$")
    public void enModificarElSistemaPresentaMensajeDeCampoRequerido() {
        actor.should(new QuestionValidate("Campo requerido").Execute(new GeneralParams(
                "Campo requerido",
                "Campo requerido",
                "//p[contains(text(),'correo')] "
        )));
    }

    @Then("^En modificacion Se presenta un (.*)$")
    public void enModificacionSePresentaUnResultado(String resultado) {
        switch (resultado){
            case "ID existe":
                actor.should(new QuestionValidate("El número de la tarjeta ya está en uso, por favor ingresar uno diferente").Execute(new GeneralParams(
                        "Mensaje número de tarjeta existente",
                        "Tarjeta existente",
                        "//button[@name='action']"
                )));
                break;
            case "ID modificado":
                actor.should(new QuestionValidate("El ID ha sido modificado exitosamente").Execute(new GeneralParams(
                        "Mensaje número de tarjeta modificado",
                        "Tarjeta creada",
                        "//button[@name='action']"
                )));
                break;
        }
    }
}
