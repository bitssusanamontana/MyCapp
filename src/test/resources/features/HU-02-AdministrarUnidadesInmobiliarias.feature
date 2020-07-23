Feature: Administrar Unidades Inmobiliarias
  Como usuario super administrador Quiero Administar las Unidades Inmobiliarias Para realizar su gestión en el sistema

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias

  Scenario: Información que se presenta al ingresar la opción de administrar Unidades Inmobiliarias
    Then El sistema muestra la informacion de las Unidades Inmobiliarias

  Scenario Outline: Realizar búsqueda de una Unidad Inmobiliaria
    When En unidades inmobiliarias Ingresa información en filtro de busqueda <busqueda> y da Enter
    Then El sistema muestra los resultados <resultado>
    Examples:
      | busqueda            | resultado             |
      | parque              | Parque residencial    |
      | Calle 127           | Niza                  |
      | 384783              | Oficinas centro       |
      | Jose                | Bits                  |
      | Barbosa             | Bits                  |
      | jbarbosam@gmail.com | Bits                  |
      | NoExiste            | No existe informacion |

   Scenario Outline: Seleccionar icono de acciones
    When En unidades inmobiliarias Selecciona una <opcion>
    Then En unidades inmobiliarias El sistema realiza una accion <accion>
    Examples:
      | opcion    | accion           |
      | consultar | Pagina consultar |
      | modificar | Pagina modificar |

  Scenario: Seleccionar Botón Crear Unidad Inmobiliaria
    When Da clic en Crear Unidad Inmobiliaria
    And El sistema redirecciona a la pagina de Crear Unidad Inmobiliaria

