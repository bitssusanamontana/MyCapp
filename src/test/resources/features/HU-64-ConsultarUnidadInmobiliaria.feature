Feature: Consultar Unidad Inmobiliaria
  Como usuario super administrador Quiero Consultar la Unidad Inmobiliaria Para visualizar toda su información

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Unidades Inmobiliarias

  Scenario: Realizar consulta de Unidad Inmobiliaria
    When Da clic en Consultar Unidad Inmobiliaria Bits
    Then El sistema presenta la informacion como consulta en los campos de consulta

  Scenario: Seleccionar boton regresar
    When Da clic en Consultar Unidad Inmobiliaria Bits
    And Da clic en el boton regresar
    Then El sistema debe presentar la página de Administrar Unidades Inmobiliarias