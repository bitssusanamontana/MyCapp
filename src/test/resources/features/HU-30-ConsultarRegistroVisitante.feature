Feature: Consultar Registro Visitante
  Como usuario super administrador Quiero Consultar el Registro de un Visitante Para visualizar toda su información

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Da clic en Administrar Entrada y Salida

  Scenario: Realizar consulta de registro de visitante
    When Da clic en Consultar registro de visitante
    Then Se visualiza formulario consultar persona asociada
    And Ruta de navegacion
    And Visualiza Label REGISTRO DE INGRESO DE VISITANTE
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
    And El sistema presenta la informacion del visitante en los campos

  Scenario: Seleccionar boton regresar
    When Da clic en Consultar registro de visitante
    And Da clic en el boton regresar
    Then redirige al usuario a la página de Administrar Ingreso y Salida