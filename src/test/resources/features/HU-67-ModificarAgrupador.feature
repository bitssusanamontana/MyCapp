Feature: Modificar agrupador
  Como usuario Quiero Modificar un Agrupador Para continuar su gestión.

  Background: Ingreso a Modificar agrupador
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias
    And Da clic sobre la unidad inmobiliaria Bits
    And da clic en Modificar agrupador

  Scenario: 1.Información que se presenta al seleccionar el botón de Modificar
    Then  El sistema presenta formulario Modificar Agrupador
    And  En Modificar agrupador visualiza el formulario
    And En Modificar agrupador visualiza campo nombre agrupador
    And En Modificar agrupador visualiza campo numero de unidades independientes
    And En Modificar agrupador visualiza boton de guardar bloqueado

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    Given En Modificar agrupador Ingresa informacion en el campo nombre de agrupacion
    And En Modificar agrupador Da clic en una pagina diferente <pagina>
    When En Modificar agrupador Selecciona una opcion del pop up <opcion>
    Then En Modificar agrupador El sistema cierra el pop up
    And En Modificar agrupador Muestra la <opcion> segun la opcion seleccionada
    Examples:
      | pagina    | opcion |
      | Principal | si     |
      | Principal | no     |

  Scenario Outline: 4.No ingresar información en los campos requeridos
    When  En Modificar agrupador borra la informacion del <campo_requerido>
    Then  En Modificar agrupador se presenta mensaje indicando que el campo es <campo_requerido>

    Examples:
      | campo_requerido                   |
      | Nombre Agrupador                  |
      | numero de Unidades Independientes |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    When  En Modificar agrupador ingresa al campo <nombre> y <numero> de agrupador
    Then  En Modificar agrupador sistema presenta <habilitado> el boton de guardar

    Examples:
      | nombre      | numero | habilitado |
      | Agrupacion1 | 2      | Si         |
      | Agrupacion2 |        | No         |

  Scenario Outline: 6.Ingresar informacion en campo # de Unidades Independientes
    When En Modificar agrupador Ingresa un <valor> para el campo numero de unidades independientes
    Then En Modificar agrupador en el campo numero de unidades El sistema muestra el <resultado>

    Examples:
      | valor   | resultado |
      | 10ab%&( | 10        |

  Scenario Outline: 7.Ingresar información en el campo alfanumérico Nombre Agrupador, incluyendo caracteres especiales y el espacio
    And  En Modificar agrupador el usuario Da clic en el campo Nombre Agrupador
    When En Modificar agrupador Ingresa un <valor> para el campo nombre de agrupador
    Then En Modificar agrupador en el campo nombre El sistema muestra <resultado>

    Examples:

      | valor                                                                  | resultado                                          |
      | Agrupador # 5                                                          | Agrupador # 5                                      |
      | 1234567890123456789012345678901234567890123456789012345678901234567890 | 12345678901234567890123456789012345678901234567890 |

  Scenario Outline:  9.Creación de Agrupador
    When  En Modificar agrupador ingresa al campo <nombre> y <numero> de agrupador
    And   En Modificar agrupador da clic en boton guardar
    Then  En Modificar agrupador sistema presenta el <mensaje> de éxito o error

    Examples:
      | nombre      | numero | mensaje   |
      | Agrupacion1 | 10     | exito     |
      | TORRE 3     | 3      | existente |