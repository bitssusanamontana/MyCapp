package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.questions.QuestionValidate;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearUnidadInmobiliaria {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @And("^Da clic en Unidades Inmobiliarias$")
    public void clicUnidadesInmobiliarias() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Unidades Inmobiliarias",
                "Boton Unidades Inmobiliarias",
                "//button[@name='action']"
        )));
    }

    @And("^Da clic en el boton Crear$")
    public void daClicEnElBotonCrear() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Crear Unidad Inmobiliaria",
                "Boton Crear",
                "//button[@name='action']"
        )));
    }

    @When("^Da clic en una pagina diferente (.*)$")
    public void daClicEnUnaPaginaDiferentePagina(String pagina) {
        if (pagina.equals("principal")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en pagina principal",
                    "pagina principal",
                    "//button[@name='action']"
            )));
        } else if (pagina.equals("cerrar sesion")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en cerrar sesion",
                    "cerrar sesion",
                    "//button[@name='action']"
            )));
        }
    }

    @Then("^El sistema muestra un mensaje de confirmacion$")
    public void elSistemaMuestraUnMensajeDeConfirmacion() {
        actor.should(new QuestionValidate(
                "¿Esta seguro de que desea salir de la pagina crear unidad inmobiliaria?").Execute(new GeneralParams(
                "Pagina crear unidad",
                "//p[contains(text(),'¿Esta seguro de que desea salir de la pagina crear unidad inmobiliaria?')]")));
        throw new PendingException();
    }

    @When("^Selecciona una opcion del pop up (.*)$")
    public void seleccionaUnaOpcionDelPopUpOpcion(String opcion) {
        if (opcion.equals("si")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en si",
                    "opcion si",
                    "//button[@name='action']"
            )));
        } else if (opcion.equals("no")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en no",
                    "opcion no",
                    "//button[@name='action']"
            )));
        } else {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en x",
                    "opcion x",
                    "//button[@name='action']"
            )));
        }
    }

    @Then("^El sistema cierra el pop up$")
    public void elSistemaCierraElPopUp() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isNotVisible()));
    }

    @And("^Muestra la (.*) segun la opcion seleccionada$")
    public void muestraLaPaginaSegunLaOpcionSeleccionada(String pagina) {
        if (pagina.equals("principal")) {
            actor.should(new QuestionValidate(
                    "Pagina principal").Execute(new GeneralParams(
                    "Pagina principal",
                    "//p[contains(text(),'Pagina principal')]")));
        } else if (pagina.equals("Crear Unidad inmobiliaria")) {
            actor.should(new QuestionValidate(
                    "Página crear unidad inmobiliaria").Execute(new GeneralParams(
                    "Pagina crear unidad inmobiliaria",
                    "//p[contains(text(),'Pagina principal')]")));
        }
    }

    @When("^En el formulario da clic en el (.*)$")
    public void daClicEnElCampo_requerido(String campo_requerido) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Nombre conjunto",
                        "campo Nombre conjunto",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/pais":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion/pais",
                        "campo Direccion/pais",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion/departamento",
                        "campo Direccion/departamento",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion/ciudad",
                        "campo Direccion/ciudad",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion",
                        "campo Direccion",
                        "//button[@name='action']"
                )));
                break;
            case "Nit":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Nit",
                        "campo Nit",
                        "//button[@name='action']"
                )));
                break;
            case "Numero catastro":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero catastro",
                        "campo Numero catastro",
                        "//button[@name='action']"
                )));
                break;
            case "Tipo documento":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Tipo documento",
                        "campo Tipo documento",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de documento representante",
                        "campo Numero de documento representante",
                        "//button[@name='action']"
                )));
                break;
            case "Nombre representante":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Nombre representante",
                        "campo Nombre representante",
                        "//button[@name='action']"
                )));
                break;
            case "Apellido representante":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Apellido representante",
                        "campo Apellido representante",
                        "//button[@name='action']"
                )));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Telefono unidad inmobiliaria",
                        "campo Telefono unidad inmobiliaria",
                        "//button[@name='action']"
                )));
                break;
            case "Celular representante":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Celular representante",
                        "campo Celular representante",
                        "//button[@name='action']"
                )));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Correo electronico representante",
                        "campo Correo electronico representante",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de agrupaciones",
                        "campo Numero de agrupaciones",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de unidades independientes",
                        "campo Numero de unidades independientes",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de entradas a pie",
                        "campo Numero de entradas a pie",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de entradas vehiculares",
                        "campo Numero de entradas vehiculares",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de parqueaderos",
                        "campo Numero de parqueaderos",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @And("^Ingresa en todos los campos la informacion correcta$")
    public void ingresaInformacionInformacionEnCadaCampo() {
        actor.attemptsTo(new EnterTextAction("Bits Americas").Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Nombre Conjunto",
                "Campo Nombre Conjunto",
                "//input[@id='idEmail']"
        )));

        actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        actor.attemptsTo(Click.on(By.cssSelector("#departamento"), By.linkText("Bogotá")));
        actor.attemptsTo(Click.on(By.cssSelector("#ciudad"), By.linkText("Bogotá")));

        actor.attemptsTo(new EnterTextAction("Calle 106").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion",
                "campo Direccion",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("94854955").Execute(new GeneralParams(
                "Usuario da Clic en campo Nit",
                "campo Nit",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("98544985").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero catastro",
                "campo Numero catastro",
                "//button[@name='action']"
        )));

        actor.attemptsTo(Click.on(By.cssSelector("#tipodoc"), By.linkText("CC")));

        actor.attemptsTo(new EnterTextAction("978787").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero de documento representante",
                "campo Numero de documento representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Alexander").Execute(new GeneralParams(
                "Usuario da Clic en campo Nombre representante",
                "campo Nombre representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Salcedo").Execute(new GeneralParams(
                "Usuario da Clic en campo Apellido representante",
                "campo Apellido representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("394858934").Execute(new GeneralParams(
                "Usuario da Clic en campo Telefono unidad inmobiliaria",
                "campo Telefono unidad inmobiliaria",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("3214556789").Execute(new GeneralParams(
                "Usuario da Clic en campo Celular representante",
                "campo Celular representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("bitsamericas@bitsamericas.com").Execute(new GeneralParams(
                "Usuario da Clic en campo Correo electronico representante",
                "campo Correo electronico representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("15").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero de agrupaciones",
                "campo Numero de agrupaciones",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("150").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero de unidades independientes",
                "campo Numero de unidades independientes",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero de entradas a pie",
                "campo Numero de entradas a pie",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero de entradas vehiculares",
                "campo Numero de entradas vehiculares",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("80").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero de parqueaderos",
                "campo Numero de parqueaderos",
                "//button[@name='action']"
        )));


    }

    @Then("^Se muestra habilitado el boton guardar$")
    public void seMuestraHabilitadoElBotonGuardar() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @Then("^Visualiza el resultado esperado (.*)$")
    public void visualizaElResultadoEsperadoResultado(String resultado) {
        switch (resultado) {
            case "Nombre conjunto":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Nombre Conjunto",
                        "Campo Nombre Conjunto",
                        "//input[@id='idEmail']"
                )));
                break;
            case "Direccion/pais":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Direccion/pais",
                        "campo Direccion/pais",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/departamento":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Direccion/departamento",
                        "campo Direccion/departamento",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/ciudad":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Direccion/ciudad",
                        "campo Direccion/ciudad",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion",
                        "campo Direccion",
                        "//button[@name='action']"
                )));
                break;
            case "Nit":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Nit",
                        "campo Nit",
                        "//button[@name='action']"
                )));
                break;
            case "Numero catastro":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero catastro",
                        "campo Numero catastro",
                        "//button[@name='action']"
                )));
                break;
            case "Tipo documento":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Tipo documento",
                        "campo Tipo documento",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de documento representante":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero de documento representante",
                        "campo Numero de documento representante",
                        "//button[@name='action']"
                )));
                break;
            case "Nombre representante":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Nombre representante",
                        "campo Nombre representante",
                        "//button[@name='action']"
                )));
                break;
            case "Apellido representante":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Apellido representante",
                        "campo Apellido representante",
                        "//button[@name='action']"
                )));
                break;
            case "Telefono unidad inmobiliaria":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Telefono unidad inmobiliaria",
                        "campo Telefono unidad inmobiliaria",
                        "//button[@name='action']"
                )));
                break;
            case "Celular representante":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Celular representante",
                        "campo Celular representante",
                        "//button[@name='action']"
                )));
                break;
            case "Correo electronico representante":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Correo electronico representante",
                        "campo Correo electronico representante",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de agrupaciones":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero de agrupaciones",
                        "campo Numero de agrupaciones",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de unidades independientes":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero de unidades independientes",
                        "campo Numero de unidades independientes",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de entradas a pie":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero de entradas a pie",
                        "campo Numero de entradas a pie",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de entradas vehiculares":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero de entradas vehiculares",
                        "campo Numero de entradas vehiculares",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de parqueaderos":
                actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                        "campo Numero de parqueaderos",
                        "campo Numero de parqueaderos",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @Given("^Da clic en el campo Pais$")
    public void daClicEnElCampoPais() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo pais",
                "campo pais",
                "//button[@name='action']"
        )));
    }

    @When("^Selecciona uno de los (.*) configurados$")
    public void seleccionaUnoDeLosValores_paisesConfigurados(String pais) {
        if (pais.equals("Colombia")) {
            actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        }

    }

    @Then("^Debe habilitar el campo de Departamento$")
    public void debeHabilitarElCampoDeDepartamento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @And("^presenta en el campo el listado de (.*)$")
    public void presentaEnElCampoElListadoDeValores_departamentos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^presenta en el campo ‘Telefono unidad inmobiliaria’ el prefijo (.*) del pais seleccionado$")
    public void presentaEnElCampoTelefonoUnidadInmobiliariaElPrefijoPrefijoDelPaisSeleccionado() {
        actor.should(new QuestionValidate("+57?").Execute(
                new GeneralParams(
                        "validacion prefijo pais",
                        "Prefijo pais",
                        "//p[contains(text(),'+57')] "
                )
        ));
    }

    @And("^Da clic el campo de Departamento$")
    public void daClicElCampoDeDepartamento(String departamento) {
        if (departamento.equals("Bogota")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en Bogota",
                    "Bogota Colombia",
                    "//button[@name='action']"
            )));
        }
    }

    @Then("^presenta en el campo ‘ciudad’ habilitado$")
    public void presentaEnElCampoCiudadHabilitado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @When("^Da clic en el campo (.*)$")
    public void daClicEnElCampoCampo(String campo) {
        if (campo.equals("Tipo de documento")) {
            actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                    "Usuario da Clic en tipo de documento",
                    "tipo de documento",
                    "//button[@name='action']"
            )));
        }
    }

    @Then("^presenta un listado de los <valores> configurados para el campo$")
    public void presentaUnListadoDeLosValoresConfiguradosParaElCampo() {
        actor.should(seeThat(the("//p[contains(text(),'tipo de documentos')]"), isVisible()));
    }

    @When("^Da clic en Pais del campo Celular Representante$")
    public void daClicEnPaisDelCampoCelularRepresentante() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo celular representante",
                "Celular representante",
                "//button[@name='action']"
        )));
    }

    @Then("^se presenta el (.*) que se encuentre configurado para el pais seleccionado$")
    public void sePresentaElPrefijoQueSeEncuentreConfiguradoParaElPaisSeleccionado(String pais) {
        if (pais.equals("Colombia")) {
            actor.should(new QuestionValidate("+57").Execute(
                    new GeneralParams(
                            "validacion prefijo pais",
                            "Prefijo pais",
                            "//p[contains(text(),'+57')] "
                    )
            ));
        }
    }

    @Given("^Ingresa en el (.*) un (.*) de telefono$")
    public void daClicEnElCampoTelefono(String campo_telefono, String numero) {
        if (campo_telefono.equals("telefono unidad inmobiliaria")) {
            actor.attemptsTo(new EnterTextAction(numero).Execute(
                    new GeneralParams(
                            "numero unidad inmobiliaria",
                            "numero unidad inmobiliaria",
                            "//p[contains(text(),'+57')] "
                    )
            ));
        } else if (campo_telefono.equals("Celular representante")) {
            actor.attemptsTo(new EnterTextAction(numero).Execute(
                    new GeneralParams(
                            "numero Celular representante",
                            "numero Celular representante",
                            "//p[contains(text(),'+57')] "
                    )
            ));
        }
    }

    @Then("^El sistema muestra el resultado (.*)$")
    public void elSistemaMuestraElResultadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(
                new GeneralParams(
                        "Resultado validacion numero de telefono",
                        "Validacion",
                        "//p[contains(text(),'campo')] "
                )
        ));
    }

    @When("^Ingresa un correo <correo>$")
    public void ingresaUnCorreoCorreo(String correo) {
        actor.attemptsTo(new EnterTextAction(correo).Execute(
                new GeneralParams(
                        "correo representante",
                        "correo representante",
                        "//p[contains(text(),'correo')] "
                )
        ));
    }

    @When("^Ingresa solo algunos datos en los campos$")
    public void ingresaSoloAlgunosDatosEnLosCampos() {
        actor.attemptsTo(new EnterTextAction("Conjunto Bits").Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Nombre Conjunto",
                "Campo Nombre Conjunto",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/pais",
                "campo Direccion/pais",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Colombia",
                "campo Colombia",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/departamento",
                "campo Direccion/departamento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Bogota",
                "campo Bogota",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/ciudad",
                "campo Direccion/ciudad",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Bogota",
                "campo Direccion/ciudad Bogota",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Calle 106 # 45-32").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion",
                "campo Direccion",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("634564564").Execute(new GeneralParams(
                "Usuario da Clic en campo Nit",
                "campo Nit",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("345435534").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero catastro",
                "campo Numero catastro",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento",
                "campo Tipo documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento CC",
                "campo Tipo documento CC",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("6545353443").Execute(new GeneralParams(
                "Usuario Ingresa el Numero de documento representante",
                "campo Numero de documento representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Jose Arturo").Execute(new GeneralParams(
                "Usuario Ingresa el campo Nombre representante",
                "campo Nombre representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Barbosa Contreras").Execute(new GeneralParams(
                "Usuario Ingresa el campo Apellido representante",
                "campo Apellido representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("36453535").Execute(new GeneralParams(
                "Usuario Ingresa el campo Telefono unidad inmobiliaria",
                "campo Telefono unidad inmobiliaria",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("3212345678").Execute(new GeneralParams(
                "Usuario Ingresa el campo Celular representante",
                "campo Celular representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("jbarbosac@bitsamericas.com").Execute(new GeneralParams(
                "Usuario Ingresa el campo Correo electronico representante",
                "campo Correo electronico representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("5").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de agrupaciones",
                "campo Numero de agrupaciones",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("60").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de unidades independientes",
                "campo Numero de unidades independientes",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas a pie",
                "campo Numero de entradas a pie",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas vehiculares",
                "campo Numero de entradas vehiculares",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("30").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de parqueaderos",
                "campo Numero de parqueaderos",
                "//button[@name='action']"
        )));
    }

    @Then("^No se muestra habilitado el boton guardar$")
    public void noSeMuestraHabilitadoElBotonGuardar() {
        actor.should(seeThat(the("//button[@name='action']"), isNotEnabled()));
    }

    @When("^Ingresa la informacion (.*) en el campo Numero documento representante$")
    public void ingresaLaInformacionNumeroEnElCampoNumeroDocumentoRepresentante(String numeroDocRepresentante) {
        actor.attemptsTo(new EnterTextAction(numeroDocRepresentante).Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de parqueaderos",
                "campo Numero de parqueaderos",
                "//button[@name='action']"
        )));
    }

    @Then("^El sistema muestra la informacion de los campos de (.*), (.*), (.*) y (.*) ya diligenciados$")
    public void elSistemaMuestraLaInformacionDeLosCamposDeNombreApellidosCelularYCorreoYaDiligenciados(String nombre, String apellidos, String celular, String correo) {
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(nombre)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(apellidos)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(celular)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(correo)));

    }

    @When("^Ingresa todos los datos de direccion, nit, catastro, telefono unidad y correo ya existentes$")
    public void ingresaTodosLosDatosDeDireccionNitCatastroTelefonoUnidadYCorreoYaExistentes() {
        actor.attemptsTo(new EnterTextAction("Conjunto Bits").Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Nombre Conjunto",
                "Campo Nombre Conjunto",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/pais",
                "campo Direccion/pais",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Colombia",
                "campo Colombia",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/departamento",
                "campo Direccion/departamento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Bogota",
                "campo Bogota",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/ciudad",
                "campo Direccion/ciudad",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Bogota",
                "campo Direccion/ciudad Bogota",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Calle 106 # 45-32").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion",
                "campo Direccion",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("634564564").Execute(new GeneralParams(
                "Usuario da Clic en campo Nit",
                "campo Nit",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("345435534").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero catastro",
                "campo Numero catastro",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento",
                "campo Tipo documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento CC",
                "campo Tipo documento CC",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("6545353443").Execute(new GeneralParams(
                "Usuario Ingresa el Numero de documento representante",
                "campo Numero de documento representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Jose Arturo").Execute(new GeneralParams(
                "Usuario Ingresa el campo Nombre representante",
                "campo Nombre representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Barbosa Contreras").Execute(new GeneralParams(
                "Usuario Ingresa el campo Apellido representante",
                "campo Apellido representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("36453535").Execute(new GeneralParams(
                "Usuario Ingresa el campo Telefono unidad inmobiliaria",
                "campo Telefono unidad inmobiliaria",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("3212345678").Execute(new GeneralParams(
                "Usuario Ingresa el campo Celular representante",
                "campo Celular representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("jbarbosac@bitsamericas.com").Execute(new GeneralParams(
                "Usuario Ingresa el campo Correo electronico representante",
                "campo Correo electronico representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("5").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de agrupaciones",
                "campo Numero de agrupaciones",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("60").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de unidades independientes",
                "campo Numero de unidades independientes",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas a pie",
                "campo Numero de entradas a pie",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas vehiculares",
                "campo Numero de entradas vehiculares",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("30").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de parqueaderos",
                "campo Numero de parqueaderos",
                "//button[@name='action']"
        )));
    }

    @Then("^Da clic en el boton guardar$")
    public void daClicEnElBotonGuardar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Clic boton Guardar",
                "boton guardar",
                "//button[@name='action']"
        )));
    }

    @And("^presenta los mensajes de error datos unicos$")
    public void presentaLosMensajesDeErrorDatosUnicos() {
        actor.should(new QuestionValidate("La direccion ya se encuentra asociada a otra unidad inmobiliaria").Execute(new GeneralParams(
                "Mensaje de error de direccion existente",
                "DIreccion existente",
                "//p[contains(text(),'direccion')] "
        )));
        actor.should(new QuestionValidate("El nit ya se encuentra asociado a otra unidad inmobiliaria").Execute(new GeneralParams(
                "Mensaje de error de nit existente",
                "nit existente",
                "//p[contains(text(),'nit')] "
        )));
        actor.should(new QuestionValidate("El numero de catastro ya se encuentra asociado a otra unidad inmobiliaria").Execute(new GeneralParams(
                "Mensaje de error de numero de catastro existente",
                "catastro existente",
                "//p[contains(text(),'catastro')] "
        )));
        actor.should(new QuestionValidate("El telefono de la unidad ya se encuentra asociada a otra unidad inmobiliaria").Execute(new GeneralParams(
                "Mensaje de error de telefono existente",
                "telefono existente",
                "//p[contains(text(),'telefono')] "
        )));
        actor.should(new QuestionValidate("El correo ya se encuentra asociado a otra unidad inmobiliaria").Execute(new GeneralParams(
                "Mensaje de error de correo existente",
                "correo existente",
                "//p[contains(text(),'correo')] "
        )));
    }

    @When("^Ingresa los datos del formulario correctamente$")
    public void ingresaLosDatosDelFormularioCorrectamente() {
        actor.attemptsTo(new EnterTextAction("Conjunto Bits").Execute(new GeneralParams(
                "Usuario ingresa texto en un campo Nombre Conjunto",
                "Campo Nombre Conjunto",
                "//input[@id='idEmail']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/pais",
                "campo Direccion/pais",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Colombia",
                "campo Colombia",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/departamento",
                "campo Direccion/departamento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Bogota",
                "campo Bogota",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion/ciudad",
                "campo Direccion/ciudad",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Bogota",
                "campo Direccion/ciudad Bogota",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Calle 106 # 45-32").Execute(new GeneralParams(
                "Usuario da Clic en campo Direccion",
                "campo Direccion",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("634564564").Execute(new GeneralParams(
                "Usuario da Clic en campo Nit",
                "campo Nit",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("345435534").Execute(new GeneralParams(
                "Usuario da Clic en campo Numero catastro",
                "campo Numero catastro",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento",
                "campo Tipo documento",
                "//button[@name='action']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo Tipo documento CC",
                "campo Tipo documento CC",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("6545353443").Execute(new GeneralParams(
                "Usuario Ingresa el Numero de documento representante",
                "campo Numero de documento representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Jose Arturo").Execute(new GeneralParams(
                "Usuario Ingresa el campo Nombre representante",
                "campo Nombre representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("Barbosa Contreras").Execute(new GeneralParams(
                "Usuario Ingresa el campo Apellido representante",
                "campo Apellido representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("36453535").Execute(new GeneralParams(
                "Usuario Ingresa el campo Telefono unidad inmobiliaria",
                "campo Telefono unidad inmobiliaria",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("3212345678").Execute(new GeneralParams(
                "Usuario Ingresa el campo Celular representante",
                "campo Celular representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("jbarbosac@bitsamericas.com").Execute(new GeneralParams(
                "Usuario Ingresa el campo Correo electronico representante",
                "campo Correo electronico representante",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("5").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de agrupaciones",
                "campo Numero de agrupaciones",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("60").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de unidades independientes",
                "campo Numero de unidades independientes",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas a pie",
                "campo Numero de entradas a pie",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("2").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de entradas vehiculares",
                "campo Numero de entradas vehiculares",
                "//button[@name='action']"
        )));

        actor.attemptsTo(new EnterTextAction("30").Execute(new GeneralParams(
                "Usuario Ingresa el campo Numero de parqueaderos",
                "campo Numero de parqueaderos",
                "//button[@name='action']"
        )));
    }


    @Then("^Se muestra el mensaje de creacion esxitosa$")
    public void seMuestraElMensajeDeCreacionEsxitosa() {
        actor.should(new QuestionValidate("La unidad inmobiliaria ha sido creada exitosamente").Execute(new GeneralParams(
                "Mensaje de exito de creacion de la unidad inmobiliaria",
                "creacion exitosa",
                "//p[contains(text(),'correo')] "
        )));
    }

    @Then("^El usuario visualiza el formulario de Creacion de Unidad Inmobiliaria$")
    public void elUsuarioVisualizaElFormularioDeCreacionDeUnidadInmobiliaria() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Nombre conjunto$")
    public void campoNombreConjunto() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Direccion/Pais$")
    public void campoDireccionPais() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Direccion/Departamento$")
    public void campoDireccionDepartamento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Direccion/Ciudad$")
    public void campoDireccionCiudad() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Direccion$")
    public void campoDireccion() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Nit$")
    public void campoNit() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero catastro$")
    public void campoNumeroCatastro() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Tipo documento$")
    public void campoTipoDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero documento representante$")
    public void campoNumeroDocumentoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Nombre representante$")
    public void campoNombreRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Apellido representante$")
    public void campoApellidoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Telefono unidad inmobiliaria$")
    public void campoTelefonoUnidadInmobiliaria() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Celular representante$")
    public void campoCelularRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Correo electronico representante$")
    public void campoCorreoElectronicoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero de agrupaciones$")
    public void campoNumeroDeAgrupaciones() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero de unidades independientes$")
    public void campoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero de entradas a pie$")
    public void campoNumeroDeEntradasAPie() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero de entradas vehiculares$")
    public void campoNumeroDeEntradasVehiculares() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^Campo Numero de parqueaderos$")
    public void campoNumeroDeParqueaderos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }


    @And("^Ingresa en el campo (.*) la informacion (.*)$")
    public void ingresaEnElCampoCampo_requeridoLaInformacionInformacion(String campo_requerido, String informacion) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario ingresa texto en un campo Nombre Conjunto",
                        "Campo Nombre Conjunto",
                        "//input[@id='idEmail']"
                )));
                break;
            case "Direccion/pais":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion/pais",
                        "campo Direccion/pais",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion/departamento",
                        "campo Direccion/departamento",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion/ciudad",
                        "campo Direccion/ciudad",
                        "//button[@name='action']"
                )));
                break;
            case "Direccion":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Direccion",
                        "campo Direccion",
                        "//button[@name='action']"
                )));
                break;
            case "Nit":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Nit",
                        "campo Nit",
                        "//button[@name='action']"
                )));
                break;
            case "Numero catastro":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero catastro",
                        "campo Numero catastro",
                        "//button[@name='action']"
                )));
                break;
            case "Tipo documento":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Tipo documento",
                        "campo Tipo documento",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de documento representante",
                        "campo Numero de documento representante",
                        "//button[@name='action']"
                )));
                break;
            case "Nombre representante":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Nombre representante",
                        "campo Nombre representante",
                        "//button[@name='action']"
                )));
                break;
            case "Apellido representante":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Apellido representante",
                        "campo Apellido representante",
                        "//button[@name='action']"
                )));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Telefono unidad inmobiliaria",
                        "campo Telefono unidad inmobiliaria",
                        "//button[@name='action']"
                )));
                break;
            case "Celular representante":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Celular representante",
                        "campo Celular representante",
                        "//button[@name='action']"
                )));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Correo electronico representante",
                        "campo Correo electronico representante",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de agrupaciones",
                        "campo Numero de agrupaciones",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de unidades independientes",
                        "campo Numero de unidades independientes",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de entradas a pie",
                        "campo Numero de entradas a pie",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de entradas vehiculares",
                        "campo Numero de entradas vehiculares",
                        "//button[@name='action']"
                )));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(new EnterTextAction(informacion).Execute(new GeneralParams(
                        "Usuario da Clic en campo Numero de parqueaderos",
                        "campo Numero de parqueaderos",
                        "//button[@name='action']"
                )));
                break;
        }
    }

    @Then("^El sistema presenta mensaje de Campo requerido$")
    public void elSistemaPresentaMensajeDeCampoRequerido() {
        actor.should(new QuestionValidate("Campo requerido").Execute(new GeneralParams(
                "Mensaje campo requerido",
                "Campo requerido",
                "//button[@name='action']"
        )));
    }

    @And("^redirige al usuario a la página de Administrar Unidades Inmobiliarias$")
    public void redirigeAlUsuarioALaPaginaDeAdministrarUnidadesInmobiliarias() {
        actor.should(new QuestionValidate("Administración de Unidades Inmobiliarias").Execute(new GeneralParams(
                "Página de Administración de Unidades Inmobiliarias",
                "Administración de Unidades Inmobiliarias",
                "//p[contains(text()] "
        )));
    }
}


    
