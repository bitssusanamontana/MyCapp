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
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ModificarUnidadInmobiliaria {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @And("^Da clic en el boton modificar$")
    public void daClicEnElBotonModificar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Modificar Unidad",
                "Boton modificar Unidad",
                "//button[@name='action']"
        )));
    }

    @And("^Borra la informacion del (.*)$")
    public void borraLaInformacionDelCampo_requerido(String campo_requerido) {
        switch (campo_requerido) {
            case "Nombre conjunto":

                actor.attemptsTo(Enter.theValue("").into("//button[@name='action']").thenHit(Keys.ENTER));
                break;
            case "Direccion/pais":
                actor.attemptsTo(Enter.theValue("").into("//button[@n ame='action']").thenHit(Keys.ENTER));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(Enter.theValue("").into("//butt on[@name='action']").thenHit(Keys.ENTER));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(Enter.theValue("").into("//button[@name='acti on']").thenHit(Keys.ENTER));
                break;
            case "Direccion":
                actor.attemptsTo(Enter.theValue("").into("//button[@name='ac tion']").thenHit(Keys.ENTER));
                break;
            case "Nit":
                actor.attemptsTo(Enter.theValue("").into("//butt on[@ name='action']").thenHit(Keys.ENTER));
                break;
            case "Numero catastro":
                actor.attemptsTo(Enter.theValue("").into("//butt on[@name= 'action']").thenHit(Keys.ENTER));
                break;
            case "Tipo documento":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Tipo documento",
                        "campo Tipo documento",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(Enter.theValue("").into("//bu tton[@name='action']").thenHit(Keys.ENTER));
                break;
            case "Nombre representante":
                actor.attemptsTo(Enter.theValue("").into("//button[@name ='action']").thenHit(Keys.ENTER));
                break;
            case "Apellido representante":
                actor.attemptsTo(Enter.theValue("").into("//button[ @name='action']").thenHit(Keys.ENTER));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(Enter.theValue("").into("//button[@ name='action']").thenHit(Keys.ENTER));
                break;
            case "Celular representante":
                actor.attemptsTo(Enter.theValue("").into("//button[@ n ame='action']").thenHit(Keys.ENTER));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(Enter.theValue("").into("//button[@na me='action']").thenHit(Keys.ENTER));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(Enter.theValue("").into("//button[@name='actio n']").thenHit(Keys.ENTER));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(Enter.theValue("").into("//butt on[@name='ac tion']").thenHit(Keys.ENTER));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(Enter.theValue("").into("//button[@name='act ion']").thenHit(Keys.ENTER));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(Enter.theValue("").into("//button[@name='acti o n']").thenHit(Keys.ENTER));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(Enter.theValue("").into("//button[@name= 'act ion']").thenHit(Keys.ENTER));
                break;
        }
    }

    @Given("^Da clic en el pais$")
    public void daClicEnElPais() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo país",
                "campo país",
                "//button[@name='action']"
        )));
    }

    @When("^Ingresa un correo (.*)$")
    public void ingresaUnCorreoCorreo(String correo) {
        actor.attemptsTo(new EnterTextAction(correo).Execute(new GeneralParams(
                "Usuario ingresa correo",
                "Campo correo",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^Se muestra el mensaje de modificacion exitosa$")
    public void seMuestraElMensajeDeModificacionExitosa() {
        actor.should(new QuestionValidate("La unidad inmobiliaria ha sido modificada exitosamente").Execute(new GeneralParams(
                "Mensaje de exito de modificación de la unidad inmobiliaria",
                "modificación exitosa",
                "//p[contains(text(),'correo')] "
        )));
    }


}
