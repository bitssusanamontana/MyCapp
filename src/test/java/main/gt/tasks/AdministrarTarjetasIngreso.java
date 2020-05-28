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
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AdministrarTarjetasIngreso {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic en Tarjetas de Ingreso$")
    public void daClicEnTarjetasDeIngreso() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'tarjetas ingreso')]").andThen(Actions::click));
    }

    @Then("^El sistema presenta la Ruta de navegacion$")
    public void elSistemaPresentaLaRutaDeNavegacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Label Administracion de Tarjetas$")
    public void labelAdministracionDeTarjetas() {

        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Tabla de registros$")
    public void tablaDeRegistros() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Boton carga masiva$")
    public void botonCargaMasiva() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^El boton de Crear ID$")
    public void elBotonDeCrearID() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @Then("^En Tarjeta de Ingreso El sistema muestra los resultados según la (.*)$")
    public void enTarjetaDeIngresoElSistemaMuestraLosResultadosSegunLaBusqueda(String busqueda) {
        switch (busqueda){
            case "visitante":
                actor.should(seeThat(the("/button[@name='action']"), isVisible()));
                break;
            case "2345":
                actor.should(seeThat(the("/button[@name= 'action']"), isVisible()));
                break;
        }
    }

    @When("^Da clic sobre cada (.*) de Tarjeta de Ingreso$")
    public void daClicSobreCadaFiltroDeTarjetaDeIngreso(String filtro) {
        switch (filtro){
            case "ID":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Tarjetas de Ingreso",
                        "filtro Tarjetas de Ingreso",
                        "//input[@id='password']"
                )));
                break;
            case "Numero":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Tarjetas de Ingreso",
                        "filtro Tarjetas de Ingreso",
                        "//input[ @id='password']"
                )));
                break;
            case "Tipo":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Tarjetas de Ingreso",
                        "filtro Tarjetas de Ingreso",
                        "//inp ut[@id='password']"
                )));
                break;
            case "Ingreso":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Tarjetas de Ingreso",
                        "filtro Tarjetas de Ingreso",
                        "//input[@ id='password']"
                )));
                break;
            case "Tecnologia":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en filtro Tarjetas de Ingreso",
                        "filtro Tarjetas de Ingreso",
                        "/ /input[@id='password']"
                )));
                break;
        }

    }

    @Then("^se presenta listado de las Tarjetas de ingreso$")
    public void sePresentaListadoDeLasTarjetasDeIngreso() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Tarjeta de Ingreso En el (.*) Se ingresa (.*)$")
    public void tarjetaDeIngresoEnElFiltroSeIngresaInformacion(String filtro, String informacion) {
        switch (filtro) {
            case "ID":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda",
                        "//input[@id='password']"
                )));
                break;
            case "Numero":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda nombre",
                        "//input[@id='password']"
                )));
                break;
            case "Tipo":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda ubicacion",
                        "//input[@id='password']"
                )));
                break;
            case "Ingreso":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda Activa",
                        "//input[@id='password']"
                )));
                break;
            case "Tecnologia":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en campo búsqueda",
                        "Campo búsqueda Activa",
                        "//input[@id='pas sword']"
                )));
                break;
        }
    }

    @Then("^Tarjeta de Ingreso Y muestra el (.*)$")
    public void tarjetaDeIngresoYMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "validación resultado",
                "Resultado",
                "//p[contains(text(),'+57')] "
        )));
    }

    @And("^Se muestra el(.*) en la tabla de tarjetas de ingreso$")
    public void seMuestraElResultadoEnLaTablaDeTarjetasDeIngreso(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "validación resultado",
                "Resultado",
                "//p[contains(text(),'+57')] "
        )));
    }

    @When("^En tarjetas de ingreso Selecciona una (.*)$")
    public void enTarjetasDeIngresoSeleccionaUnaOpcion(String opcion) {
        switch (opcion) {

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
                        "Check activar",
                        "//input[@id='password']"
                )));
                break;
        }


    }

    @Then("^En tarjetas de ingreso se realiza una accion (.*)$")
    public void enTarjetasDeIngresoSeRealizaUnaAccionAccion(String opcion, String accion) {
        switch (opcion) {

            case "modificar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "Página modificar",
                        "pagina modificar",
                        "//button[@name='action']"
                )));
                break;

            case "activar":
                actor.should(new QuestionValidate(accion).Execute(new GeneralParams(
                        "presenta mensaje",
                        "rol activado",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @When("^Da clic en Crear ID$")
    public void daClicEnCrearID() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en Crear ID",
                "Crear ID",
                "//button[@name='action']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Crear ID$")
    public void elSistemaRedireccionaALaPaginaDeCrearID() {
        actor.should(new QuestionValidate("Página Crear ID").Execute(new GeneralParams(
                "Página Crear ID",
                "Página Crear ID",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en Carga Masiva$")
    public void daClicEnCargaMasiva() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en Carga Masiva",
                "Carga Masiva",
                "//button[@name='action']"
        )));
    }

    @And("^El sistema redirecciona a la pagina de Carga Masiva$")
    public void elSistemaRedireccionaALaPaginaDeCargaMasiva() {
        actor.should(new QuestionValidate("Página Carga Masiva").Execute(new GeneralParams(
                "Página Carga Masiva",
                "Página Carga Masiva",
                "//button[@name='action']"
        )));
    }
}
