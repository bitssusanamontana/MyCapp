Feature: Administrar Entrada y Salida
  Como usuario Quiero Administrar las Entrada y Salida Para iniciar su gestión.

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Administrar Entrada y Salida

  Scenario: Información que se presenta al ingresar la opción de administrar Entrada y Salida
    Then El sistema presenta la Ruta de navegacion
    And Label Administracion de Entrada y Salida
    And Tabla de registros Entrada y salida
    And Boton Registrar Ingreso Visitante
    And Paginador

  Scenario Outline: Realizar búsqueda de Entrada y Salida
    When Ingresa información en filtro de busqueda <busqueda>
    And Da clic en buscar
    Then En Entrada y Salida El sistema muestra los resultados según la <busqueda>
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
      | ID tarjeta |
      | Accion     |
      | Tipo       |
      | Ingreso    |
      | Fecha      |
      | Documento  |
      | Nombre     |

  Scenario Outline: Autocomplete de cada filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre cada <filtro> de Tarjeta de Ingreso
    And Tarjeta de Ingreso En el <filtro> Se ingresa <informacion>
    Then Tarjeta de Ingreso Y muestra el <resultado>
    Examples:
      | filtro     | informacion | resultado |
      | ID tarjeta | 234         | 2345      |
      | Accion     | 354354      | 3543541   |
      | Tipo       | Vis         | Visitante |
      | Ingreso    | Peaton      | Peatonal  |
      | Fecha      | Chi         | Chip      |
      | Documento  | Chi         | Chip      |
      | Nombre     | Chi         | Chip      |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given El usuario Da clic sobre la opción Filtros
    When Da clic sobre cada <filtro> de Tarjeta de Ingreso
    And Tarjeta de Ingreso En el <filtro> Se ingresa <informacion>
    Then Tarjeta de Ingreso Y muestra el <resultado>
    Then EL usuario seleccion el primer elemento
    And Se muestra el <resultado> en la tabla de tarjetas de ingreso
    Examples:
      | filtro     | informacion | resultado |
      | ID tarjeta | 234         | 2345      |
      | Accion     | 354354      | 3543541   |
      | Tipo       | Vis         | Visitante |
      | Ingreso    | Peaton      | Peatonal  |
      | Fecha      | Chi         | Chip      |
      | Documento  | Chi         | Chip      |
      | Nombre     | Chi         | Chip      |


  Scenario Outline: Seleccionar icono de acciones
    When En administrar ingreso y salida Selecciona una <opcion>
    Then En administrar ingreso y salida se realiza una accion <accion>
    Examples:
      | opcion    | accion             |
      | Consultar | Pagina Consultar   |
      | Modificar | Pagina modificar   |
      | Salida    | marca salida       |
      | Anotacion | Pagina Anotaciones |


  Scenario: Seleccionar Botón Registrar Ingreso
    When Da clic en Registrar Ingreso
    And El sistema redirecciona a la pagina de Registrar Ingreso
