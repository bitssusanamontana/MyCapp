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
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AdministrarRoles {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Then("^Se visualizan los elementos de administrar roles$")
    public void elSistemaLaInformacionDeLosRolesExistentes() {
        // Filtro de búsqueda
        actor.should(seeThat(the("//button[@class='colm2 icon_search']"), isVisible()));
        //Etiqueta ‘Administración de roles’
        actor.should(seeThat(the("#h--title-name-rol"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("//th[@id='th--rol-0']"), isVisible()));
        //Botón Crear Rol
        actor.should(seeThat(the("#btn--add-rol"), isVisible()));
        //Paginación
        actor.should(seeThat(the("//div[@class='pagination']"), isVisible()));

    }

    @When("^Ingresa información en filtro de busqueda (.*)$")
    public void ingresaInformacionEnFiltroDeBusquedaBusqueda(String informacion) {
        actor.attemptsTo(Enter.theValue(informacion).into("//input[@id='ipt--search-filterId']"));

    }


    @And("^Da clic en buscar$")
    public void daClicEnBuscar() {
        actor.attemptsTo(Hit.the(Keys.ENTER).into("//input[@id='ipt--search-filterId']"));
    }

    @Then("^El sistema muestra los resultados (.*)$")
    public void elSistemaMuestraLosResultadosResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Verificación del resultado esperado",
                "Resultado esperado",
                "//tr[1]//td[1]"
        )));

    }

    @When("^De la tabla de Roles Selecciona una (.*)$")
    public void seleccionaUnaOpcion(String opcion) throws InterruptedException {
        switch (opcion) {
            case "consultar":
                actor.attemptsTo(Click.on("#btn--table-row-view3"));
                Thread.sleep(2000);
                break;
            case "modificar":
                actor.attemptsTo(Click.on("#btn--table-row-edit3"));
                Thread.sleep(2000);
                break;
            case "eliminar":
                actor.attemptsTo(Click.on("#btn--table-row-delete3"));
                Thread.sleep(2000);
                break;
            case "activar":
                actor.attemptsTo(Click.on("//tr[3]//td[2]//div[4]//div[1]//label[1]"));
                Thread.sleep(2000);
                break;
        }


    }

    @Then("^El sistema redirecciona por medio de una accion (.*)$")
    public void elSistemaRealizaUnaAccionAccion(String accion) {
        switch (accion) {
            case "Pagina consultar":
                actor.should(new QuestionValidate("Consultar Rol").Execute(new GeneralParams(
                        "campo requerido",
                        "campo requerido",
                        "#h--tittle-consult"
                )));
            case "Pagina modificar":
                actor.should(new QuestionValidate("Modificar Rol").Execute(new GeneralParams(
                        "campo requerido",
                        "campo requerido",
                        "#h--tittle-modify]"
                )));
                break;
            case "mensaje eliminar":
                actor.should(new QuestionValidate("Eliminar rol Administrador").Execute(new GeneralParams(
                        "Eliminar rol Administrador",
                        "Eliminar rol Administrador",
                        "#hHeader"
                )));
                break;
            case "mensaje activar":
                actor.should(new QuestionValidate("Inactivar rol Rol Indep").Execute(new GeneralParams(
                        "Eliminar rol Administrador",
                        "Eliminar rol Administrador",
                        "//h3[@id='hHeader']"
                )));
                break;
        }
    }


    @When("^Da clic en inactivar rol$")
    public void daClicEnActivarOInactivarRol() throws InterruptedException {
        actor.attemptsTo(Click.on("//tr[3]//td[2]//div[4]//div[1]//label[1]"));
        Thread.sleep(2000);
    }

    @Then("^Se visualiza el mensaje de confirmacion de inactivacion$")
    public void elSistemaPresentaUnMensajeInactivacion() {

        actor.should(new QuestionValidate("Inactivar rol Rol Indep").Execute(new GeneralParams(
                "Eliminar rol Administrador",
                "Eliminar rol Administrador",
                "//h3[@id='hHeader']"
        )));
    }


    @When("^Da clic en activar rol$")
    public void daClicEnActivarRol() {
        actor.attemptsTo(Click.on("//tr[3]//td[2]//div[4]//div[1]//label[1]"));
    }

    @And("^El usuario da clic en (.*) de inactivacion y se realiza una accion$")
    public void elUsuarioDaClicEnOpcion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(Click.on("#btn--footer-yes"));
            //mensaje de confirmación de inactivación
            actor.should(new QuestionValidate("Se inactivo el rol Rol Indep").Execute(new GeneralParams(
                    "Inactivar rol Rol Indep",
                    "Inactivar rol Rol Indep",
                    "#divMessage"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(Click.on("#btn--footer-no"));
            //Se cierra el pop up
            actor.should(seeThat(the("//#hHeader"), isNotVisible()));
        }

    }

    @Then("^El usuario da clic en (.*) de activacion y realiza una accion$")
    public void elUsuarioDaClicEnOpcionDeActivacionYRealizaUnaAccion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(Click.on("#btn--footer-yes"));
            //mensaje de confirmación de inactivación
            actor.should(new QuestionValidate("Se activo el rol Rol Indep").Execute(new GeneralParams(
                    "activar rol Rol Indep",
                    "activar rol Rol Indep",
                    "#divMessage"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(Click.on("#btn--footer-no"));
            //Se cierra el pop up
            actor.should(seeThat(the("//#hHeader"), isNotVisible()));
        }
    }

    @When("^Da clic sobre el icono de Eliminar rol de Admin$")
    public void daClicSobreElIconoDeEliminarRolDeAdmin() {
        actor.attemptsTo(Click.on("#btn--table-row-delete3"));
    }

    @Then("^El mensaje de confirmacion de activacion se muestra$")
    public void elSistemaDebePresentarElMensajeDeConfirmacion() {
        actor.should(new QuestionValidate("¿Está seguro de eliminar el rol Rol Indep ?").Execute(new GeneralParams(
                "eliminar rol Rol Indep",
                "eliminar rol Rol Indep",
                "#divMessage"
        )));
    }


    @And("^Presenta un pop up de Eliminación$")
    public void presentaUnPopUpDeEliminacion() {
        actor.should(seeThat(the("#hHeader"), isVisible()));
    }

    @And("^El sistema presenta mensaje de eliminación$")
    public void elSistemaPresentaMensajeDeEliminacion() {

        actor.should(seeThat(the("#divMessage"), isVisible()));
    }

    @And("^Las opciones de Si y no de eliminacion$")
    public void lasOpcionesDeSiYNo() {
        actor.should(seeThat(the("#btnYes"), isVisible()));
        actor.should(seeThat(the("#btnnoChangeState"), isVisible()));
    }

    @And("^Da clic sobre la (.*) de eliminacion$")
    public void daClicSobreLaOpcion(String opcion) {
        switch (opcion) {
            case "Si":
                actor.attemptsTo(Click.on("#btnYes"));
                actor.attemptsTo(Click.on("#btnCloseModal"));
                break;
            case "No":
                actor.attemptsTo(Click.on("#btnnoChangeState"));
                break;
        }

    }

    @Then("^El sistema tiene el (.*)$")
    public void elSistemaTieneElResultado(String resultado) {
        switch (resultado) {
            case "Elimina el rol":
                actor.should(seeThat(the("#btnDelete80"), isNotVisible()));
                break;
            case "Cierra el pop up":
                actor.should(seeThat(the("#divMessage"), isNotVisible()));
                break;
        }

    }

    @And("^Se muestra el mensaje de activacion de rol$")
    public void seMuestraElMensajeDeActivacionDeRol() {
        actor.should(seeThat(the("//div[@class='ctn-img']"), isVisible()));
    }


    @And("^Ingresa el usuario y la contrasena$")
    public void ingresaElUsuarioYLaContrasena() throws InterruptedException {
        actor.attemptsTo(Enter.theValue("rherrerar").into("//input[@id='userName']"));
        actor.attemptsTo(Enter.theValue("123456").into("//input[@id='password']"));
        Thread.sleep(2000);
    }

    @And("^Da clic en continuar$")
    public void daClicEnContinuar() throws InterruptedException {
        actor.attemptsTo(Click.on("//button[@id='login']"));
        Thread.sleep(2000);
    }
}
