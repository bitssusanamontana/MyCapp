Feature: Modificar Persona asociada a Unidad Independiente
  Como usuario Quiero Modificar una Persona asociada a la Unidad Independiente Para continuar su gestión.

  Background: Un usuario en la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Ingresa al agrupador deseado
    And da clic en la unidad independiente
    And da clic en el boton Modificar persona asociada

  Scenario: Información que se presenta al seleccionar el botón de crear
    Then El sistema presenta el formulario Modificar persona asociada
    And En modificar persona Ruta de navegacion
    And En modificar persona Campo selector Tipo persona
    And En modificar persona Campo Selector Tipo de Documento
    And En modificar persona Campo Número de Documento
    And En modificar persona Campo Nombres
    And En modificar persona Campo Apellidos
    And En modificar persona Campo Correo Electrónico
    And En modificar persona Campo Telefono Fijo
    And En modificar persona Campo Teléfono Celular
    And En modificar persona El boton de guardar bloqueado

  Scenario Outline: Salir del formulario de Mofificación de persona asociada
    When Da clic en una pagina diferente <pagina>
    Then El sistema muestra un mensaje de confirmacion
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

  Scenario Outline: Cerrar el mensaje ¿Esta seguro de que desea salir de la página Modificar persona asociada?

    And Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la pagina segun la opcion seleccionada
    Examples:
      | pagina    | opcion |
      | Principal | si     |
      | Principal | no     |
      | Principal | x      |

  Scenario Outline: Borrar información en los campos requeridos
    When En modificar persona Borra la informacion en el campo <campo_requerido>
    Then En modificar persona El sistema presenta el mensaje "Campo requerido"
    And En modificar persona El boton de guardar bloqueado
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
    When En modificar persona <Cambia> toda la informacion en los campos requeridos
    Then En modificar persona <Se_muestra> habilitado el boton guardar
    Examples:
      | Cambia | Se_muestra |
      | Si      | Si         |
      | no      | no         |

  Scenario Outline: Cambiar información en campos obligatorios
    When En modificar persona Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then En modificar persona Persona asociada Visualiza el resultado esperado <resultado>
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

  Scenario Outline: Cambia información errada en campos numéricos
    When En modificar persona Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then En modificar persona Visualiza el resultado esperado <resultado>
    Examples:
      | campo_requerido     | informacion              | resultado            |
      | Numero de Documento | 242424242424242323230000 | 24242424242424232323 |
      | Telefono Fijo       | 242424242424242323230000 | 24242424242424232323 |
      | Telefono Celular    | 12345678901111           | 1234567890           |

  Scenario Outline: Cambia información errada en campo email
    When En modificar persona Ingresa en el email la informacion <informacion>
    Then En modificar persona Visualiza el mensaje de error
    Examples:
      | informacion            |
      | jobarbosa.com          |
      | jobarbosa@.com         |
      | jobarbosa@             |
      | jobarbosa%&/@gmail.com |

  Scenario: Modificación de Persona asociada a Unidad Independiente
    When En modificar persona Ingresa toda información en cada uno de los campos requeridos de forma correcta
    And En modificar persona Da clic en el boton Guardar
    Then En modificar persona Muestra el mensaje modificación exitosa de persona
    And redirige al usuario a la página de Administrar Unidad independiente