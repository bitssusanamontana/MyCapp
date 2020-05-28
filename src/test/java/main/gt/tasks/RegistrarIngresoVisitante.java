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
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RegistrarIngresoVisitante {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic sobre el botón Registro de Ingreso de visitante$")
    public void daClicRegistroVisitante() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'registro visitante')]").andThen(Actions::click));
    }

    @And("^Visualiza Label REGISTRO DE INGRESO DE VISITANTE$")
    public void visualizaLabelREGISTRODEINGRESODEVISITANTE() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Tipo de Identificacion$")
    public void visualizaCampoTipoDeIdentificacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Numero de Documento$")
    public void visualizaCampoNumeroDeDocumento() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Nombres$")
    public void visualizaCampoNombres() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Apellidos$")
    public void visualizaCampoApellidos() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo ARL$")
    public void visualizaCampoARL() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo EPS$")
    public void visualizaCampoEPS() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo ingreso$")
    public void visualizaCampoIngreso() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo ID tarjeta$")
    public void visualizaCampoIDTarjeta() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Agrupacion$")
    public void visualizaCampoAgrupacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Unidad Independiente$")
    public void visualizaCampoUnidadIndependiente() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Placa$")
    public void visualizaCampoPlaca() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Parqueadero asignado$")
    public void visualizaCampoParqueaderoAsignado() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Campo Motivo de ingreso$")
    public void visualizaCampoMotivoDeIngreso() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Enlace tomar foto$")
    public void visualizaEnlaceTomarFoto() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza El boton de guardar bloqueado$")
    public void visualizaElBotonDeGuardarBloqueado() {
        actor.should(seeThat(the("/button[@name='action']"), isNotEnabled()));
    }

    @When("^(.*) toda la informacion en los campos requeridos en registro visitante$")
    public void ingresaTodaLaInformacionEnLosCamposRequeridosEnRegistroVisitante(String ingresa) {
        switch (ingresa) {
            case "si":
                //Seleccionar tipo de documento
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("CC")));
                //INgresa número de documento
                actor.attemptsTo(Enter.keyValues("32454235").into("//input[@id='doc']"));
                //Ingresa Nombres
                actor.attemptsTo(Enter.keyValues("Jose Pedro").into("//input[@id='doc']"));
                //Ingresa Apellidos
                actor.attemptsTo(Enter.keyValues("Barbosa Suarez").into("//input[@id='doc']"));
                //Ingresa ARL
                actor.attemptsTo(Enter.keyValues("SURA").into("//input[@id='doc']"));
                //Ingresa EPS
                actor.attemptsTo(Enter.keyValues("COMPENSAR").into("//input[@id='doc']"));
                //Seleccionar tipo de Ingreso
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("Vehicular")));
                //Seleccionar ID tarjeta
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("123")));
                //Seleccionar agrupación
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("TOrre 2")));
                //Seleccionar unidad independiente
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("109")));
                //Ingresa placa
                actor.attemptsTo(Enter.keyValues("AHT748").into("//input[@id='doc']"));
                //Seleccionar parqueadero asignado
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("H5")));
                //Ingresa Motivo de ingreso
                actor.attemptsTo(Enter.keyValues("Visita familiar").into("//input[@id='doc']"));
                break;
            case ("no"):
                //Seleccionar tipo de documento
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("CC")));
                //INgresa número de documento
                actor.attemptsTo(Enter.keyValues("32454235").into("//input[@id='doc']"));
                //Ingresa Nombres
                actor.attemptsTo(Enter.keyValues("Jose Pedro").into("//input[@id='doc']"));
                //Ingresa Apellidos
                actor.attemptsTo(Enter.keyValues("Barbosa Suarez").into("//input[@id='doc']"));
                //Ingresa ARL
                actor.attemptsTo(Enter.keyValues("SURA").into("//input[@id='doc']"));
                break;
        }
    }

    @When("^Ingresa en registro visitante en el campo (.*) la informacion (.*)$")
    public void ingresaEnRegistroVisitanteEnElCampoCampo_requeridoLaInformacionInformacion(String campo, String informacion) {
        switch (campo){
            case ("Tipo de identificacion"):
            //Seleccionar tipo de documento
            actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText(informacion)));
            case ("Numero de documento"):
            //INgresa número de documento
            actor.attemptsTo(Enter.keyValues(informacion).into("//input[@id='doc']"));
            case ("Nombres"):
            //Ingresa Nombres
            actor.attemptsTo(Enter.keyValues(informacion).into("//input[@id='doc']"));
            case ("Apellidos"):
            //Ingresa Apellidos
            actor.attemptsTo(Enter.keyValues(informacion).into("//input[@id='doc']"));
            case ("Ingreso"):
            //Seleccionar tipo de Ingreso
            actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText(informacion)));
            case ("ID tarjeta"):
            //Seleccionar ID tarjeta
            actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText(informacion)));
            case ("Agrupacion"):
            //Seleccionar agrupación
            actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText(informacion)));
            case ("Unidad Independiente"):
            //Seleccionar unidad independiente
            actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText(informacion)));
            case ("Placa"):
            //Ingresa placa
            actor.attemptsTo(Enter.keyValues(informacion).into("//input[@id='doc']"));
            case ("Parqueadero asignado"):
            //Seleccionar parqueadero asignado
            actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText(informacion)));
            case ("Motivo de Ingreso"):
            //Ingresa Motivo de ingreso
            actor.attemptsTo(Enter.keyValues(informacion).into("//input[@id='doc']"));
            break;
        }
    }

    @Then("^Visualiza en registro visitante el resultado esperado (.*)$")
    public void visualizaEnRegistroVisitanteElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado esperado",
                "resultado esperado",
                "//input[@id='idEmail']"
        )));
    }

    @When("^Ingresa en registro visitante información en cada uno de los campos requeridos de forma correcta$")
    public void ingresaEnRegistroVisitanteInformacionEnCadaUnoDeLosCamposRequeridosDeFormaCorrecta() {
        //Seleccionar tipo de documento
        actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("CC")));
        //INgresa número de documento
        actor.attemptsTo(Enter.keyValues("32454235").into("//input[@id='doc']"));
        //Ingresa Nombres
        actor.attemptsTo(Enter.keyValues("Jose Pedro").into("//input[@id='doc']"));
        //Ingresa Apellidos
        actor.attemptsTo(Enter.keyValues("Barbosa Suarez").into("//input[@id='doc']"));
        //Ingresa ARL
        actor.attemptsTo(Enter.keyValues("SURA").into("//input[@id='doc']"));
        //Ingresa EPS
        actor.attemptsTo(Enter.keyValues("COMPENSAR").into("//input[@id='doc']"));
        //Seleccionar tipo de Ingreso
        actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("Vehicular")));
        //Seleccionar ID tarjeta
        actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("123")));
        //Seleccionar agrupación
        actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("TOrre 2")));
        //Seleccionar unidad independiente
        actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("109")));
        //Ingresa placa
        actor.attemptsTo(Enter.keyValues("AHT748").into("//input[@id='doc']"));
        //Seleccionar parqueadero asignado
        actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("H5")));
        //Ingresa Motivo de ingreso
        actor.attemptsTo(Enter.keyValues("Visita familiar").into("//input[@id='doc']"));

    }

    @Then("^Muestra el mensaje de registro exitoso de visitante$")
    public void muestraElMensajeDeRegistroExitosoDeVisitante() {
        actor.should(new QuestionValidate("Mensaje registro exitoso").Execute(new GeneralParams(
                "Mensaje registro exitoso",
                "Mensaje registro exitoso",
                "//input[@id='idEmail']"
        )));
    }

    @And("^redirige al usuario a la página de Administrar Ingreso y Salida$")
    public void redirigeAlUsuarioALaPaginaDeAdministrarIngresoYSalida() {
        actor.should(new QuestionValidate("Administración de Ingreso y salida").Execute(new GeneralParams(
                "Página de Administración de Ingreso y salida",
                "Administración de Ingreso y salida",
                "//p[contains(text()] "
        )));
    }

    @When("^Da clic en Enlace Tomar Foto$")
    public void daClicEnEnlaceTomarFoto() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'Ingresar')]").andThen(Actions::click));
    }

    @Then("^El sistema muestra el pop up el cual permitirá tomar una foto frontal de la persona$")
    public void elSistemaMuestraElPopUpElCualPermitiraTomarUnaFotoFrontalDeLaPersona() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }
}
