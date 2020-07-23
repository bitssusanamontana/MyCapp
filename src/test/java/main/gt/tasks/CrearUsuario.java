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


public class CrearUsuario {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Se da clic en Administar usuarios$")
    public void seDaClicEnAdministarUsuarios() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^da clic en crear usuario$")
    public void daClicEnCrearUsuario() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta formulario Crear usuario$")
    public void elSistemaPresentaFormularioCrearUsuario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza el formulario$")
    public void enCrearUsuarioVisualizaElFormulario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo tipo de identificacion$")
    public void enCrearUsuarioVisualizaCampoTipoDeIdentificacion() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo numero de identificacion$")
    public void enCrearUsuarioVisualizaCampoNumeroDeIdentificacion() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo nombre$")
    public void enCrearUsuarioVisualizaCampoNombre() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo apellidos$")
    public void enCrearUsuarioVisualizaCampoApellidos() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo telefono$")
    public void enCrearUsuarioVisualizaCampoTelefono() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo rol$")
    public void enCrearUsuarioVisualizaCampoRol() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza campo usuario$")
    public void enCrearUsuarioVisualizaCampoUsuario() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza el enlace tomar foto$")
    public void enCrearUsuarioVisualizaElEnlaceTomarFoto() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @And("^En crear usuario visualiza boton de guardar bloqueado$")
    public void enCrearUsuarioVisualizaBotonDeGuardarBloqueado() {
        actor.should(seeThat(the(""),isNotEnabled()));
    }

    @When("^En crear usuario da clic en (.*)$")
    public void enCrearUsuarioDaClicEnCampo_requerido(String campo) {
        switch (campo){
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

    @And("^En crear usuario da clic en el boton guardar$")
    public void enCrearUsuarioDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En crear usuario se presenta mensaje indicando que el campo es requerido$")
    public void enCrearUsuarioSePresentaMensajeIndicandoQueElCampoEsRequerido() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @When("^En crear usuario ingresa o selecciona informacion en los campos (.*) (.*) (.*) (.*) (.*) y (.*)$")
    public void enCrearUsuarioIngresaOSeleccionaInformacionEnLosCamposTipo_documentoDocumentoNombreApellidosTelefonoYRol(String tipo_doc, String documento, String nombre, String apellidos, String telefono, String rol) {
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(tipo_doc)));
        actor.attemptsTo(Enter.theValue(documento).into(""));
        actor.attemptsTo(Enter.theValue(nombre).into(""));
        actor.attemptsTo(Enter.theValue(apellidos).into(""));
        actor.attemptsTo(Enter.theValue(telefono).into(""));
        actor.attemptsTo(Click.on(By.cssSelector(""), By.linkText(rol)));
}

    @Then("^En crear usuario sistema presenta (.*) el boton de guardar$")
    public void enCrearUsuarioSistemaPresentaHabilitadoElBotonDeGuardar(String habilitado) {
        switch (habilitado){
            case "si":
                actor.should(seeThat(the(""), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the(""), isNotEnabled()));
                break;
        }
    }

    @When("^En crear usuario Ingresa o selecciona en el (.*) del formulario un (.*)$")
    public void enCrearUsuarioIngresaOSeleccionaEnElCampoDelFormularioUnValor(String campo, String valor) {
        switch (campo){
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


    @Then("^En crear usuario El sistema muestra el (.*)$")
    public void enCrearUsuarioElSistemaMuestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado de ingreso",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^En crear usuario da clic en boton guardar$")
    public void enCrearUsuarioDaClicEnBotonGuardar() {
        actor.attemptsTo(Click.on("     "));
    }

    @Then("^En crear usuario sistema presenta el (.*) de exito o error$")
    public void enCrearUsuarioSistemaPresentaElMensajeDeExitoOError(String mensaje) {
        switch (mensaje){
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

    @And("^En crear usuario muestra en el campo usuario el (.*)$")
    public void enCrearUsuarioMuestraEnElCampoUsuarioElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Usuario",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En crear usuario da clic enlace a Agregar foto$")
    public void enCrearUsuarioDaClicEnlaceAAgregarFoto() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^visualiza las opciones para agregar una foto$")
    public void visualizaLasOpcionesParaAgregarUnaFoto() {
        actor.should(seeThat(the(""),isVisible()));
    }

    @When("^en crear usuario selecciona una de las (.*)$")
    public void enCrearUsuarioSeleccionaUnaDeLasOpciones(String opciones) {
        switch (opciones){
            case "subir foto":
                actor.attemptsTo(Click.on(""));
                break;
            case "tomar foto":
                actor.attemptsTo(Click.on(" "));
                break;
        }
    }

    @Then("^En crear usuario se presenta una (.*)$")
    public void enCrearUsuarioSePresentaUnaAccion(String accion) {
        switch (accion){
            case "aplicacion camara":
                actor.should(seeThat(the(""),isVisible()));
                break;
            case "pop up seleccion foto":
                actor.should(seeThat(the(" "),isVisible()));
                break;
        }
    }

    @When("^En crear usuario sube una foto$")
    public void enCrearUsuarioSubeUnaFoto() {
        actor.attemptsTo(Click.on(" "));
    }

    @Then("^Se muestra la foto cargada$")
    public void seMuestraLaFotoCargada() {
        actor.should(seeThat(the(" "),isVisible()));
    }

    @When("^En crear usuario se clic en la foto$")
    public void enCrearUsuarioSeClicEnLaFoto() {
        actor.attemptsTo(Click.on(" "));
    }

    @Then("^se visualizan las opciones de edicion de la foto$")
    public void seVisualizanLasOpcionesDeEdicionDeLaFoto() {
        actor.should(seeThat(the(" "),isVisible()));
        actor.should(seeThat(the(" "),isVisible()));
        actor.should(seeThat(the(" "),isVisible()));
        actor.should(seeThat(the(" "),isVisible()));
    }

    @When("^En crear usuario escoge eliminar foto$")
    public void enCrearUsuarioEscogeEliminarFoto() {
        actor.attemptsTo(Click.on(" "));
    }

    @And("^En crear usuario se presenta un pop up de confirmacion de eliminacion$")
    public void enCrearUsuarioSePresentaUnPopUpDeConfirmacionDeEliminacion() {
        actor.should(seeThat(the(" "),isVisible()));
    }

    @And("^En crear usuario selecciona la opcion de (.*) eliminar$")
    public void enCrearUsuarioSeleccionaLaOpcionDeOpcionEliminar(String opcion) {
        switch (opcion){
            case "si":
                actor.attemptsTo(Click.on(""));
                break;
            case "no":
                actor.attemptsTo(Click.on(" "));
                break;
        }
    }

    @Then("^En crear usuario se tiene la (.*) de eliminar$")
    public void enCrearUsuarioSeTieneLaAccionDeEliminar(String accion) {
        switch (accion){
            case "foto eliminada":
                actor.should(seeThat(the(" "),isNotVisible()));
                break;
            case "cierra pop up":
                actor.should(seeThat(the("  "),isNotVisible()));
                break;
        }
    }
}
