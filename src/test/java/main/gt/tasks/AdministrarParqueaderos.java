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
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AdministrarParqueaderos {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Label Administracion de Parqueaderos$")
    public void labelAdministracionDeParqueaderos() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^Tabla de registros de Parqueaderos$")
    public void tablaDeRegistrosDeParqueaderos() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^Boton Crear Parqueadero$")
    public void botonCrearParqueadero() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @When("^En Parqueaderos Ingresa información en filtro de busqueda (.*)$")
    public void enParqueaderosIngresaInformacionEnFiltroDeBusquedaBusqueda(String busqueda) {
        actor.attemptsTo(Enter.theValue(busqueda).into(""));
    }

    @And("^En Parqueaderos Da clic en buscar$")
    public void enParqueaderosDaClicEnBuscar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En Administrar Parqueaderos El sistema muestra los resultados según la (.*)$")
    public void enAdministrarParqueaderosElSistemaMuestraLosResultadosSegunLaBusqueda(String busqueda) {
        switch (busqueda){
            case "H1":
                actor.should(new QuestionValidate("Parqueadero H1").Execute(new GeneralParams(
                        "Registro",
                        "//p[contains(text(),'')] "
                )));
                break;
            case "P5":
                actor.should(new QuestionValidate("Parqueadero P5").Execute(new GeneralParams(
                        "Registro",
                        "//p[contains(text(),'')] "
                )));
                break;
        }
    }

    @When("^En Administrar Parqueaderos Selecciona una (.*)$")
    public void enAdministrarParqueaderosSeleccionaUnaOpcion(String opcion) {
        switch (opcion){
            case "Modificar":
                actor.attemptsTo(Click.on(""));
                break;
            case "Activa":
                actor.attemptsTo(Click.on(" "));
                break;
        }
    }

    @Then("^En Administrar Parqueaderos se realiza una accion (.*)$")
    public void enAdministrarParqueaderosSeRealizaUnaAccionAccion(String accion) {
        switch (accion){
            case "Pagina modificar":
                actor.should(seeThat(the(""),isVisible()));
                break;
            case "mensaje":
                actor.should(seeThat(the(" "),isVisible()));
                break;

        }
    }

    @When("^En administrar Parqueaderos da clic en activar$")
    public void enAdministrarParqueaderosDaClicEnActivar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En administrar Parqueaderos se muestra la confirmacion de activacion$")
    public void enAdministrarParqueaderosSeMuestraLaConfirmacionDeActivacion() {
        actor.should(new QuestionValidate("Parqueadero activado").Execute(new GeneralParams(
                "Activación",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En administrar Parqueaderos da clic en inactivar$")
    public void enAdministrarParqueaderosDaClicEnInactivar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En administrar Parqueaderos se muestra la confirmacion de inactivacion$")
    public void enAdministrarParqueaderosSeMuestraLaConfirmacionDeInactivacion() {
        actor.should(new QuestionValidate("Parqueadero inactivado").Execute(new GeneralParams(
                "Activación",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En administrar Parqueaderos se da clic en la (.*) de activacion$")
    public void enAdministrarParqueaderosSeDaClicEnLaOpcionDeActivacion(String opcion) {
        switch (opcion){
            case "si":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "no":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @Then("^En administrar Parqueaderos realiza la (.*) de activar parqueadero$")
    public void enAdministrarParqueaderosRealizaLaAccionDeActivarParqueadero(String accion) {
        switch (accion){
            case "activo":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "inactivo":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @When("^En administrar Parqueaderos se da clic en la (.*) de inactivacion$")
    public void enAdministrarParqueaderosSeDaClicEnLaOpcionDeInactivacion(String opcion) {
        switch (opcion){
            case "si":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "no":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @Then("^En administrar Parqueaderos realiza la (.*) de inactivar en administrar agrupador$")
    public void enAdministrarParqueaderosRealizaLaAccionDeInactivarEnAdministrarAgrupador(String accion) {
        switch (accion){
            case "activo":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "inactivo":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @When("^Da clic en Crear Parqueadero$")
    public void daClicEnCrearParqueadero() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^El sistema redirecciona a la pagina de Crear Parqueadero$")
    public void elSistemaRedireccionaALaPaginaDeCrearParqueadero() {
        actor.should(new QuestionValidate("Crear Parqueadero").Execute(new GeneralParams(
                "Página Crear Parqueadero",
                "//p[contains(text(),'')] "
        )));
    }
}
