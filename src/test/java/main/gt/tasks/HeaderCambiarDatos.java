package main.gt.tasks;


import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HeaderCambiarDatos {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Given("^Un usuario da clic sobre la foto de perfil $")
    public void unUsuarioDaClicSobreLaFotoDePerfil() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en foto de perfil",
                "Foto de perfil",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en la opción Cambiar datos$")
    public void daClicEnLaOpcionCambiarDatos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en cambiar datos",
                "Boton cambiar datos",
                "//button[@name='action']"
        )));
    }

    @And("^Presenta el campo nombre habilitado y nombre de usuario$")
    public void presentaElCampoNombreHabilitadoYNombreDeUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo apellido habilitado y apellido de usuario$")
    public void presentaElCampoApellidoHabilitadoYApellidoDeUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo correo electrónico habilitado$")
    public void presentaElCampoCorreoElectronicoHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo teléfono habilitado$")
    public void presentaElCampoTelefonoHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el botón Guardar habilitado$")
    public void presentaElBotonGuardarHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Opción de cerrar ventana emergente$")
    public void opcionDeCerrarVentanaEmergente() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Presenta el botón Cambiar habilitado$")
    public void presentaElBotonCambiarHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @When("^Da clic sobre la opción de cerrar la ventana emergente$")
    public void daClicSobreLaOpcionDeCerrarLaVentanaEmergente() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en cerrar",
                "Cerrar ventana",
                "//button[@name='action']"
        )));
    }

    @And("^Deja al usuario en la página que se encuentra actualmente$")
    public void dejaAlUsuarioEnLaPaginaQueSeEncuentraActualmente() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @When("^Ingresa en el campo de (.*) y borra la informacion$")
    public void ingresaEnElCampoDeCampoYBorraLaInformacion(String campo) {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "click en el campo",
                "contrasenaActual",
                "//button[@name='action']"
        )));
        switch (campo) {
            case "nombre":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar nombre",
                        "Borrar nombre",
                        "//button[@name='action']"
                )));
                break;
            case "apellido":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar apellido",
                        "Borrar apellido",
                        "//button[@name='action']"
                )));
                break;
            case "correo":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar correo",
                        "Borrar correo",
                        "//button[@name='action']"
                )));
                break;
            case "telefono":
                actor.attemptsTo(new EnterTextAction("").Execute(new GeneralParams(
                        "Borrar telefono",
                        "Borrar telefono",
                        "//button[@name='action']"
                )));
                break;
        }

    }

    @Then("^El boton de guardar se visualiza inhabilitado$")
    public void elBotonDeGuardarSeVisualizaInhabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isNotEnabled()));
    }

    @And("^Se presenta el mensaje de obligatoriedad$")
    public void sePresentaElMensaje() {
        actor.should(new QuestionValidate("Campo Obligatorio").Execute(new GeneralParams(
                "Mensaje de Obligatoriedad",
                "Campo Obligatorio",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa correctamente toda la informacion de los campos$")
    public void ingresaCorrectamenteTodaLaInformacionDeLosCampos() {
        //Ingresa nombre
        actor.attemptsTo(new EnterTextAction("Pepito").Execute(new GeneralParams(
                "Ingresar nombre",
                "nombre",
                "//button[@name='action']"
        )));
        //Ingresa apellido
        actor.attemptsTo(new EnterTextAction("Perez").Execute(new GeneralParams(
                "Ingresar apellido",
                "apellido",
                "//button[@name='action']"
        )));
        //Ingresa correo
        actor.attemptsTo(new EnterTextAction("pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "//button[@name='action']"
        )));
        //Ingresa telefono
        actor.attemptsTo(new EnterTextAction("7777777").Execute(new GeneralParams(
                "Ingresar telefono",
                "telefono",
                "//button[@name='action']"
        )));
    }

    @Then("^El boton de guardar se visualiza habilitado$")
    public void elBotonDeGuardarSeVisualizaHabilitado() {
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Da clic en el boton Guardar$")
    public void daClicEnElBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "click en guardad",
                "Botón guardar",
                "//button[@name='action']"
        )));
    }

    @Then("^Se verifica que el cambio se aplico$")
    public void seVerificaQueElCambioSeAplico() {
        actor.should(new QuestionValidate("Jose").Execute(new GeneralParams(
                "Cambio exitoso de nombre",
                "Cambio de nombre",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("Barbosa").Execute(new GeneralParams(
                "Cambio exitoso de apellido",
                "Cambio de apellido",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("jbarbosa@").Execute(new GeneralParams(
                "Cambio exitoso de correo",
                "Cambio de correo",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("7777777").Execute(new GeneralParams(
                "Cambio exitoso de telefono",
                "Cambio de telefono",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa en el cada campo informacion incorrecta$")
    public void IngresaEnElCampoLaInformacion() {
        actor.attemptsTo(new EnterTextAction("Pepito123").Execute(new GeneralParams(
                "Ingresar nombre",
                "nombre",
                "//button[@name='action']"
        )));
        //Ingresa apellido
        actor.attemptsTo(new EnterTextAction("Perez123").Execute(new GeneralParams(
                "Ingresar apellido",
                "apellido",
                "//button[@name='action']"
        )));
        //Ingresa correo
        actor.attemptsTo(new EnterTextAction("$%&/pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "//button[@name='action']"
        )));
        //Ingresa telefono
        actor.attemptsTo(new EnterTextAction("7777777skdjfdlskjdskl").Execute(new GeneralParams(
                "Ingresar telefono",
                "telefono",
                "//button[@name='action']"
        )));
    }

    @And("^muestra el resultado$")
    public void muestraElResultado() {
        actor.should(new QuestionValidate("Pepito").Execute(new GeneralParams(
                "Cambio exitoso de nombre",
                "Cambio de nombre",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("Perez").Execute(new GeneralParams(
                "Cambio exitoso de apellido",
                "Cambio de apellido",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("pepitoperez@hotmail.com").Execute(new GeneralParams(
                "Cambio exitoso de correo",
                "Cambio de correo",
                "//p[contains(text(),'correo')] "
        )));
        actor.should(new QuestionValidate("7777777").Execute(new GeneralParams(
                "Cambio exitoso de telefono",
                "Cambio de telefono",
                "//p[contains(text(),'correo')] "
        )));
    }

    @And("^Da clic sobre el campo teléfono$")
    public void daClicSobreElCampoTelefono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Clic en campo teléfono",
                "campo teléfono",
                "//button[@name='action']"
        )));
    }

    @And("^Da clic sobre el campo pais$")
    public void daClicSobreElCampoPais() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Clic en campo país",
                "campo país",
                "//button[@name='action']"
        )));
    }

    @When("^Selecciona el pais Colombia$")
    public void seleccionaElPaisColombia() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "selecciona país",
                "selección país",
                "//button[@name='action']"
        )));
    }

    @Then("^Se presenta el prefijo de Colombia$")
    public void sePresentaElPrefijo() {
        actor.should(new QuestionValidate("+57").Execute(new GeneralParams(
                "Prefijo",
                "prefijo",
                "//p[contains(text(),'+57')] "
        )));
    }

    @When("^Ingresa un (.*) de telefono$")
    public void ingresaUnNumeroDeTelefono(String numeroTelefono) {
        actor.attemptsTo(new EnterTextAction(numeroTelefono).Execute(new GeneralParams(
                "Ingresar telefono",
                "telefono",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema muestra la (.*) y Presenta el (.*) al poner el cursor encima$")
    public void elSistemaMuestraLaValidacion(String validacion, String mensaje) {
        if (validacion.equals("correcto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en icono correcto",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                    "mensaje icono correcto",
                    "//button[@name='action']"
            )));
        } else if (validacion.equals("incorrecto")) {
            actor.should(seeThat(the("//button[@name='action']"), isVisible()));
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "clic en icono incorrecto",
                    "//button[@name='action']"
            )));
            actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                    "mensaje icono incorrecto",
                    "//button[@name='action']"
            )));
        }
    }

    @And("^Ingresa un (.*)$")
    public void ingresaUnCorreo(String correo) {
        actor.attemptsTo(new EnterTextAction(correo).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "//button[@name='action']"
        )));
    }

    @When("^Coloca el cursor sobre el icono$")
    public void colocaElCursorSobreElIcono() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta un (.*)$")
    public void elSistemaPresentaUnMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "mensaje icono validado",
                "mensaje presentado",
                "//button[@name='action']"
        )));
    }

    @And("^Presenta el campo correo electrónico habilitado y correo de usuario$")
    public void presentaElCampoCorreoElectronicoHabilitadoYCorreoDeUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Presenta el campo teléfono habilitado y telefono de usuario$")
    public void presentaElCampoTelefonoHabilitadoYTelefonoDeUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
        actor.should(seeThat(the("//button[@name='action']"), isEnabled()));
    }

    @And("^Se presenta el mensaje de campo es requerido$")
    public void sePresentaElMensajeDeCampoEsRequerido() {
        actor.should(new QuestionValidate("Campo requerido").Execute(new GeneralParams(
                "mensaje icono correcto",
                "//button[@name='action']"
        )));
    }

    @When("^Se ingresa en el (.*) la (.*)$")
    public void seIngresaEnElCampoLaInformacion(String campo, String informacion) {
        switch (campo) {
            case "nombre":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Ingresar correo",
                        "correo",
                        "//button[@name='action']"
                )));
                break;
            case "apellido":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Ingresar correo",
                        "correo",
                        "// button[@name='action']"
                )));
                break;
            case "telefono":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Ingresar correo",
                        "correo",
                        "// but ton[@name='action']"
                )));
                break;
            case "correo":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Ingresar correo",
                        "correo",
                        "// button[@name='act ion']"
                )));
                break;


        }
    }

    @And("^muestra el (.*)$")
    public void muestraElResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Prefijo",
                "prefijo",
                "//p[contains(text(),'+57')] "
        )));

    }


    @And("^Presenta el (.*) al poner el cursor encima$")
    public void presentaElResultadoAlPonerElCursorEncima(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Mensaje de resultado",
                "mensaje de resultado",
                "//p[contains(text(),'+57')] "
        )));
    }

    @And("^Da clic sobre el campo correo$")
    public void daClicSobreElCampoCorreo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en correo",
                "//button[@name='action']"
        )));
    }

    @When("^El usuario da clic en el botón guardar$")
    public void elUsuarioDaClicEnElBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en guardar",
                "//button[@name='action']"
        )));
    }

    @Then("^Se muestra el mensaje de actualización exitosa$")
    public void seMuestraElMensajeDeActualizacionExitosa() {
        actor.should(new QuestionValidate("Se ha realizado el cambio de datos de forma correcta").Execute(new GeneralParams(
                "Mensaje de resultado",
                "mensaje de resultado",
                "//p[contains(text(),'+57')] "
        )));
    }

    @When("^Se ingresan los datos (.*), (.*),(.*) y (.*)$")
    public void seIngresanLosDatosNombreApellidoCorreoYTelefono(String nombre, String apellido, String correo, String telefono) {
        actor.attemptsTo(new EnterTextAction(nombre).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
        actor.attemptsTo(new EnterTextAction(apellido).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
        actor.attemptsTo(new EnterTextAction(correo).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
        actor.attemptsTo(new EnterTextAction(telefono).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
    }

    @Then("^Se verifica que el cambio se aplico en los datos de los datos (.*), (.*),(.*) y (.*)$")
    public void seVerificaQueElCambioSeAplicoEnLosDatosDeLosDatosNombreApellidoCorreoYTelefono(String nombre, String apellido, String correo, String telefono) {
        actor.should(new QuestionValidate(nombre).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
        actor.should(new QuestionValidate(apellido).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
        actor.should(new QuestionValidate(correo).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
        actor.should(new QuestionValidate(telefono).Execute(new GeneralParams(
                "Ingresar correo",
                "correo",
                "// button[@name='act ion']"
        )));
    }
}
