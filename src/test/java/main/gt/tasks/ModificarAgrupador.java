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

public class ModificarAgrupador {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }
    Target PAGINA_UNI_INM = Target.the("UNIDADES INMOBILIARIAS").located(By.cssSelector("#h--title-name-estateUnits"));
    Target MODIFICAR_AGRUPADOR = Target.the("MODIFICAR AGRUPADOR").located(By.cssSelector("#btn--table-row-edit1"));
    Target TITULO_MODIFICAR_AGRUPADOR = Target.the("TITULO MODIFICAR AGRUPADOR").located(By.cssSelector("#h--tittle-groupings-modify    "));
    Target NOMBRE_AGRUPADOR = Target.the("CAMPO NOMBRE AGRUPADOR").located(By.cssSelector("#ipt--name-grouping-modify"));
    Target NUMERO_UNI_INDEP = Target.the("CAMPO NUMERO DE UNIDADES INDEP").located(By.cssSelector("#ipt--independentAmount-grouping-modify"));
    Target GUARDAR_AGRUPADOR = Target.the("BOTÓN GUARDAR AGRUPADOR").located(By.cssSelector("#btn--save-grouping-modify"));
    Target SI_SALIR = Target.the("SI SALIR").located(By.cssSelector("#btnExit"));
    Target NO_SALIR = Target.the("NO SALIR").located(By.cssSelector("#btnErrorClose"));
    Target MENSAJE_MODIFICACION = Target.the("EXITO ").located(By.cssSelector("#divMessage"));
    Target MENSAJE_ERROR = Target.the("ERROR ").located(By.cssSelector("#hHeader"));

    @And("^da clic en Modificar agrupador$")
    public void daClicEnModificarAgrupador() throws InterruptedException {
        actor.attemptsTo(Click.on(MODIFICAR_AGRUPADOR));
        Thread.sleep(2000);
    }

    @Then("^El sistema presenta formulario Modificar Agrupador$")
    public void elSistemaPresentaFormularioModificarAgrupador() {
        actor.should(seeThat(the(TITULO_MODIFICAR_AGRUPADOR),isVisible()));
    }

    @And("^En Modificar agrupador visualiza el formulario$")
    public void enModificarAgrupadorVisualizaElFormulario() {
        actor.should(seeThat(the(TITULO_MODIFICAR_AGRUPADOR),isVisible()));
    }

    @And("^En Modificar agrupador visualiza campo nombre agrupador$")
    public void enModificarAgrupadorVisualizaCampoNombreAgrupador() {
        actor.should(seeThat(the(NOMBRE_AGRUPADOR),isVisible()));
    }

    @And("^En Modificar agrupador visualiza campo numero de unidades independientes$")
    public void enModificarAgrupadorVisualizaCampoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the(NUMERO_UNI_INDEP),isVisible()));
    }

    @And("^En Modificar agrupador visualiza boton de guardar bloqueado$")
    public void enModificarAgrupadorVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(GUARDAR_AGRUPADOR),isEnabled()));
    }

    @When("^En Modificar agrupador borra la informacion del (.*)$")
    public void enModificarAgrupadorDaClicEnCampo_requerido(String campo) {
        switch (campo){
            case ("Nombre Agrupador"):
                actor.attemptsTo(Enter.theValue("").into(NOMBRE_AGRUPADOR));
                actor.attemptsTo(Click.on(NUMERO_UNI_INDEP));
                break;
            case ("Numero de Unidades Independientes"):
                actor.attemptsTo(Enter.theValue("").into(NUMERO_UNI_INDEP));
                actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
                break;
        }
    }

    @And("^En Modificar agrupador da clic en el boton guardar$")
    public void enModificarAgrupadorDaClicEnElBotonGuardar() throws InterruptedException {
        actor.attemptsTo(Click.on(GUARDAR_AGRUPADOR));
        Thread.sleep(2000);
    }

    @Then("^En Modificar agrupador se presenta mensaje indicando que el campo es (.*)$")
    public void enModificarAgrupadorSePresentaMensajeIndicandoQueElCampoEsRequerido(String campo) throws InterruptedException {
        switch (campo) {
            case ("Nombre Agrupador"):
                Thread.sleep(1000);
                actor.should(seeThat(the("#p--name-grouping-modify"
                ), isVisible()));
                Thread.sleep(1000);
                break;
            case ("Numero de Unidades Independientes"):
                Thread.sleep(1000);
                actor.should(seeThat(the("//p[@id='p--independentAmount-grouping-modify']"
                ), isVisible()));
                Thread.sleep(1000);
                break;
        }
    }

    @When("^En Modificar agrupador ingresa al campo (.*) agrupacion$")
    public void enModificarAgrupadorIngresaAlCampoNombreAgrupacion(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into(""));
    }

    @And("^En Modificar agrupador ingresa al campo (.*) de unidades$")
    public void enModificarAgrupadorIngresaAlCampoNumeroDeUnidades(String numero) {
        actor.attemptsTo(Enter.theValue(numero).into(NUMERO_UNI_INDEP));
    }

    @Then("^En Modificar agrupador sistema presenta (.*) el boton de guardar$")
    public void enModificarAgrupadorSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(GUARDAR_AGRUPADOR), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(GUARDAR_AGRUPADOR), isNotEnabled()));
                break;
        }
    }

    @When("^En Modificar agrupador Ingresa un (.*) para el campo numero de unidades independientes$")
    public void enModificarAgrupadorIngresaUnValorParaElCampoNumeroDeUnidadesIndependientes(String valor) throws InterruptedException {
        actor.attemptsTo(Enter.theValue("").into(NOMBRE_AGRUPADOR));
        actor.attemptsTo(Enter.theValue(valor).into(NUMERO_UNI_INDEP).thenHit(Keys.ENTER));
        actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
        Thread.sleep(1000);
    }

    @Then("^En Modificar agrupador en el campo numero de unidades El sistema muestra el (.*)$")
    public void enModificarAgrupadorElSistemaMuestraElResultado(String resultado) {
        actor.should(seeThat(the(NUMERO_UNI_INDEP), hasValue(resultado)));
    }

    @And("^En Modificar agrupador el usuario Da clic en el campo Nombre Agrupador$")
    public void enModificarAgrupadorElUsuarioDaClicEnElCampoNombreAgrupador() {
        actor.attemptsTo(Click.on(NOMBRE_AGRUPADOR));
    }

    @When("^En Modificar agrupador Ingresa un (.*) para el campo nombre de agrupador$")
    public void enModificarAgrupadorIngresaUnValorParaElCampoNombreDeAgrupador(String valor) {
        actor.attemptsTo(Enter.theValue("").into(NUMERO_UNI_INDEP));
        actor.attemptsTo(Enter.theValue(valor).into(NOMBRE_AGRUPADOR).thenHit(Keys.ENTER));
        actor.attemptsTo(Click.on(NUMERO_UNI_INDEP));
    }

    @Then("^En Modificar agrupador en el campo nombre El sistema muestra (.*)$")
    public void enModificarAgrupadorElSistemaMuestraResultado(String resultado) {
        actor.should(seeThat(the(NOMBRE_AGRUPADOR), hasValue(resultado)));
    }

    @When("^En Modificar agrupador ingresa al campo (.*) y (.*) de agrupador$")
    public void enModificarAgrupadorIngresaAlCampoNombreYNumeroDeAgrupador(String nombre, String numero) throws InterruptedException {
        actor.attemptsTo(Enter.theValue(nombre).into(NOMBRE_AGRUPADOR));
        Thread.sleep(1000);
        actor.attemptsTo(Enter.theValue(numero).into(NUMERO_UNI_INDEP));
        Thread.sleep(1000);
    }

    @And("^En Modificar agrupador da clic en boton guardar$")
    public void enModificarAgrupadorDaClicEnBotonGuardar() throws InterruptedException {
        Thread.sleep(1000);
        actor.attemptsTo(Click.on(GUARDAR_AGRUPADOR));
        Thread.sleep(3000);
    }

    @Then("^En Modificar agrupador sistema presenta el (.*) de éxito o error$")
    public void enModificarAgrupadorSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje){
            case "exito":
                actor.should(seeThat(the(MENSAJE_MODIFICACION), isVisible()));
                break;
            case "existente":
                actor.should(seeThat(the(MENSAJE_ERROR), isVisible()));
                break;
        }
    }

    @Given("^En Modificar agrupador Ingresa informacion en el campo nombre de agrupacion$")
    public void enModificarAgrupadorIngresaInformacionEnElCampoNombreDeAgrupacion() {
        actor.attemptsTo(Enter.theValue("Agrupador sig").into(NOMBRE_AGRUPADOR));
    }

    @And("^En Modificar agrupador Da clic en una pagina diferente (.*)$")
    public void enModificarAgrupadorDaClicEnUnaPaginaDiferentePagina(String pagina) throws InterruptedException {
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

    @When("^En Modificar agrupador Selecciona una opcion del pop up (.*)$")
    public void enModificarAgrupadorSeleccionaUnaOpcionDelPopUpOpcion(String opcion) {
        switch (opcion) {
            case "si":
                actor.attemptsTo(Click.on(SI_SALIR));
                break;
            case "no":
                actor.attemptsTo(Click.on(NO_SALIR));
                break;
        }
    }

    @Then("^En Modificar agrupador El sistema cierra el pop up$")
    public void enModificarAgrupadorElSistemaCierraElPopUp() {
        actor.should(seeThat(the(SI_SALIR), isNotVisible()));
    }

    @And("^En Modificar agrupador Muestra la (.*) segun la opcion seleccionada$")
    public void enModificarAgrupadorMuestraLaPaginaSegunLaOpcionSeleccionada(String pagina) {
        switch (pagina) {
            case ("Principal"):
                actor.should(seeThat(the(PAGINA_UNI_INM), isVisible()));
                break;
            case ("Modificar Agrupador"):
                actor.should(seeThat(the(TITULO_MODIFICAR_AGRUPADOR), isVisible()));
                break;
        }
    }
}

