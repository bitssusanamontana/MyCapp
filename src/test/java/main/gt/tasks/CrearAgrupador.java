package main.gt.tasks;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearAgrupador {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    Target PAGINA_UNI_INM = Target.the("UNIDADES INMOBILIARIAS").located(By.cssSelector("#h--title-name-estateUnits"));
    Target BITS = Target.the("BITS AMERICAS").located(By.cssSelector("#a--ESTATE_UNIT-1-estateUnits"));
    Target CREAR_AGRUPADOR = Target.the("CREAR AGRUPADOR").located(By.cssSelector("#btn--add-groups"));
    Target TITULO_CREAR_AGRUPADOR = Target.the("TITULO CREAR AGRUPADOR").located(By.cssSelector("#h--tittle-groupings-create"));
    Target NOMBRE_AGRUPADOR = Target.the("CAMPO NOMBRE AGRUPADOR").located(By.cssSelector("#ipt--name-grouping-create"));
    Target NUMERO_UNI_INDEP = Target.the("CAMPO NUMERO DE UNIDADES INDEP").located(By.cssSelector("#ipt--independentAmount-grouping-create"));
    Target GUARDAR_AGRUPADOR = Target.the("BOTÓN GUARDAR AGRUPADOR").located(By.cssSelector("#btn--save-grouping-create"));
    Target SI_SALIR = Target.the("SI SALIR").located(By.cssSelector("#btnExit"));
    Target NO_SALIR = Target.the("NO SALIR").located(By.cssSelector("#btnErrorClose"));
    Target MENSAJE_CREACION = Target.the("EXITO ").located(By.cssSelector("#divMessage"));
    Target MENSAJE_ERROR = Target.the("ERROR ").located(By.cssSelector("#hHeader"));


    @And("^Se visualiza la pagina Administracion de Unidades Inmobiliarias$")
    public void seVisualizaLaPaginaAdministracionDeUnidadesInmobiliarias() {
        actor.should(seeThat(the(PAGINA_UNI_INM), isVisible()));
    }

    @And("^Se da clic en el nombre de la Unidad Bits$")
    public void seDaClicEnElNombreDeLaUnidadBits() throws InterruptedException {

        actor.attemptsTo(Click.on(BITS));
        Thread.sleep(2000);
    }

    @And("^da clic en Crear agrupador$")
    public void daClicEnCrearAgrupador() throws InterruptedException {
        actor.attemptsTo(Click.on(CREAR_AGRUPADOR));
        Thread.sleep(2000);
    }

    @Then("^El sistema presenta formulario Crear Agrupador$")
    public void elSistemaPresentaFormularioCrearAgrupador() {
        actor.should(seeThat(the(TITULO_CREAR_AGRUPADOR), isVisible()));
    }

    @And("^En crear agrupador visualiza el formulario$")
    public void enCrearAgrupadorVisualizaElFormulario() {
        actor.should(seeThat(the(TITULO_CREAR_AGRUPADOR), isVisible()));
    }

    @And("^En crear agrupador visualiza campo nombre agrupador$")
    public void enCrearAgrupadorVisualizaCampoNombreAgrupador() {
        actor.should(seeThat(the(NOMBRE_AGRUPADOR), isVisible()));
    }

    @And("^En crear agrupador visualiza campo numero de unidades independientes$")
    public void enCrearAgrupadorVisualizaCampoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the(NUMERO_UNI_INDEP), isVisible()));
    }

    @And("^En crear agrupador visualiza boton de guardar bloqueado$")
    public void enCrearAgrupadorVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(GUARDAR_AGRUPADOR), isNotEnabled()));
    }

    @When("^En crear agrupador da clic en (.*) e ingresa información en el otro campo$")
    public void enCrearAgrupadorDaClicEnCampo_requerido(String campo) throws InterruptedException {
        switch (campo) {
            case ("Nombre Agrupador"):
                actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
                actor.attemptsTo(Click.on(NUMERO_UNI_INDEP));
                Thread.sleep(1000);
                break;
            case ("Numero de Unidades Independientes"):
                actor.attemptsTo(Click.on(NUMERO_UNI_INDEP));
                actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
                Thread.sleep(1000);
                break;
        }

    }

    @And("^En crear agrupador da clic en el boton guardar$")
    public void enCrearAgrupadorDaClicEnElBotonGuardar() throws InterruptedException {
        actor.attemptsTo(Click.on(GUARDAR_AGRUPADOR));
        Thread.sleep(1000);
    }

    @Then("^En crear agrupador se presenta mensaje indicando que el campo es (.*)$")
    public void enCrearAgrupadorSePresentaMensajeIndicandoQueElCampoEsRequerido(String campo) throws InterruptedException {
        switch (campo) {
            case ("Nombre Agrupador"):
                Thread.sleep(1000);
                actor.should(seeThat(the("//p[@id='p--name-grouping-create']"
                ), isVisible()));
                Thread.sleep(1000);
                break;
            case ("Numero de Unidades Independientes"):
                Thread.sleep(1000);
                actor.should(seeThat(the("//p[@id='p--independentAmount-grouping-create']"
                ), isVisible()));
                Thread.sleep(1000);
                break;
        }

    }

    @When("^En crear agrupador ingresa al campo (.*) agrupacion$")
    public void enCrearAgrupadorIngresaAlCampoNombreAgrupacion(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(NOMBRE_AGRUPADOR));
    }

    @And("^En crear agrupador ingresa al campo (.*) de unidades$")
    public void enCrearAgrupadorIngresaAlCampoNumeroDeUnidades(String numero) {
        actor.attemptsTo(Enter.theValue(numero).into(NUMERO_UNI_INDEP));
    }

    @Then("^En crear agrupador sistema presenta (.*) el boton de guardar$")
    public void enCrearAgrupadorSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado) {
            case "si":
                actor.should(seeThat(the(GUARDAR_AGRUPADOR), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(GUARDAR_AGRUPADOR), isNotEnabled()));
                break;
        }

    }

    @When("^En crear agrupador Ingresa un (.*) para el campo numero de unidades independientes$")
    public void enCrearAgrupadorIngresaUnValorParaElCampoNumeroDeUnidadesIndependientes(String valor) throws InterruptedException {
        actor.attemptsTo(Enter.theValue(valor).into(NUMERO_UNI_INDEP).thenHit(Keys.ENTER));
        actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
        Thread.sleep(1000);
    }

    @Then("^En crear agrupador en el campo numero de unidades El sistema muestra el (.*)$")
    public void enCrearAgrupadorElSistemaMuestraElResultado(String resultado) {
        actor.should(seeThat(the(NUMERO_UNI_INDEP), hasValue(resultado)));
    }

    @And("^En crear agrupador el usuario Da clic en el campo Nombre Agrupador$")
    public void enCrearAgrupadorElUsuarioDaClicEnElCampoNombreAgrupador() {
        actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
    }

    @When("^En crear agrupador Ingresa un (.*) para el campo nombre de agrupador$")
    public void enCrearAgrupadorIngresaUnValorParaElCampoNombreDeAgrupador(String valor) {
        actor.attemptsTo(Enter.theValue(valor).into(NOMBRE_AGRUPADOR).thenHit(Keys.ENTER));
        actor.attemptsTo(Click.on(NUMERO_UNI_INDEP));
    }

    @Then("^En crear agrupador en el campo nombre El sistema muestra (.*)$")
    public void enCrearAgrupadorElSistemaMuestraResultado(String resultado) {
        actor.should(seeThat(the(NOMBRE_AGRUPADOR), hasValue(resultado)));
    }

    @When("^En crear agrupador ingresa al campo (.*) y (.*) de agrupador$")
    public void enCrearAgrupadorIngresaAlCampoNombreYNumeroDeAgrupador(String nombre, String numero) throws InterruptedException {
        actor.attemptsTo(Enter.theValue(nombre).into(NOMBRE_AGRUPADOR));
        Thread.sleep(1000);
        actor.attemptsTo(Enter.theValue(numero).into(NUMERO_UNI_INDEP));
        Thread.sleep(1000);
    }

    @And("^En crear agrupador da clic en boton guardar$")
    public void enCrearAgrupadorDaClicEnBotonGuardar() throws InterruptedException {
        Thread.sleep(1000);
        actor.attemptsTo(Click.on(GUARDAR_AGRUPADOR));
        Thread.sleep(2000);
    }

    @Then("^En crear agrupador sistema presenta el (.*) de éxito o error$")
    public void enCrearAgrupadorSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje) {
            case "exito":
                actor.should(seeThat(the(MENSAJE_CREACION), isVisible()));
                break;
            case "existente":
                actor.should(seeThat(the(MENSAJE_ERROR), isVisible()));
                break;
        }
    }

    @And("^En crear agrupador Muestra la (.*) segun la opcion seleccionada$")
    public void enCrearAgrupadorMuestraLaPaginaSegunLaOpcionSeleccionada(String opcion) {
        switch (opcion) {
            case ("si"):
                actor.should(seeThat(the(PAGINA_UNI_INM), isVisible()));
                break;
            case ("no"):
                actor.should(seeThat(the(TITULO_CREAR_AGRUPADOR), isVisible()));
                break;
        }
    }

    @Given("^En crear agrupador Da clic en una pagina diferente (.*)$")
    public void enCrearAgrupadorDaClicEnUnaPaginaDiferentePagina(String pagina) throws InterruptedException {
        switch (pagina) {
            case ("Principal"):
                actor.attemptsTo(Click.on("//button[@class='btn-menu ng-star-inserted']"));
                actor.attemptsTo(Click.on("//span[contains(text(),'Unidades inmobiliarias')]"));
                actor.attemptsTo(Click.on("//i[@class='material-icons notranslate']"));
                Thread.sleep(1000);
                break;
            case ("Usuario"):
                actor.attemptsTo(Click.on("//button[@class='btn-menu ng-star-inserted']"));
                actor.attemptsTo(Click.on("//mat-panel-title[@class='mat-expansion-panel-header-title ng-tns-c29-3']"));
                actor.attemptsTo(Click.on("//span[contains(text(),'Usuarios')]"));
                actor.attemptsTo(Click.on("//i[@class='material-icons notranslate']"));
                Thread.sleep(1000);
                break;
        }

    }

    @When("^En crear agrupador Selecciona una opcion del pop up (.*)$")
    public void enCrearAgrupadorSeleccionaUnaOpcionDelPopUpOpcion(String opcion) throws InterruptedException {
        switch (opcion) {
            case "si":
                actor.attemptsTo(Click.on(SI_SALIR));
                Thread.sleep(2000);
                break;
            case "no":
                actor.attemptsTo(Click.on(NO_SALIR));
                Thread.sleep(2000);
                break;
        }
    }

    @Then("^En crear agrupador El sistema cierra el pop up$")
    public void enCrearAgrupadorElSistemaCierraElPopUp() {
        actor.should(seeThat(the(MENSAJE_CREACION), isNotVisible()));
    }

    @Given("^En crear agrupador Ingresa informacion en el campo nombre de agrupacion$")
    public void enCrearAgrupadorIngresaInformacionEnElCampoNombreDeAgrupacion() {
        actor.attemptsTo(Enter.theValue("Agrupador").into(NOMBRE_AGRUPADOR));
    }
}
