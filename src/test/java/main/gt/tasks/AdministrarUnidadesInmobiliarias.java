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

public class AdministrarUnidadesInmobiliarias {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @Then("^El sistema muestra la informacion de las Unidades Inmobiliarias$")
    public void elSistemaMuestraLaInformacionDeLasUnidadesInmobiliarias() {
        // Filtro de búsqueda
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Etiqueta ‘Administración de Unidades Inmobiliarias’
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Botón Crear Unidad
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Paginación
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));

    }

    @When("^Selecciona una (.*)$")
    public void seleccionaUnaOpcion(String opcion) {
        switch (opcion) {
            case "consultar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en consultar",
                        "Botón consultar",
                        "//input[@id='password']"
                )));
                break;
            case "modificar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en modificar",
                        "Botón modificar",
                        "//input[@id='password']"
                )));
                break;
            case "activar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en activar",
                        "Check Activar",
                        "//input[@id='password']"
                )));
                break;
        }
    }

    @Then("^El sistema realiza una accion (.*)$")
    public void elSistemaRealizaUnaAccionAccion(String opcion, String accion) {
        switch (opcion) {
            case "consultar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Página consultar",
                        "pagina consultar",
                        "//button[@name='action']"
                )));
                break;
            case "modificar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Página modificar",
                        "pagina modificar",
                        "//button[@name='action']"
                )));
                break;
            case "activar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Mensaje de activación",
                        "Activación",
                        "//button[@name='action']"
                )));
                break;

        }
    }

    @When("^Da clic en Crear Unidad Inmobiliaria$")
    public void daClicEnCrearUnidadInmobiliaria() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en crear",
                "Botón Crear",
                "//input[@id='password']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Crear Unidad Inmobiliaria$")
    public void elSistemaRedireccionaALaPaginaDeCrearUnidadInmobiliaria() {
        actor.should(new QuestionValidate("Crear Unidad").Execute(new GeneralParams(
                "Página Crear Unidad",
                "pagina crear Unidad",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en los (.*) de Unidades Inmobiliarias$")
    public void daClicEnLosFiltroDeUnidadesInmobiliarias(String filtro) {
        switch (filtro){
            case "Nombre":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Nombre",
                        "Filtro nombre",
                        "//input[@id='password']"
                )));
            case "Nit":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Nit",
                        "Filtro Nit",
                        "//input[@id='password']"
                )));
            case "Catastro":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro catastro",
                        "Filtro catastro",
                        "//input[@id='password']"
                )));
            case "Dirección":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro dirección",
                        "Filtro dirección",
                        "//input[@id='password']"
                )));
        }

    }

    @And("^En Unidad Inmobiliaria Se ingresa (.*) en el (.*)$")
    public void enUnidadInmobiliariaSeIngresaInformacionEnElFiltro(String informacion, String filtro) {
        switch (filtro){
            case "Nombre":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa información en el filtro Nombre",
                        "Filtro Nombre",
                        "//input[@id='password']"
                )));
            case "Nit":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa información en el filtro Nit",
                        "Filtro Nit",
                        "//input[@id='password']"
                )));
            case "Catastro":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa información en el filtro catastro",
                        "Filtro catastro",
                        "//input[@id='password']"
                )));
            case "Dirección":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa información en el filtro dirección",
                        "Filtro dirección",
                        "//input[@id='password']"
                )));
        }
    }

    @Then("^En Unidad Inmobiliaria se muestra el (.*)$")
    public void enUnidadInmobiliariaSeMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de filtro",
                "resultado filtro",
                "//button[@name='action']"
        )));
    }

    @Then("^EL usuario seleccion el primer elemento$")
    public void elUsuarioSeleccionElErElemento() {
        actor.attemptsTo(Click.on(By.cssSelector("#listaresultados"), By.linkText("Colombia")));
    }

    @And("^Se muestran los resultados en la tabla$")
    public void seMuestranLosResultadosEnLaTabla() {
        actor.should(new QuestionValidate("resultado").Execute(new GeneralParams(
                "Resultado de filtro",
                "resultado filtro",
                "//button[@name='action']"
        )));
    }
}
