Feature: Agregar Anotación
  Como usuario Quiero Agregar una anotación Para realizar su seguimiento.

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Administrar Entrada y Salida
    And Da clic sobre el botón Agregar Anotación

  Scenario: Información que se presenta al seleccionar el botón de Agregar Anotación
    Then Se visualiza formulario agregar anotacion
    And Ruta de navegacion
    And Visualiza Label AGREGAR ANOTACION
    And Visualiza Campo Tipo de Identificacion
    And Visualiza Campo Numero de Documento
    And Visualiza Campo Nombres
    And Visualiza Campo Apellidos
    And Visualiza Campo Tipo
    And Visualiza Campo ingreso
    And Visualiza Campo ID tarjeta
    And Visualiza Campo Agrupacion
    And Visualiza Campo Unidad Independiente
    And Visualiza Campo Historial de anotaciones
    And Visualiza Campo de texto Agregar anotacion
    And Foto del Usuario del registro
    And Visualiza El boton de guardar bloqueado

  Scenario Outline: Salir del formulario de Creación de ID
    When Da clic en una pagina diferente <pagina>
    Then El sistema muestra un mensaje de confirmacion para salir de Crear ID
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    Given Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la <accion> segun la opcion seleccionada
    Examples:
      | pagina    | opcion | accion                    |
      | Principal | si     | Principal                 |
      | Principal | no     | Crear Unidad inmobiliaria |
      | Principal | x      | Crear Unidad inmobiliaria |

  Scenario Outline: Ingresar o no información en el campo anotación
    When Ingresa <informacion> en el campo anotacion
    And Se da clic por fuera del campo
    Then se presenta el <resultado>
    And el boton guardar <habilitado>
    Examples:
      | informacion                                                                                                                                            | resultado                                                                                                                                    | habilitado |
      |                                                                                                                                                        | campo obligatorio                                                                                                                            | no         |
      | kdjflkdsj                                                                                                                                              | kdjflkdsj                                                                                                                                    | si         |
      | 123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890 | 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890 | si         |

Scenario: Agregar Anotación
  When El usuario ingresa una anotacion
  And Da clic en el boton guardar
  Then Se visualiza el mensaje de anotacion exitosa