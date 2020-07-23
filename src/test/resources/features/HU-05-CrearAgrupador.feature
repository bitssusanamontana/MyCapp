Feature: Crear agrupador
  Como usuario Quiero crear un Agrupador Para iniciar su gestión.

  Background: Ingreso a Crear Agrupador
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias
    And Da clic sobre la unidad inmobiliaria Bits
    And da clic en Crear agrupador

  Scenario: 1.Información que se presenta al seleccionar el botón de crear
    Then  El sistema presenta formulario Crear Agrupador
    And  En crear agrupador visualiza el formulario
    And En crear agrupador visualiza campo nombre agrupador
    And En crear agrupador visualiza campo numero de unidades independientes
    And En crear agrupador visualiza boton de guardar bloqueado

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    When En crear agrupador Ingresa informacion en el campo nombre de agrupacion
    And En crear agrupador Da clic en una pagina diferente <pagina>
    And En crear agrupador Selecciona una opcion del pop up <opcion>
    Then En crear agrupador Muestra la <opcion> segun la opcion seleccionada
    Examples:
      | pagina    | opcion |
      | Principal | si     |
      | Principal | no     |

  Scenario Outline: 4.No ingresar información en los campos requeridos
    When  En crear agrupador da clic en <campo_requerido> e ingresa información en el otro campo
    Then  En crear agrupador se presenta mensaje indicando que el campo es <campo_requerido>

    Examples:
      | campo_requerido                   |
      | Nombre Agrupador                  |
      | Numero de Unidades Independientes |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    When  En crear agrupador ingresa al campo <nombre> agrupacion
    And   En crear agrupador ingresa al campo <numero> de unidades
    Then  En crear agrupador sistema presenta <habilitado> el boton de guardar

    Examples:
      | nombre      | numero | habilitado |
      | Agrupacion1 | 2      | Si         |
      | Agrupacion2 |        | No         |

  Scenario Outline: 6.Ingresar informacion en campo # de Unidades Independientes
    When En crear agrupador Ingresa un <valor> para el campo numero de unidades independientes
    Then En crear agrupador en el campo numero de unidades El sistema muestra el <resultado>

    Examples:
      | valor   | resultado |
      | 10(&%AB | 10        |

  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Agrupador, incluyendo caracteres especiales y el espacio
    And  En crear agrupador el usuario Da clic en el campo Nombre Agrupador
    When En crear agrupador Ingresa un <valor> para el campo nombre de agrupador
    Then En crear agrupador en el campo nombre El sistema muestra <resultado>

    Examples:

      | valor                                                                  | resultado                                          |
      | Agrupador # 4                                                          | Agrupador # 4                                      |
      | 1234567890123456789012345678901234567890123456789012345678901234567890 | 12345678901234567890123456789012345678901234567890 |


  Scenario Outline:  9.Creación de Agrupador
    When  En crear agrupador ingresa al campo <nombre> y <numero> de agrupador
    And   En crear agrupador da clic en boton guardar
    Then  En crear agrupador sistema presenta el <mensaje> de éxito o error

    Examples:
      | nombre   | numero | mensaje   |
      | Torre 8 | 10     | exito     |
      | Torre 30 | 10     | existente |

