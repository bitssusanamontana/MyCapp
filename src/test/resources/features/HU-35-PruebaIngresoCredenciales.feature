Feature: Como usuario de la aplicación de conjuntos deseo iniciar sesión para gestionar unidades inmobiliarias.

  Background: Ingresar a la aplicación

  Scenario Outline: Ingreso exitoso a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    When Ingresa información de usuario de <Tipo_usuario>
    And Ingresa la información de contrasena <Contrasena>
    And Da clic sobre el botón Ingresar
    Then El sistema presenta la página Administracion de roles
    Examples:
      | Tipo_usuario | Contrasena |
      | test         | test       |