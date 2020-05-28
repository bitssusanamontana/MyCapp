Feature: Editar el ingreso de un visitante
  Como usuario Quiero Editar el ingreso de un visitante Para realizar su seguimiento

  Background: Un usuario en la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Administrar Entrada y Salida
    And Da clic sobre el botón Editar Ingreso de visitante

  Scenario: Información que se presenta al seleccionar el botón de Editar
    Then El sistema presenta el formulario crear persona asociada
    And Ruta de navegacion
    And Visualiza Label EDITAR INGRESO DE VISITANTE
    And Visualiza Campo Tipo de Identificacion
    And Visualiza Campo Numero de Documento
    And Visualiza Campo Nombres
    And Visualiza Campo Apellidos
    And Visualiza Campo ARL
    And Visualiza Campo EPS
    And Visualiza Campo ingreso
    And Visualiza Campo ID tarjeta
    And Visualiza Campo Agrupacion
    And Visualiza Campo Unidad Independiente
    And Visualiza Campo Placa
    And Visualiza Campo Parqueadero asignado
    And Visualiza Campo Motivo de ingreso
    And Visualiza Enlace tomar foto
    And Visualiza El boton de guardar bloqueado

  Scenario Outline: Salir del formulario de Registro Ingreso Visitante
    When Da clic en una pagina diferente <pagina>
    Then El sistema muestra un mensaje de confirmacion
    Examples:
      | pagina        |
      | Principal     |
      | Cerrar_sesion |

  Scenario Outline: Cerrar el mensaje ¿Esta seguro de que desea salir de la página crear persona asociada?
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
    When Da clic en el <campo_requerido>
    And Borra informacion del <campo_requerido>
    And Da clic por fuera del campo
    Then El sistema presenta el mensaje de Campo requerido
    And El boton de guardar bloqueado
    Examples:
      | campo_requerido        |
      | Tipo de Identificacion |
      | Numero de Documento    |
      | Nombres                |
      | Apellidos              |
      | Ingreso                |
      | ID tarjeta             |
      | Agrupacion             |
      | Unidad Independiente   |
      | Placa                  |
      | Parqueadero asignado   |
      | Motivo de Ingreso      |

  Scenario Outline: Se habilita si o no botón de guardar
    When <Ingresa> toda la informacion en los campos requeridos en edicion de visitante
    Then <Se_muestra> habilitado el boton guardar
    Examples:
      | Ingresa | Se_muestra |
      | Si      | Si         |
      | no      | no         |

  Scenario Outline: Ingresar información en campos obligatorios
    When Ingresa en edicion visitante en el campo <campo_requerido> la informacion <informacion>
    Then Visualiza en edicion visitante el resultado esperado <resultado>
    Examples:
      | campo_requerido        | informacion     | resultado    |
      | Tipo de Identificacion | CC              |              |
      | Numero de Documento    | 894758KSJDSKJD  | 894758       |
      | Nombres                | JOSE123         | JOSE         |
      | Apellidos              | BARBOSA3984$%%% | BARBOSA      |
      | Ingreso                | VEHICULAR       | VEHICULAR    |
      | ID tarjeta             | 003             | 003          |
      | Agrupacion             | TORRE 2         | TORRE 2      |
      | Unidad Independiente   | 102             | 102          |
      | Placa                  | JHD4566 %&/     | JHD456       |
      | Parqueadero asignado   | H1              | H1           |
      | Motivo de Ingreso      | 2343 USDJSDK    | 2343 USDJSDK

  Scenario: Edicion exitosa de ingreso de visitante
    When Ingresa en Edicion visitante información en cada uno de los campos requeridos de forma correcta
    And Da clic en el boton Guardar
    Then Muestra el mensaje de edicion exitosa de visitante
    And redirige al usuario a la página de Administrar Ingreso y Salida

  Scenario: Enlace Tomar Foto
    When Da clic en Enlace Tomar Foto
    Then El sistema muestra el pop up el cual permitirá tomar una foto frontal de la persona