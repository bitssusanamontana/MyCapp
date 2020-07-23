Feature: Administrar Parqueadero
  Como usuario Quiero Administrar un Parqueadero Para iniciar su gestión.

  Background: Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en el nombre de la Unidad Bits
    And da clic en Parqueaderos

  Scenario: Información que se presenta al ingresar la opción de administrar Parqueaderos
    Then El sistema presenta la Ruta de navegacion
    And Label Administracion de Parqueaderos
    And Tabla de registros de Parqueaderos
    And Boton Crear Parqueadero
    And Paginador

  Scenario Outline: Realizar búsqueda de Parqueadero
    When En Parqueaderos Ingresa información en filtro de busqueda <busqueda>
    And En Parqueaderos Da clic en buscar
    Then En Administrar Parqueaderos El sistema muestra los resultados según la <busqueda>
    Examples:
      | busqueda  |
      | H2 |
      | P4      |


  Scenario Outline: Seleccionar icono de acciones
    When En Administrar Parqueaderos Selecciona una <opcion>
    Then En Administrar Parqueaderos se realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | Modificar | Pagina modificar |
      | Activa    | mensaje          |

  Scenario: Activar un Parqueadero
    When En administrar Parqueaderos da clic en activar
    Then En administrar Parqueaderos se muestra la confirmacion de activacion

  Scenario: Inactivar un Parqueadero
    When En administrar Parqueaderos da clic en inactivar
    Then En administrar Parqueaderos se muestra la confirmacion de inactivacion

  Scenario Outline: Confirmación de Activar un Parqueadero
    Given En administrar Parqueaderos da clic en activar
    And En administrar Parqueaderos se muestra la confirmacion de activacion
    When En administrar Parqueaderos se da clic en la <opcion> de activacion
    Then En administrar Parqueaderos realiza la <accion> de activar parqueadero
    Examples:
      | opcion | accion   |
      | si     | activo   |
      | no     | inactivo |

  Scenario: Inactivar un Parqueadero
    When En administrar Parqueaderos da clic en inactivar
    Then En administrar Parqueaderos se muestra la confirmacion de inactivacion

  Scenario Outline: Confirmación de Inactivar un parqueadero
    Given En administrar Parqueaderos da clic en inactivar
    And En administrar Parqueaderos se muestra la confirmacion de inactivacion
    When En administrar Parqueaderos se da clic en la <opcion> de inactivacion
    Then En administrar Parqueaderos realiza la <accion> de inactivar en administrar agrupador
    Examples:
      | opcion | accion   |
      | si     | inactivo |
      | no     | activo   |

  Scenario: Seleccionar Botón Crear Parqueadero
    When Da clic en Crear Parqueadero
    And El sistema redirecciona a la pagina de Crear Parqueadero
