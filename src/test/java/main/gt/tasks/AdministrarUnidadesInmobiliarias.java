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
import org.openqa.selenium.Keys;
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
        actor.should(seeThat(the("//button[@class='colm2 icon_search']"), isVisible()));
        //Etiqueta ‘Administración de Unidades Inmobiliarias’
        actor.should(seeThat(the("//h1[@id='h--title-name-estateUnits']"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("//th[@id='th--estateUnits-0']"), isVisible()));
        //Botón Crear Unidad
        actor.should(seeThat(the("#btn--add-estateUnits"), isVisible()));
        //Paginación
        actor.should(seeThat(the("//div[@class='pagination']"), isVisible()));

    }

    @When("^En unidades inmobiliarias Selecciona una (.*)$")
    public void seleccionaUnaOpcion(String opcion) {
        switch (opcion) {
            case "consultar":
                actor.attemptsTo(Click.on("#btn--table-row-view2"));
                break;
            case "modificar":
                actor.attemptsTo(Click.on("#btn--table-row-edit2"));
                break;

        }
    }

    @Then("^En unidades inmobiliarias El sistema realiza una accion (.*)$")
    public void elSistemaRealizaUnaAccionAccion(String accion) {
        switch (accion) {
            case "Pagina consultar":
                actor.should(new QuestionValidate("Consultar unidad inmobiliaria").Execute(new GeneralParams(
                        "Página consultar",
                        "pagina consultar",
                        "//h1[@class='tittle']"
                )));
                break;
            case "Pagina modificar":
                actor.should(new QuestionValidate("Modificar unidad inmobiliaria").Execute(new GeneralParams(
                        "Página modificar",
                        "pagina modificar",
                        "//h1[@class='tittle']"
                )));
                break;

        }
    }

    @When("^Da clic en Crear Unidad Inmobiliaria$")
    public void daClicEnCrearUnidadInmobiliaria() {
        actor.attemptsTo(Click.on("#btn--add-estateUnits"));
    }

    @And("^El sistema redirecciona a la pagina de Crear Unidad Inmobiliaria$")
    public void elSistemaRedireccionaALaPaginaDeCrearUnidadInmobiliaria() {
        actor.should(new QuestionValidate("Crear unidad inmobiliaria").Execute(new GeneralParams(
                "Página Crear Unidad",
                "pagina crear Unidad",
                "//h1[@class='tittle']"
        )));
    }

    @When("^Da clic en los (.*) de Unidades Inmobiliarias$")
    public void daClicEnLosFiltroDeUnidadesInmobiliarias(String filtro) {
        switch (filtro){
            case "Nombre":
                actor.attemptsTo(Click.on(""));
            case "Nit":
                actor.attemptsTo(Click.on(""));
            case "Catastro":
                actor.attemptsTo(Click.on(""));
            case "Dirección":
                actor.attemptsTo(Click.on(""));
        }

    }

    @And("^En Unidad Inmobiliaria Se ingresa (.*) en el (.*)$")
    public void enUnidadInmobiliariaSeIngresaInformacionEnElFiltro(String informacion, String filtro) {
        switch (filtro){
            case "Nombre":
                actor.attemptsTo(Enter.theValue(informacion).into(""));
            case "Nit":
                actor.attemptsTo(Enter.theValue(informacion).into(""));
            case "Catastro":
                actor.attemptsTo(Enter.theValue(informacion).into(""));
            case "Dirección":
                actor.attemptsTo(Enter.theValue(informacion).into(""));
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

    @When("^En unidades inmobiliarias Ingresa información en filtro de busqueda (.*) y da Enter$")
    public void enUnidadesInmobiliariasIngresaInformacionEnFiltroDeBusquedaBusquedaYDaEnter(String informacion) {
        actor.attemptsTo(
                Enter.theValue(informacion).into("//input[@id='ipt--search-filterId']").thenHit(Keys.ENTER)
        );
    }
}
