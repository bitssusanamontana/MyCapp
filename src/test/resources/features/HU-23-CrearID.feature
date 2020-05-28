Feature: Crear ID de tarjeta de Ingreso
  Como usuario Quiero crear un ID de Tarjeta de Ingreso Para asignar a un usuario.

  Background: Un usuario ingresa credencial correctamente e Ingresa a tarjetas de Ingreso
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Tarjetas de Ingreso
    And Da clic sobre Crear ID

  Scenario: Información que se presenta al seleccionar el botón de crear ID
    Then El usuario visualiza la ruta de navegacion
    And El usuario visualiza el label de la página
    And El usuario visualiza el campo ID
    And El usuario visualiza el campo Numero de tarjeta
    And El usuario visualiza el campo campo tipo de tarjeta
    And El usuario visualiza el campo Ingreso
    And El usuario visualiza el campo tecnologia
    And El usuario visualiza el boton Guardar bloqueado

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

  Scenario Outline: No ingresar información en los campos requeridos
    When En Crear ID Da clic en el <campo_requerido>
    And Da clic por fuera del campo
    Then El sistema presenta mensaje de Campo requerido
    Examples:
      | campo_requerido   |
      | Numero de tarjeta |
      | Tipo              |
      | Ingreso           |
      | Tecnologia        |

  Scenario Outline: Ingresar información en el campo Número de tarjeta
    When Ingresa el <numero_tarjeta> en el campo
    And Da clic por fuera del campo
    Then El sistema muestra un <resultado>
    Examples:
      | numero_tarjeta            | resultado            |
      | Tarjeta 3                 | Tarjeta 3            |
      | Tarjeta 54$%&/(           | Tarjeta 54           |
      | T234567890123456789012345 | T2345678901234567890 |

  Scenario Outline: Ingresar información en los campos requeridos y activación botón Guardar
    When Ingresa informacion en el campo <numero_tarjeta>
    And Selecciona los datos de los campos <tipo>, <ingreso> y <tecnologia>
    Then <siono> se habilita el boton guardar
    Examples:
      | numero_tarjeta | tipo      | ingreso   | tecnologia | siono |
      | 23             | Visitante | Peatonal  | Digital    | si    |
      | 24             | Residente | Vehicular | Digital    | si    |
      |                | Visitante | Peatonal  | Digital    | no    |

  Scenario Outline: Creación de ID
    When Ingresa informacion en el campo <numero_tarjeta>
    And Selecciona los datos de los campos <tipo>, <ingreso> y <tecnologia>
    And <siono> se habilita el boton guardar
    And Da clic en Guardar
    Then Se presenta un <resultado>

    Examples:
      | numero_tarjeta | tipo      | ingreso   | tecnologia | siono | resultado |
      | 23             | Visitante | Peatonal  | Digital    | si    | ID existe |
      | Tarjeta 24     | Residente | Vehicular | Digital    | si    | ID creado |

  Scenario Outline: Creación de ID
    When Ingresa informacion en el campo <numero_tarjeta>
    And Selecciona los datos de los campos <tipo>, <ingreso> y <tecnologia>
    And <siono> se habilita el boton guardar
    And Da clic en Guardar
    Then Se presenta <error>

    Examples:
      | numero_tarjeta | tipo      | ingreso   | tecnologia | siono | error |
      | 23             | Visitante | Peatonal  | Digital    | si    | 400 |
      | Tarjeta 24     | Residente | Vehicular | Digital    | si    | 500 |
