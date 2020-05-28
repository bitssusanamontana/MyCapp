Feature: Funcionamiento de elementos header, menu y cierre de sesión
  Como usuario Quiero ver la información de la página principal Para poder interactuar con las diferentes funcionalidades

  Background: Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    When Inicia sesión

  Scenario: Información que se debe presentar en el header
    Then Visualiza el logo de la unidad inmobiliaria
    And Visualiza Nombre de la unidad inmobiliaria
    And Visualiza Ruta de navegacion
    And Visualiza Icono de cambiar de unidad inmobiliaria
    And Visualiza Seccion perfil con el usuario y foto
    And Visualiza cierre de sesion

  Scenario: Seleccionar la sección del logo de la unidad inmobiliaria en el header
    When Da clic en el logo de la unidad inmobiliaria en el header
    Then El sistema presenta una ventana emergente para realizar la configuración de logo
    And Con un botón de Seleccionar imagen
    And Texto descriptivo del formato y tamaño máximo de la imagen
    And Texto descriptivo del tamaño máximo de la imagen
    And Con un botón de guardar
    And Un botón de Cancelar
    And Con opción de cerrar ventana

  Scenario: Cambiar el logo de la unidad inmobiliaria en el header
    Given Da clic en el logo de la unidad inmobiliaria en el header
    And Da clic sobre el botón de seleccionar imagen
    And Selecciona una imagen
    When Un usuario administrador selecciona el botón guardar
    Then El sistema presenta un mensaje ‘Se ha realizado el cambió del logo exitosamente’
    And Cierra la ventana emergente
    And Actualiza el logo de la unidad inmobiliaria

  Scenario Outline: Seleccionar una imagen que no cumple con las reglas
    Given Da clic en el logo de la unidad inmobiliaria en el header
    And Da clic sobre el botón de seleccionar imagen
    And Selecciona una imagen <imagen>
    When Un usuario administrador selecciona el botón guardar
    Then El sistema presenta error con el <mensaje>
    Examples:
      | imagen                        | mensaje                                                                            |
      | formato distinto JPG/JPEG/PNG | "El formato permitido es JPG/JPEG/PNG. Por favor, seleccione otro archivo "        |
      | tamano mayor a 5MB            | "El tamano de la foto debe ser menor de 5MB. Por favor, seleccione otro archivo  " |

  Scenario: Cerrar la ventana emergente de configurar logo inmobiliario
    Given Da clic en el logo de la unidad inmobiliaria en el header
    When Da clic sobre la opción de cerrar
    Then El sistema cierra la ventana emergente
    And No actualiza la imagen de logo de la unidad inmobiliaria
    And Deja al usuario en la página actual

  Scenario Outline: Información que se presenta en la ruta de navegación
    When Da clic sobre una <pagina> del menu
    Then El sistema muestra la <ruta_de_navegacion>
    And Debe presentar como enlace la informacion antes de la ultima en la <ruta_de_navegacion>

    Examples:
      | pagina                    | ruta_de_navegacion        |
      | Inicio                    | Inicio                    |
      | Unidad Inmobiliaria       | Unidad Inmobiliaria       |
      | Crear Unidad Inmobiliaria | Unidad Inmobiliaria/Crear |

  Scenario Outline: Seleccionar un enlace de la ruta de navegacion
    Given Da clic sobre una <pagina> del menu
    And El sistema muestra la <ruta_de_navegacion>
    When Da clic sobre un <enlace> de la <ruta_de_navegacion>
    Then El sistema debe presentar una <pagina_resultado>
    Examples:
      | pagina                    | ruta_de_navegacion        | enlace              | pagina_resultado    |
      | Crear Unidad Inmobiliaria | Unidad Inmobiliaria/Crear | Unidad Inmobiliaria | Unidad Inmobiliaria |

  Scenario: Información que se presenta al seleccionar la sección de perfil
    When Da clic sobre la sección de perfil
    Then El sistema debe presentar una ventana con las opciones

  Scenario: Seleccionar opción de cambiar foto de perfil
    When Da clic sobre la sección de perfil
    And Da clic sobre opción de cambiar foto perfil
    Then El sistema presenta una ventana emergente para realizar el cambio de imagen
    And botón de Seleccionar imagen
    And Texto descriptivo del formato y tamaño máximo de la imagen
    And Texto descriptivo del tamaño máximo de la imagen
    And Con un botón de guardar
    And Un botón de Cancelar
    And Con opción de cerrar ventana

  Scenario: Realizar cambio de foto de perfil
    Given Da clic sobre la sección de perfil
    And Da clic sobre opción de cambiar foto perfil
    And Da clic sobre el botón de seleccionar imagen
    And Selecciona una imagen
    When Un usuario selecciona el botón guardar
    Then El sistema presenta un mensaje ‘Se ha realizado el cambió de la foto de perfil exitosamente’
    And Cierra la ventana emergente
    And Actualiza la imagen de perfil del usuario autenticado

  Scenario Outline: Seleccionar una imagen que no cumple con las reglas
    Given Da clic sobre la sección de perfil
    And Da clic sobre opción de cambiar foto perfil
    And Da clic sobre el botón de seleccionar imagen
    And Selecciona una imagen <imagen>
    When Un usuario selecciona el botón guardar
    Then El sistema presenta un mensaje <mensaje_foto_fallida>
    Examples:
      | imagen                           | mensaje_foto_fallida                                                           |
      | formato diferente a JPG/JPEG/PNG | El formato permitido es JPG/JPEG/PNG. Por favor, seleccione otro archivo       |
      | tamano mayor a 5MB               | El tamano de la foto debe ser menor de 5MB. Por favor, seleccione otro archivo |

  Scenario: Cerrar la ventana emergente de cambiar foto de perfil
    Given Da clic sobre la sección de perfil
    And Da clic sobre opción de cambiar foto perfil
    When Da clic sobre la opción de cerrar
    Then El sistema cierra la ventana emergente
    And No actualiza la imagen de perfil

  Scenario Outline: Niveles que debe tener el menú
    When Selecciona una opcion de un <primer_nivel> del menu
    Then Selecciona una opcion del segundo nivel del menu <segundo_nivel>
    And El sistema presenta la <pagina> seleccionada
    Examples:
      | primer_nivel        | segundo_nivel | pagina                    |
      | Unidad Inmobiliaria | Crear         | Crear Unidad inmobiliaria |

  Scenario: Realizar cierre de sesión
    When Da clic en el boton de cierre de sesion ubicado en el header
    Then Presenta la página de autenticacion





