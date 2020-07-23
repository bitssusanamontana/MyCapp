package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Background {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "https://app-frontresidentialcomplex-dev-002.azurewebsites.net/")));

    }

    @When("^Inicia sesión$")
    public void iniciarSesion() throws InterruptedException {
        actor.attemptsTo(
                Enter.theValue("administrador").into("//input[@id='userName']")
        );
        actor.attemptsTo(
                Enter.theValue("bitsAdmin2020$$").into("//input[@id='password']"));
        actor.attemptsTo(Click.on("#buttonLogin"));
        Thread.sleep(5000);

    }

    @Then("^Entra a la pagina$")
    public void entra() throws InterruptedException {
        actor.attemptsTo(
                MoveMouse.to("//button[@id='login']").andThen(Actions::click));
        Thread.sleep(5000);
    }

    }
