Feature: Crear Persona asociada a Unidad Independiente
  Como usuario Quiero crear una Persona asociada a la Unidad Independiente Para iniciar su gestión.

  Background: Un usuario en la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Ingresa al agrupador deseado
    And da clic en la unidad independiente
    And da clic en el boton crear persona asociada

  Scenario: Información que se presenta al seleccionar el botón de crear
    Then El sistema presenta el formulario crear persona asociada
    And Ruta de navegacion
    And Campo selector Tipo persona
    And Campo Selector Tipo de Documento
    And Campo Número de Documento
    And Campo Nombres
    And Campo Apellidos
    And Campo Correo Electrónico
    And Campo Telefono Fijo
    And Campo Teléfono Celular
    And El boton de guardar bloqueado

  Scenario Outline: Salir del formulario de Creación de persona asociada
    Given Da clic en Unidades Inmobiliarias
    And da clic en el boton crear persona asociada
    When Da clic en una pagina diferente <pagina>
    Then El sistema muestra un mensaje de confirmacion
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

  Scenario Outline: Cerrar el mensaje ¿Esta seguro de que desea salir de la página crear persona asociada?
    Given Da clic en Unidades Inmobiliarias
    And da clic en el boton crear persona asociada
    And Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la pagina segun la opcion seleccionada
    Examples:
      | pagina    | opcion |
      | Principal | si     |
      | Principal | no     |
      | Principal | x      |

  Scenario Outline: No ingresar información en los campos requeridos
    When Da clic en el <campo_requerido>
    And Da clic por fuera del campo
    Then El sistema presenta el mensaje "Campo requerido"
    And El boton de guardar bloqueado
    Examples:
      | campo_requerido     |
      | Tipo de Persona     |
      | Tipo de documento   |
      | Numero de Documento |
      | Nombre              |
      | Apellidos           |
      | Correo Electronico  |
      | Telefono Fijo       |
      | Telefono Celular    |

  Scenario Outline: Se habilita si o no botón de guardar
    When <Ingresa> toda la informacion en los campos requeridos
    Then <Se_muestra> habilitado el boton guardar
    Examples:
      | Ingresa | Se_muestra |
      | Si      | Si         |
      | no      | no         |

  Scenario Outline: Ingresar información en campos obligatorios
    When Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then Visualiza el resultado esperado <resultado>
    Examples:
      | campo_requerido     | informacion            | resultado          |
      | Tipo de Persona     | Propietario            | Propietario        |
      | Tipo de documento   | cc                     | cc                 |
      | Numero de Documento | 243223asd$%%&%354345   | 243223354345       |
      | Nombre              | Jose384754$$%%$        | Jose               |
      | Apellidos           | Barbosa344398#$%$      | Barbosa            |
      | Correo Electronico  | jbarbosa$%&/@gmail.com | jbarbosa@gmail.com |
      | Telefono Fijo       | 834347834jdkfjfsk%&    | 834347834          |
      | Telefono Celular    | 3124456678gfdgf#$%$    | 3124456678         |

  Scenario Outline: Ingresar información errada en campos numéricos
    When Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then Visualiza el resultado esperado <resultado>
    Examples:
      | campo_requerido     | informacion              | resultado            |
      | Numero de Documento | 242424242424242323230000 | 24242424242424232323 |
      | Telefono Fijo       | 242424242424242323230000 | 24242424242424232323 |
      | Telefono Celular    | 12345678901111           | 1234567890           |

  Scenario Outline: Ingresar información errada en campo email
    When Ingresa en el email la informacion <informacion>
    Then Visualiza el mensaje de error
    Examples:
      | informacion            |
      | jobarbosa.com          |
      | jobarbosa@.com         |
      | jobarbosa@             |
      | jobarbosa%&/@gmail.com |

  Scenario: Creación de Persona asociada a Unidad Independiente
    When Ingresa toda información en cada uno de los campos requeridos de forma correcta
    And Da clic en el boton Guardar
    Then Muestra el mensaje creacion exitosa de persona
    And redirige al usuario a la página de Administrar Unidad independiente