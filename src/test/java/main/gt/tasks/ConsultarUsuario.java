package main.gt.tasks;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class ConsultarUsuario {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @And("^da clic en Consultar usuario$")
    public void daClicEnConsultarUsuario() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^En Consultar usuario visualiza el formulario$")
    public void enConsultarUsuarioVisualizaElFormulario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo tipo de identificacion$")
    public void enConsultarUsuarioVisualizaCampoTipoDeIdentificacion() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo numero de identificacion$")
    public void enConsultarUsuarioVisualizaCampoNumeroDeIdentificacion() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo nombre$")
    public void enConsultarUsuarioVisualizaCampoNombre() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo apellidos$")
    public void enConsultarUsuarioVisualizaCampoApellidos() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo telefono$")
    public void enConsultarUsuarioVisualizaCampoTelefono() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo rol$")
    public void enConsultarUsuarioVisualizaCampoRol() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza campo usuario$")
    public void enConsultarUsuarioVisualizaCampoUsuario() {
        actor.should(seeThat(the(""), isVisible()));
    }

    @And("^En Consultar usuario visualiza el enlace tomar foto$")
    public void enConsultarUsuarioVisualizaElEnlaceTomarFoto() {
        actor.should(seeThat(the(""), isVisible()));
    }
}
