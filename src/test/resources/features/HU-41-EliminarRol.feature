Feature: Eliminar rol
  Como usuario super administrador Quiero Eliminar los roles Para que ya no exista el rol en la aplicación

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Configuracion
    And Da clic en Roles

  Scenario: Mensaje que se presenta al selecciona icono de eliminar
    When Da clic sobre el icono de Eliminar rol de Admin
    Then El sistema debe presentar el mensaje de confirmacion

  Scenario Outline: Eliminar rol sin asignacion
    When Da clic sobre el icono de Eliminar rol de Admin
    Then Selecciona una <opcion> del pop up y genera una accion
    Examples:
      | opcion | mensaje                                                 |
      | si     | Se ha realizado la eliminacion del rol                  |
      | no     |                                                         |

  Scenario Outline: Eliminar rol con asignacion
    When Da clic sobre el icono de Eliminar rol de Administrador
    Then Selecciona del rol administrador una <opcion> del pop up y genera una accion
    Examples:
      | opcion | mensaje                                                 |
      | si     | El rol ya se encuentra asignado a uno o varios usuarios |
      | no     |                                                         |

