Feature: Consultar rol y permisos
  Como usuario super administrador Quiero Consultar los roles con sus permisos Para que los usuarios puedan consultar los permisos

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Configuracion
    And Da clic en Roles


    Scenario: Realizar consulta de rol
      When Da clic en Consultar el rol de Administrador
      Then El sistema presenta la informacion como consulta en los campos

      Scenario: Seleccionar boton regresar
        When Da clic en Consultar el rol de Administrador
        And Da clic en el boton regresar
        Then El sistema debe presentar la página de Administrar roles