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
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class HeaderMenuCierrreSesion {
    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @When("^Da clic en el logo de la unidad inmobiliaria en el header$")
    public void daClicEnElLogoDeLaUnidadInmobiliariaEnElHeader() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta una ventana emergente para realizar la configuración de logo$")
    public void elSistemaPresentaUnaVentanaEmergenteParaRealizarLaConfiguracionDeLogo() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Con un botón de Seleccionar imagen$")
    public void conUnBotonDeSeleccionarImagen() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Texto descriptivo del formato y tamaño máximo de la imagen$")
    public void textoDescriptivoDelFormatoYTamanoMaximoDeLaImagen() {
        actor.should(new QuestionValidate("Texto descriptivo").Execute(new GeneralParams(
                "Texto descriptivo formato y tamaño",
                "formato y tamaño",
                "//button[@name='action']"
        )));

    }

    @And("^Texto descriptivo del tamaño máximo de la imagen$")
    public void textoDescriptivoDelTamanoMaximoDeLaImagen() {
        actor.should(new QuestionValidate("‘con un tamaño máximo de 5MB’").Execute(new GeneralParams(
                "‘con un tamaño máximo de 5MB’",
                "‘con un tamaño máximo de 5MB’",
                "//button[@name='action']"
        )));
    }

    @And("^Con un botón de guardar$")
    public void conUnBotonDeGuardar() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Un botón de Cancelar$")
    public void unBotonDeCancelar() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Con opción de cerrar ventana$")
    public void conOpcionDeCerrarVentana() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Da clic sobre el botón de seleccionar imagen$")
    public void daClicSobreElBotonDeSeleccionarImagen() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^Un usuario administrador selecciona el botón guardar$")
    public void unUsuarioAdministradorSeleccionaElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Cierra la ventana emergente$")
    public void cierraLaVentanaEmergente() {
        actor.should(seeThat(the("/button[@name='action']"), isNotVisible()));
    }

    @And("^Actualiza el logo de la unidad inmobiliaria$")
    public void actualizaElLogoDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^No actualiza la imagen de logo de la unidad inmobiliaria$")
    public void noActualizaLaImagenDeLogoDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @When("^Da clic sobre una (.*) del menu$")
    public void daClicSobreUnaPaginaDelMenu(String pagina) {
        switch (pagina) {
            case "Inicio":
                actor.attemptsTo(Click.on(""));
                break;
            case "Unidad Inmobiliaria":
                actor.attemptsTo(Click.on(" "));
                break;
            case "Crear Unidad Inmobiliaria":
                actor.attemptsTo(Click.on("  "));
                break;
        }
    }

    @Then("^En el Header menu El sistema muestra la (.*)$")
    public void elSistemaMuestraLaRuta_de_navegacion(String ruta) {
        actor.should(new QuestionValidate(ruta).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));

    }

    @And("^Debe presentar como enlace la informacion antes de la ultima en la (.*)$")
    public void debePresentarComoEnlaceLaInformacionAntesDeLaUltimaEnLaRuta_de_navegacion(String ruta) {
        actor.should(new QuestionValidate(ruta).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }


    @When("^Da clic sobre un (.*) de la (.*)$")
    public void daClicSobreUnEnlaceDeLaRuta_de_navegacion(String enlace, String ruta) {
        switch (ruta) {
            case "Unidad Inmobiliaria/Crear":
                if (enlace.equals("Unidad Inmobiliria")){actor.attemptsTo(Click.on(""));
                }
                break;
            case "Unidad Independiente/Crear":
                actor.attemptsTo(Click.on(""));
                break;
        }
    }

    @Then("^El sistema debe presentar una (.*)$")
    public void elSistemaDebePresentarUnaPagina_resultado(String pagina_resultado) {
        actor.should(new QuestionValidate(pagina_resultado).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic sobre la sección de perfil$")
    public void daClicSobreLaSeccionDePerfil() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema debe presentar una ventana con las opciones$")
    public void elSistemaDebePresentarUnaVentanaConLasOpciones() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Da clic sobre opción de cambiar foto perfil$")
    public void daClicSobreOpcionDeCambiarFotoPerfil() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^El sistema presenta una ventana emergente para realizar el cambio de imagen$")
    public void elSistemaPresentaUnaVentanaEmergenteParaRealizarElCambioDeImagen() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^botón de Seleccionar imagen$")
    public void botonDeSeleccionarImagen() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @When("^Un usuario selecciona el botón guardar$")
    public void unUsuarioSeleccionaElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^Actualiza la imagen de perfil del usuario autenticado$")
    public void actualizaLaImagenDePerfilDelUsuarioAutenticado() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^No actualiza la imagen de perfil$")
    public void noActualizaLaImagenDePerfil() {
        actor.should(seeThat(the("/button[@name='action']"), isNotVisible()));
    }

    @And("^El sistema presenta la (.*) seleccionada$")
    public void elSistemaPresentaLaPaginaSeleccionada(String pagina) {
        actor.should(new QuestionValidate(pagina).Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }

    @Then("^Presenta la página de autenticacion$")
    public void presentaLaPaginaDeAutenticacion() {
        actor.should(new QuestionValidate("Pagina autenticación").Execute(new GeneralParams(
                "Ruta de navegación",
                "Ruta de navegación",
                "//button[@name='action']"
        )));
    }

    @Then("^Visualiza el logo de la unidad inmobiliaria$")
    public void visualizaElLogoDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Nombre de la unidad inmobiliaria$")
    public void visualizaNombreDeLaUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Ruta de navegacion$")
    public void visualizaRutaDeNavegacion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Icono de cambiar de unidad inmobiliaria$")
    public void visualizaIconoDeCambiarDeUnidadInmobiliaria() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza Seccion perfil con el usuario y foto$")
    public void visualizaSeccionPerfilConElUsuarioYFoto() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }

    @And("^Visualiza cierre de sesion$")
    public void visualizaCierreDeSesion() {
        actor.should(seeThat(the("/button[@name='action']"), isVisible()));
    }


    @Then("^El sistema presenta error con el (.*)$")
    public void elSistemaPresentaElMensaje(String mensaje) {
        actor.should(new QuestionValidate(mensaje).Execute(new GeneralParams(
                "Mensaje no cumple con las reglas",
                "mensaje de error",
                "//button[@name='action']"
        )));
    }
}
