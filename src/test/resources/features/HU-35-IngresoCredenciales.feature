Feature: Como usuario de la aplicación de conjuntos deseo iniciar sesión para gestionar unidades inmobiliarias.

  Background: Ingresar a la aplicación

  Scenario Outline: : Habilitación del botón ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    When Usuario ingresar información de usuario de <usuario> y <Contrasena>
    Then El sistema <Habilitado> presenta habilitado el botón de ingresar

    Examples:
      | usuario   | Contrasena | Habilitado |
      | jabarbosa |            | no         |
      | jabarbosa | 234324     | si         |

  Scenario Outline: Ingreso exitoso a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    When Usuario ingresar información de usuario de <usuario> y <Contrasena>
    And Ingresa
    Then El sistema presenta la página Administracion de roles
    Examples:
      | usuario   | Contrasena |
      | rherrerar | 123456     |

  Scenario Outline: Ingreso fallido a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    When Usuario ingresar información de usuario de <usuario> y <Contrasena>
    And Ingresa
    Then El sistema un mensaje de error <mensaje>
    Examples:
      | usuario   | Contrasena | mensaje   |
      | inactivo  | 123        | Inactivo  |
      | jabarbosa | 243242     | Invalido  |
      | bloqueado | 1234       | Bloqueado |


  Scenario: Bloqueo de Usuario con 5 intentos de ingreso
    Given Que usuario ingresa a la pagina de inicio
    When Ingresa 5 veces información de usuario y de contrasena errada
    Then Visualmente se informa que el usuario está bloqueado

