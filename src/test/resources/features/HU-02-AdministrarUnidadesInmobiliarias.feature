Feature: Administrar Unidades Inmobiliarias
  Como usuario super administrador Quiero Administar las Unidades Inmobiliarias Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias

  Scenario: Información que se presenta al ingresar la opción de administrar Unidades Inmobiliarias
    Then El sistema muestra la informacion de las Unidades Inmobiliarias

  Scenario Outline: Realizar búsqueda de una Unidad Inmobiliaria
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda            | resultado             |
      | parque              | Parque residencial    |
      | Calle 127           | Niza                  |
      | 384783              | Oficinas centro       |
      | Jose                | Bits                  |
      | Barbosa             | Bits                  |
      | jbarbosam@gmail.com | Bits                  |
      | NoExiste            | No existe informacion |

  Scenario Outline: Comportamiento en cada uno de los filtros
    Given El usuario Da clic sobre la opción Filtros
    When Da clic en los <filtro> de Unidades Inmobiliarias
    Then El sistema presenta el listado del <filtro> seleccionado
    Examples:
      | filtro    |
      | Nombre    |
      | Nit       |
      | Catastro  |
      | Direccion |

  Scenario Outline: Autocomplete de cada filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic en los <filtro> de Unidades Inmobiliarias
    And En Unidad Inmobiliaria Se ingresa <informacion> en el <filtro>
    Then En Unidad Inmobiliaria se muestra el <resultado>
    Examples:
      | filtro    | informacion | resultado            |
      | Nombre    | jo          | jose barbosa         |
      | Nit       | 34          | 345678               |
      | Catastro  | 34          | 345678               |
      | Direccion | calle 106   | calle 106 carrera 57 |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic en los <filtro> de Unidades Inmobiliarias
    And En Unidad Inmobiliaria Se ingresa <informacion> en el <filtro>
    And En Unidad Inmobiliaria se muestra el <resultado>
    Then EL usuario seleccion el primer elemento
    And Se muestran los resultados en la tabla
    Examples:
      | filtro    | informacion | resultado            |
      | Nombre    | jo          | jose barbosa         |
      | Nit       | 34          | 345678               |
      | Catastro  | 34          | 345678               |
      | Direccion | calle 106   | calle 106 carrera 57 |



  Scenario Outline: Seleccionar icono de acciones
    When Selecciona una <opcion>
    Then El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | consultar | Pagina consultar |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear Unidad Inmobiliaria
    When Da clic en Crear Unidad Inmobiliaria
    And El sistema redirecciona a la pagina de Crear Unidad Inmobiliaria

