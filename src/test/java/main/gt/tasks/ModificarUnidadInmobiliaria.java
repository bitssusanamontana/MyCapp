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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ModificarUnidadInmobiliaria {
    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador));
    }


    @And("^Da clic en el boton modificar unidad inmobiliaria$")
    public void daClicEnElBotonModificar() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en Modificar Unidad",
                "Boton modificar Unidad",
                "//button[@name='action']"
        )));
    }

    @And("^En modificar unidad inmobiliaria Borra la informacion del (.*)$")
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

    @Given("^En modificar unidad inmobiliaria Da clic en el pais$")
    public void daClicEnElPais() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en campo país",
                "campo país",
                "//button[@name='action']"
        )));
    }

    @When("^En modificar unidad inmobiliaria Ingresa un correo (.*)$")
    public void ingresaUnCorreoCorreo(String correo) {
        actor.attemptsTo(new EnterTextAction(correo).Execute(new GeneralParams(
                "Usuario ingresa correo",
                "Campo correo",
                "//input[@id='idEmail']"
        )));
    }

    @Then("^En modificar unidad inmobiliaria Se muestra el mensaje de modificacion exitosa$")
    public void seMuestraElMensajeDeModificacionExitosa() {
        actor.should(new QuestionValidate("La unidad inmobiliaria ha sido modificada exitosamente").Execute(new GeneralParams(
                "Mensaje de exito de modificación de la unidad inmobiliaria",
                "modificación exitosa",
                "//p[contains(text(),'correo')] "
        )));
    }


    @Then("^En modificar unidad inmobiliaria El usuario visualiza el formulario de Modificacion de Unidad Inmobiliaria$")
    public void enModificarUnidadInmobiliariaElUsuarioVisualizaElFormularioDeModificacionDeUnidadInmobiliaria() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Nombre conjunto$")
    public void enModificarUnidadInmobiliariaCampoNombreConjunto() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Direccion/Pais$")
    public void enModificarUnidadInmobiliariaCampoDireccionPais() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Direccion/Departamento$")
    public void enModificarUnidadInmobiliariaCampoDireccionDepartamento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Direccion/Ciudad$")
    public void enModificarUnidadInmobiliariaCampoDireccionCiudad() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Direccion$")
    public void enModificarUnidadInmobiliariaCampoDireccion() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Nit$")
    public void enModificarUnidadInmobiliariaCampoNit() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero catastro$")
    public void enModificarUnidadInmobiliariaCampoNumeroCatastro() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Tipo documento$")
    public void enModificarUnidadInmobiliariaCampoTipoDocumento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero documento representante$")
    public void enModificarUnidadInmobiliariaCampoNumeroDocumentoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Nombre representante$")
    public void enModificarUnidadInmobiliariaCampoNombreRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Apellido representante$")
    public void enModificarUnidadInmobiliariaCampoApellidoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Telefono unidad inmobiliaria$")
    public void enModificarUnidadInmobiliariaCampoTelefonoUnidadInmobiliaria() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Celular representante$")
    public void enModificarUnidadInmobiliariaCampoCelularRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Correo electronico representante$")
    public void enModificarUnidadInmobiliariaCampoCorreoElectronicoRepresentante() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero de agrupaciones$")
    public void enModificarUnidadInmobiliariaCampoNumeroDeAgrupaciones() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero de unidades independientes$")
    public void enModificarUnidadInmobiliariaCampoNumeroDeUnidadesIndependientes() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero de entradas a pie$")
    public void enModificarUnidadInmobiliariaCampoNumeroDeEntradasAPie() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero de entradas vehiculares$")
    public void enModificarUnidadInmobiliariaCampoNumeroDeEntradasVehiculares() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria Campo Numero de parqueaderos$")
    public void enModificarUnidadInmobiliariaCampoNumeroDeParqueaderos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @When("^En modificar unidad inmobiliaria Da clic en el (.*)$")
    public void enModificarUnidadInmobiliariaDaClicEnElCampo_requerido(String campo_requerido) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.attemptsTo(Click.on(""));
                break;
            case "Direccion/pais":
                actor.attemptsTo(Click.on(" "));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(Click.on("d"));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(Click.on("c"));
                break;
            case "Direccion":
                actor.attemptsTo(Click.on("dr"));
                break;
            case "Nit":
                actor.attemptsTo(Click.on("nt"));
                break;
            case "Numero catastro":
                actor.attemptsTo(Click.on("ct"));
                break;
            case "Tipo documento":
                actor.attemptsTo(Click.on("td"));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(Click.on("nd"));
                break;
            case "Nombre representante":
                actor.attemptsTo(Click.on("nr"));
                break;
            case "Apellido representante":
                actor.attemptsTo(Click.on("ap"));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(Click.on("tu"));
                break;
            case "Celular representante":
                actor.attemptsTo(Click.on("cr"));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(Click.on("ce"));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(Click.on("na"));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(Click.on("nui"));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(Click.on("ne"));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(Click.on("ev"));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(Click.on("p"));
                break;
        }
    }

    @And("^En modificar unidad inmobiliaria Da clic por fuera del campo$")
    public void enModificarUnidadInmobiliariaDaClicPorFueraDelCampo() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En modificar unidad inmobiliaria El sistema presenta mensaje de Campo requerido$")
    public void enModificarUnidadInmobiliariaElSistemaPresentaMensajeDeCampoRequerido() {
        actor.should(new QuestionValidate("Campo requerido").Execute(
                new GeneralParams(
                        "Campo requerido",
                        "Campo requerido",
                        "//p[contains(text(Campo requerido)')] "
                )
        ));
    }

    @When("^En modificar unidad inmobiliaria Ingresa en todos los campos la informacion correcta$")
    public void enModificarUnidadInmobiliariaIngresaEnTodosLosCamposLaInformacionCorrecta() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into("nombreunidad"));
        actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        actor.attemptsTo(Click.on(By.cssSelector("#departamento"), By.linkText("Bogotá")));
        actor.attemptsTo(Click.on(By.cssSelector("#ciudad"), By.linkText("Bogotá")));
        actor.attemptsTo(Enter.theValue("calle 106").into("direccion"));
        actor.attemptsTo(Enter.theValue("4365464").into("nit"));
        actor.attemptsTo(Enter.theValue("Bits Americas").into("catastro"));
        actor.attemptsTo(Click.on(By.cssSelector("#tipodoc"), By.linkText("CC")));
        actor.attemptsTo(Enter.theValue("26253452543").into("docRepresentante"));
        actor.attemptsTo(Enter.theValue("Juan").into("nombreRepresentante"));
        actor.attemptsTo(Enter.theValue("Perez").into("apellidoRepresentante"));
        actor.attemptsTo(Enter.theValue("25345343").into("telUnidad"));
        actor.attemptsTo(Enter.theValue("43343543545").into("celRepresentante"));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into("correoRepresentante"));
        actor.attemptsTo(Enter.theValue("12").into("numeroAgrupaciones"));
        actor.attemptsTo(Enter.theValue("100").into("numeroUnidadesINde"));
        actor.attemptsTo(Enter.theValue("2").into("entradasPie"));
        actor.attemptsTo(Enter.theValue("2").into("entradasVehiculares"));
        actor.attemptsTo(Enter.theValue("80").into("numeroParqueaderos"));
    }

    @Then("^En modificar unidad inmobiliaria Se muestra habilitado el boton guardar$")
    public void enModificarUnidadInmobiliariaSeMuestraHabilitadoElBotonGuardar() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @And("^En modificar unidad inmobiliaria Ingresa en el campo (.*) la informacion (.*)$")
    public void enModificarUnidadInmobiliariaIngresaEnElCampoCampo_requeridoLaInformacionInformacion(String campo_requerido, String informacion) {
        switch (campo_requerido) {
            case "Nombre conjunto":
                actor.attemptsTo(Enter.theValue(informacion).into(""));
                break;
            case "Direccion/pais":
                actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
                break;
            case "Direccion/departamento":
                actor.attemptsTo(Click.on(By.cssSelector("#departamento"), By.linkText("Bogota")));
                break;
            case "Direccion/ciudad":
                actor.attemptsTo(Click.on(By.cssSelector("#ciudad"), By.linkText("Bog")));
                break;
            case "Direccion":
                actor.attemptsTo(Enter.theValue(informacion).into("dr"));
                break;
            case "Nit":
                actor.attemptsTo(Enter.theValue(informacion).into("nit"));
                break;
            case "Numero catastro":
                actor.attemptsTo(Enter.theValue(informacion).into("ct"));
                break;
            case "Tipo documento":
                actor.attemptsTo(Click.on(By.cssSelector("tipoDoc"), By.linkText("CC")));
                break;
            case "Numero de documento representante":
                actor.attemptsTo(Enter.theValue(informacion).into("nd"));
                break;
            case "Nombre representante":
                actor.attemptsTo(Enter.theValue(informacion).into("nb"));
                break;
            case "Apellido representante":
                actor.attemptsTo(Enter.theValue(informacion).into("ap"));
                break;
            case "Telefono unidad inmobiliaria":
                actor.attemptsTo(Enter.theValue(informacion).into("tu"));
                break;
            case "Celular representante":
                actor.attemptsTo(Enter.theValue(informacion).into("cr"));
                break;
            case "Correo electronico representante":
                actor.attemptsTo(Enter.theValue(informacion).into("ce"));
                break;
            case "Numero de agrupaciones":
                actor.attemptsTo(Enter.theValue(informacion).into("na"));
                break;
            case "Numero de unidades independientes":
                actor.attemptsTo(Enter.theValue(informacion).into("nui"));
                break;
            case "Numero de entradas a pie":
                actor.attemptsTo(Enter.theValue(informacion).into("ne"));
                break;
            case "Numero de entradas vehiculares":
                actor.attemptsTo(Enter.theValue(informacion).into("nv"));
                break;
            case "Numero de parqueaderos":
                actor.attemptsTo(Enter.theValue(informacion).into("np"));
                break;
        }
    }

    @Then("^En modificar unidad inmobiliaria Visualiza el resultado esperado (.*)$")
    public void enModificarUnidadInmobiliariaVisualizaElResultadoEsperadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(new GeneralParams(
                "Resultado",
                "Resultado",
                "//button[@name='action']"
        )));
    }

    @Given("^En modificar unidad inmobiliaria Da clic en el campo Pais$")
    public void enModificarUnidadInmobiliariaDaClicEnElCampoPais() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^En modificar unidad inmobiliaria Selecciona uno de los (.*) configurados$")
    public void enModificarUnidadInmobiliariaSeleccionaUnoDeLosValores_paisesConfigurados(String pais) {
        if (pais.equals("Colombia")) {
            actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        }
    }

    @Then("^En modificar unidad inmobiliaria Debe habilitar el campo de Departamento$")
    public void enModificarUnidadInmobiliariaDebeHabilitarElCampoDeDepartamento() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @And("^En modificar unidad inmobiliaria presenta en el campo el listado de <valores_departamentos>$")
    public void enModificarUnidadInmobiliariaPresentaEnElCampoElListadoDeValores_departamentos() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @And("^En modificar unidad inmobiliaria presenta en el campo ‘Telefono unidad inmobiliaria’ el prefijo (.*) del pais seleccionado$")
    public void enModificarUnidadInmobiliariaPresentaEnElCampoTelefonoUnidadInmobiliariaElPrefijoPrefijoDelPaisSeleccionado(String prefijo) {
        actor.should(new QuestionValidate(prefijo).Execute(
                new GeneralParams(
                        "validacion prefijo pais",
                        "Prefijo pais",
                        "//p[contains(text(),'+57')] "
                )
        ));
    }

    @And("^En modificar unidad inmobiliaria Da clic el campo de Departamento$")
    public void enModificarUnidadInmobiliariaDaClicElCampoDeDepartamento() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En modificar unidad inmobiliaria presenta en el campo ‘ciudad’ habilitado$")
    public void enModificarUnidadInmobiliariaPresentaEnElCampoCiudadHabilitado() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isEnabled()));
    }

    @When("^En modificar unidad inmobiliaria Da clic en el campo (.*)$")
    public void enModificarUnidadInmobiliariaDaClicEnElCampoCampo(String campo) {
        if (campo.equals("Tipo de documento")) {
            actor.attemptsTo(Click.on(""));
        }
    }

    @Then("^En modificar unidad inmobiliaria presenta un listado de los valores configurados para el campo$")
    public void enModificarUnidadInmobiliariaPresentaUnListadoDeLosValoresConfiguradosParaElCampo() {
        actor.should(seeThat(the("//p[contains(text(),'Inicio')]"), isVisible()));
    }

    @When("^En modificar unidad inmobiliaria Da clic en Pais del campo Celular Representante$")
    public void enModificarUnidadInmobiliariaDaClicEnPaisDelCampoCelularRepresentante() {
        actor.attemptsTo(Click.on(""));
    }

    @Then("^En modificar unidad inmobiliaria se presenta el (.*) que se encuentre configurado para el pais seleccionado$")
    public void enModificarUnidadInmobiliariaSePresentaElPrefijoQueSeEncuentreConfiguradoParaElPaisSeleccionado(String prefijo) {
        actor.should(new QuestionValidate(prefijo).Execute(
                new GeneralParams(
                        "validacion prefijo pais",
                        "Prefijo pais",
                        "//p[contains(text(),'+57')] "
                )
        ));
    }

    @When("^En modificar unidad inmobiliaria Ingresa en el (.*) un (.*) de telefono$")
    public void enModificarUnidadInmobiliariaIngresaEnElCampoUnNumeroDeTelefono(String campo, String numero) {
        switch (campo){
            case "telefono unidad inmobiliaria":
                actor.attemptsTo(Enter.theValue(numero).into(""));
                break;
                case "Celular representante":
                    actor.attemptsTo(Enter.theValue(numero).into(" "));
                    break;
        }
    }

    @Then("^En modificar unidad inmobiliaria El sistema muestra el resultado (.*)$")
    public void enModificarUnidadInmobiliariaElSistemaMuestraElResultadoResultado(String resultado) {
        actor.should(new QuestionValidate(resultado).Execute(
                new GeneralParams(
                        "Resultado validacion numero de telefono",
                        "Validacion",
                        "//p[contains(text(),'campo')] "
                )
        ));
    }

    @Given("^En modificar unidad inmobiliaria Da clic en el campo correo electronico$")
    public void enModificarUnidadInmobiliariaDaClicEnElCampoCorreoElectronico() {
        actor.attemptsTo(Click.on(""));
    }

    @When("^En modificar unidad inmobiliaria Ingresa solo algunos datos en los campos$")
    public void enModificarUnidadInmobiliariaIngresaSoloAlgunosDatosEnLosCampos() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into("nombreunidad"));
        actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        actor.attemptsTo(Click.on(By.cssSelector("#departamento"), By.linkText("Bogotá")));
        actor.attemptsTo(Click.on(By.cssSelector("#ciudad"), By.linkText("Bogotá")));
        actor.attemptsTo(Enter.theValue("calle 106").into("direccion"));
        actor.attemptsTo(Enter.theValue("4365464").into("nit"));
        actor.attemptsTo(Enter.theValue("Bits Americas").into("catastro"));
        actor.attemptsTo(Click.on(By.cssSelector("#tipodoc"), By.linkText("CC")));
        actor.attemptsTo(Enter.theValue("").into("docRepresentante"));
        actor.attemptsTo(Enter.theValue("Juan").into("nombreRepresentante"));
        actor.attemptsTo(Enter.theValue("Perez").into("apellidoRepresentante"));
        actor.attemptsTo(Enter.theValue("25345343").into("telUnidad"));
        actor.attemptsTo(Enter.theValue("").into("celRepresentante"));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into("correoRepresentante"));
        actor.attemptsTo(Enter.theValue("12").into("numeroAgrupaciones"));
        actor.attemptsTo(Enter.theValue("").into("numeroUnidadesINde"));
        actor.attemptsTo(Enter.theValue("2").into("entradasPie"));
        actor.attemptsTo(Enter.theValue("2").into("entradasVehiculares"));
        actor.attemptsTo(Enter.theValue("").into("numeroParqueaderos"));
    }

    @Then("^En modificar unidad inmobiliaria No se muestra habilitado el boton guardar$")
    public void enModificarUnidadInmobiliariaNoSeMuestraHabilitadoElBotonGuardar() {
        actor.should(seeThat(the("//button[@name='action']"), isNotEnabled()));
    }

    @And("^En modificar unidad inmobiliaria Ingresa la informacion (.*) en el campo Numero documento representante$")
    public void enModificarUnidadInmobiliariaIngresaLaInformacionNumeroEnElCampoNumeroDocumentoRepresentante(String numeroDocRepresentante) {
        actor.attemptsTo(Enter.theValue(numeroDocRepresentante).into(""));
    }

    @Then("^En modificar unidad inmobiliaria El sistema muestra la informacion de los campos de (.*), (.*), (.*) y (.*) ya diligenciados$")
    public void enModificarUnidadInmobiliariaElSistemaMuestraLaInformacionDeLosCamposDeNombreApellidosCelularYCorreoYaDiligenciados(String nombre, String apellidos, String celular, String correo) {
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(nombre)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(apellidos)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(celular)));
        actor.should(seeThat(the("//button[@name='action']"), Predicate.isEqual(correo)));
    }

    @When("^En modificar unidad inmobiliaria Ingresa todos los datos de direccion, nit, catastro, telefono unidad y correo ya existentes$")
    public void enModificarUnidadInmobiliariaIngresaTodosLosDatosDeDireccionNitCatastroTelefonoUnidadYCorreoYaExistentes() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into("nombreunidad"));
        actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        actor.attemptsTo(Click.on(By.cssSelector("#departamento"), By.linkText("Bogotá")));
        actor.attemptsTo(Click.on(By.cssSelector("#ciudad"), By.linkText("Bogotá")));
        actor.attemptsTo(Enter.theValue("calle 106").into("direccion"));
        actor.attemptsTo(Enter.theValue("4365464").into("nit"));
        actor.attemptsTo(Enter.theValue("Bits Americas").into("catastro"));
        actor.attemptsTo(Click.on(By.cssSelector("#tipodoc"), By.linkText("CC")));
        actor.attemptsTo(Enter.theValue("26253452543").into("docRepresentante"));
        actor.attemptsTo(Enter.theValue("Juan").into("nombreRepresentante"));
        actor.attemptsTo(Enter.theValue("Perez").into("apellidoRepresentante"));
        actor.attemptsTo(Enter.theValue("25345343").into("telUnidad"));
        actor.attemptsTo(Enter.theValue("43343543545").into("celRepresentante"));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into("correoRepresentante"));
        actor.attemptsTo(Enter.theValue("12").into("numeroAgrupaciones"));
        actor.attemptsTo(Enter.theValue("100").into("numeroUnidadesINde"));
        actor.attemptsTo(Enter.theValue("2").into("entradasPie"));
        actor.attemptsTo(Enter.theValue("2").into("entradasVehiculares"));
        actor.attemptsTo(Enter.theValue("80").into("numeroParqueaderos"));
    }

    @Then("^En modificar unidad inmobiliaria Da clic en el boton guardar$")
    public void enModificarUnidadInmobiliariaDaClicEnElBotonGuardar() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^En modificar unidad inmobiliaria presenta los mensajes de error datos unicos$")
    public void enModificarUnidadInmobiliariaPresentaLosMensajesDeErrorDatosUnicos() {
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

    @When("^En modificar unidad inmobiliaria Ingresa los datos del formulario correctamente$")
    public void enModificarUnidadInmobiliariaIngresaLosDatosDelFormularioCorrectamente() {
        actor.attemptsTo(Enter.theValue("Bits Americas").into("nombreunidad"));
        actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        actor.attemptsTo(Click.on(By.cssSelector("#departamento"), By.linkText("Bogotá")));
        actor.attemptsTo(Click.on(By.cssSelector("#ciudad"), By.linkText("Bogotá")));
        actor.attemptsTo(Enter.theValue("calle 106").into("direccion"));
        actor.attemptsTo(Enter.theValue("4365464").into("nit"));
        actor.attemptsTo(Enter.theValue("Bits Americas").into("catastro"));
        actor.attemptsTo(Click.on(By.cssSelector("#tipodoc"), By.linkText("CC")));
        actor.attemptsTo(Enter.theValue("26253452543").into("docRepresentante"));
        actor.attemptsTo(Enter.theValue("Juan").into("nombreRepresentante"));
        actor.attemptsTo(Enter.theValue("Perez").into("apellidoRepresentante"));
        actor.attemptsTo(Enter.theValue("25345343").into("telUnidad"));
        actor.attemptsTo(Enter.theValue("43343543545").into("celRepresentante"));
        actor.attemptsTo(Enter.theValue("repre@gmail.com").into("correoRepresentante"));
        actor.attemptsTo(Enter.theValue("12").into("numeroAgrupaciones"));
        actor.attemptsTo(Enter.theValue("100").into("numeroUnidadesINde"));
        actor.attemptsTo(Enter.theValue("2").into("entradasPie"));
        actor.attemptsTo(Enter.theValue("2").into("entradasVehiculares"));
        actor.attemptsTo(Enter.theValue("80").into("numeroParqueaderos"));
    }

    @And("^En modificar unidad inmobiliaria presenta en el campo el listado de (.*)$")
    public void enModificarUnidadInmobiliariaPresentaEnElCampoElListadoDeValores_ciudades(String ciudad) {
        actor.should(new QuestionValidate(ciudad).Execute(new GeneralParams(
                "ciudad",
                "ciudad",
                "//p[contains(text(),'correo')] "
        )));
    }

    @Given("^En modificar unidad inmobiliaria clic en el campo pais$")
    public void enModificarUnidadInmobiliariaClicEnElCampoPais() {
        actor.attemptsTo(Click.on(""));
    }

    @And("^En modificar unidad inmobiliaria Selecciona un pais (.*)$")
    public void enModificarUnidadInmobiliariaSeleccionaUnPaisValores_paisesConfigurado(String pais) {
        if (pais.equals("Colombia")) {
            actor.attemptsTo(Click.on(By.cssSelector("#pais"), By.linkText("Colombia")));
        }
    }


}
