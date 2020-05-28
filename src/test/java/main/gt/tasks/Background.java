package main.gt.tasks;

import core.actions.OpenUrlAction;
import core.Helpers.GeneralParams;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
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
                "https://app-frontresidentialcomplex-dev-001.azurewebsites.net/account/login")));

    }

    @When("^Inicia sesión$")
    public void iniciarSesion() {
        actor.attemptsTo(
                Enter.theValue("rherrerar").into("//input[@id='userName']")
        );
        actor.attemptsTo(
                Enter.theValue("123456").into("//input[@id='password']"));
    }

    @Then("^Entra a la pagina$")
    public void entra() throws InterruptedException {
        actor.attemptsTo(
                MoveMouse.to("//button[@id='login']").andThen(Actions::click));
        Thread.sleep(5000);
    }

}
