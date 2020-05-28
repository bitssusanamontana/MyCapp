Feature: Administrar Unidades Logísticas
  Como usuario super administrador Quiero Administar las Unidades Logísticas Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Logísticas

  Scenario: Información que se presenta al ingresar la opción de administrar Tarjetas de Ingreso
    Then Visualiza la Ruta de navegacion
    And Visualiza Label Administracion de Unidades Logísticas
    And Visualiza Tabla de registros
    And Visualiza El boton de Crear Unidad logistica
    And Visualiza Paginador

  Scenario Outline: Realizar búsqueda de Agrupador de Unidad logística
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda      | resultado               |
      | Torre 1       | Piscina                 |
      | Salon comunal | Salon comunal principal |
      | Gim           | Gimnasio                |
      | Activa        | Salon comunal principal |

  Scenario Outline: Comportamiento en cada uno de los filtros
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre el <filtro> de Unidad logistica
    Then El sistema muestra el listado de las unidades logisticas
    Examples:
      | filtro    |
      | Tipo      |
      | Ubicacion |
      | Nombre    |
      | Activa    |


  Scenario Outline: Autocomplete de cada filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre el <filtro> de Unidad logistica
    And En el <filtro> Se ingresa <informacion>
    Then Y muestra el <resultado>
    Examples:
      | filtro    | informacion | resultado     |
      | Tipo      | Sal         | Salon comunal |
      | Ubicacion | Torr        | Torre 1       |
      | Nombre    | Pis         | Piscina       |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre el <filtro> de Unidad logistica
    And En el <filtro> Se ingresa <informacion>
    Then Y muestra el <resultado>
    Then EL usuario seleccion el primer elemento
    And Se muestra el <resultado> en la tabla
    Examples:
      | filtro    | informacion | resultado     |
      | Tipo      | Sal         | Salon comunal |
      | Ubicacion | Torr        | Torre 1       |
      | Nombre    | Pis         | Piscina       |

  Scenario Outline: Seleccionar icono de acciones
    When Selecciona una <opcion>
    Then El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear Unidad logistica
    When Da clic en Crear Unidad logistica
    And El sistema redirecciona a la pagina de Crear Unidad logistica

  Scenario: Seleccionar Botón Parqueaderos
    When Da clic en Parqueaderos
    And El sistema redirecciona a la pagina de Administrar Parqueaderos