Feature: Administrar roles y permisos
  Como usuario super administrador Quiero Administar los roles con sus permisos Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    And Ingresa el usuario y la contrasena
    And Da clic en continuar
    #And Da clic en Configuracion
    #And Da clic en Roles

  Scenario: Información que se presenta al ingresar la opción de administrar roles
    Then Se visualizan los elementos de administrar roles

  #Scenario Outline: Realizar búsqueda de un rol
   # When Ingresa información en filtro de busqueda <busqueda>
    #And Da clic en buscar
    #Then El sistema muestra los resultados <resultado>
    #Examples:
     # | busqueda | resultado             |
      #| Admin    | Administrador         |
      #| NoExiste | No existe informacion |


  Scenario Outline: Seleccionar icono de acciones
    When De la tabla de Roles Selecciona una <opcion>
    Then El sistema redirecciona por medio de una accion <accion>
    Examples:
      | opcion    | accion           |
      | consultar | Pagina consultar |
      | Eliminar  | mensaje eliminar |
      | modificar | Pagina modificar |
      | activar   | mensaje activar  |

  Scenario Outline: Inactivar Rol
    When Da clic en inactivar rol
    And Se visualiza el mensaje de confirmacion de inactivacion
    Then El usuario da clic en <opcion> de inactivacion y se realiza una accion

    Examples:
      | opcion |
      | si     |
      | no     |


  Scenario Outline: Activar rol
    When Da clic en activar rol
    And El mensaje de confirmacion de activacion se muestra
    Then El usuario da clic en <opcion> de activacion y realiza una accion

    Examples:
      | opcion |
      | si     |
      | no     |

  Scenario Outline: Eliminar Rol
    When Da clic sobre el icono de Eliminar rol de Admin
    And Presenta un pop up de Eliminación
    And El sistema presenta mensaje de eliminación
    And Las opciones de Si y no
    And  Da clic sobre la <opcion>
    Then El sistema tiene el <resultado>

    Examples:
      | opcion | resultado        |
      | si     | Elimina el rol   |
      | no     | Cierra el pop up |

