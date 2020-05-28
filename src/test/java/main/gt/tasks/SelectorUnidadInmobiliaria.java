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
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SelectorUnidadInmobiliaria {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Inicia sesión con un usuario con una unidad$")
    public void iniciarSesionUnaUnidad() {
        actor.attemptsTo(new EnterTextAction("jbarbosam").Execute(new GeneralParams(
                "Usuario ingresa texto en el campo usuario",
                "Campo usuario",
                "//input[@id='idEmail']"
        )));

        actor.attemptsTo(new EnterTextAction("TigoTest123#").Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@id='password']"
                )
        ));

    }

    @Then("^El sistema le muestra al usuario la pantalla de Inicio$")
    public void elSistemaLeMuestraAlUsuarioLaPantallaDeInicio() {
        actor.should(new QuestionValidate("Página de Inicio").Execute(new GeneralParams(
                "Página de Inicio",
                "Página de Inicio",
                "//button[@name='action']"
        )));
    }

    @When("^Inicia sesión con un usuario con mas de una unidad$")
    public void iniciaSesionConUnUsuarioConMasDeUnaUnidad() {
        actor.attemptsTo(new EnterTextAction("jbarbosam").Execute(new GeneralParams(
                "Usuario ingresa texto en el campo usuario",
                "Campo usuario",
                "//input[@id='idEmail']"
        )));

        actor.attemptsTo(new EnterTextAction("TigoTest123#").Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@id='password']"
                )
        ));
    }

    @Then("^El sistema presenta la ventana emergente de Selector$")
    public void elSistemaPresentaLaVentanaEmergenteDeSelector() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^la seccion de busqueda$")
    public void laSeccionDeBusqueda() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^el listado de unidades asociadas al usuario$")
    public void elListadoDeUnidadesAsociadasAlUsuario() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Selecciona la unidad inmobiliaria$")
    public void seleccionaLaUnidadInmobiliaria() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en Unidad",
                "//button[@name='action']"
        )));
    }

    @And("^Se encuentra en la pagina de inicio$")
    public void seEncuentraEnLaPaginaDeInicio() {
        actor.should(new QuestionValidate("Página de Inicio").Execute(new GeneralParams(
                "Página de Inicio",
                "Página de Inicio",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic sobre el icono de cambiar unidad$")
    public void daClicSobreElIconoDeCambiarUnidad() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono cambiar Unidad",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema presenta una ventana emergente con el nombre de las unidades inmobiliarias$")
    public void elSistemaPresentaUnaVentanaEmergenteConElNombreDeLasUnidadesInmobiliarias() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^El campo de busqueda$")
    public void elCampoDeBusqueda() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Se muestra resaltada la unidad actual$")
    public void seMuestraResaltadaLaUnidadActual() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Se muestra el boton de cerrar$")
    public void seMuestraElBotonDeCerrar() {
        actor.should(seeThat(the("//button[@name='action']"), isVisible()));
    }

    @And("^Se muestra el boton de cancelar$")
    public void seMuestraElBotonDeCancelar() {

    }

    @Then("^Se cierra la ventana emergente del Selector de Unidades Inmobiliarias$")
    public void seCierraLaVentanaEmergenteDelSelectorDeUnidadesInmobiliarias() {
        actor.should(seeThat(the("//button[@name='action']"), isNotVisible()));
    }

    @And("^El sistema presenta la página inicial con la información de la unidad inmobiliaria seleccionada$")
    public void elSistemaPresentaLaPaginaInicialConLaInformacionDeLaUnidadInmobiliariaSeleccionada() {
        actor.should(new QuestionValidate("Página de Inicio unidad xxx").Execute(new GeneralParams(
                "Página de Inicio",
                "Página de Inicio",
                "//button[@name='action']"
        )));
    }

    @And("^Se encuentra en la pagina (.*)$")
    public void seEncuentraEnLaPaginaUbicacion(String ubicacion) {
        switch (ubicacion) {
            case "Inicio":
                actor.should(new QuestionValidate("Página de Inicio unidad xxx").Execute(new GeneralParams(
                        "Página de Inicio",
                        "Página de Inicio",
                        "//button[@name='action']"
                )));
                break;
            case "Unidad Inmobiliaria":
                actor.should(new QuestionValidate("Página de unidad xxx").Execute(new GeneralParams(
                        "Página de unidad",
                        "Página de unidad",
                        "//button[@name='action']"
                )));
                break;
            case "Parqueaderos":
                actor.should(new QuestionValidate("Página de Parqueaderos").Execute(new GeneralParams(
                        "Página de parqueaderos",
                        "Página de parqueaderos",
                        "//button[@name='action']"
                )));
                break;
        }

    }

    @And("^Sigue en la (.*)$")
    public void sigueEnLaUbicacion(String ubicacion) {
        switch (ubicacion) {
            case "Inicio":
                actor.should(new QuestionValidate("Página de Inicio unidad xxx").Execute(new GeneralParams(
                        "Página de Inicio",
                        "Página de Inicio",
                        "//button[@name='action']"
                )));
                break;
            case "Unidad Inmobiliaria":
                actor.should(new QuestionValidate("Página de unidad xxx").Execute(new GeneralParams(
                        "Página de unidad",
                        "Página de unidad",
                        "//button[@name='action']"
                )));
                break;
            case "Parqueaderos":
                actor.should(new QuestionValidate("Página de Parqueaderos").Execute(new GeneralParams(
                        "Página de parqueaderos",
                        "Página de parqueaderos",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @When("^Un usuario ingresa una (.*) sobre el campo de consulta$")
    public void unUsuarioIngresaUnaPalabraSobreElCampoDeConsulta(String palabra) {
        actor.attemptsTo(new EnterTextAction(palabra).Execute(new GeneralParams(
                "Ingresar palabra clave",
                "palabra clave",
                "//button[@name='action']"
        )));
    }

    @And("^Da clic en el icono de buscar$")
    public void daClicEnElIconoDeBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono buscar",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema trae los (.*) que contienen la (.*)$")
    public void elSistemaTraeLosRegistrosQueContienenLaPalabra(String registros, String palabra) {
        actor.should(new QuestionValidate(registros).Execute(new GeneralParams(
                "Página de parqueaderos",
                "Página de parqueaderos",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en el icono de filtros$")
    public void daClicEnElIconoDeFiltros() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono filtros",
                "//button[@name='action']"
        )));
    }

    @And("^Da clic en un <filtro>$")
    public void daClicEnUnFiltro() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono filtros",
                "//button[@name='action']"
        )));
    }

    @And("^ingresa (.*)$")
    public void ingresaInformacion(String informacion) {
        actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                "Ingresar palabra filtro",
                "palabra filtro",
                "//button[@name='action']"
        )));
    }

    @And("^Selecciona el (.*)$")
    public void seleccionaElElemento(String elemento) {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en icono filtros",
                "//button[@name='action']"
        )));
    }

    @Then("^Se muestra el (.*) en el filtro$")
    public void seMuestraElElementoEnElFiltro(String elemento) {
        actor.should(new QuestionValidate(elemento).Execute(new GeneralParams(
                "Elemento filtro",
                "Elementos filtros",
                "//button[@name='action']"
        )));
    }

    @And("^Da clic en el boton Buscar$")
    public void daClicEnElBotonBuscar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "clic en buscar",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema muestra un (.*) con la informacion del filtro$")
    public void elSistemaMuestraUnResultadoConLaInformacionDelFiltro(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultados búsqueda",
                "Resultado búsqueda",
                "//button[@name='action']"
        )));
    }


    @And("^Da clic en un (.*)$")
    public void daClicEnUnFiltro(String filtro) {
        switch (filtro) {
            case "nombre":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "clic en icono buscar",
                        "//button[@name='action']"
                )));
                break;
            case "nit":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "clic en icono buscar",
                        "//bu tton[@name='action']"
                )));
                break;
            case "catastro":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "clic en icono buscar",
                        "//button[@name='act ion']"
                )));
                break;
            case "dirección":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "clic en icono buscar",
                        "//button[@nam e='action']"
                )));
                break;
        }
    }
}
