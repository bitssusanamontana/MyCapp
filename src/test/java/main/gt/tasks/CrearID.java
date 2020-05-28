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
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearID {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }
    @And("^Da clic sobre Crear ID$")
    public void daClicSobreCrearID() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Crear ID",
                "Crear ID",
                "//button[@name='action']"
        )));
    }

    @Then("^El usuario visualiza la ruta de navegacion$")
    public void elUsuarioVisualizaLaRutaDeNavegacion() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el label de la página$")
    public void elUsuarioVisualizaElLabelDeLaPagina() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo ID$")
    public void elUsuarioVisualizaElCampoID() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo Numero de tarjeta$")
    public void elUsuarioVisualizaElCampoNumeroDeTarjeta() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo campo tipo de tarjeta$")
    public void elUsuarioVisualizaElCampoCampoTipoDeTarjeta() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo Ingreso$")
    public void elUsuarioVisualizaElCampoIngreso() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el campo tecnologia$")
    public void elUsuarioVisualizaElCampoTecnologia() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^El usuario visualiza el boton Guardar bloqueado$")
    public void elUsuarioVisualizaElBotonGuardarBloqueado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotEnabled()));
    }

    @Then("^El sistema muestra un mensaje de confirmacion para salir de Crear ID$")
    public void elSistemaMuestraUnMensajeDeConfirmacionParaSalirDeCrearID() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
        actor.should(new QuestionValidate("¿Está seguro de que desea salir de la página crear ID?").Execute(new GeneralParams(
                "Mensaje de salir página de crear ID",
                "salir página de crear ID",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^En Crear ID Da clic en el (.*)$")
    public void enCrearIDDaClicEnElCampo_requerido(String campo) {
        switch (campo) {
            case "numero de tarjeta":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en numero de tarjeta",
                        "numero de tarjeta",
                        "//button[@name='action']"
                )));
                break;
            case "tipo":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en tipo de tarjeta",
                        "tipo de tarjeta",
                        "//butto n[@name='action']"
                )));
                break;
            case "ingreso":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en ingreso",
                        "ingreso",
                        "//button[@name='action']"
                )));
                break;
            case "tecnologia":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en tecnologia",
                        "tecnologia de tarjeta",
                        "//button[@name='action']"
                )));
                break;
        }

    }

    @When("^Ingresa el (.*) en el campo$")
    public void ingresaElNumero_tarjetaEnElCampo(String numero_tarjeta) {
        actor.attemptsTo(new EnterTextAction(numero_tarjeta).Execute(new GeneralParams(
                "Usuario Ingresa el campo numero de tarjeta",
                "campo numero de tarjeta",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema muestra un (.*)$")
    public void elSistemaMuestraUnResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "resultado esperado",
                "resultado esperado",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa informacion en el campo (.*)$")
    public void ingresaInformacionEnElCampoNumero_tarjeta(String numero_tarjeta) {
        actor.attemptsTo(new EnterTextAction(numero_tarjeta).Execute(new GeneralParams(
                "Usuario Ingresa el campo numero de tarjeta",
                "campo numero de tarjeta",
                "//button[@name='action']"
        )));
    }

    @And("^Selecciona los datos de los campos (.*), (.*) y (.*)$")
    public void seleccionaLosDatosDeLosCamposTipoIngresoYTecnologia(String tipo, String ingreso, String tecnologia) {
        actor.attemptsTo(Click.on(By.cssSelector("#menuTipo"), By.linkText(tipo)));
        actor.attemptsTo(Click.on(By.cssSelector("#menuIngreso"), By.linkText(ingreso)));
        actor.attemptsTo(Click.on(By.cssSelector("#menuTecnologia"), By.linkText(tecnologia)));
    }

    @Then("^(.*) se habilita el boton guardar$")
    public void sionoSeHabilitaElBotonGuardar(String siono) {
        switch (siono) {
            case "si":
                actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
                break;
            case "no":
                actor.should(seeThat(the("//p[ contains(text(),'Inicio')]"), isNotEnabled()));
                break;

        }
    }

    @And("^Da clic en Guardar$")
    public void daClicEnGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Guardar",
                "Botón guardar",
                "//button[@name='action']"
        )));
    }

    @Then("^Se presenta un (.*)$")
    public void sePresentaUnResultado(String resultado) {
        switch (resultado){
            case "ID existe":
                actor.should(new QuestionValidate("El número de la tarjeta ya está en uso, por favor ingresar uno diferente").Execute(new GeneralParams(
                        "Mensaje número de tarjeta existente",
                        "Tarjeta existente",
                        "//button[@name='action']"
                )));
                break;
            case "ID creado":
                actor.should(new QuestionValidate("El ID ha sido creado exitosamente").Execute(new GeneralParams(
                        "Mensaje número de tarjeta creado",
                        "Tarjeta creada",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @Then("^Se presenta (.*)$")
    public void sePresentaError(String error) {
        switch (error){
            case "400":
                actor.should(new QuestionValidate("Error 400").Execute(new GeneralParams(
                        "Mensaje Error 400",
                        "Error 400",
                        "//button[@name='action']"
                )));
                break;
            case "500":
                actor.should(new QuestionValidate("Error 500").Execute(new GeneralParams(
                        "Mensaje Error 500",
                        "Error 500",
                        "//button[@name='action']"
                )));
                break;
        }
    }
}
