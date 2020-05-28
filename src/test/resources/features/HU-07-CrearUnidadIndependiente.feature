Feature: Crear Unidad Independiente
  Como usuario Quiero crear una unidad independiente Para iniciar su gestión.

  Background: Ingreso a Crear unidad independiente
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en el nombre de la Unidad Bits
    And clic en agrupador deseado
    And da clic en crear unidad independiente

  Scenario: 1.Información que se presenta al seleccionar el botón de crear
    Then  El sistema presenta formulario Crear unidad independiente
    And  En crear unidad independiente visualiza el formulario
    And En crear unidad independiente visualiza campo nombre unidad independiente
    And En crear unidad independiente visualiza campo numero de catastro
    And En crear unidad independiente visualiza campo numero de metros cuadrados
    And En crear unidad independiente visualiza boton de guardar bloqueado

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
    When  En crear unidad independiente da clic en <campo_requerido>
    And   En crear unidad independiente da clic en el boton guardar
    Then  En crear unidad independiente se presenta mensaje indicando que el campo es requerido

    Examples:
      | campo_requerido             |
      | Nombre unidad independiente |
      | numero de catastro          |
      | numero de metros cuadrados  |


  Scenario Outline: 5.Se habilita si o no botón de guardar
    When  En crear unidad independiente ingresa al campo <nombre> unidad independiente
    And   En crear unidad independiente ingresa al campo <numero> de catastro
    And   En crear unidad independiente ingresa al campo <metros> cuadrados
    Then  En crear unidad independiente sistema presenta <habilitado> el boton de guardar

    Examples:
      | nombre   | numero | metros | habilitado |
      | 102      | 2      | 50     | Si         |
      | apto 301 |        |        | No         |
      |          | 3      |        | No         |

  Scenario Outline: 6.Ingresar informacion en los campos de crear unidad independiente
    When En crear unidad independiente Ingresa en el <campo> del formulario un <valor>
    Then En crear unidad independiente El sistema muestra el <resultado>

    Examples:
      | campo    | valor                                    | resultado                      |
      | nombre   | Apto 10#$%                               | Apto 10                        |
      | catastro | 55ab                                     | 55                             |
      | metros   | 123456$%ygg                              | 12345                          |
      | nombre   | asdfghjkl 123456789012345678901234567890 | asdfghjkl 12345678901234567890 |
      | catastro | 123456789012345678901234567890           | 12345678901234567890           |
      | metros   | 5565499                                  | 55654                          |

  Scenario Outline:  9.Creación de Agrupador
    When  En crear unidad independiente ingresa al campo <nombre>, <catastro> y <metros> de unidad independiente
    And   En crear unidad independiente da clic en boton guardar
    Then  En crear unidad independiente sistema presenta el <mensaje> de éxito o error

    Examples:
      | nombre   | catastro | metros | mensaje   |
      | Apto 102 | 2543     | 45     | exito     |
      | Apto 102 | 3        | 45     | existente |