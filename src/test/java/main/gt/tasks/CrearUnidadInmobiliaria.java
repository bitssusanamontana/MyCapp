package main.gt.tasks;

import core.Helpers.GeneralParams;
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
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
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

    Target PAIS = Target.the("PAÍS UNIDAD").located(By.cssSelector("#mat-select-18"));
    Target DEPARTAMENTO = Target.the("DEPARTAMENTO").located(By.cssSelector("#mat-select-19"));
    Target CIUDAD = Target.the("CIUDAD").located(By.cssSelector("#mat-select-20"));
    Target DIRECCION = Target.the("DIRECCIÓN").located(By.cssSelector("#address"));
    Target NOMBRE = Target.the("NOMBRE").located(By.cssSelector("#estateUnitName"));
    Target NIT = Target.the("NIT").located(By.cssSelector("#nit"));
    Target CATASTRO = Target.the("CATASTRO").located(By.cssSelector("#cadastreNumber"));
    Target TIPO_DOC = Target.the("TIPO DOCUMENTO").located(By.cssSelector("#mat-select-21"));
    Target DOC_REP = Target.the("DOCUMENTO REPRESENTANTE").located(By.cssSelector("#identificationNumber"));
    Target NOMBRE_REP = Target.the("NOMBRE REPRESENTANTE").located(By.cssSelector("#name"));
    Target APELLIDOS_REP = Target.the("APELLIDOS REPRESENTANTE").located(By.cssSelector("#surnameRepresentative"));
    Target CORREO_REP = Target.the("CORREO REPRESENTANTE").located(By.cssSelector("#email"));
    Target PAIS_TEL = Target.the("PAIS TELEFONO").located(By.cssSelector("#mat-select-22"));
    Target NUM_TEL = Target.the("NUMERO TELEFONO").located(By.cssSelector("#phone"));
    Target PAIS_CEL = Target.the("PAIS CELULAR").located(By.cssSelector("#mat-select-23"));
    Target NUM_CEL = Target.the("NUMERO CELULAR").located(By.cssSelector("#mobile"));
    Target AGRUPACIONES = Target.the("NUMERO AGRUPACIONES").located(By.cssSelector("#numberGroup"));
    Target UNI_INDEP = Target.the("NUMERO UNIDADES INDEPENDIENTES").located(By.cssSelector("#numberIndependentUnit"));
    Target PEATONALES = Target.the("ENTRADAS PEATONALES").located(By.cssSelector("#numberPedestrianEntrance"));
    Target VEHICULARES = Target.the("ENTRADAS VEHICULARES").located(By.cssSelector("#numberVehicularEntrance"));
    Target PARQUEADEROS = Target.the("PARQUEADEROS").located(By.cssSelector("#numberParkingLots"));
    Target ACTIVAR = Target.the("ACTIVAR UNIDAD").located(By.xpath("//div[@class='onoffswitch']"));
    Target GUARDAR = Target.the("BOTÓN GUARDAR").located(By.xpath("//button[contains(text(),'Guardar')]"));

    @And("^Da clic en Unidades Inmobiliarias$")
    public void clicUnidadesInmobiliarias() throws InterruptedException {
        actor.attemptsTo(Click.on("//button[@class='btn-menu ng-star-inserted']"));
        actor.attemptsTo(Click.on("//mat-panel-title[@class='mat-expansion-panel-header-title ng-tns-c29-3']"));
        actor.attemptsTo(Click.on("//span[contains(text(),'Unidades inmobiliarias')]"));
        actor.attemptsTo(Click.on("//i[@class='material-icons notranslate']"));
        Thread.sleep(3000);
    }

    @And("^Da clic en el boton Crear unidad inmobiliaria$")
    public void daClicEnElBotonCrear() {
        actor.attemptsTo(Click.on("#btn--add-estateUnits"));
    }

    @When("^Da clic en una pagina diferente (.*)$")
    public void daClicEnUnaPaginaDiferentePagina(String pagina) throws InterruptedException {
        if (pagina.equals("principal")) {
            actor.attemptsTo(Click.on("//button[@class='btn-menu ng-star-inserted']"));
            actor.attemptsTo(Click.on("//mat-panel-title[@class='mat-expansion-panel-header-title ng-tns-c29-3']"));
            actor.attemptsTo(Click.on("//span[contains(text(),'Unidades inmobiliarias')]"));
            actor.attemptsTo(Click.on("//i[@class='material-icons notranslate']"));
            Thread.sleep(2000);
        } else if (pagina.equals("cerrar sesion")) {
            actor.attemptsTo(Click.on(""));
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
        switch (opcion) {
            case "si":
                actor.attemptsTo(Click.on("#btnExit"));
                break;
            case "no":
                actor.attemptsTo(Click.on("#btnCloseModal"));
                break;
        }
    }

    @Then("^El sistema cierra el pop up$")
    public void elSistemaCierraElPopUp() {
        actor.should(seeThat(the("#btnYes"), isNotVisible()));
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

    @When("^En crear unidad inmobiliaria En el formulario da clic en el (.*)$")
    public void daClicEnElCampo_requerido(String campo_requerido) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.attemptsTo(Click.on(NOMBRE));
                break;
            case "Direccion/pais":
                actor.attemptsTo(Click.on(PAIS));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(Click.on(DEPARTAMENTO));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(Click.on(CIUDAD));
                break;
            case "Direccion":
                actor.attemptsTo(Click.on(DIRECCION));
                break;
            case "Nit":
                actor.attemptsTo(Click.on(NIT));
                break;
            case "Numero catastro":
                actor.attemptsTo(Click.on(CATASTRO));
                break;
            case "Tipo documento":
                actor.attemptsTo(Click.on(TIPO_DOC));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(Click.on(DOC_REP));
                break;
            case "Nombre representante":
                actor.attemptsTo(Click.on(NOMBRE_REP));
                break;
            case "Apellido representante":
                actor.attemptsTo(Click.on(APELLIDOS_REP));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(Click.on(NUM_TEL));
                break;
            case "Celular representante":
                actor.attemptsTo(Click.on(NUM_CEL));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(Click.on(CORREO_REP));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(Click.on(AGRUPACIONES));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(Click.on(UNI_INDEP));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(Click.on(PEATONALES));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(Click.on(VEHICULARES));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(Click.on(PARQUEADEROS));
                break;
        }
    }

    @And("^En crear unidad inmobiliaria Ingresa en todos los campos la informacion correcta$")
    public void ingresaInformacionInformacionEnCadaCampo() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into(NOMBRE));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Colombia").from(PAIS));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(DEPARTAMENTO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(CIUDAD));
        actor.attemptsTo(Enter.theValue("calle 106").into(DIRECCION));
        actor.attemptsTo(Enter.theValue("4365464").into(NIT));
        actor.attemptsTo(Enter.theValue("Bits Americas").into(CATASTRO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("CC").from(TIPO_DOC));
        actor.attemptsTo(Enter.theValue("26253452543").into(DOC_REP));
        actor.attemptsTo(Enter.theValue("Juan").into(NOMBRE_REP));
        actor.attemptsTo(Enter.theValue("Perez").into(APELLIDOS_REP));
        actor.attemptsTo(Enter.theValue("25345343").into(NUM_TEL));
        actor.attemptsTo(Enter.theValue("43343543545").into(NUM_CEL));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into(CORREO_REP));
        actor.attemptsTo(Enter.theValue("12").into(AGRUPACIONES));
        actor.attemptsTo(Enter.theValue("100").into(UNI_INDEP));
        actor.attemptsTo(Enter.theValue("2").into(PEATONALES));
        actor.attemptsTo(Enter.theValue("2").into(VEHICULARES));
        actor.attemptsTo(Enter.theValue("80").into(PARQUEADEROS));


    }

    @Then("^En crear unidad inmobiliaria Se muestra habilitado el boton guardar$")
    public void seMuestraHabilitadoElBotonGuardar() {
        actor.should(seeThat(the(GUARDAR), isEnabled()));
    }

    @Then("^En crear unidad inmobiliaria segun el (.*) Visualiza el resultado esperado (.*)$")
    public void visualizaElResultadoEsperadoResultado(String campo_requerido, String resultado) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.should(seeThat(the(NOMBRE), Predicate.isEqual(resultado)));
                break;
            case "Direccion/pais":
                actor.attemptsTo(Click.on(PAIS));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(Click.on(DEPARTAMENTO));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(Click.on(CIUDAD));
                break;
            case "Direccion":
                actor.attemptsTo(Click.on(DIRECCION));
                break;
            case "Nit":
                actor.attemptsTo(Click.on(NIT));
                break;
            case "Numero catastro":
                actor.attemptsTo(Click.on(CATASTRO));
                break;
            case "Tipo documento":
                actor.attemptsTo(Click.on(TIPO_DOC));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(Click.on(DOC_REP));
                break;
            case "Nombre representante":
                actor.attemptsTo(Click.on(NOMBRE_REP));
                break;
            case "Apellido representante":
                actor.attemptsTo(Click.on(APELLIDOS_REP));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(Click.on(NUM_TEL));
                break;
            case "Celular representante":
                actor.attemptsTo(Click.on(NUM_CEL));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(Click.on(CORREO_REP));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(Click.on(AGRUPACIONES));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(Click.on(UNI_INDEP));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(Click.on(PEATONALES));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(Click.on(VEHICULARES));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(Click.on(PARQUEADEROS));
                break;
        }

    }

    @Given("^En crear unidad inmobiliaria Da clic en el campo Pais$")
    public void daClicEnElCampoPais() {
        actor.attemptsTo(Click.on(PAIS));
    }

    @When("^En crear unidad inmobiliaria Selecciona uno de los (.*) configurados$")
    public void seleccionaUnoDeLosValores_paisesConfigurados(String pais) {
        if (pais.equals("Colombia")) {
            actor.attemptsTo(SelectFromOptions.byVisibleText("Colombia").from(PAIS));
        }

    }

    @Then("^En crear unidad inmobiliaria Debe habilitar el campo de Departamento$")
    public void debeHabilitarElCampoDeDepartamento() {
        actor.should(seeThat(the(DEPARTAMENTO), isEnabled()));
    }

    @And("^En crear unidad inmobiliaria presenta en el campo el listado de (.*)$")
    public void presentaEnElCampoElListadoDeValores_departamentos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria presenta en el campo ‘Telefono unidad inmobiliaria’ el prefijo (.*) del pais seleccionado$")
    public void presentaEnElCampoTelefonoUnidadInmobiliariaElPrefijoPrefijoDelPaisSeleccionado(String prefijo) {
        actor.should(new QuestionValidate(prefijo).Execute(
                new GeneralParams(
                        "validacion prefijo pais",
                        "Prefijo pais",
                        "//p[contains(text(),'+57')] "
                )
        ));
    }

    @And("^En crear unidad inmobiliaria Da clic el campo de Departamento$")
    public void daClicElCampoDeDepartamento() {
        actor.attemptsTo(Click.on(""));
    }


    @Then("^En crear unidad inmobiliaria presenta en el campo ‘ciudad’ habilitado$")
    public void presentaEnElCampoCiudadHabilitado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @When("^En crear unidad inmobiliaria Da clic en el campo (.*)$")
    public void daClicEnElCampoCampo(String campo) {
        if (campo.equals("Tipo de documento")) {
            actor.attemptsTo(Click.on(""));
        }
    }

    @Then("^En crear unidad inmobiliaria presenta un listado de los valores configurados para el campo$")
    public void presentaUnListadoDeLosValoresConfiguradosParaElCampo() {
        actor.should(seeThat(the("//p[contains(text(),'tipo de documentos')]"), isVisible()));
    }

    @When("^En crear unidad inmobiliaria Da clic en Pais del campo Celular Representante$")
    public void daClicEnPaisDelCampoCelularRepresentante() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En crear unidad inmobiliaria se presenta el (.*) que se encuentre configurado para el pais seleccionado$")
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

    @Given("^En crear unidad inmobiliaria Ingresa en el (.*) un (.*) de telefono$")
    public void daClicEnElCampoTelefono(String campo, String numero) {
        switch (campo) {
            case "telefono unidad inmobiliaria":
                actor.attemptsTo(Enter.theValue(numero).into(""));
                break;
            case "Celular representante":
                actor.attemptsTo(Enter.theValue(numero).into(" "));
                break;
        }
    }

    @Then("^En crear unidad inmobiliaria El sistema muestra el resultado (.*)$")
    public void elSistemaMuestraElResultadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(
                new GeneralParams(
                        "Resultado validacion numero de telefono",
                        "Validacion",
                        "//p[contains(text(),'campo')] "
                )
        ));
    }

    @When("^En crear unidad inmobiliaria Ingresa un correo (.*)$")
    public void ingresaUnCorreoCorreo(String correo) {
        actor.attemptsTo(Enter.theValue(correo).into(""));
    }

    @When("^En crear unidad inmobiliaria Ingresa solo algunos datos en los campos$")
    public void ingresaSoloAlgunosDatosEnLosCampos() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into(NOMBRE));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Colombia").from(PAIS));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(DEPARTAMENTO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(CIUDAD));
        actor.attemptsTo(Enter.theValue("calle 106").into(DIRECCION));
        actor.attemptsTo(Enter.theValue("4365464").into(NIT));
        actor.attemptsTo(Enter.theValue("Bits Americas").into(CATASTRO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("CC").from(TIPO_DOC));
        actor.attemptsTo(Enter.theValue("26253452543").into(DOC_REP));
        actor.attemptsTo(Enter.theValue("Juan").into(NOMBRE_REP));
        actor.attemptsTo(Enter.theValue("Perez").into(APELLIDOS_REP));
        actor.attemptsTo(Enter.theValue("").into(NUM_TEL));
        actor.attemptsTo(Enter.theValue("43343543545").into(NUM_CEL));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into(CORREO_REP));
        actor.attemptsTo(Enter.theValue("12").into(AGRUPACIONES));
        actor.attemptsTo(Enter.theValue("").into(UNI_INDEP));
        actor.attemptsTo(Enter.theValue("2").into(PEATONALES));
        actor.attemptsTo(Enter.theValue("2").into(VEHICULARES));
        actor.attemptsTo(Enter.theValue("80").into(PARQUEADEROS));
    }

    @Then("^En crear unidad inmobiliaria No se muestra habilitado el boton guardar$")
    public void noSeMuestraHabilitadoElBotonGuardar() {
        actor.should(seeThat(the("//button[@name='action']"), isNotEnabled()));
    }

    @When("^En crear unidad inmobiliaria Ingresa la informacion (.*) en el campo Numero documento representante$")
    public void ingresaLaInformacionNumeroEnElCampoNumeroDocumentoRepresentante(String numeroDocRepresentante) {
        actor.attemptsTo(Enter.theValue(numeroDocRepresentante).into(""));
    }

    @Then("^En crear unidad inmobiliaria El sistema muestra la informacion de los campos de (.*), (.*), (.*) y (.*) ya diligenciados$")
    public void elSistemaMuestraLaInformacionDeLosCamposDeNombreApellidosCelularYCorreoYaDiligenciados(String nombre, String apellidos, String celular, String correo) {
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(nombre)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(apellidos)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(celular)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(correo)));

    }

    @When("^En crear unidad inmobiliaria Ingresa todos los datos de direccion, nit, catastro, telefono unidad y correo ya existentes$")
    public void ingresaTodosLosDatosDeDireccionNitCatastroTelefonoUnidadYCorreoYaExistentes() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into(NOMBRE));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Colombia").from(PAIS));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(DEPARTAMENTO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(CIUDAD));
        actor.attemptsTo(Enter.theValue("calle 106").into(DIRECCION));
        actor.attemptsTo(Enter.theValue("4365464").into(NIT));
        actor.attemptsTo(Enter.theValue("Bits Americas").into(CATASTRO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("CC").from(TIPO_DOC));
        actor.attemptsTo(Enter.theValue("26253452543").into(DOC_REP));
        actor.attemptsTo(Enter.theValue("Juan").into(NOMBRE_REP));
        actor.attemptsTo(Enter.theValue("Perez").into(APELLIDOS_REP));
        actor.attemptsTo(Enter.theValue("25345343").into(NUM_TEL));
        actor.attemptsTo(Enter.theValue("43343543545").into(NUM_CEL));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into(CORREO_REP));
        actor.attemptsTo(Enter.theValue("12").into(AGRUPACIONES));
        actor.attemptsTo(Enter.theValue("100").into(UNI_INDEP));
        actor.attemptsTo(Enter.theValue("2").into(PEATONALES));
        actor.attemptsTo(Enter.theValue("2").into(VEHICULARES));
        actor.attemptsTo(Enter.theValue("80").into(PARQUEADEROS));
    }

    @Then("^En crear unidad inmobiliaria Da clic en el boton guardar$")
    public void daClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(GUARDAR));
    }

    @And("^En crear unidad inmobiliaria presenta los mensajes de error datos unicos$")
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

    @When("^En crear unidad inmobiliaria Ingresa los datos del formulario correctamente$")
    public void ingresaLosDatosDelFormularioCorrectamente() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into(NOMBRE));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Colombia").from(PAIS));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(DEPARTAMENTO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Bogotá").from(CIUDAD));
        actor.attemptsTo(Enter.theValue("calle 106").into(DIRECCION));
        actor.attemptsTo(Enter.theValue("4365464").into(NIT));
        actor.attemptsTo(Enter.theValue("Bits Americas").into(CATASTRO));
        actor.attemptsTo(SelectFromOptions.byVisibleText("CC").from(TIPO_DOC));
        actor.attemptsTo(Enter.theValue("26253452543").into(DOC_REP));
        actor.attemptsTo(Enter.theValue("Juan").into(NOMBRE_REP));
        actor.attemptsTo(Enter.theValue("Perez").into(APELLIDOS_REP));
        actor.attemptsTo(Enter.theValue("25345343").into(NUM_TEL));
        actor.attemptsTo(Enter.theValue("43343543545").into(NUM_CEL));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into(CORREO_REP));
        actor.attemptsTo(Enter.theValue("12").into(AGRUPACIONES));
        actor.attemptsTo(Enter.theValue("100").into(UNI_INDEP));
        actor.attemptsTo(Enter.theValue("2").into(PEATONALES));
        actor.attemptsTo(Enter.theValue("2").into(VEHICULARES));
        actor.attemptsTo(Enter.theValue("80").into(PARQUEADEROS));
    }


    @Then("^En crear unidad inmobiliaria Se muestra el mensaje de creacion esxitosa$")
    public void seMuestraElMensajeDeCreacionEsxitosa() {
        actor.should(new QuestionValidate("La unidad inmobiliaria ha sido creada exitosamente").Execute(new GeneralParams(
                "Mensaje de exito de creacion de la unidad inmobiliaria",
                "creacion exitosa",
                "//p[contains(text(),'correo')] "
        )));
    }

    @Then("^En crear unidad inmobiliaria El usuario visualiza el formulario de Creacion de Unidad Inmobiliaria$")
    public void elUsuarioVisualizaElFormularioDeCreacionDeUnidadInmobiliaria() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Nombre conjunto$")
    public void campoNombreConjunto() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Direccion/Pais$")
    public void campoDireccionPais() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Direccion/Departamento$")
    public void campoDireccionDepartamento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Direccion/Ciudad$")
    public void campoDireccionCiudad() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Direccion$")
    public void campoDireccion() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Nit$")
    public void campoNit() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero catastro$")
    public void campoNumeroCatastro() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Tipo documento$")
    public void campoTipoDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero documento representante$")
    public void campoNumeroDocumentoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Nombre representante$")
    public void campoNombreRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Apellido representante$")
    public void campoApellidoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Telefono unidad inmobiliaria$")
    public void campoTelefonoUnidadInmobiliaria() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Celular representante$")
    public void campoCelularRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Correo electronico representante$")
    public void campoCorreoElectronicoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero de agrupaciones$")
    public void campoNumeroDeAgrupaciones() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero de unidades independientes$")
    public void campoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero de entradas a pie$")
    public void campoNumeroDeEntradasAPie() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero de entradas vehiculares$")
    public void campoNumeroDeEntradasVehiculares() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En crear unidad inmobiliaria Campo Numero de parqueaderos$")
    public void campoNumeroDeParqueaderos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }


    @And("^En crear unidad inmobiliaria Ingresa en el campo (.*) la informacion (.*)$")
    public void ingresaEnElCampoCampo_requeridoLaInformacion(String campo_requerido, String informacion) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.attemptsTo(Enter.theValue(informacion).into(NOMBRE));
                break;
            case "Direccion":
                actor.attemptsTo(Enter.theValue(informacion).into(DIRECCION));
                break;
            case "Nit":
                actor.attemptsTo(Enter.theValue(informacion).into(NIT));
                break;
            case "Numero catastro":
                actor.attemptsTo(Enter.theValue(informacion).into(CATASTRO));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(Enter.theValue(informacion).into(DOC_REP));
                break;
            case "Nombre representante":
                actor.attemptsTo(Enter.theValue(informacion).into(NOMBRE_REP));
                break;
            case "Apellido representante":
                actor.attemptsTo(Enter.theValue(informacion).into(APELLIDOS_REP));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(Enter.theValue(informacion).into(NUM_TEL));
                break;
            case "Celular representante":
                actor.attemptsTo(Enter.theValue(informacion).into(NUM_CEL));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(Enter.theValue(informacion).into(CORREO_REP));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(Enter.theValue(informacion).into(AGRUPACIONES));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(Enter.theValue(informacion).into(UNI_INDEP));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(Enter.theValue(informacion).into(PEATONALES));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(Enter.theValue(informacion).into(VEHICULARES));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(Enter.theValue(informacion).into(PARQUEADEROS));
                break;
        }
    }

    @Then("^En crear unidad inmobiliaria El sistema presenta mensaje de Campo requerido$")
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

    @And("^En crear unidad inmobiliaria Da clic por fuera del campo$")
    public void enCrearUnidadInmobiliariaDaClicPorFueraDelCampo() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^visualiza el label iniciar sesion$")
    public void visualizaElLabelIniciarSesion() {
        actor.should(seeThat(the("#sesion"), isVisible()));
    }

    @Then("^confirma el titulo de iniciar sesion$")
    public void confirmaElTituloDeIniciarSesion() {
        actor.should(seeThat(the("#sesion"), isVisible()));
    }
}


    
