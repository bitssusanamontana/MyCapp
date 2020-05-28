package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class ConsultarUnidadInmobiliaria {

    Actor actor;
    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @When("^Da clic en Consultar Unidad Inmobiliaria Bits$")
    public void daClicEnConsultarUnidadInmobiliariaBits() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Da clic en Consultar Unidad",
                "clic en Consultar Unidad",
                "/button[@name='action']"
        )));
    }

    @Then("^El sistema presenta la informacion como consulta en los campos de consulta$")
    public void elSistemaPresentaLaInformacionComoConsultaEnLosCamposDeConsulta() {
        actor.should(new QuestionValidate("Conjunto Bits").Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Nombre Conjunto",
                "Campo Nombre Conjunto",
                "//input[@id='idEmail']"
        )));
        actor.should(new QuestionValidate("colombia").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/pais",
                "campo Direccion/pais",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("Bogota").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/departamento",
                "campo Direccion/departamento",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("Bogota").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/ciudad",
                "campo Direccion/ciudad",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("Calle 106 # 45-32").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion",
                "campo Direccion",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("634564564").Execute(new GeneralParams(
                "Usuario da Clic en campo Nit",
                "campo Nit",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("345435534").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero catastro",
                "campo Numero catastro",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("cc").Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento",
                "campo Tipo documento",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("6545353443").Execute(new GeneralParams(
                "Usuario Ingresa el Numero de documento representante",
                "campo Numero de documento representante",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("Jose Arturo").Execute(new GeneralParams(
                "Usuario Ingresa el campo Nombre representante",
                "campo Nombre representante",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("Barbosa Contreras").Execute(new GeneralParams(
                "Usuario Ingresa el campo Apellido representante",
                "campo Apellido representante",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("36453535").Execute(new GeneralParams(
                "Usuario Ingresa el campo Telefono unidad inmobiliaria",
                "campo Telefono unidad inmobiliaria",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("3212345678").Execute(new GeneralParams(
                "Usuario Ingresa el campo Celular representante",
                "campo Celular representante",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("jbarbosac@bitsamericas.com").Execute(new GeneralParams(
                "Usuario Ingresa el campo Correo electronico representante",
                "campo Correo electronico representante",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("5").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de agrupaciones",
                "campo Numero de agrupaciones",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("60").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de unidades independientes",
                "campo Numero de unidades independientes",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas a pie",
                "campo Numero de entradas a pie",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas vehiculares",
                "campo Numero de entradas vehiculares",
                "//button[@name='action']"
        )));

        actor.should(new QuestionValidate("30").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de parqueaderos",
                "campo Numero de parqueaderos",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema debe presentar la página de Administrar Unidades Inmobiliarias$")
    public void elSistemaDebePresentarLaPaginaDeAdministrarUnidadesInmobiliarias() {
        actor.should(new QuestionValidate("Administrar Unidades Inmobiliarias").Execute(new GeneralParams(
                "Título Administrar Unidades",
                "//button[@name='action']"
        )));
    }
}
