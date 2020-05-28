Feature: Funcionamiento del elemento footer
  Como usuario Quiero ver la información del footer

  Background: Ingresar a la aplicación
    When Que usuario ingresa a la pagina de inicio
    And Inicia sesión

  Scenario: Información que se debe presentar en el footer
    When El usuario se ubica al final de la pantalla
    Then Visualiza la informacion del Footer

  Scenario: Seleccionar el logo de Bits Américas
    When Da clic sobre el logo de Bits Américas
    Then El sistema debe abrir una nueva ventana
    And El sistema presenta la página de Bits Américas