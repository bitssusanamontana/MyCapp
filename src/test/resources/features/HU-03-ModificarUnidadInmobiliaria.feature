Feature: Como usuario Quiero modificar una Unidad Inmobiliaria Para continuar su gestión.

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar

  Scenario: Se visualizan los elementos de la página de Modificar Unidad
    Given Da clic en Unidades Inmobiliarias
    When Da clic en el boton modificar
    Then El usuario visualiza el formulario de Modificacion de Unidad Inmobiliaria
    And Campo Nombre conjunto
    And Campo Direccion/Pais
    And Campo Direccion/Departamento
    And Campo Direccion/Ciudad
    And Campo Direccion
    And Campo Nit
    And Campo Numero catastro
    And Campo Tipo documento
    And Campo Numero documento representante
    And Campo Nombre representante
    And Campo Apellido representante
    And Campo Telefono unidad inmobiliaria
    And Campo Celular representante
    And Campo Correo electronico representante
    And Campo Numero de agrupaciones
    And Campo Numero de unidades independientes
    And Campo Numero de entradas a pie
    And Campo Numero de entradas vehiculares
    And Campo Numero de parqueaderos

  Scenario Outline: Salir del formulario de Modificación de unidad inmobiliaria
    Given Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar
    When Da clic en una pagina diferente <pagina>
    Then El sistema muestra un mensaje de confirmacion
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

  Scenario Outline: Acciones pop up de confirmación de salir del formulario
    Given Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar
    And Da clic en una pagina diferente <pagina>
    When Selecciona una opcion del pop up <opcion>
    Then El sistema cierra el pop up
    And Muestra la <accion> segun la opcion seleccionada
    Examples:
      | pagina    | opcion | accion                    |
      | Principal | si     | Principal                 |
      | Principal | no     | Crear Unidad inmobiliaria |
      | Principal | x      | Crear Unidad inmobiliaria |

  Scenario Outline: Borrar información en los campos requeridos
    Given Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar
    When Da clic en el <campo_requerido>
    And Borra la informacion del <campo_requerido>
    And Da clic por fuera del campo
    Then El sistema presenta mensaje de Campo requerido
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
    Given Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar
    When Ingresa en todos los campos la informacion correcta
    Then Se muestra habilitado el boton guardar

  Scenario Outline: Ingresar información en campos numéricos
    Given Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar
    When Borra la informacion del <campo_requerido>
    And Da clic en el <campo_requerido>
    And Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then Visualiza el resultado esperado <resultado>
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
    Given Da clic en Unidades Inmobiliarias
    And Da clic en el boton modificar
    When Borra la informacion del <campo_requerido>
    And Ingresa en el campo <campo_requerido> la informacion <informacion>
    Then Visualiza el resultado esperado <resultado>
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
    Given Da clic en el campo Pais
    When Selecciona uno de los <valores_paises> configurados
    Then Debe habilitar el campo de Departamento
    And presenta en el campo el listado de <valores_departamentos>
    And presenta en el campo ‘Telefono unidad inmobiliaria’ el prefijo <prefijo> del pais seleccionado
    Examples:
      | valores_paises | valores_departamentos | prefijo |
      | Colombia       | informacion           | +57     |

  Scenario Outline: Dependencia de los campos de dirección (Departamento y ciudad)
    Given Da clic en el pais
    And Selecciona uno de los <valores_paises> configurados
    And Da clic el campo de Departamento
    When Selecciona uno de los <valores_departamentos> configurados
    Then presenta en el campo ‘ciudad’ habilitado
    And presenta en el campo el listado de <valores_ciudades>
    Examples:
      | valores_departamentos | valores_ciudades |
      | Bogota                | Bogota           |

  Scenario Outline: Seleccionar informacion en campos de listas
    When Da clic en el campo <campo>
    Then presenta un listado de los <valores> configurados para el campo
    Examples:
      | campo             | valores    |
      | Tipo de documento | CC, TI, CE |

  Scenario Outline: Visualizar el prefijo despues de seleccionar pais
    When Da clic en Pais del campo Celular Representante
    And Selecciona uno de los <valores_paises> configurados
    Then se presenta el <prefijo> que se encuentre configurado para el pais seleccionado
    Examples:
      | valores_paises | prefijo |
      | Colombia       | +57     |

  Scenario Outline: Ingresar informacion en campos de tipo telefono
    When Ingresa en el <campo> un <numero> de telefono
    Then El sistema muestra el resultado <resultado>
    Examples:
      | campo                        | numero                   | resultado                      |
      | telefono unidad inmobiliaria | 2343434343434334         | 2343434                        |
      | telefono unidad inmobiliaria | 23434                    | Minimo debe tener 7 caracteres |
      | telefono unidad inmobiliaria | 234343434/&%$            | 2343434                        |
      | Celular representante        | 234343434343433498989898 | 234343434343433                |

  Scenario Outline: Ingresar informacion en campos de tipo correo electronico
    Given Da clic en el campo correo electronico
    When Ingresa un correo <correo>
    Then El sistema muestra el resultado <resultado>
    Examples:
      | correo              | resultado                                                  |
      | usuario@ejemplo.com | Correo valido                                              |
      | usuario.com         | El correo electronico no es valido. Ejemplo ususario@h.com |
      | usuario@            | El correo electronico no es valido. Ejemplo ususario@h.com |
      | usuario@h           | El correo electronico no es valido. Ejemplo ususario@h.com |

  Scenario: No Se habilita el boton de guardar
    When Ingresa solo algunos datos en los campos
    Then No se muestra habilitado el boton guardar

  Scenario Outline: Ingreso de numero de documento de representante ya existe
    When Borra la informacion del campo numero de documento representante
    And Ingresa la informacion <numero> en el campo Numero documento representante
    And Da clic por fuera del campo
    Then El sistema muestra la informacion de los campos de <Nombre>, <Apellidos>, <Celular> y <correo> ya diligenciados
    Examples:
      | numero   | Nombre | Apellidos | Celular    | correo                     |
      | 48759375 | Jose   | Barbosa   | 3948598437 | jbarbosam@bitsamericas.com |
      | 93854983 |        |           |            |                            |

  Scenario: Modificación de unidad inmobiliaria con datos existentes
    When Ingresa todos los datos de direccion, nit, catastro, telefono unidad y correo ya existentes
    Then Da clic en el boton guardar
    And presenta los mensajes de error datos unicos

  Scenario: Modificación exitosa de Unidad inmobiliaria
    When Ingresa los datos del formulario correctamente
    And Da clic en el boton guardar
    Then Se muestra el mensaje de modificacion exitosa
