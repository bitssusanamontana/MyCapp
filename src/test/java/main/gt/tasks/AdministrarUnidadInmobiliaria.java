package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AdministrarUnidadInmobiliaria {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    Target BITS = Target.the("BITS AMERICAS").located(By.cssSelector("#a--ESTATE_UNIT-1-estateUnits"));
    Target BUSQUEDA = Target.the("BUSQUEDA AGRUPADOR").located(By.xpath("//button[@class='colm2 icon_search']"));
    Target CAMPO_BUSQUEDA = Target.the("CAMPO BUSQUEDA AGRUPADOR").located(By.cssSelector("#ipt--search-filterId"));
    Target TITULO_UNIDAD_INM = Target.the("TITULO AGRUPADOR").located(By.cssSelector("#h--title-name-groups"));
    Target TABLA_AGRUPADORES = Target.the("TABLA AGRUPADOR").located(By.cssSelector("#th--groups-0"));
    Target CREAR_AGRUPADOR = Target.the("CREAR AGRUPADOR").located(By.cssSelector("#btn--add-groups"));
    Target PAGINADOR = Target.the("PAGINADOR AGRUPADOR").located(By.xpath("//div[@class='pagination ng-star-inserted']"));
    Target MODIFICAR_AGRUPADOR_1 = Target.the("MODIFICAR AGRUPADOR").located(By.cssSelector("#btn--table-row-edit1"));
    Target ACTIVA_AGRUPADOR_1 = Target.the("ACTIVA AGRUPADOR").located(By.xpath("//tr[1]//td[3]//div[2]//div[1]//label[1]"));
    Target TITULO_CREAR_AGRUPADOR = Target.the("TITULO CREAR AGRUPADOR").located(By.cssSelector("#h--tittle-groupings-create"));

    @And("^Da clic sobre la unidad inmobiliaria Bits$")
    public void daClicSobreLaUnidadInmobiliariaBits() throws InterruptedException {
        actor.attemptsTo(Click.on(BITS));
        Thread.sleep(2000);
    }

    @Then("^El sistema muestra la informacion de la Unidad Inmobiliaria$")
    public void elSistemaMuestraLaInformacionDeLaUnidadInmobiliaria() {
        // Filtro de búsqueda
        actor.should(seeThat(the(BUSQUEDA), isVisible()));
        //Etiqueta ‘Administración de Unidad Inmobiliaria’
        actor.should(seeThat(the(TITULO_UNIDAD_INM), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the(TABLA_AGRUPADORES), isVisible()));
        //Botón Crear Agrupación
        actor.should(seeThat(the(CREAR_AGRUPADOR), isVisible()));
        //Paginación
        actor.should(seeThat(the(PAGINADOR), isVisible()));

    }

    @When("^Da clic en Crear Agrupacion$")
    public void daClicEnCrearAgrupacion() {
        actor.attemptsTo(Click.on(CREAR_AGRUPADOR));
    }

    @And("^El sistema redirecciona a la pagina de Crear Agrupacion$")
    public void elSistemaRedireccionaALaPaginaDeCrearAgrupacion() {

        actor.should(new QuestionValidate("Crear Agrupación").Execute(new GeneralParams(
                " Listado agrupación",
                "listado agrupación",
                "#h--tittle-groupings-create"
        )));
    }

    @When("^Da clic sobre el filtro Agrupaciones de Unidad Inmobiliaria$")
    public void daClicSobreElFiltroAgrupacionesDeUnidadInmobiliaria() {
        actor.attemptsTo(Click.on(BUSQUEDA));
    }

    @Then("^El sistema presenta el listado de las agrupaciones$")
    public void elSistemaPresentaElListadoDeLasAgrupaciones() {
        actor.should(new QuestionValidate("listado Agrupación").Execute(new GeneralParams(
                " Listado agrupación",
                "listado agrupación",
                "//button[@name='action']"
        )));
    }

    @And("^En Agrupacion Se ingresa (.*)$")
    public void enAgrupacionSeIngresaInformacion(String informacion) {
        actor.attemptsTo(Enter.theValue(informacion).into(CAMPO_BUSQUEDA));
    }

    @Then("^En Agrupacion muestra el (.*)$")
    public void enAgrupacionMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                " Resultado Listado agrupación",
                "Resultado listado agrupación",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en Parqueaderos$")
    public void daClicEnParqueaderos() {
        actor.attemptsTo(Click.on("/input[@id='password']"));
    }


    @Given("^En administrar unidad inmobiliaria El usuario Da clic sobre la opción de búsqueda$")
    public void elUsuarioDaClicSobreLaOpcionBusqueda() {
        actor.attemptsTo(Click.on(BUSQUEDA));
    }

    @When("^En administrar unidad inmobiliaria Ingresa información en filtro de busqueda (.*)$")
    public void enAdministrarUnidadInmobiliariaIngresaInformacionEnFiltroDeBusquedaBusqueda(String busqueda) throws InterruptedException {
        actor.attemptsTo(Enter.theValue(busqueda).into(CAMPO_BUSQUEDA));
        Thread.sleep(2000);
    }

    @Then("^En administrar unidad inmobiliaria El sistema muestra los resultados (.*)$")
    public void enAdministrarUnidadInmobiliariaElSistemaMuestraLosResultadosResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                " página Administrar parqueaderos",
                "Administrar parqueaderos",
                "//td[1]//div[1]"
        )));
    }

    @When("^En administrar unidad inmobiliaria Selecciona una (.*)$")
    public void enAdministrarUnidadInmobiliariaSeleccionaUnaOpcion(String opcion) {
        switch (opcion) {
            case "modificar":
                actor.attemptsTo(Click.on(MODIFICAR_AGRUPADOR_1));
                break;
            case "activar":
                actor.attemptsTo(Click.on(ACTIVA_AGRUPADOR_1));
                break;
        }
    }

    @Then("^En administrar unidad inmobiliaria El sistema realiza una accion (.*)$")
    public void enAdministrarUnidadInmobiliariaElSistemaRealizaUnaAccionAccion(String accion) {
        switch (accion) {
            case "Pagina modificar":
                actor.should(seeThat(the("#h--tittle-groupings-modify"), isVisible()));
                break;
            case "presenta mensaje":
                actor.should(seeThat(the("//div[@id='divMessage']"), isVisible()));
                break;
        }
    }

    @And("^En administrar unidad inmobiliaria selecciona el primer valor (.*)$")
    public void enAdministrarUnidadInmobiliariaSeleccionaElPrimerValor(String valor) {
        switch (valor) {
            case ("TORRE 10"):
                actor.attemptsTo(Click.on("//span[@class='colm2']"));
                break;
            case ("TORRE 3"):
                actor.attemptsTo(Click.on("//span[@class='colm2 ']"));
                break;
        }
    }
}
