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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Managed;
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
        //actor.should(seeThat(the("/button[@name='action']"), isVisible()));
        //Etiqueta ‘Administración de roles’
        actor.should(seeThat(the("//h1[@id='titleName']"), isVisible()));
        //Sección Tabla
        actor.should(seeThat(the("//tr[1]//td[1]"), isVisible()));
        //Botón Crear Rol
        actor.should(seeThat(the("//button[@class='colm23 ng-star-inserted']"), isVisible()));
        //Paginación
        actor.should(seeThat(the("//div[@class='pagination']"), isVisible()));

    }

    @When("^Ingresa información en filtro de busqueda (.*)$")
    public void ingresaInformacionEnFiltroDeBusquedaBusqueda(String informacion) {
        actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                "Usuario ingresa texto en campo búsqueda",
                "Campo búsqueda",
                "//input[@id='password']"
        )));

    }


    @And("^Da clic en buscar$")
    public void daClicEnBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en buscar",
                "Botón buscar",
                "//input[@id='password']"
        )));
    }

    @Then("^El sistema muestra los resultados (.*)$")
    public void elSistemaMuestraLosResultadosResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Verificación del resultado esperado",
                "Resultado esperado",
                "//input[@id='password']"
        )));

    }

    @When("^De la tabla de Roles Selecciona una (.*)$")
    public void seleccionaUnaOpcion(String opcion) {
        switch (opcion) {
            case "consultar":
                actor.attemptsTo(Click.on("#btnConsult7"));
                break;
            case "modificar":
                actor.attemptsTo(Click.on("#btnEdit7"));

                break;
            case "eliminar":
                actor.attemptsTo(Click.on("btnDelete7"));
                break;
            case "activar":
                actor.attemptsTo(Click.on("#mat-checkbox-1"));
                break;
        }


    }

    @Then("^El sistema redirecciona por medio de una accion (.*)$")
    public void elSistemaRealizaUnaAccionAccion(String accion) throws InterruptedException {
        switch (accion) {
            case "Pagina consultar":
            case "Pagina modificar":
                actor.should(seeThat(the("//h2[@id='h--tittle']"), isVisible()));
                Thread.sleep(2000);
                break;
            case "mensaje eliminar":
                actor.should(seeThat(the("//h3[@id='hHeader']"), isVisible()));
                Thread.sleep(2000);
                break;
            case "mensaje activar":
                actor.should(seeThat(the("//div[@id='divMessage']"), isVisible()));
                Thread.sleep(2000);
                break;
        }
    }


    @When("^Da clic en inactivar rol$")
    public void daClicEnActivarOInactivarRol() throws InterruptedException {
        actor.attemptsTo(Click.on("//div[contains(text(),'2')]"));
        Thread.sleep(2000);
        actor.attemptsTo(Click.on("#mat-checkbox-94"));
        Thread.sleep(1000);

    }

    @Then("^Se visualiza el mensaje de confirmacion de inactivacion$")
    public void elSistemaPresentaUnMensajeInactivacion() {
        actor.should(seeThat(the("#divMessage"), isVisible()));
    }


    @When("^Da clic en activar rol$")
    public void daClicEnActivarRol() {
        actor.attemptsTo(Click.on("//div[contains(text(),'2')]"));
        actor.attemptsTo(Click.on("//mat-checkbox[@id='mat-checkbox-104']"));
    }

    @And("^El usuario da clic en (.*) de inactivacion y se realiza una accion$")
    public void elUsuarioDaClicEnOpcion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(Click.on("#btnYes"));
            //mensaje de confirmación de inactivación
            actor.should(seeThat(the("#divMessage"), isVisible()));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(Click.on("#btnnoChangeState"));
            //Se cierra el pop up
            actor.should(seeThat(the("//#hHeader"), isNotVisible()));
        }

    }

    @Then("^El usuario da clic en (.*) de activacion y realiza una accion$")
    public void elUsuarioDaClicEnOpcionDeActivacionYRealizaUnaAccion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(Click.on("#btnYes"));
            actor.should(seeThat(the("#divMessage"), isVisible()));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(Click.on("#btnnoChangeState"));
            //Se cierra el pop up
            actor.should(seeThat(the("#hHeader"), isNotVisible()));
        }
    }

    @When("^Da clic sobre el icono de Eliminar rol de Admin$")
    public void daClicSobreElIconoDeEliminarRolDeAdmin() {
        actor.attemptsTo(Click.on("#btnDelete80"));
    }

    @Then("^El mensaje de confirmacion de activacion se muestra$")
    public void elSistemaDebePresentarElMensajeDeConfirmacion() {
        actor.should(seeThat(the("//div[@id='divMessage']"), isVisible()));
    }

    @And("^Selecciona una (.*) del pop up y genera una accion$")
    public void seleccionaUnaOpcionDelMensajeDeConfirmacion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(Click.on("#btnYes"));
            actor.should(seeThat(the("#divMessage"), isVisible()));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(Click.on("#btnnoChangeState"));
            //Se cierra el pop up
            actor.should(seeThat(the("#hHeader"), isNotVisible()));
        }
    }

    @When("^Da clic sobre el icono de Eliminar rol de Administrador$")
    public void daClicSobreElIconoDeEliminarRolDeAdministrador() {
        actor.attemptsTo(Click.on("#btnDelete7"));
    }

    @Then("^Selecciona del rol administrador una (.*) del pop up y genera una accion$")
    public void seleccionaDelRolAdministradorUnaOpcionDelPopUpYGeneraUnaAccion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(Click.on("#btnYes"));
            actor.should(seeThat(the("#divMessage"), isVisible()));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(Click.on("#btnnoChangeState"));
            actor.should(seeThat(the("#hHeader"), isNotVisible()));
        }
    }


    @And("^Presenta un pop up de Eliminación$")
    public void presentaUnPopUpDeEliminacion() {
        actor.should(seeThat(the("#hHeader"), isVisible()));
    }

    @And("^El sistema presenta mensaje de eliminación$")
    public void elSistemaPresentaMensajeDeEliminacion() {
        actor.should(seeThat(the("#divMessage"), isVisible()));
    }

    @And("^Las opciones de Si y no$")
    public void lasOpcionesDeSiYNo() {
        actor.should(seeThat(the("#btnYes"), isVisible()));
        actor.should(seeThat(the("#btnnoChangeState"), isVisible()));
    }

    @And("^Da clic sobre la (.*)$")
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
