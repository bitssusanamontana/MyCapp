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

public class AdministrarUnidadLogistica {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic en Unidades Logísticas$")
    public void daClicEnUnidadesLogísticas() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Unidades Logisticas",
                "Unidades logisticas",
                "//input[@id='password']"
        )));
    }

    @Then("^Visualiza la Ruta de navegacion$")
    public void visualizaLaRutaDeNavegacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Label Administracion de Unidades Logísticas$")
    public void visualizaLabelAdministracionDeUnidadesLogísticas() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Tabla de registros$")
    public void visualizaTablaDeRegistros() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza El boton de Crear Unidad logistica$")
    public void visualizaElBotonDeCrearUnidadLogistica() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Paginador$")
    public void visualizaPaginador() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @When("^Da clic sobre el (.*) de Unidad logistica$")
    public void daClicSobreElFiltroDeUnidadLogistica(String filtro) {
        switch (filtro){
            case "Tipo":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en tipo",
                        "filtro tipo",
                        "//input[@id='password']"
                )));
                break;
            case "Nombre":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en nombre",
                        "filtro nombre",
                        "//input[@id='password']"
                )));
                break;
            case "Ubicacion":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en ubicacion",
                        "filtro ubicacion",
                        "//input[@id='password']"
                )));
                break;
            case "Activa":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en activa",
                        "filtro activa",
                        "//input[@id='password']"
                )));
                break;
        }
    }

    @Then("^El sistema muestra el listado de las unidades logisticas$")
    public void elSistemaMuestraElListadoDeLasUnidadesLogisticas() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^En el (.*) Se ingresa (.*)$")
    public void enElFiltroSeIngresaInformacion(String filtro, String informacion) {
        switch (filtro){
            case "Tipo":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda",
                        "//input[@id='password']"
                )));
                break;
            case "Nombre":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda nombre",
                        "//input[@id='password']"
                )));
                break;
            case "Ubicacion":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda ubicacion",
                        "//input[@id='password']"
                )));
                break;
            case "Activa":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda Activa",
                        "//input[@id='password']"
                )));
                break;

        }
    }

    @Then("^Y muestra el (.*)$")
    public void yMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "validación resultado",
                "Resultado",
                "//p[contains(text(),'+57')] "
        )));
    }

    @And("^Se muestra el (.*) en la tabla$")
    public void seMuestraElResultadoEnLaTabla(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "validación resultado en la tabla",
                "Resultado en la tabla",
                "//p[contains(text(),'+57')] "
        )));
    }

    @When("^Da clic en Crear Unidad logistica$")
    public void daClicEnCrearUnidadLogistica() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en Crear Unidad Logistica",
                "Crear Unidad logistica",
                "//input[@id='password']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Crear Unidad logistica$")
    public void elSistemaRedireccionaALaPaginaDeCrearUnidadLogistica() {
        actor.should(new QuestionValidate("Creación de Unidad Logística").Execute(new GeneralParams(
                "validación página Creación de Unidad Logística",
                "Página Creación de Unidad Logística",
                "//p[contains(text(),'+57')] "
        )));
    }
}
