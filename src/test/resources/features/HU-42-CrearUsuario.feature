Feature: Crear usuario
  Como usuario Quiero crear un usuario Para iniciar su gestión.

  Background: Ingreso a Crear usuario
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en Administar usuarios
    And da clic en crear usuario

  Scenario: 1.Información que se presenta al seleccionar el botón de crear
    Then  El sistema presenta formulario Crear usuario
    And  En crear usuario visualiza el formulario
    And En crear usuario visualiza campo tipo de identificacion
    And En crear usuario visualiza campo numero de identificacion
    And En crear usuario visualiza campo nombre
    And En crear usuario visualiza campo apellidos
    And En crear usuario visualiza campo telefono
    And En crear usuario visualiza campo rol
    And En crear usuario visualiza campo usuario
    And En crear usuario visualiza el enlace tomar foto
    And En crear usuario visualiza boton de guardar bloqueado

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    Given Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la <pagina> segun la opcion seleccionada
    Examples:
      | pagina    | opcion | pagina          |
      | Principal | si     | Principal       |
      | Principal | no     | Crear Agrupador |
      | Principal | x      | Crear Agrupador |

  Scenario Outline: 4.No ingresar información en los campos requeridos
    When  En crear usuario da clic en <campo_requerido>
    And   En crear usuario da clic en el boton guardar
    Then  En crear usuario se presenta mensaje indicando que el campo es requerido

    Examples:
      | campo_requerido |
      | tipo documento  |
      | documento       |
      | nombre          |
      | apellido        |
      | telefono        |
      | rol             |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    When  En crear usuario ingresa o selecciona informacion en los campos <tipo_documento> <documento> <nombre> <apellidos> <telefono> y <rol>
    Then  En crear usuario sistema presenta <habilitado> el boton de guardar

    Examples:
      | tipo_documento | documento | nombre | apellidos | telefono | rol           | habilitado |
      | CC             | 3243234   | Jose   | Barbosa   | 3542432  | Administrador | si         |
      | CE             |           | Jose   |           |          | Vigilante     | no         |


  Scenario Outline: 6.Ingresar informacion en los campos de crear usuario
    When En crear usuario Ingresa o selecciona en el <campo> del formulario un <valor>
    Then En crear usuario El sistema muestra el <resultado>

    Examples:
      | campo          | valor              | resultado     |
      | tipo documento | CC                 | CC            |
      | documento      | 42342FGF$%$$       | 42342         |
      | nombre         | Jose348543#$%$#%   | Jose          |
      | apellidos      | Barbosa3489 #$%$#% | Barbosa       |
      | telefono       | 42342FGF$%$$       | 42342         |
      | rol            | Administrador      | Administrador |

  Scenario: Enlace agregar foto
    When En crear usuario da clic enlace a Agregar foto
    Then visualiza las opciones para agregar una foto

  Scenario Outline: Opciones agregar foto
    Given En crear usuario da clic enlace a Agregar foto
    When en crear usuario selecciona una de las <opciones>
    Then En crear usuario se presenta una <accion>
    Examples:
      | opciones   | accion                |
      | tomar foto | aplicacion camara     |
      | subir foto | pop up seleccion foto |

  Scenario: Carga de foto
    Given En crear usuario da clic enlace a Agregar foto
    When En crear usuario sube una foto
    Then Se muestra la foto cargada

  Scenario: Opciones con foto cargada
    Given En crear usuario da clic enlace a Agregar foto
    And En crear usuario sube una foto
    And Se muestra la foto cargada
    When En crear usuario se clic en la foto
    Then se visualizan las opciones de edicion de la foto

  Scenario Outline: Eliminar la foto
    Given En crear usuario da clic enlace a Agregar foto
    And En crear usuario sube una foto
    And Se muestra la foto cargada
    And En crear usuario se clic en la foto
    When En crear usuario escoge eliminar foto
    And En crear usuario se presenta un pop up de confirmacion de eliminacion
    And En crear usuario selecciona la opcion de <opcion> eliminar
    Then En crear usuario se tiene la <accion> de eliminar

    Examples:
      | opcion | accion         |
      | si     | foto eliminada |
      | no     | cierra pop up  |


  Scenario Outline:  9.Creación de usuario
    When  En crear usuario ingresa o selecciona informacion en los campos <tipo_documento> <documento> <nombre> <apellidos> <telefono> y <rol>
    And En crear usuario muestra en el campo usuario el <resultado>
    And   En crear usuario da clic en boton guardar
    Then  En crear usuario sistema presenta el <mensaje> de exito o error

    Examples:
      | tipo_documento | documento | nombre | apellidos      | telefono | rol           | resultado | mensaje   |
      | CC             | 3243234   | Jose   | Barbosa Perez  | 3542432  | Administrador | jbarbosap | Exitoso   |
      | CC             | 3243234   | Jose   | Barbosa Suarez | 3542432  | Administrador | jbarbosas | Existente |