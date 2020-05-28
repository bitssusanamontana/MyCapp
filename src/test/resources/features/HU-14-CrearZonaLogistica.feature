Feature: Crear Zona Logística
  Como usuario Quiero crear una Zona Logística Para iniciar su gestión.

  Background: Un usuario ingresa credencial correctamente e Ingresa a Zonas Logísticas
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Administrar Zonas Logisticas
    And Da clic sobre Crear Zona Logistica

  Scenario: Información que se presenta al seleccionar el botón de crear Zona Logística
    Then El usuario visualiza la ruta de navegacion
    And El usuario visualiza el label de Zona Logistica
    And El usuario visualiza el campo Selector Tipo Unidad Logistica
    And El usuario visualiza el campo Nombre Unidad Logistica
    And El usuario visualiza el campo Ubicacion Unidad Logistica
    And El usuario visualiza el boton Guardar bloqueado

  Scenario Outline: Salir del formulario de Creación de Unidad Logistica
    When Da clic en una pagina diferente <pagina>
    Then El usuario visualiza el mensaje de salir de Crear Unidad Logistica
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
    When En Unidad Logistica Da clic en el <campo_requerido>
    And Da clic por fuera del campo
    Then En unidad logistica el sistema presenta mensaje de Campo requerido
    Examples:
      | campo_requerido       |
      | Tipo Unidad Logistica |
      | Nombre                |
      | Ubicacion             |


  Scenario Outline: Ingresar información en el campo nombre
    When En unidad logistica ingresa el <nombre> en el campo
    And Da clic por fuera del campo
    Then En unidad logistica el sistema muestra un <resultado>
    Examples:
      | nombre                    | resultado            |
      | Piscina 3                 | Piscina 3            |
      | Salon 54$%&/(             | Salon 54             |
      | T234567890123456789012345 | T2345678901234567890 |

  Scenario Outline: Ingresar información en el campo ubicación
    When En unidad logistica ingresa el <ubicacion> en el campo
    And Da clic por fuera del campo
    Then En unidad logistica el sistema muestra un <resultado>
    Examples:
      | ubicacion                 | resultado            |
      | Torre 3                   | Torre 3              |
      | Recepcion 54$%&/(         | Recepcion 54         |
      | T234567890123456789012345 | T2345678901234567890 |

  Scenario Outline: Ingresar información en los campos requeridos y activación botón Guardar
    When En unidad logistica ingresa informacion en el campo <nombre> y <ubicacion>
    And Selecciona del campo <tipo>
    Then <siono> se habilita el boton guardar
    Examples:
      | nombre | ubicacion | tipo      | siono |
      | 23     | Visitante | Peatonal  | si    |
      | 24     | Residente | Vehicular | si    |
      |        | Visitante | Peatonal  | no    |

  Scenario Outline: Creación de ID
    When En unidad logistica ingresa informacion en el campo <nombre> y <ubicacion>
    And En unidad logistica Selecciona el campo <tipo>
    And <siono> se habilita el boton guardar
    And Da clic en Guardar
    Then En unidad logistica se presenta un <resultado>

    Examples:
      | nombre        | ubicacion       | tipo          | siono | resultado               |
      | Salon comunal | Torre 5         | Salon comunal | si    | Unidad logistica existe |
      | Piscina 2     | Torre principal | Piscina       | si    | Unidad Logistica creada |

  Scenario Outline: Creación de Unidad logistica
    When En unidad logistica ingresa informacion en el campo <nombre> y <ubicacion>
    And En unidad logistica Selecciona el campo <tipo>
    And <siono> se habilita el boton guardar
    And Da clic en Guardar
    Then Se presenta <error>

    Examples:
    Examples:
      | nombre        | ubicacion       | tipo          | siono | error |
      | Salon comunal | Torre 5         | Salon comunal | si    | 400   |
      | Piscina 2     | Torre principal | Piscina       | si    | 500   |
