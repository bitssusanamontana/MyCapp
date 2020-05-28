Feature: Seleccionar unidad inmobiliaria
  Como usuario administrador Quiero seleccionar una unidad inmobiliaria Para realizar la gestión sobre la unidad

  Scenario: El selector no se muestra
    Given Que usuario ingresa a la pagina de inicio
    When Inicia sesión con un usuario con una unidad
    Then El sistema le muestra al usuario la pantalla de Inicio

  Scenario:Información que se debe presentar en el selector
    Given Que usuario ingresa a la pagina de inicio
    When Inicia sesión con un usuario con mas de una unidad
    Then El sistema presenta la ventana emergente de Selector
    And la seccion de busqueda
    And el listado de unidades asociadas al usuario

  Scenario: Información que se debe presentar en el selector
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina de inicio
    When Da clic sobre el icono de cambiar unidad
    Then El sistema presenta una ventana emergente con el nombre de las unidades inmobiliarias
    And El campo de busqueda
    And Se muestra resaltada la unidad actual
    And Se muestra el boton de cerrar
    And Se muestra el boton de cancelar

  Scenario: Realizar la selección de una unidad inmobiliaria
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina de inicio
    When Da clic sobre el icono de cambiar unidad
    And Selecciona la unidad inmobiliaria
    Then Se cierra la ventana emergente del Selector de Unidades Inmobiliarias
    And El sistema presenta la página inicial con la información de la unidad inmobiliaria seleccionada

  Scenario Outline: Cerrar el selector desde cualquier ubicacion
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina <ubicacion>
    When Da clic sobre el icono de cambiar unidad
    And Da clic sobre la opción de cerrar la ventana emergente
    Then El sistema cierra la ventana emergente
    And Sigue en la <ubicacion>
    Examples:
      | ubicacion           |
      | Inicio              |
      | Unidad inmobiliaria |
      | Parqueaderos        |

  Scenario Outline: Realizar una búsqueda de unidades inmobiliarias
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina de inicio
    And Da clic sobre el icono de cambiar unidad
    And El sistema presenta una ventana emergente con el nombre de las unidades inmobiliarias
    And El campo de busqueda
    When Un usuario ingresa una <palabra> sobre el campo de consulta
    And Da clic en el icono de buscar
    Then El sistema trae los <registros> que contienen la <palabra>
    Examples:
      | palabra | registros                     |
      | parque  | parque residencial, parque 93 |
      | 93      | 9834849, parque 93            |

  Scenario Outline: Seleccionar un elemento de la lista presentada en el filtro
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina de inicio
    And Da clic sobre el icono de cambiar unidad
    And El sistema presenta una ventana emergente con el nombre de las unidades inmobiliarias
    And El campo de busqueda
    When Da clic en el icono de filtros
    And Da clic en un <filtro>
    And ingresa <informacion>
    And Selecciona el <elemento>
    Then Se muestra el <elemento> en el filtro
    Examples:
      | filtro    | informacion | elemento      |
      | nombre    | conj        | conjunto Bits |
      | nit       | 23          | 234567        |
      | catastro  | 1234        | 123456        |
      | direccion | calle 7     | calle 74      |

  Scenario Outline: Realizar consulta de unidades inmobiliarias por la opción de filtros
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina de inicio
    And Da clic sobre el icono de cambiar unidad
    And El sistema presenta una ventana emergente con el nombre de las unidades inmobiliarias
    And El campo de busqueda
    When Da clic en el icono de filtros
    And Da clic en un <filtro>
    And ingresa <informacion>
    And Selecciona el <elemento>
    And Da clic en el boton Buscar
    Then El sistema muestra un <resultado> con la informacion del filtro
    Examples:
      | filtro    | informacion | elemento      | resultado     |
      | nombre    | conj        | conjunto Bits | conjunto Bits |
      | nit       | 23          | 234567        | conjunto Bits |
      | catastro  | 1234        | 123456        | conjunto Bits |
      | direccion | calle 7     | calle 74      | conjunto Bits |

  Scenario Outline: Realizar consulta de unidades inmobiliarias por la opción de busqueda y filtros
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión con un usuario con mas de una unidad
    And Selecciona la unidad inmobiliaria
    And Se encuentra en la pagina de inicio
    And Da clic sobre el icono de cambiar unidad
    And El sistema presenta una ventana emergente con el nombre de las unidades inmobiliarias
    And El campo de busqueda
    When Un usuario ingresa una <palabra> sobre el campo de consulta
    And Da clic en el icono de filtros
    And Da clic en un <filtro>
    And ingresa <informacion>
    And Selecciona el <elemento>
    And Da clic en el boton Buscar
    Then El sistema muestra un <resultado> con la informacion del filtro
    Examples:
      | palabra  | filtro    | informacion | elemento      | resultado     |
      | 23       | nombre    | conj        | conjunto Bits | conjunto Bits |
      | conjunto | nit       | 23          | 234567        | conjunto Bits |
      | bits     | catastro  | 1234        | 123456        | conjunto Bits |
      | bits     | direccion | calle 7     | calle 74      | conjunto Bits |

