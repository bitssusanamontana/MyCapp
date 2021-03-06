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
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ModificarRolYPermisos {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic en el boton Modificar Rol$")
    public void daClicEnElBotonModificarRol() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta una ventana con la informacion de Modificar rol$")
    public void elSistemaPresentaUnaVentanaConLaInformacionDeModificarRol() {
        // Etiqueta Modificar Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Campo Nombre Rol
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Sección Permisos
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Guardar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
        //Botón Cancelar
        actor.should(seeThat(the("/button[@name='action']"),isVisible()));
    }

    @When("^Edita la informacion del nombre del Rol$")
    public void editaLaInformacionDelNombreDelRol() {
        actor.attemptsTo(Enter.theValue("").into(""));
    }

    @Then("^Se muestra el mensaje de modificación$")
    public void seMuestraElMensajeDeModificacion() {
        actor.should(new QuestionValidate("Modificación del rol exitosa").Execute(new GeneralParams(
                "Mensaje creación de rol",
                "Creación rol",
                "//input[@id='idEmail']"
        )));
    }
}
