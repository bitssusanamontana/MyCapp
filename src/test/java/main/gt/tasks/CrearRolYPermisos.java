package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearRolYPermisos {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic en Configuracion$")
    public void daClicEnConfiguracion() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Da clic en Roles$")
    public void daClicEnRoles() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Da clic en el boton Crear Rol$")
    public void daClicEnElBotonCrearRol() {
        actor.attemptsTo(Click.on("//button[@class='colm23 ng-star-inserted']"));
    }

    Target CHECK = Target.the("ROLES CHECK").
            locatedBy("#chk--switch-00");

    @Then("^El sistema presenta una ventana con la informacion de crear rol$")
    public void elSistemaPresentaUnaVentanaConLaInformacionDeCrearRol() throws InterruptedException {
        // Etiqueta Crear Rol
        actor.attemptsTo(Enter.keyValues("Rol prueba").into("//input[@id='ipt-name-rol-create']"));
    //  actor.should(seeThat(the("#ipt--name-rol"),isVisible()));
        actor.should(seeThat(the("//h2[@id='h--tittle-create']"),isVisible()));


        actor.attemptsTo(Click.on("#chk--switch-00"));

       // actor.should(seeThat(the("//span[@id='inner-00']"),isVisible()));

/*        actor.should(seeThat(the("//h2[@id='h--tittle']"),isVisible()));
        //Campo Nombre Rol
        actor.should(seeThat(the("//input[@id='ipt--name-rol']"),isVisible()));
        //Sección Permisos
        actor.should(seeThat(the("//p[@id='p--permits']"),isVisible()));
        //Botón Guardar
        actor.should(seeThat(the("//button[@id='btn--save-rol']"),isNotEnabled()));*/

    }

    @When("^Ingresa información en el campo nombre de rol$")
    public void ingresaInformacionEnElCampoNombreDeRol() {
        actor.attemptsTo(Enter.keyValues("Rol prueba").into("//input[@id='ipt--name-rol']"));
    }

    @Then("^El sistema presenta habilitado el boton de guardar$")
    public void elSistemaPresentaHabilitadoElBotonDeGuardar() {
        actor.should(seeThat(the("#btn--save-rol"),isEnabled()));
    }

    @When("^Ingresa el nombre del rol (.*) en el campo nombre de rol$")
    public void ingresaUnNombreEnElCampoNombreDeRol(String nombre) {
        actor.attemptsTo(Enter.theValue(nombre).into("#ipt--name-rol"));
    }

    @Then("^Se muestra el nombre de rol esperado (.*)$")
    public void seMuestraElResultadoEsperadoResultado(String resultado) {
        actor.should(seeThat(the("#ipt--name-rol"), Predicate.isEqual(resultado)));

    }

    @When("^Se da clic en Configuracion$")
    public void seDaClicEnConfiguracion() {
        actor.attemptsTo(Click.on("#inner-00"));
    }

    @And("^Se da clic en Unidades Inmobiliarias$")
    public void seDaClicEnUnidadesInmobiliarias() {
        actor.attemptsTo(Click.on("#inner-100"));
    }

    @Then("^Se visualizan seleccionados cada check$")
    public void seVisualizanSeleccionadosCadaCheck() {
        //Check en Configuración
        actor.should(seeThat(the("#inner-00"),isSelected()));
        //Check en Administrar rol
        actor.should(seeThat(the("#inner-000"),isSelected()));
        //Check en Administracion de usuarios
        actor.should(seeThat(the("#inner-001"),isSelected()));
    }

    @Then("^Se visualizan todos los hijos y acciones seleccionados$")
    public void seVisualizanTodosLosHijosYAccionesSeleccionados() {
        //Check en Configuración
        actor.should(seeThat(the("#inner-00"),isSelected()));
        //Check en Administrar rol
        actor.should(seeThat(the("#inner-000"),isSelected()));
        //Check en Crear rol
        actor.should(seeThat(the("#inner-0000"),isSelected()));
        //Check en Modificar rol
        actor.should(seeThat(the("#inner-0001"),isSelected()));
        //Check en Consultar rol
        actor.should(seeThat(the("#inner-0003"),isSelected()));
        //Check en Eliminar rol
        actor.should(seeThat(the("#inner-0002"),isSelected()));

    }


    @And("^Que se encuentra seleccionado configuracion$")
    public void queSeEncuentraSeleccionadoConfiguracion() {
        actor.attemptsTo(Click.on("#inner-10"));
        actor.should(seeThat(the("#inner-10"),isSelected()));
    }
    @And("^Que se encuentra seleccionado configuracion 2$")
    public void queSeEncuentraSeleccionadoConfiguracionDos() {
        actor.should(seeThat(the("#inner-00"),isSelected()));
    }

    @Then("^Se visualizan todos los hijos desmarcados$")
    public void seVisualizanTodosLosHijosDesmarcados() {
        //Check en Administrar rol
        actor.should(seeThat(the("#inner-000"),isNotSelected()));
        //Check en Administracion de usuarios
        actor.should(seeThat(the("#inner-001"),isNotSelected()));
    }

    @When("^se desmarcan los hijos$")
    public void seDesmarcanLosHijos() {
        //Check en Administrar rol
        actor.should(seeThat(the("#inner-000"),isNotSelected()));
        //Check en Crear rol
        actor.should(seeThat(the("#inner-0000"),isNotSelected()));
        //Check en Modificar rol
        actor.should(seeThat(the("#inner-0001"),isNotSelected()));
        //Check en Consultar rol
        actor.should(seeThat(the("#inner-0003"),isNotSelected()));
        //Check en Eliminar rol
        actor.should(seeThat(the("#inner-0002"),isNotSelected()));
    }

    @Then("^Se mantiene seleccionado configuracion$")
    public void seMantieneSeleccionadoConfiguracion() {
        actor.should(seeThat(the("#inner-00"),isSelected()));
    }

    @And("^se encuentran marcados los hijos de configuracion 2$")
    public void seEncuentranMarcadosLosHijos() {
        //Check en Unidades Inmobiliarias
        actor.should(seeThat(the("#inner-10"),isSelected()));
    }

    @When("^se desmarcan todas las acciones del hijo configuracion 2$")
    public void seDesmarcanTodasLasAcciones() {
        actor.attemptsTo(Click.on("#inner-1000"));
        actor.attemptsTo(Click.on("#inner-1001"));
        actor.attemptsTo(Click.on("#inner-1002"));
        actor.attemptsTo(Click.on("#inner-1003"));
        actor.attemptsTo(Click.on("#inner-1004"));
    }


    @When("^se desmarca la accion de Modificar rol$")
    public void seDesmarcaLaAccionDeEditar() {
        actor.attemptsTo(Click.on("#inner-0001"));
    }

    @Then("^se mantienen seleccionados las demas acciones$")
    public void seMantienenSeleccionadosLasDemasAcciones() {
        //Check en Administrar rol
        actor.should(seeThat(the("#inner-000"),isSelected()));
        //Check en Crear rol
        actor.should(seeThat(the("#inner-0000"),isSelected()));
        //Check en Modificar rol
        actor.should(seeThat(the("#inner-0001"),isNotSelected()));
        //Check en Consultar rol
        actor.should(seeThat(the("#inner-0003"),isSelected()));
        //Check en Eliminar rol
        actor.should(seeThat(the("#inner-0002"),isSelected()));
    }

    @And("^Que se encuentra desmarcada configuracion$")
    public void queSeEncuentraDesmarcadaConfiguracion() {
        actor.should(seeThat(the("/button[@name='action']"),isNotSelected()));
    }

    @When("^se selecciona la accion de Editar$")
    public void seSeleccionaLaAccionDeEditar() {
        actor.attemptsTo(Click.on("#inner-0001"));
    }

    @Then("^se muestra seleccionado el padre y el hijo$")
    public void seMuestraSeleccionadoElPadreYElHijo() {
        //Check en Configuración
        actor.should(seeThat(the("#inner-00"),isSelected()));
        //Check en Administrar rol
        actor.should(seeThat(the("#inner-000"),isSelected()));
    }

    @And("^Se selecciona configuracion$")
    public void seSeleccionaConfiguracion() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en padre",
                "Clic padre",
                "//input[@id='idEmail']"
        )));
    }

    @When("^Se da clic en guardar$")
    public void seDaClicEnGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en guardar",
                "Clic guardar",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^Se muestra el mensaje de creacion$")
    public void seMuestraElMensajeDeCreacion() {
        actor.should(new QuestionValidate("Se ha creado el rol exitosamente").Execute(new GeneralParams(
                "Mensaje creación de rol",
                "Creación rol",
                "#divMessage"
        )));

    }

    @And("^redirige al usuario a la página de Administrar Roles$")
    public void redirigeAlUsuarioALaPaginaDeAdministrarRoles() throws InterruptedException {
        actor.attemptsTo(Click.on("#btnCloseModal"));
        Thread.sleep(2000);
        actor.should(new QuestionValidate("Administración de Roles").Execute(new GeneralParams(
                "Página de Administración de Roles",
                "Administración de Roles",
                "//div[@class='colm1']"
        )));
    }

    @Then("^El sistema presenta exito o error en (.*)$")
    public void elSistemaPresentaExitoOErrorEnMensaje(String mensaje) {
        switch (mensaje){
            case ("existente"):
                actor.should(seeThat(the("#p--error-enssage"),isVisible()));
                break;
            case ("creado"):
                actor.should(seeThat(the("#divMessage"),isVisible()));
                break;
            case ("obligatorio"):
                actor.should(seeThat(the("/button[@name'action']"),isVisible()));
                break;
        }

    }

    @And("^En crear rol da clic en el boton guardar$")
    public void enCrearRolDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on("#btn--save-rol"));

    }
}
