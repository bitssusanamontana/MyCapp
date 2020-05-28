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

public class AdministrarIngresoYSalida {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic en Administrar Entrada y Salida$")
    public void daClicEnAdministrarEntradaYSalida() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'Administrar entrada y salida')]").andThen(Actions::click));
    }

    @And("^Label Administracion de Entrada y Salida$")
    public void labelAdministracionDeEntradaYSalida() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Tabla de registros Entrada y salida$")
    public void tablaDeRegistrosEntradaYSalida() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Boton Registrar Ingreso Visitante$")
    public void botonRegistrarIngresoVisitante() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Paginador$")
    public void paginador() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @Then("^En Entrada y Salida El sistema muestra los resultados según la (.*)$")
    public void enEntradaYSalidaElSistemaMuestraLosResultadosSegunLaBusqueda(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Validación resultado",
                "Validación resultado",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en Registrar Ingreso$")
    public void daClicEnRegistrarIngreso() {
        actor.attemptsTo(
                MoveMouse.to("//a[contains(text(),'registrar ingreso')]").andThen(Actions::click));
    }

    @And("^El sistema redirecciona a la pagina de Registrar Ingreso$")
    public void elSistemaRedireccionaALaPaginaDeRegistrarIngreso() {
        actor.should(new QuestionValidate("Página Registrar ingreso").Execute(new GeneralParams(
                "Página Registrar ingreso",
                "Página Registrar ingreso",
                "//button[@name='action']"
        )));
    }

    @When("^En administrar ingreso y salida Selecciona una (.*)$")
    public void enAdministrarIngresoYSalidaSeleccionaUnaOpcion(String opcion) {
        switch (opcion) {

            case "Consultar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en consultar",
                        "Botón consultar",
                        "//input[@id='password']"
                )));
                break;

            case "Modificar":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en modificar",
                        "Botón modificar",
                        "//input[@id='password']"
                )));
                break;

            case "Salida":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en salida",
                        "Botón salida",
                        "//input[@id='password']"
                )));
                break;
            case "Anotacion":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en anotacion",
                        "Botón anotacion",
                        "//input[@id='password']"
                )));
                break;
        }
    }
            @Then("^En administrar ingreso y salida se realiza una accion (.*)$")
            public void enAdministrarIngresoYSalidaSeRealizaUnaAccionAccion (String accion) {
                switch (accion) {

                    case "Pagina consultar":
                        actor.should(new QuestionValidate("Página consultar").Execute(new GeneralParams(
                                "Página consultar",
                                "Página consultar",
                                "//button[@name='action']"
                        )));
                        break;

                    case "Pagina modificar":
                        actor.should(new QuestionValidate("Página modificar").Execute(new GeneralParams(
                                "Página modificar",
                                "Página modificar",
                                "//button[@name='action']"
                        )));
                        break;

                    case "marca salida":
                        actor.should(new QuestionValidate("Registro salida").Execute(new GeneralParams(
                                "Página Registrar ingreso",
                                "Página Registrar ingreso",
                                "//button[@name='action']"
                        )));
                        break;
                    case "Pagina Anotaciones":
                        actor.should(new QuestionValidate("Página Anotaciones").Execute(new GeneralParams(
                                "Página anotaciones",
                                "Página anotaciones",
                                "//button[@name='action']"
                        )));
                        break;
                }

            }
        }
