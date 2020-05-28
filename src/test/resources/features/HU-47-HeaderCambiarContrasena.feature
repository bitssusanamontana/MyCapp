Feature: Cambiar contraseña
  Como usuario Quiero cambiar la contraseña Para ingresar a la aplicación

  Background: Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión

  Scenario: Informacion que se presenta al seleccionar la opción de cambiar contrasena
    Given Un usuario da clic sobre la foto de perfil
    When Da clic en la opcion Cambiar contrasena
    Then El sistema presenta una ventana emergente
    And Presenta el campo Contrasena actual habilitado sin informacion
    And Presenta el campo Nueva contrasena habilitado sin informacion
    And Presenta el campo Confirmar contrasena habilitado sin informacion
    And Presenta el boton de Cambiar bloqueado
    And Presenta la opcion de Cerrar la ventana emergente
    And Presenta el boton de Cancelar

  Scenario: Cerrar la ventana emergente de cambiar contraseña
    Given Un usuario da clic sobre la foto de perfil
    And Da clic en la opcion Cambiar contrasena
    When Da clic sobre la opción de cerrar
    Then El sistema cierra la ventana emergente
    And No actualiza la información de la contraseña
    And Deja al usuario en la página actual

  Scenario Outline: No ingresar información en los campos requeridos
    Given Un usuario da clic sobre la foto de perfil
    And Da clic en la opcion Cambiar contrasena
    When Da clic en <campo_requerido>  y No ingresa información
    And Da clic por fuera del campo
    Then El sistema presenta un indicando que el campo es requerido
    Examples:
      | campo_requerido         |
      | Contrasena actual       |
      | Nueva contrasena        |
      | Confirmacion contrasena |

  Scenario Outline: Ingresar una contraseña actual
    Given Un usuario da clic sobre la foto de perfil
    And Da clic en la opcion Cambiar contrasena
    And Da clic en contrasena actual
    When Ingresa una <contrasenaActual>
    Then El sistema muestra un <resultado> y se muestra un mensaje
    Examples:
      | contrasenaActual | resultado        |
      | Bits20           | Check correcto   |
      | Bits2020         | Check incorrecto |

  Scenario Outline: Ingresar una nueva contraseña
    Given Un usuario da clic sobre la foto de perfil
    And Da clic en la opcion Cambiar contrasena
    And Da clic en contrasena actual
    And Ingresa una <contrasenaActual>
    When Ingresa nueva contrasena <NuevaContrasena>
    Then El sistema muestra el <resultado> y se muestra un mensaje

    Examples:
      | contrasenaActual | NuevaContrasena | resultado        |
      | Bits2020         | Bits2021        | Check correcto   |
      | Bits2020         | B1t52021        | Check correcto   |
      | Bits2020         | b1t52021        | Check incorrecto |
      | Bits2020         | Bits            | Check incorrecto |
      | Bits2020         | B1t5            | Check incorrecto |
      | Bits2020         | B1t$%&/52021    | Check incorrecto |

  Scenario Outline: Ingresar una confirmacion de contraseña
    Given Un usuario da clic sobre la foto de perfil
    And Da clic en la opcion Cambiar contrasena
    And Da clic en contrasena actual
    And Ingresa una <contrasenaActual>
    When Ingresa una <NuevaContrasena>
    And Confirmacion de contrasena ingresada <confirmacionContrasena>
    Then Se muestra el <resultado> y Se pasa el cursor por el check y se muestra un mensaje
    And <SioNo> Se habilita el boton guardar
    Examples:
      | contrasenaActual | NuevaContrasena | confirmacionContrasena | resultado        | SioNo |
      | Bits2020         | Bits2021        | Bits2021               | Check correcto   | Si    |
      | Bits2020         | B1t52021        | Bits2021               | Check incorrecto | No    |

  Scenario: Se habilita el botón Guardar
    Given Un usuario da clic sobre la foto de perfil
    When Se ingresan datos correctos para cambiar la contrasena
    Then Se habilita el boton de guardar

  Scenario: Cambio exitoso de contraseña
    Given Un usuario da clic sobre la foto de perfil
    When Se ingresan datos correctos para cambiar la contrasena
    And Se habilita el boton de guardar
    And Se da clic en el boton guardar
    Then Se muestra el mensaje de cambio exitoso







