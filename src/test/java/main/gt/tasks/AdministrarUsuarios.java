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

public class AdministrarUsuarios {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Se visualiza la pagina Administracion de Usuarios$")
    public void seVisualizaLaPaginaAdministracionDeUsuarios() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Label Administracion de Usuarios$")
    public void labelAdministracionDeUsuarios() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^Tabla de registros de Usuarios$")
    public void tablaDeRegistrosDeUsuarios() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^Boton Crear Usuario$")
    public void botonCrearUsuario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @When("^En Usuarios Ingresa información en filtro de busqueda (.*)$")
    public void enUsuariosIngresaInformacionEnFiltroDeBusquedaBusqueda(String busqueda) {
        actor.attemptsTo(Enter.theValue(busqueda).into(""));
    }

    @And("^En Usuarios Da clic en buscar$")
    public void enUsuariosDaClicEnBuscar() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @Then("^En Administrar Usuarios El sistema muestra los resultados según la (.*)$")
    public void enAdministrarUsuariosElSistemaMuestraLosResultadosSegunLaBusqueda(String busqueda) {
        switch (busqueda) {
            case "barbosa":
                actor.should(new QuestionValidate("jbarbosa").Execute(new GeneralParams(
                        "Registro",
                        "//p[contains(text(),'')] "
                )));
                break;
            case "3454353":
                actor.should(new QuestionValidate("asalcedo").Execute(new GeneralParams(
                        "Registro",
                        "//p[contains(text(),'')] "
                )));
                break;
        }
    }

    @When("^En Administrar Usuarios Selecciona una (.*)$")
    public void enAdministrarUsuariosSeleccionaUnaOpcion(String opcion) {
        switch (opcion) {
            case "Modificar":
                actor.attemptsTo(Click.on(""));
                break;
            case "Consultar":
                actor.attemptsTo(Click.on(" "));
                break;
            case "Eliminar":
                actor.attemptsTo(Click.on("   "));
                break;
            case "Activa":
                actor.attemptsTo(Click.on("  "));
                break;
        }
    }

    @Then("^En Administrar Usuarios se realiza una accion (.*)$")
    public void enAdministrarUsuariosSeRealizaUnaAccionAccion(String accion) {
        switch (accion) {
            case "Pagina modificar":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "mensaje":
                actor.should(seeThat(the(" "), isVisible()));
                break;
            case "Pagina consultar":
                actor.should(seeThat(the("  "), isVisible()));
                break;
            case "confirmacion eliminar":
                actor.should(seeThat(the("    "), isVisible()));
                break;

        }
    }

    @When("^En administrar usuarios da clic en activar$")
    public void enAdministrarUsuariosDaClicEnActivar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En administrar usuariosse muestra la confirmacion de activacion$")
    public void enAdministrarUsuariosseMuestraLaConfirmacionDeActivacion() {
        actor.should(seeThat(the("    "), isVisible()));
    }

    @When("^En administrar usuarios da clic en inactivar$")
    public void enAdministrarUsuariosDaClicEnInactivar() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En administrar usuarios se muestra la confirmacion de inactivacion$")
    public void enAdministrarUsuariosSeMuestraLaConfirmacionDeInactivacion() {
        actor.should(seeThat(the("    "), isVisible()));
    }

    @And("^En administrar usuarios se muestra la confirmacion de activacion$")
    public void enAdministrarUsuariosSeMuestraLaConfirmacionDeActivacion() {
        actor.should(seeThat(the("    "), isVisible()));
    }

    @When("^En administrar usuarios se da clic en la (.*) de activacion$")
    public void enAdministrarUsuariosSeDaClicEnLaOpcionDeActivacion(String opcion) {
        switch (opcion) {
            case "si":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "no":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @Then("^En administrar usuarios realiza la (.*) de activar en administrar usuario$")
    public void enAdministrarUsuariosRealizaLaAccionDeActivarEnAdministrarUsuario(String accion) {
        switch (accion) {
            case "activo":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "inactivo":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @When("^En administrar usuarios se da clic en la (.*) de inactivacion$")
    public void enAdministrarUsuariosSeDaClicEnLaOpcionDeInactivacion(String opcion) {
        switch (opcion){
            case "si":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "no":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @Then("^En administrar usuarios realiza la (.*) de inactivar un usuario$")
    public void enAdministrarUsuariosRealizaLaAccionDeInactivarUnUsuario(String accion) {
        switch (accion){
            case "activo":
                actor.should(seeThat(the(""), isVisible()));
                break;
            case "inactivo":
                actor.should(seeThat(the(" "), isVisible()));
                break;
        }
    }

    @When("^En administrar usuarios Da clic en Crear Usuario$")
    public void enAdministrarUsuariosDaClicEnCrearUsuario() {actor.attemptsTo(Click.on(""));
    }

    @And("^El sistema redirecciona a la pagina de Crear Usuario$")
    public void elSistemaRedireccionaALaPaginaDeCrearUsuario() {
        actor.should(new QuestionValidate("Crear Usuario").Execute(new GeneralParams(
                "Página Crear Usuario",
                "//p[contains(text(),'')] "
        )));
    }
}
