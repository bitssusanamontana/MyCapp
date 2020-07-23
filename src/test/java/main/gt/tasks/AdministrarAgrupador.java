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
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AdministrarAgrupador {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    Target MODIFICAR_AGRUPADOR = Target.the("MODIFICAR AGRUPADOR").located(By.cssSelector(""));



    @And("^da clic en el agrupador deseado$")
    public void daClicEnElAgrupadorDeseado() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Se visualiza Administrar Agrupador$")
    public void seVisualizaAdministrarAgrupador() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^Label Administracion de Agrupador$")
    public void labelAdministracionDeAgrupador() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^Tabla de registros de Unidades independientes$")
    public void tablaDeRegistrosDeUnidadesIndependientes() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^Boton Crear Unidad Independiente$")
    public void botonCrearUnidadIndependiente() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @Then("^En Administrar agrupador El sistema muestra los resultados según la (.*)$")
    public void enAdministrarAgrupadorElSistemaMuestraLosResultadosSegunLaBusqueda(String busqueda) {
        switch (busqueda){
            case "H1":
                actor.should(new QuestionValidate("Agrupador H1").Execute(new GeneralParams(
                        "Registro",
                        "//p[contains(text(),'')] "
                )));
                break;
            case "P5":
                actor.should(new QuestionValidate("Torre P5").Execute(new GeneralParams(
                        "Registro",
                        "//p[contains(text(),'')] "
                )));
                break;
        }
    }

    @When("^En Administrar Agrupador Selecciona una (.*)$")
    public void enAdministrarAgrupadorSeleccionaUnaOpcion(String opcion) {
        switch (opcion){
            case "Modificar":
                actor.attemptsTo(Click.on(""));
                break;
            case "Activa":
                actor.attemptsTo(Click.on(" "));
                break;
        }
    }

    @Then("^En Administrar Agrupador se realiza una accion (.*)$")
    public void enAdministrarAgrupadorSeRealizaUnaAccionAccion(String accion) {
        switch (accion){
            case "Pagina modificar":
                actor.should(seeThat(the(""),isVisible()));
                break;
            case "mensaje":
                actor.should(seeThat(the(" "),isVisible()));
                break;

        }
    }

    @When("^En administrar agrupador da clic en activar$")
    public void enAdministrarAgrupadorDaClicEnActivar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^se muestra la confirmacion de activacion$")
    public void seMuestraLaConfirmacionDeActivacion() {
        actor.should(new QuestionValidate("Agrupador activado").Execute(new GeneralParams(
                "Activación",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En administrar agrupador da clic en inactivar$")
    public void enAdministrarAgrupadorDaClicEnInactivar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^se muestra la confirmacion de inactivacion$")
    public void seMuestraLaConfirmacionDeInactivacion() {
        actor.should(new QuestionValidate("Agrupador inactivado").Execute(new GeneralParams(
                "Inactivación",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^se da clic en la (.*) de activacion$")
    public void seDaClicEnLaOpcionDeActivacion(String opcion) {
        switch (opcion){
            case "si":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "no":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @Then("^realiza la (.*) de activar en administrar agrupador$")
    public void realizaLaAccionEnAdministrarAgrupador(String accion) {
        switch (accion){
            case "activo":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "inactivo":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @Then("^realiza la (.*) de inactivar en administrar agrupador$")
    public void realizaLaAccionInactivarEnAdministrarAgrupador(String accion) {
        switch (accion){
            case "activo":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "inactivo":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @When("^se da clic en la (.*) de inactivacion$")
    public void seDaClicEnLaOpcionDeInactivacion(String opcion) {
        switch (opcion){
            case "si":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "no":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @When("^Da clic en Crear Unidad Independiente$")
    public void daClicEnCrearUnidadIndependiente() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^El sistema redirecciona a la pagina de Crear Unidad Independiente$")
    public void elSistemaRedireccionaALaPaginaDeCrearUnidadIndependiente() {
        actor.should(new QuestionValidate("Crear Unidad Independiente").Execute(new GeneralParams(
                "Página Crear Unidad Independiente",
                "//p[contains(text(),'correo')] "
        )));
    }
}
