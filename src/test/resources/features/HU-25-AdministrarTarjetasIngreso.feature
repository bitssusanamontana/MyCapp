Feature: Administrar Tarjetas de Ingreso
  Como usuario super administrador Quiero Administar las Tarjetas de Ingreso Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Tarjetas de Ingreso

  Scenario: Información que se presenta al ingresar la opción de administrar Tarjetas de Ingreso
    Then El sistema presenta la Ruta de navegacion
    And Label Administracion de Tarjetas
    And Tabla de registros
    And Boton carga masiva
    And El boton de Crear ID

  Scenario Outline: Realizar búsqueda de Tarjeta de Ingreso
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then En Tarjeta de Ingreso El sistema muestra los resultados según la <busqueda>
    Examples:
      | busqueda  |
      | Visitante |
      | 2345      |

  Scenario Outline: Comportamiento en cada uno de los filtros
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre cada <filtro> de Tarjeta de Ingreso
    Then se presenta listado de las Tarjetas de ingreso
    Examples:
      | filtro     |
      | ID         |
      | Numero     |
      | Tipo       |
      | Ingreso    |
      | Tecnologia |

  Scenario Outline: Autocomplete de cada filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre cada <filtro> de Tarjeta de Ingreso
    And Tarjeta de Ingreso En el <filtro> Se ingresa <informacion>
    Then Tarjeta de Ingreso Y muestra el <resultado>
    Examples:
      | filtro     | informacion | resultado |
      | ID         | 234         | 2345      |
      | Numero     | 354354      | 3543541   |
      | Tipo       | Vis         | Visitante |
      | Ingreso    | Peaton      | Peatonal  |
      | Tecnologia | Chi         | Chip      |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre cada <filtro> de Tarjeta de Ingreso
    And Tarjeta de Ingreso En el <filtro> Se ingresa <informacion>
    Then Tarjeta de Ingreso Y muestra el <resultado>
    Then EL usuario seleccion el primer elemento
    And Se muestra el <resultado> en la tabla de tarjetas de ingreso
    Examples:
      | filtro    | informacion | resultado     |
      | Tipo      | Sal         | Salon comunal |
      | Ubicacion | Torr        | Torre 1       |
      | Nombre    | Pis         | Piscina       |


  Scenario Outline: Seleccionar icono de acciones
    When En tarjetas de ingreso Selecciona una <opcion>
    Then En tarjetas de ingreso se realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | modificar | Pagina modificar |
      | activar   | presenta mensaje |


  Scenario: Seleccionar Botón Crear ID
    When Da clic en Crear ID
    And El sistema redirecciona a la pagina de Crear ID

  Scenario: Seleccionar Botón Carga Masiva
    When Da clic en Carga Masiva
    And El sistema redirecciona a la pagina de Carga Masiva