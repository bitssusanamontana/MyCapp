Feature: Como usuario Quiero Iniciar sesión

  Scenario:Ingresar a la aplicación
    Given Que usuario ingresa a la pagina de inicio
    When Inicia sesión
    Then Entra a la pagina
    And El sistema presenta la página Administracion de roles