Feature: Como usuario Quiero cargar masivamente Tarjetas de Ingreso Para asignar a los usuarios.

  Background: Un usuario ingresa correctamente a la pantalla de Carga Masiva
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Tarjetas de Ingreso
    And Da clic sobre Carga Masiva

  Scenario: Información que se presenta al seleccionar el botón de Carga Masiva
    Then El usuario visualiza la ruta de navegacion
    And El usuario visualiza el label “CARGA MASIVA DE ID DE TARJETAS DE INGRESO”
    And El usuario visualiza el label informativo
    And El usuario visualiza el Enlace de descarga: Descargar archivo CSV en Blanco
    And El usuario visualiza el Enlace de descarga: Descargar archivo CSV de Ejemplo
    And El usuario visualiza el Boton Cargar Archivo CSV
    And El usuario visualiza el boton Guardar bloqueado

  Scenario Outline: Salir del formulario de Carga Masiva
    When Da clic en una pagina diferente <pagina>
    Then Se muestra un mensaje de confirmacion para salir de Carga Masiva
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

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

  Scenario: No ingresar Cargar el archivo con el formato requerido
    When Da clic en Boton Cargar Archivo CSV
    And No carga ningún archivo
    Then El sistema presenta mensaje de error de carga
    And El boton de guardar bloqueado

  Scenario Outline: Carga de Archivo y activación botón Guardar
    Given Da clic en Boton Cargar Archivo CSV
    When Selecciona un archivo con <formato>
    And Da clic en Cargar
    Then Se <activa> el boton guardar
    Examples:
      | formato | activa |
      | CSV     | si     |
      | xls     | no     |

  Scenario Outline: Carga Masiva de Tarjetas de Ingreso
    Given Da clic en Boton Cargar Archivo CSV
    When Selecciona un archivo <diligenciado>
    And Da clic en Cargar
    And Da clic en el boton Guardar
    Then Se tiene el mensaje de carga <mensaje>
    Examples:
      | diligenciado | mensaje        |
      | si           | Carga Exitosa  |
      | no           | Error de Carga |

  Scenario Outline: Enlaces de descarga
    When Se da clic en el enlace de descarca <enlace>
    Then El sistema descarga el archivo <correspondiente> en formato CSV
    Examples:
      | enlace  | correspondiente |
      | Ejemplo | Con registros   |
      | Blanco  | Sin registros   |