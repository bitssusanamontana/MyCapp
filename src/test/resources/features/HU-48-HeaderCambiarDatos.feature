Feature: Cambiar datos de usuario
  Como usuario Quiero cambiar mis datos Para que estén actualizados en la aplicación

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión

  Scenario: Información que se presenta al seleccionar la opción de cambiar datos
    Given Un usuario da clic sobre la foto de perfil 
    When Da clic en la opción Cambiar datos
    Then El sistema presenta una ventana emergente
    And Presenta el campo nombre habilitado y nombre de usuario
    And Presenta el campo apellido habilitado y apellido de usuario
    And Presenta el campo correo electrónico habilitado y correo de usuario
    And Presenta el campo teléfono habilitado y telefono de usuario
    And Presenta el botón Guardar habilitado
    And Opción de cerrar ventana emergente
    And Presenta el botón Cambiar habilitado

  Scenario: Cerrar la ventana de cambiar datos
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    When Da clic sobre la opción de cerrar la ventana emergente
    Then El sistema cierra la ventana emergente
    And Deja al usuario en la página que se encuentra actualmente

  Scenario Outline: Se inhabilita botón de guardar borrando la informacion
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    When Ingresa en el campo de <campo> y borra la informacion
    Then El boton de guardar se visualiza inhabilitado
    And Se presenta el mensaje de campo es requerido
    Examples:
      | campo    |
      | nombre   |
      | apellido |
      | correo   |
      | telefono |

  Scenario: Se habilita botón de guardar
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    When Ingresa correctamente toda la informacion de los campos
    Then El boton de guardar se visualiza habilitado

  Scenario Outline: Cambiar la información de los campos
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    When Se ingresan los datos <nombre>, <apellido>,<correo> y <telefono>
    And Da clic en el boton Guardar
    Then Se verifica que el cambio se aplico en los datos de los datos <nombre>, <apellido>,<correo> y <telefono>
    Examples:
      | nombre | apellido | correo                    | telefono |
      | Jose   | Barbosa  | jbarbosa@bitsamericas.com | 34745847 |

  Scenario Outline: Validación de los campos
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    When Se ingresa en el <campo> la <informacion>
    Then El boton de guardar se visualiza inhabilitado
    And muestra el <resultado>
    Examples:
      | campo    | informacion             | resultado         |
      | nombre   | Sandra34543             | Sandra            |
      | apellido | Barbosa$%&%4545         | Barbosa           |
      | correo   | sbarbo$%&/#$sa@bits.com | sbarbosa@bits.com |
      | telefono | 2334456dsfdsfsd#$%&$    | 2334456           |

  Scenario: Campo tipo país
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    And Da clic sobre el campo teléfono
    And Da clic sobre el campo pais
    When Selecciona el pais Colombia
    Then Se presenta el prefijo de Colombia

  Scenario Outline: Campos tipo telefono
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    And Da clic sobre el campo teléfono
    When Ingresa un <numero> de telefono
    And Da clic por fuera del campo
    Then El sistema muestra la <validacion>
    And Presenta el <resultado> al poner el cursor encima
    Examples:
      | numero     | validacion | resultado                   |
      | 5345345435 | correcto   | Cumple con la estructura    |
      | 12344      | incorrecto | Minimo debe tener 7 digitos |

  Scenario Outline: Mensaje que se debe presentar al colocar el cursor en el icono de validacion
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    And Da clic sobre el campo correo
    And Ingresa un <correo>
    And Da clic por fuera del campo
    When Coloca el cursor sobre el icono
    Then El sistema presenta un <mensaje>
    Examples:
      | correo             | mensaje                                                             |
      | ssbits@hotmail.com | Cumple con la estructura                                            |
      | ssbits.hotmail.com | el correo electronico ingresado no es valido. Ejemplo usuario@h.com |

  Scenario: Se habilita botón de guardar
    Given Un usuario da clic sobre la foto de perfil 
    And Da clic en la opción Cambiar datos
    And Ingresa correctamente toda la informacion de los campos
    And El boton de guardar se visualiza habilitado
    When El usuario da clic en el botón guardar
    Then Se muestra el mensaje de actualización exitosa




