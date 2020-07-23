Feature: Administrar Usuarios
  Como usuario Quiero Administrar Usuarios Para iniciar su gestión.

  Background: Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Usuarios

  Scenario: Información que se presenta al ingresar la opción de administrar agrupador
    Then El sistema presenta la Ruta de navegacion
    And Label Administracion de Usuarios
    And Tabla de registros de Usuarios
    And Boton Crear Usuario
    And Paginador

  Scenario Outline: Realizar búsqueda de Entrada y Salida
    When En Usuarios Ingresa información en filtro de busqueda <busqueda>
    And En Usuarios Da clic en buscar
    Then En Administrar Usuarios El sistema muestra los resultados según la <busqueda>
    Examples:
      | busqueda  |
      | Visitante |
      | 2345      |


  Scenario Outline: Seleccionar icono de acciones
    When En Administrar Usuarios Selecciona una <opcion>
    Then En Administrar Usuarios se realiza una accion <accion>
    Examples:
      | opcion    | accion                |
      | Consultar | Pagina consultar      |
      | Modificar | Pagina modificar      |
      | Eliminar  | confirmacion eliminar |
      | Activa    | mensaje               |

  Scenario: Activar un usuario
    When En administrar usuarios da clic en activar
    Then En administrar usuariosse muestra la confirmacion de activacion

  Scenario: En administrar usuarios Inactivar un agrupador
    When En administrar usuarios da clic en inactivar
    Then En administrar usuarios se muestra la confirmacion de inactivacion

  Scenario Outline: En administrar usuarios Confirmación de Activar un agrupador
    Given En administrar usuarios da clic en activar
    And En administrar usuarios se muestra la confirmacion de activacion
    When En administrar usuarios se da clic en la <opcion> de activacion
    Then En administrar usuarios realiza la <accion> de activar en administrar usuario
    Examples:
      | opcion | accion   |
      | si     | activo   |
      | no     | inactivo |

  Scenario: Inactivar un usuario
    When En administrar usuarios da clic en inactivar
    Then En administrar usuarios se muestra la confirmacion de inactivacion

  Scenario Outline: En administrar usuarios Confirmación de Inactivar un usuario
    Given En administrar agrupador da clic en inactivar
    And En administrar usuarios se muestra la confirmacion de inactivacion
    When En administrar usuarios se da clic en la <opcion> de inactivacion
    Then En administrar usuarios realiza la <accion> de inactivar un usuario
    Examples:
      | opcion | accion   |
      | si     | inactivo |
      | no     | activo   |

  Scenario: Seleccionar Botón Crear Usuario
    When En administrar usuarios Da clic en Crear Usuario
    And El sistema redirecciona a la pagina de Crear Usuario
