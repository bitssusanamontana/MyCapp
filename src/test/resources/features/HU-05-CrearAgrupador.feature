Feature: Crear agrupador
  Como usuario Quiero crear un Agrupador Para iniciar su gestión.

  Background: Ingreso a Crear Agrupador
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en el nombre de la Unidad Bits
    And da clic en Crear agrupador

  Scenario: 1.Información que se presenta al seleccionar el botón de crear
    Then  El sistema presenta formulario Crear Agrupador
    And  En crear agrupador visualiza el formulario
    And En crear agrupador visualiza campo nombre agrupador
    And En crear agrupador visualiza campo numero de unidades independientes
    And En crear agrupador visualiza boton de guardar bloqueado

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
    When  En crear agrupador da clic en <campo_requerido>
    And   En crear agrupador da clic en el boton guardar
    Then  En crear agrupador se presenta mensaje indicando que el campo es requerido

    Examples:
      | campo_requerido                   |
      | Nombre Agrupador                  |
      | numero de Unidades Independientes |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    When  En crear agrupador ingresa al campo <nombre> agrupacion
    And   En crear agrupador ingresa al campo <numero> de unidades
    Then  En crear agrupador sistema presenta <habilitado> el boton de guardar

    Examples:
      | nombre      | numero | habilitado |
      | Agrupacion1 | 2      | Si         |
      | Agrupacion2 |        | No         |
      |             | 3      | No         |

  Scenario Outline: 6.Ingresar informacion en campo # de Unidades Independientes
    When En crear agrupador Ingresa un <valor> para el campo numero de unidades independientes
    Then En crear agrupador El sistema muestra el <resultado>

    Examples:
      | valor  | resultado |
      | 10     | 10        |
      | 55ab   | 55        |
      | 123456 | 123456    |
      | 12(6   | 126       |

  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Agrupador, incluyendo caracteres especiales y el espacio
    And  En crear agrupador el usuario Da clic en el campo Nombre Agrupador
    When En crear agrupador Ingresa un <valor> para el campo nombre de agrupador
    Then En crear agrupador El sistema muestra <resultado>

    Examples:

      | valor                                                           | resultado                                             |
      | Agrupador 4                                                     | agrupador 4                                           |
      | 123456789123456789123456789123456789123456789123456789123456789 | 12345678912345678912345678912345678912345678912345678 |


  Scenario Outline:  9.Creación de Agrupador
    When  En crear agrupador ingresa al campo <nombre> y <numero> de agrupador
    And   En crear agrupador da clic en boton guardar
    Then  En crear agrupador sistema presenta el <mensaje> de éxito o error

    Examples:
      | nombre      | numero | mensaje   |
      | Agrupacion1 | 2      | exito     |
      | Agrupacion1 | 3      | existente |