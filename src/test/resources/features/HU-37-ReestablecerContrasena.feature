Feature: Reestablecer Contraseña
  Como usuario Quiero reestablecer la contraseña Para ingresar a la aplicación

  Background: Link restablecer contraseña
    Given Un usuario en la página de reestablecer contrasena

  Scenario: Seleccionar el botón de volver
    When Da clic en el botón volver
    Then El sistema presenta la página de autenticación de la aplicación

  Scenario Outline: No ingresar información en los campos requeridos
    When En formulario de restablecer contrasena Da clic en el campo requerido <campo_requerido> y da clic
    Then Se muestra un mensaje de error del campo requerido <requerido>
    Examples:
      | campo_requerido         | requerido              |
      | Nueva contrasena        | contrasena requerida   |
      | Confirmacion contrasena | confirmacion requerida |

  Scenario Outline: Ingresar una nueva contraseña
    When Ingresa la <contrasena> en el campo nueva contrasena
    Then El sistema informa que la nueva contraseña ingresada cumple con las reglas
    Examples:
      | contrasena |
      | Bits2019   |

  Scenario Outline: Ingresar la confirmación de la contraseña
    When Ingresa <contrasena> y la confirmación <confirmacionContrasena>
    Then El sistema informa que la confirmación de la contraseña ingresada cumple con las reglas
    Examples:
      | contrasena | confirmacionContrasena |
      | Bits2019   | Bits2019               |

  Scenario Outline: Mensaje que se debe presentar al colocar el cursor en el icono de correcto (chek) o de incorrecto(x) en el campo Nueva contraseña
    When Ingresa <contrasena> y la confirmación <confirmacionContrasena>
    Then Se muestra un mensaje de error de ingreso de la contraseña <mensaje>
    Examples:
      | contrasena | confirmacionContrasena | mensaje      |
      | Bits2019   | Bits2019               | cumplen      |
      | Bits       | Bits                   | no cumplen   |
      | Bits2019   | Bits201                | no coinciden |

  Scenario Outline: Se selecciona el botón de ingresar después de realizar el restablecimiento
    When Ingresa <contrasena> y la confirmación <confirmacionContrasena>
    And Da clic en el botón reestablecer
    And El sistema muestra el mensaje de restablecimiento exitoso
    And Da clic en el botón Finalizar
    Then El sistema presenta la página de autenticación de la aplicación
    Examples:
      | contrasena | confirmacionContrasena |
      | Bits2020   | Bits2020               |

