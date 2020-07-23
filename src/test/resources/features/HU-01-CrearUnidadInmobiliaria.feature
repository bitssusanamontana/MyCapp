Feature: Como usuario Quiero crear una Unidad Inmobiliaria Para iniciar su gestión.

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias
    And Da clic en el boton Crear unidad inmobiliaria

  Scenario: Se visualizan los elementos de la página de Crear Unidad
    Then En crear unidad inmobiliaria El usuario visualiza el formulario de Creacion de Unidad Inmobiliaria
    And En crear unidad inmobiliaria Campo Nombre conjunto
    And En crear unidad inmobiliaria Campo Direccion/Pais
    And En crear unidad inmobiliaria Campo Direccion/Departamento
    And En crear unidad inmobiliaria Campo Direccion/Ciudad
    And En crear unidad inmobiliaria Campo Direccion
    And En crear unidad inmobiliaria Campo Nit
    And En crear unidad inmobiliaria Campo Numero catastro
    And En crear unidad inmobiliaria Campo Tipo documento
    And En crear unidad inmobiliaria Campo Numero documento representante
    And En crear unidad inmobiliaria Campo Nombre representante
    And En crear unidad inmobiliaria Campo Apellido representante
    And En crear unidad inmobiliaria Campo Telefono unidad inmobiliaria
    And En crear unidad inmobiliaria Campo Celular representante
    And En crear unidad inmobiliaria Campo Correo electronico representante
    And En crear unidad inmobiliaria Campo Numero de agrupaciones
    And En crear unidad inmobiliaria Campo Numero de unidades independientes
    And En crear unidad inmobiliaria Campo Numero de entradas a pie
    And En crear unidad inmobiliaria Campo Numero de entradas vehiculares
    And En crear unidad inmobiliaria Campo Numero de parqueaderos

  Scenario Outline: Salir del formulario de Creación de unidad inmobiliaria
    When Da clic en una pagina diferente <pagina>
    Then El sistema muestra un mensaje de confirmacion
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    And Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la <accion> segun la opcion seleccionada
    Examples:
      | pagina    | opcion | accion                    |
      | Principal | si     | Principal                 |
      | Principal | no     | Crear Unidad inmobiliaria |
      | Principal | x      | Crear Unidad inmobiliaria |

  Scenario Outline: No ingresar información en los campos requeridos
    When En crear unidad inmobiliaria En el formulario da clic en el <campo_requerido>
    And En crear unidad inmobiliaria Da clic por fuera del campo
    Then En crear unidad inmobiliaria El sistema presenta mensaje de Campo requerido
    Examples:
      | campo_requerido                   |
      | Nombre conjunto                   |
      | Direccion/Pais                    |
      | Direccion/Departamento            |
      | Direccion/Ciudad                  |
      | Direccion                         |
      | Nit                               |
      | Numero catastro                   |
      | Tipo documento                    |
      | Numero documento representante    |
      | Nombre representante              |
      | Apellido representante            |
      | Telefono unidad inmobiliaria      |
      | Celular representante             |
      | Correo electronico representante  |
      | Numero de agrupaciones            |
      | Numero de unidades independientes |
      | Numero de entradas a pie          |
      | Numero de entradas vehiculares    |
      | Numero de parqueaderos            |

  Scenario: Se habilita si el botón de guardar
    When En crear unidad inmobiliaria Ingresa en todos los campos la informacion correcta
    Then En crear unidad inmobiliaria Se muestra habilitado el boton guardar

  Scenario Outline: Ingresar información en campos numéricos
    When En crear unidad inmobiliaria En el formulario da clic en el <campo_requerido>
    And En crear unidad inmobiliaria Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then En crear unidad inmobiliaria segun el <campo_requerido> Visualiza el resultado esperado <resultado>
    Examples:
      | campo_requerido                   | informacion | resultado |
      | Numero documento representante    | 4848C       | 4848      |
      | Telefono unidad inmobiliaria      | 354$%&      | 354       |
      | Celular representante             | 34567m&&    | 34567     |
      | Numero de agrupaciones            | 345((       | 345       |
      | Numero de unidades independientes | 4848C       | 4848      |
      | Numero de entradas a pie          | 354$%&      | 354       |
      | Numero de entradas vehiculares    | 34567m&&    | 34567     |
      | Numero de parqueaderos            | 34 5( (     | 345       |
      | Numero de agrupaciones            | 343434      | 34343     |
      | Numero de unidades independientes | 343434      | 34343     |
      | Numero de entradas a pie          | 343434      | 34343     |
      | Numero de entradas vehiculares    | 343434      | 34343     |
      | Numero de parqueaderos            | 343434      | 34343     |

  Scenario Outline: Ingresar información en campos alfanuméricos
    When En crear unidad inmobiliaria Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then En crear unidad inmobiliaria Visualiza el resultado esperado <resultado>
    Examples:
      | campo_requerido                  | informacion                                              | resultado                                           |
      | Nombre conjunto                  | Conjunto Bits 45678901234567890123                       | Conjunto Bits 45678901234567890                     |
      | Direccion                        | calle 106 56 3456789012345678901234567890123456789012345 | calle 106 56 34567890123456789012345678901234567890 |
      | Nit                              | 1234567890123456789012345678901234567890                 | 123456789012345678901234567890                      |
      | Numero catastro                  | 1234567890123456789012345678901234567890                 | 123456789012345678901234567890                      |
      | Nombre representante             | Jose asdfghjklaasdfghjklaasdfghjkla                      | Jose asdfghjklaasdfghjklaasdfg                      |
      | Apellido representante           | Barbosa asdfghjklaasdfghjklaasdfghjkla                   | Barbosa asdfghjklaasdfghjklaasd                     |
      | Correo electronico representante | bitsamericas@bitsamericas.com                            | bitsamericas@bitsamericas.com                       |
      | Nombre conjunto                  | Bits $$ - 2                                              | Bits - 2                                            |

  Scenario Outline: Dependencia de los campos de dirección (País y Departamento)
    And En crear unidad inmobiliaria Da clic en el campo Pais
    When En crear unidad inmobiliaria Selecciona uno de los <valores_paises> configurados
    Then En crear unidad inmobiliaria Debe habilitar el campo de Departamento
    And En crear unidad inmobiliaria presenta en el campo el listado de <valores_departamentos>
    And En crear unidad inmobiliaria presenta en el campo ‘Telefono unidad inmobiliaria’ el prefijo <prefijo> del pais seleccionado
    Examples:
      | valores_paises | valores_departamentos | prefijo |
      | Colombia       | informacion           | +57     |

  Scenario Outline: Dependencia de los campos de dirección (Departamento y ciudad)
    Given En crear unidad inmobiliaria Da clic en el campo Pais
    And En crear unidad inmobiliaria Selecciona uno de los <valores_paises> configurados
    And En crear unidad inmobiliaria Da clic el campo de Departamento
    When En crear unidad inmobiliaria Selecciona uno de los <valores_departamentos> configurados
    Then En crear unidad inmobiliaria presenta en el campo ‘ciudad’ habilitado
    And En crear unidad inmobiliaria presenta en el campo el listado de <valores_ciudades>
    Examples:
      | valores_paises | valores_departamentos | valores_ciudades |
      | Colombia       | Bogota                | Bogota           |

  Scenario Outline: Seleccionar informacion en campos de listas
    When En crear unidad inmobiliaria Da clic en el campo <campo>
    Then En crear unidad inmobiliaria presenta un listado de los valores configurados para el campo
    Examples:
      | campo             |
      | Tipo de documento |

  Scenario Outline: Visualizar el prefijo despues de seleccionar pais
    When En crear unidad inmobiliaria Da clic en Pais del campo Celular Representante
    And En crear unidad inmobiliaria Selecciona uno de los <valores_paises> configurados
    Then En crear unidad inmobiliaria se presenta el <prefijo> que se encuentre configurado para el pais seleccionado
    Examples:
      | valores_paises | prefijo |
      | Colombia       | +57     |

  Scenario Outline: Ingresar informacion en campos de tipo telefono
    When En crear unidad inmobiliaria Ingresa en el <campo> un <numero> de telefono
    Then En crear unidad inmobiliaria El sistema muestra el resultado <resultado>
    Examples:
      | campo                        | numero                   | resultado                      |
      | telefono unidad inmobiliaria | 2343434343434334         | 2343434                        |
      | telefono unidad inmobiliaria | 23434                    | Minimo debe tener 7 caracteres |
      | telefono unidad inmobiliaria | 234343434/&%$            | 2343434                        |
      | Celular representante        | 234343434343433498989898 | 234343434343433                |

  Scenario Outline: Ingresar informacion en campos de tipo correo electronico
    Given En crear unidad inmobiliaria Da clic en el campo correo electronico
    When En crear unidad inmobiliaria Ingresa un correo <correo>
    Then En crear unidad inmobiliaria El sistema muestra el resultado <resultado>
    Examples:
      | correo              | resultado                                                  |
      | usuario@ejemplo.com | Correo valido                                              |
      | usuario.com         | El correo electronico no es valido. Ejemplo ususario@h.com |
      | usuario@            | El correo electronico no es valido. Ejemplo ususario@h.com |
      | usuario@h           | El correo electronico no es valido. Ejemplo ususario@h.com |

  Scenario: No Se habilita el boton de guardar
    When En crear unidad inmobiliaria Ingresa solo algunos datos en los campos
    Then En crear unidad inmobiliaria No se muestra habilitado el boton guardar

  Scenario Outline: Ingreso de numero de documento de representante ya existe
    When En crear unidad inmobiliaria Ingresa la informacion <numero> en el campo Numero documento representante
    And En crear unidad inmobiliaria Da clic por fuera del campo
    Then En crear unidad inmobiliaria El sistema muestra la informacion de los campos de <Nombre>, <Apellidos>, <Celular> y <correo> ya diligenciados
    Examples:
      | numero   | Nombre | Apellidos | Celular    | correo                     |
      | 48759375 | Jose   | Barbosa   | 3948598437 | jbarbosam@bitsamericas.com |
      | 93854983 |        |           |            |                            |

  Scenario: Creacion de unidad inmobiliaria con datos existentes
    When En crear unidad inmobiliaria Ingresa todos los datos de direccion, nit, catastro, telefono unidad y correo ya existentes
    Then En crear unidad inmobiliaria Da clic en el boton guardar
    And En crear unidad inmobiliaria presenta los mensajes de error datos unicos

  Scenario: Creacion exitosa de Unidad inmobiliaria
    When En crear unidad inmobiliaria Ingresa los datos del formulario correctamente
    And En crear unidad inmobiliaria Da clic en el boton guardar
    Then En crear unidad inmobiliaria Se muestra el mensaje de creacion esxitosa
    And redirige al usuario a la página de Administrar Unidades Inmobiliarias
