Feature: Modificar Parqueadero
  Como usuario Quiero Modificar un Parqueadero Para continuar su gestión.

  Background: Ingreso a Modificar Parqueadero
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en el nombre de la Unidad Bits
    And da clic en Parqueaderos
    And da clic en Modificar Parqueadero x

  Scenario: 1.Información que se presenta al seleccionar el botón de Modificar
    Then  El sistema presenta formulario Modificar Parqueadero x
    And  En Modificar Parqueadero visualiza el formulario x
    And En Modificar Parqueadero visualiza campo tipo de parqueadero x
    And En Modificar Parqueadero visualiza campo agrupacion x
    And En Modificar Parqueadero visualiza campo unidad independiente x
    And En Modificar Parqueadero visualiza campo numero de parqueadero x
    And En Modificar Parqueadero visualiza campo tipo de vehiculo x
    And En Modificar Parqueadero visualiza boton de guardar bloqueado

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
    When  En Modificar Parqueadero borra la información en <campo_requerido>
    And   En Modificar Parqueadero da clic en el boton guardar
    Then  En Modificar Parqueadero se presenta mensaje indicando que el campo es requerido

    Examples:
      | campo_requerido       |
      | tipo                  |
      | agrupacion            |
      | unidad independiente  |
      | numero de parqueadero |
      | tipo de vehiculo      |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    When  En Modificar Parqueadero ingresa o selecciona informacion en los campos <tipo> <agrupacion> <unidad> <numero> y <vehiculo>
    Then  En Modificar Parqueadero sistema presenta <habilitado> el boton de guardar

    Examples:
      | tipo      | agrupacion | unidad | numero | vehiculo | habilitado |
      | propio    | T3         | 104    | 006    | carro    | si         |
      | propio    |            | 104    | 006    | carro    | no         |
      | visitante |            |        | 006    | carro    | no         |


  Scenario Outline: 6.Ingresar informacion en los campos de Modificar parqueadero
    When En Modificar Parqueadero Ingresa o selecciona en el <campo> del formulario un <valor>
    Then En Modificar Parqueadero El sistema muestra el <resultado>

    Examples:
      | campo                | valor                                         | resultado            |
      | tipo                 | Propio                                        | Apto 10              |
      | agrupacion           | T4                                            | 55                   |
      | unidad independiente | 102                                           | 12345                |
      | numero parqueadero   | asdfghjkl #$%&/123456789012345678901234567890 | asdfghjkl 1234567890 |
      | vehiculo             | Carro                                         | Carro                |

  Scenario Outline:  9.Modificación de Parqueadero
    When  En Modificar Parqueadero ingresa o selecciona informacion en los campos <tipo> <agrupacion> <unidad> <numero> y <vehiculo>
    And   En Modificar Parqueadero da clic en boton guardar
    Then  En Modificar Parqueadero sistema presenta el <mensaje> de exito o error

    Examples:
      | tipo   | agrupacion | unidad | numero | vehiculo | mensaje   |
      | propio | T3         | 104    | 006    | carro    | exito     |
      | propio |            | 104    | 006    | carro    | existente |