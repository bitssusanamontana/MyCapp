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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ModificarUsuario {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^da clic en modificar usuario$")
    public void daClicEnModificarUsuario() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario modificar usuario$")
    public void elSistemaPresentaFormularioModificarUsuario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza el formulario$")
    public void enModificarUsuarioVisualizaElFormulario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo tipo de identificacion$")
    public void enModificarUsuarioVisualizaCampoTipoDeIdentificacion() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo numero de identificacion$")
    public void enModificarUsuarioVisualizaCampoNumeroDeIdentificacion() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo nombre$")
    public void enModificarUsuarioVisualizaCampoNombre() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo apellidos$")
    public void enModificarUsuarioVisualizaCampoApellidos() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo telefono$")
    public void enModificarUsuarioVisualizaCampoTelefono() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo rol$")
    public void enModificarUsuarioVisualizaCampoRol() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza campo usuario$")
    public void enModificarUsuarioVisualizaCampoUsuario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza el enlace tomar foto$")
    public void enModificarUsuarioVisualizaElEnlaceTomarFoto() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En modificar usuario visualiza boton de guardar bloqueado$")
    public void enModificarUsuarioVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""), isNotEnabled()));
    }

    @When("^En modificar usuario borra la información del (.*)$")
    public void enModificarUsuarioBorraLaInformacionDelCampo_requerido(String campo) {
        switch (campo) {
            case "tipo de documento":
                actor.attemptsTo(Click.on(""));
                break;
            case "documento":
                actor.attemptsTo(Click.on(" "));
                break;
            case "nombre":
                actor.attemptsTo(Click.on("  "));
                break;
            case "apellidos":
                actor.attemptsTo(Click.on("   "));
                break;
            case "telefono":
                actor.attemptsTo(Click.on("     "));
                break;
            case "rol":
                actor.attemptsTo(Click.on("      "));
                break;
        }
    }

    @And("^En modificar usuario da clic en el boton guardar$")
    public void enModificarUsuarioDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En modificar usuario se presenta mensaje indicando que el campo es requerido$")
    public void enModificarUsuarioSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @When("^En modificar usuario ingresa o selecciona informacion en los campos (.*) (.*) (.*) (.*) (.*) y (.*)$")
    public void enModificarUsuarioIngresaOSeleccionaInformacionEnLosCamposTipo_documentoDocumentoNombreApellidosTelefonoYRol(String tipo_doc, String documento, String nombre, String apellidos, String telefono, String rol) {
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(tipo_doc)));
        actor.attemptsTo(Enter.theValue(documento).into(""));
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(apellidos).into(""));
        actor.attemptsTo(Enter.theValue(telefono).into(""));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(rol)));
    }

    @Then("^En modificar usuario sistema presenta (.*) el boton de guardar$")
    public void enModificarUsuarioSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado) {
            case "si":
                actor.should(seeThat(the(""), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""), isNotEnabled()));
                break;
        }
    }

    @When("^En modificar usuario Ingresa o selecciona en el (.*) del formulario un (.*)$")
    public void enModificarUsuarioIngresaOSeleccionaEnElCampoDelFormularioUnValor(String campo, String valor) {
        switch (campo) {
            case "tipo documento":
                actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(valor)));
                break;
            case "documento":
                actor.attemptsTo(Enter.theValue(valor).into(""));
                break;
            case "nombre":
                actor.attemptsTo(Enter.theValue(valor).into(" "));
                break;
            case "apellidos":
                actor.attemptsTo(Enter.theValue(valor).into("  "));
                break;
            case "telefono":
                actor.attemptsTo(Enter.theValue(valor).into("    "));
                break;
            case "tipo de vehiculo":
                actor.attemptsTo(Click.on(By.cssSelector("   "), By.linkText(valor)));
                break;
        }
    }

    @Then("^En modificar usuario El sistema muestra el (.*)$")
    public void enModificarUsuarioElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En modificar usuario da clic enlace a Agregar foto$")
    public void enModificarUsuarioDaClicEnlaceAAgregarFoto() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En modificar visualiza las opciones para agregar una foto$")
    public void enModificarVisualizaLasOpcionesParaAgregarUnaFoto() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @When("^En modificar usuario sube una foto$")
    public void enModificarUsuarioSubeUnaFoto() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En modificar Se muestra la foto cargada$")
    public void enModificarSeMuestraLaFotoCargada() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @When("^En modificar usuario se clic en la foto$")
    public void enModificarUsuarioSeClicEnLaFoto() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En modificar se visualizan las opciones de edicion de la foto$")
    public void enModificarSeVisualizanLasOpcionesDeEdicionDeLaFoto() {
        actor.should(seeThat(the(" "), isVisible()));
        actor.should(seeThat(the(" "), isVisible()));
        actor.should(seeThat(the(" "), isVisible()));
        actor.should(seeThat(the(" "), isVisible()));
    }

    @When("^En modificar usuario escoge eliminar foto$")
    public void enModificarUsuarioEscogeEliminarFoto() {
        actor.attemptsTo(Click.on("     "));
    }

    @And("^En modificar usuario se presenta un pop up de confirmacion de eliminacion$")
    public void enModificarUsuarioSePresentaUnPopUpDeConfirmacionDeEliminacion() {
        actor.should(seeThat(the(" "), isVisible()));
    }

    @And("^En modificar usuario selecciona la opcion de (.*) eliminar$")
    public void enModificarUsuarioSeleccionaLaOpcionDeOpcionEliminar(String opcion) {
        switch (opcion) {
            case "si":
                actor.attemptsTo(Click.on(""));
                break;
            case "no":
                actor.attemptsTo(Click.on(" "));
                break;
        }
    }

    @Then("^En modificar usuario se tiene la (.*) de eliminar$")
    public void enModificarUsuarioSeTieneLaAccionDeEliminar(String accion) {
        switch (accion) {
            case "foto eliminada":
                actor.should(seeThat(the(" "), isNotVisible()));
                break;
            case "cierra pop up":
                actor.should(seeThat(the("  "), isNotVisible()));
                break;
        }
    }

    @And("^En modificar usuario muestra en el campo usuario el (.*)$")
    public void enModificarUsuarioMuestraEnElCampoUsuarioElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^En modificar usuario da clic en boton guardar$")
    public void enModificarUsuarioDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En modificar usuario sistema presenta el (.*) de exito o error$")
    public void enModificarUsuarioSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje) {
            case "exito":
                actor.should(new QuestionValidate("Usuario creado exitosamente").Execute(new GeneralParams(
                        "Usuario creada exitosamente",
                        "//p[contains(text(),'correo')] "
                )));
                break;
            case "existente":
                actor.should(new QuestionValidate("Usuario existente").Execute(new GeneralParams(
                        "Usuario ya existente",
                        "/)] "
                )));
                break;
        }
    }
}
