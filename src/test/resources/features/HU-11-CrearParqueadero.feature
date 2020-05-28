Feature: Como usuario Quiero crear un Parqueadero Para iniciar su gestión.

  Background: Un usuario ingresa credenciales correctamente
    Given Que usuario ingresa a la pagina de inicio
    And Ingresa el usuario y la contrasena
    And Da clic en continuar
    And Da clic en Administrar Parqueaderos
    And Da clic en Crear Parqueadero

  Scenario: Información que se presentaa al seleccionar el botón de crear
    Then El sistema presentaa un formulario “Crear Parqueadero”
    And El botón de guardaar bloqueado

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    Given Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la <accion> segun la opcion seleccionada
    Examples:
      | pagina    | opcion | accion                    |
      | Principal | si     | Principal                 |
      | Principal | no     | Crear Unidad inmobiliaria |
      | Principal | x      | Crear Unidad inmobiliaria |

  Scenario Outline: 3.Cerrar el mensaje ¿Está seguro de que desea salir de la página crear Parqueadero?
    Given  Un usuario en la pagina de Crear Parqueadero
    And    Selecciona una de las <opciones_formulario> para salir del formulario
    When   Seleccionaa una de las <opciones_mensaje> para cerrar el mensaje

    Then   El sistemaa debe realizar unas <acciones> dependiendo de la opcion seleccionada

    Examples:


      |opciones_formulario                       |opciones_mensaje  |    acciones|
      | pagina del menu                          |Cerrar mensaje    |  Cierra el mensaje dejando al usuario en el formulario de crear Parqueadero sin borrar ningún dato                          |
      | pagina del menu                          |Botón No          |  Cierra el mensaje dejando al usuario en el formulario de crear Parqueadero sin borrar ningún dato                          |
      | pagina del menu                          |Botón Si          |  * Cierra el mensaje      * Presenta la página seleccionada      * No conserva los datos del formulario de crear Parqueadero|
      | enlace de la ruta de navegación          |Cerrar mensaje    |  Cierra el mensaje dejando al usuario en el formulario de crear Parqueadero sin borrar ningún dato                          |
      | enlace de la ruta de navegación          |Botón No          |  Cierra el mensaje dejando al usuario en el formulario de crear Parqueadero sin borrar ningún dato                          |
      | enlace de la ruta de navegación          |Botón Si          |  * Cierra el mensaje      * Presenta la página seleccionada      * No conserva los datos del formulario de crear Parqueadero|
      | icono de cambiar de Parqueadero          |cerrar mensaje    |  Cierra el mensaje dejando al usuario en el formulario de crear Parqueadero sin borrar ningún dato                          |
      | icono de cerrar sesión                   |Botón No          |  Cierra el mensaje dejando al usuario en el formulario de crear Parqueadero sin borrar ningún dato                          |
      | icono de cerrar sesión                   |Botón Si          |  * Cierra el mensaje      * Cierra la sesión       * Presenta la página de autenticación      * No conserva los datos del formulario de crear Parqueadero|

  Scenario Outline: 4.No ingresar información en los campos requeridos
    Given  Un usuario en la página de Crear Parqueadero
    When   Da clicc en el <campo_requerido>
    And    Da clic por fuera del caampo
    Then   El sistema presentaa un <mensaje> indicando que el campo es requerido
    And    El sistema debe indicar a nivel visual que el campo es obligatorioo

    Examples:

      |campo_requerido       | mensaje              |
      |Tipo de Parqueadero   | El campo es requerido|
      |Agrupación            | El campo es requerido|
      |Unidad Independiente  | El campo es requerido|
      |Numero Parqueadero    | El campo es requerido|
      |Tipo de Vehículo      | El campo es requerido|

  Scenario Outline: 5.Se habilita si o no botón de guardar
#    Given Un usuario en la página de Crear Parqueaderoo
    When  Realiza una <clilc> sobre los campos
    Then  El sistemaa presenta sí o no <habilitado> el botón de guardar

    Examples:

      | clilc                                                       | habilitado     |
      | Ingresa información correcta en todos los campos requeridos  | si se habilita |
      | Ingresa información en algunos campos requeridos             | no se habilita |
      | Borra información en algunos campos requeridos               | no se habilita |

  Scenario: 6.Ingresar información en campo tipo Selección
    Given Un usuario en la página de Crear Parqueadero
    And   Daa clic en el <campo>
    When  Seleccionaa del <listado> una <opción>
    Then  El sistema realiza las <validaciones> y la <acción> consecuente.


  Scenario Outline: 7.Ingresar información en campo alfanumérico Número de Parqueadero
    Given  Un usuario en la página de Crear Parqueadero
    And    Daa clic en el campo alfanumérico Número de Parqueadero
    When   Ingresaa un <valor> el sistema valida las <reglas> definidas para el Campo Número de Parqueadero
    Then   El sistemaa realiza sí o no unas <acciones>

    Examples:

      | Valor         | reglas  |  acciones|
      | Parqueadero 1 | *Mínimo 1 carácter    *Máximo 20 caracteres    *Tipo Alfanumérico    *Permite espacios | Cumple con las reglas y guarda los caracteres tipo texto en Mayúscula.|
      | P102          | *Mínimo 1 carácter   *Máximo 20 caracteres    *Tipo Alfanumérico    *Permite espacios  | No realiza ninguna acción el campo cumple con las reglas              |
      | H23###%&      | *No admite caracteres especiales                                                       | Sólo presenta en el campo los caracteres de alfanumérico    H23       |


  Scenario Outline: 8.Se habilita botón de guardar
    Given  Un usuario en la págiina de Crear Parqueadero
    When  Realizaa una <acción> sobre un <campo>
    Then  El sistemaa presenta sí o no <habilitado> el botón de guardarr

    Examples:

      | acción                                                 |campo                 | habilitado|
      | borra toda la información                              |todos los campos      | no|
      | ingresa información                                    |algunos campos        | no|
      | Ingresa información que no cumple con la estructura    |Número de Parqueadero | no|
      | ingresa información de forma correcta                  |todos los campos      | si |


  Scenario: 9.Creación de Parqueadero
    Given Un usuario en la página de Crear Parqueadero
    And   Ingresaa la información en cada uno de los campos requeridos de forma correcta
    When  Daa click en el botón Guardar
    Then  El sistema realiza unaas <validaciones> en los <campos> enviados


  Scenario: 10.Validaciones que se realizan en la estructura del campo Número de Parqueadero, incluyendo espacios, al seleccionar el botón guardar
    Given  Se envíaa un <valor> para un <campo> de <tipo_de_campo>
    When   Se envía la petición al servicioo web
    Then   El sistemaa realiza unas <validaciones> en los campos enviados
    And    El sistemaa presenta un <resultado>


  Scenario Outline: 11.Errores al seleccionar el botón guardar
    Given  Un usuario en la página de Crear Parqueadero
    And    Ingresaa la información en cada uno de los campos requeridos de la forma correcta
    When   Daa clic en el botón Guardar
    Then   El sistema intenta guardaar la información

    Examples:

      |tipo  |  mensaje|
      |Error 500 se corresponden a errores del sistema  | Se presenta el siguiente mensaje ‘El proceso no se terminó satisfactoriamente. Intente nuevamente en unos segundos’|

  Scenario: 12.Error 400 al seleccionar el botón guardar
    Given  Un usuario en la página de Unidades inmobiliariaas
    And   Seleccionaa el botón de Crear
    And   Ingresaa la información en cada uno de los campos requeridos de forma correcta
    When  Daa clic en el botón Guardar
    Then  El sistemaa intenta guardar la información
    And   Se presenta un error tipo 400
    And   El sistema redireccionaa a una página en la cual se debe información el error




