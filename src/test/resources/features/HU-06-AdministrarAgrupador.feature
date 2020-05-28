Feature: Administrar Agrupador
  Como usuario Quiero Administrar un agrupador Para iniciar su gestión.

  Background: Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en el nombre de la Unidad Bits
    And da clic en el agrupador deseado
    And Se visualiza Administrar Agrupador

  Scenario: Información que se presenta al ingresar la opción de administrar Entrada y Salida
    Then El sistema presenta la Ruta de navegacion
    And Label Administracion de Agrupador
    And Tabla de registros de Unidades independientes
    And Boton Crear Unidad Independiente
    And Paginador

  Scenario Outline: Realizar búsqueda de Entrada y Salida
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then En Administrar agrupador El sistema muestra los resultados según la <busqueda>
    Examples:
      | busqueda  |
      | Visitante |
      | 2345      |


  Scenario Outline: Seleccionar icono de acciones
    When En Administrar Agrupador Selecciona una <opcion>
    Then En Administrar Agrupador se realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | Modificar | Pagina modificar |
      | Activa    | mensaje          |

  Scenario: Activar un agrupador
    When En administrar agrupador da clic en activar
    Then se muestra la confirmacion de activacion

  Scenario: Inactivar un agrupador
    When En administrar agrupador da clic en inactivar
    Then se muestra la confirmacion de inactivacion

  Scenario Outline: Confirmación de Activar un agrupador
    Given En administrar agrupador da clic en activar
    And se muestra la confirmacion de activacion
    When se da clic en la <opcion> de activacion
    Then realiza la <accion> de activar en administrar agrupador
    Examples:
      | opcion | accion   |
      | si     | activo   |
      | no     | inactivo |

  Scenario: Inactivar un agrupador
    When En administrar agrupador da clic en inactivar
    Then se muestra la confirmacion de inactivacion

  Scenario Outline: Confirmación de Inactivar un agrupador
    Given En administrar agrupador da clic en inactivar
    And se muestra la confirmacion de inactivacion
    When se da clic en la <opcion> de inactivacion
    Then realiza la <accion> de inactivar en administrar agrupador
    Examples:
      | opcion | accion   |
      | si     | inactivo |
      | no     | activo   |

  Scenario: Seleccionar Botón Crear Unidad Independiente
    When Da clic en Crear Unidad Independiente
    And El sistema redirecciona a la pagina de Crear Unidad Independiente
