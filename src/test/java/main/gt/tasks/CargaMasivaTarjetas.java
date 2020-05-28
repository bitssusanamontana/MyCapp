package main.gt.tasks;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.actions.MoveMouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Predicate;

public class CargaMasivaTarjetas {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic sobre Carga Masiva$")
    public void daClicSobreCargaMasiva() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'Carga Masiva')]").andThen(Actions::click));
    }

    @And("^El usuario visualiza el label “CARGA MASIVA DE ID DE TARJETAS DE INGRESO”$")
    public void elUsuarioVisualizaElLabelCARGAMASIVA() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el label informativo$")
    public void elUsuarioVisualizaElLabelInformativo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el Enlace de descarga: Descargar archivo CSV en Blanco$")
    public void elUsuarioVisualizaElEnlaceDeDescargaDescargarArchivoCSVEnBlanco() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el Enlace de descarga: Descargar archivo CSV de Ejemplo$")
    public void elUsuarioVisualizaElEnlaceDeDescargaDescargarArchivoCSVDeEjemplo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el Boton Cargar Archivo CSV$")
    public void elUsuarioVisualizaElBotonCargarArchivoCSV() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @Then("^Se muestra un mensaje de confirmacion para salir de Carga Masiva$")
    public void seMuestraUnMensajeDeConfirmacionParaSalirDeCargaMasiva() {
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("¿Está seguro de que desea salir de la página Carga Masiva de Tarjetas de Ingreso?")));
    }

    @When("^Da clic en Boton Cargar Archivo CSV$")
    public void daClicEnBotonCargarArchivoCSV() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'Cargar Archivo')]").andThen(Actions::click));
    }


    @And("^No carga ningún archivo$")
    public void noCargaNingunArchivo() {
        actor.attemptsTo(Click.on("//a[contains(text(),'clic cerrar')]"));
    }


    @Then("^El sistema presenta mensaje de error de carga$")
    public void elSistemaPresentaMensajeDeErrorDeCarga() {
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual("No se ha cargado el archivo")));
    }

    @When("^Selecciona un archivo con (.*)$")
    public void seleccionaUnArchivoConFormato(String formato) {
        switch (formato) {
            case "CSV":
                RemoteWebDriver rdriver = new RemoteWebDriver(null);
                rdriver.setFileDetector(new LocalFileDetector());
                WebElement element = rdriver.findElement(By.xpath("//button[@name='action']"));
                element.sendKeys("//ruta");
                break;
            case "xls":
                element = (WebElement) By.xpath("//bu tton[@name='action']");
                element.sendKeys("//ruta");
                break;

        }
    }

    @And("^Da clic en Cargar$")
    public void daClicEnCargar() {
        actor.attemptsTo(Click.on("//a[contains(text(),'clic cargar')]"));
    }


    @Then("^Se (.*) el boton guardar$")
    public void seActivaElBotonGuardar(String activa) {
        switch (activa) {
            case "Si":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
                break;
        }

    }

    @When("^Selecciona un archivo (.*)$")
    public void seleccionaUnArchivoDiligenciado(String diligenciado) {
        switch (diligenciado) {
            case "Si":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
                break;
        }
    }

    @Then("^Se tiene el mensaje de carga (.*)$")
    public void seTieneElMensajeDeCargaMensaje(String mensaje_carga) {
        switch (mensaje_carga) {
            case "Carga exitosa":
                actor.should(seeThat(the("//button[@name='action']"),
                        Predicate.isEqual("Se han creado exitosamente las Tarjetas de Ingreso")));
                break;
            case "Error de carga":
                actor.should(seeThat(the("//button[@name='action']"),
                        Predicate.isEqual("Existen registros con información incompleta, por favor revisar y volver a realizar la carga")));
                break;
        }
    }

    @When("^Se da clic en el enlace de descarca (.*)$")
    public void seDaClicEnElEnlaceDeDescarcaEnlace(String enlace) {
        switch (enlace) {
            case "Ejemplo":
                actor.attemptsTo(Click.on("//a[contains(text(),'clic ejemplo')]"));
                break;
            case "Blanco":
                actor.attemptsTo(Click.on("//a[contains(text(),'clic blanco')]"));
                break;
        }
    }

    @Then("^El sistema descarga el archivo (.*) en formato CSV$")
    public void elSistemaDescargaElArchivoCorrespondienteEnFormatoCSV(String correspondiente) {
        switch (correspondiente) {
            case "Con registros":
                actor.attemptsTo(Click.on("//a[contains(text(),'clic ejemplo')]"));
                break;
            case "Sin registros":
                actor.attemptsTo(Click.on("//a[contains(text(),'clic blanco')]"));
                break;
        }
    }
}
