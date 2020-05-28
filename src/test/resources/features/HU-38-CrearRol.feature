Feature: Crear rol y asignar permisos
  Como usuario super administrador Quiero crear los roles con sus permisos Para que los usuarios tengan los permisos que son en el sistema de inmobiliarias

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Ingresa el usuario y la contrasena
    And Da clic en continuar
   # And Inicia sesión
    #And Da clic en Configuracion
    #And Da clic en Roles
    And Da clic en el boton Crear Rol

  Scenario: Informacion que se presenta al seleccionar el boton Crear rol
    Then El sistema presenta una ventana con la informacion de crear rol

  Scenario: Habilitación del botón guardar
    When Ingresa información en el campo nombre de rol
    Then El sistema presenta habilitado el boton de guardar

  Scenario Outline: Ingresar información en el campo Nombre rol
    When Ingresa el nombre del rol <nombre> en el campo nombre de rol
    Then Se muestra el nombre de rol esperado <resultado>
    Examples:
      | nombre                              | resultado                      |
      | Admin                               | Admin                          |
      | Admin 28.%&/                        | Admin 28.                      |
      | 12345678901234567890123456789012345 | 123456789012345678901234567890 |

  Scenario Outline: Realizar la creación de rol
    When Ingresa el nombre del rol <nombre> en el campo nombre de rol
    And En crear rol da clic en el boton guardar
    Then El sistema presenta exito o error en <mensaje>
    Examples:
      | nombre    | mensaje     |
      | Admin     | existente   |
      | Admin 28. | creado      |
      |           | obligatorio |

  Scenario: Seleccionar permisos
    When Se da clic en Configuracion
    Then Se visualizan seleccionados cada check

  Scenario: Seleccionar permisos padre
    When Se da clic en Configuracion
    Then Se visualizan todos los hijos y acciones seleccionados

  Scenario: Desmarcar permisos padre
    Given Ingresa información en el campo nombre de rol
    And Que se encuentra seleccionado configuracion
    When Se da clic en Configuracion
    Then Se visualizan todos los hijos desmarcados

  Scenario: Desmarcar hijos
    Given Ingresa información en el campo nombre de rol
    And Que se encuentra seleccionado configuracion
    When se desmarcan los hijos
    Then Se mantiene seleccionado configuracion

  Scenario: Desmarcar acciones
    Given Ingresa información en el campo nombre de rol
    And Que se encuentra seleccionado configuracion 2
    And se encuentran marcados los hijos de configuracion 2
    When se desmarcan todas las acciones del hijo configuracion 2
    Then se encuentran marcados los hijos de configuracion 2

  Scenario: Desmarcar una acción
    Given Ingresa información en el campo nombre de rol
    And Que se encuentra seleccionado configuracion
    And Se visualizan todos los hijos y acciones seleccionados
    When se desmarca la accion de Modificar rol
    Then se mantienen seleccionados las demas acciones

  Scenario: Marcar permiso padre
    Given Ingresa información en el campo nombre de rol
    And Que se encuentra desmarcada configuracion
    When se selecciona la accion de Editar
    Then se muestra seleccionado el padre y el hijo

  Scenario: Creación del rol con permisos
    Given Ingresa información en el campo nombre de rol
    And Se selecciona configuracion
    And se selecciona la accion de Editar
    When En crear rol da clic en el boton guardar
    Then Se muestra el mensaje de creacion
    And redirige al usuario a la página de Administrar Roles






