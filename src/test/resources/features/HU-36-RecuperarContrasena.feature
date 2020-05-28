Feature: Como usuario Quiero recuperar la contraseña Para ingresar a la aplicación

  Background: Un usuario ingresa a la aplicación de conjuntos
    Given Que usuario ingresa a la pagina de inicio


  Scenario: Información que se presenta al ingresar al enlace Olvidaste tu contraseña
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    Then Visualiza Label Recuperar contraseña
    And Visualiza Label Ingresa tu documento o correo
    And Visualiza Campo tipo texto
    And Visualiza Icono de ayuda
    And Visualiza El boton Enviar
    And Visualiza Boton volver

  Scenario: Seleccionar el botón de volver
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación

  Scenario: No ingresar información en el campo usuario
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Da clic en usuario
    Then El sistema presenta inhabilitado el botón Enviar

  Scenario Outline: Habilitación del botón de enviar
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    Then El sistema presenta habilitado el botón Enviar
    Examples:
      | usuario  |
      | rherrera |
      | ttest    |
      | vxyz     |

  Scenario Outline: Ingreso de información para recuperar la contraseña
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    And Da clic en el boton Enviar
    Then El sistema presenta el mensaje <Mensaje>
    Examples:
      | usuario                         | Mensaje  |
      | 4324242                         | Invalido |
      | CC123                           | Inactivo |
      | susana.montana@bitsamericas.com | Exitoso  |

  Scenario Outline: Selección del botón de volver al realizar la recuperación de contraseña
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Ingresa información de <usuario> en el campo de usuario
    And Da clic en el boton Enviar
    And El usuario visualiza el mensaje de exito
    And Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación
    Examples:
      | usuario                         |
      | susana.montana@bitsamericas.com |

  Scenario: Icono de ayuda|
    When Da clic en el enlace ¿Olvidaste tu contrasena?
    And Da clic en icono de ayuda
    Then Se muestra un pop up con el mensaje de ayuda