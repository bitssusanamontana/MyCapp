Feature: Administrar Unidad Inmobiliaria
  Como usuario super administrador Quiero Administar la Unidad Inmobiliaria Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias
    And Da clic sobre la unidad inmobiliaria Bits

  Scenario: Información que se presenta al ingresar la opción de administrar Unidad Inmobiliaria
    Then El sistema muestra la informacion de la Unidad Inmobiliaria

  Scenario Outline: Realizar búsqueda de Agrupador de Unidad Inmobiliaria
    When En administrar unidad inmobiliaria El usuario Da clic sobre la opción de búsqueda
    And En administrar unidad inmobiliaria Ingresa información en filtro de busqueda <busqueda>
    And En administrar unidad inmobiliaria selecciona el primer valor <valor>
    Then En administrar unidad inmobiliaria El sistema muestra los resultados <resultado>
    Examples:
      | busqueda | valor    | resultado |
      | Torre 10 | TORRE 10 | TORRE 10  |

  Scenario Outline: Seleccionar icono de acciones
    When En administrar unidad inmobiliaria Selecciona una <opcion>
    Then En administrar unidad inmobiliaria El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear Agrupación
    When Da clic en Crear Agrupacion
    Then El sistema redirecciona a la pagina de Crear Agrupacion

