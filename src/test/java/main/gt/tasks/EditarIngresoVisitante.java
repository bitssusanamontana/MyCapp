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

public class EditarIngresoVisitante {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic sobre el botón Editar Ingreso de visitante$")
    public void daClicRegistroVisitante() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'registro visitante')]").andThen(Actions::click));
    }

    @And("^Visualiza Label EDITAR INGRESO DE VISITANTE$")
    public void visualizaLabelEDITARINGRESODEVISITANTE() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Borra informacion del (.*)$")
    public void borraInformacionDelCampo_requerido(String campo) {
        switch (campo) {
            case ("Tipo de identificacion"):
                //Seleccionar tipo de documento
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("")));
            case ("Numero de documento"):
                //INgresa número de documento
                actor.attemptsTo(Enter.keyValues("").into("//input[@id='doc']"));
            case ("Nombres"):
                //Ingresa Nombres
                actor.attemptsTo(Enter.keyValues("").into("//input[@id='doc']"));
            case ("Apellidos"):
                //Ingresa Apellidos
                actor.attemptsTo(Enter.keyValues("").into("//input[@id='doc']"));
            case ("Ingreso"):
                //Seleccionar tipo de Ingreso
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("")));
            case ("ID tarjeta"):
                //Seleccionar ID tarjeta
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("")));
            case ("Agrupacion"):
                //Seleccionar agrupación
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("")));
            case ("Unidad Independiente"):
                //Seleccionar unidad independiente
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("")));
            case ("Placa"):
                //Ingresa placa
                actor.attemptsTo(Enter.keyValues("").into("//input[@id='doc']"));
            case ("Parqueadero asignado"):
                //Seleccionar parqueadero asignado
                actor.attemptsTo(Click.on(By.cssSelector("#mainMenu"), By.linkText("")));
            case ("Motivo de Ingreso"):
                //Ingresa Motivo de ingreso
                actor.attemptsTo(Enter.keyValues("").into("//input[@id='doc']"));
                break;
        }
    }

    @When("^(.*) toda la informacion en los campos requeridos en edicion de visitante$")
    public void ingresaTodaLaInformacionEnLosCamposRequeridosEnEdicionDeVisitante(String ingresa) {
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

    @When("^Ingresa en edicion visitante en el campo (.*) la informacion (.*)$")
    public void ingresaEnEdicionVisitanteEnElCampoCampo_requeridoLaInformacionInformacion(String campo, String informacion) {
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

    @Then("^Visualiza en edicion visitante el resultado esperado (.*)$")
    public void visualizaEnEdicionVisitanteElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado esperado",
                "resultado esperado",
                "//input[@id='idEmail']"
        )));
    }

    @When("^Ingresa en Edicion visitante información en cada uno de los campos requeridos de forma correcta$")
    public void ingresaEnEdicionVisitanteInformacionEnCadaUnoDeLosCamposRequeridosDeFormaCorrecta() {
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

    @Then("^Muestra el mensaje de edicion exitosa de visitante$")
    public void muestraElMensajeDeEdicionExitosaDeVisitante() {
        actor.should(new QuestionValidate("Mensaje edicion exitoso").Execute(new GeneralParams(
                "Mensaje edicion exitoso",
                "Mensaje edicion exitoso",
                "//input[@id='idEmail']"
        )));
    }
}
