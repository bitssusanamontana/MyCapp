Feature: Consultar usuario
  Como usuario Quiero Consultar un usuario Para visualizar su gestión.

  Background: Ingreso a Consultar usuario
    Given Que usuario ingresa a la pagina de inicio
    And Inicia sesión
    And Se visualiza la pagina Administracion de Unidades Inmobiliarias
    And Se da clic en Administar usuarios
    And da clic en Consultar usuario

  Scenario: 1.Información que se presenta al seleccionar el botón de Consultar
    Then  El sistema presenta formulario Crear usuario
    And  En Consultar usuario visualiza el formulario
    And En Consultar usuario visualiza campo tipo de identificacion
    And En Consultar usuario visualiza campo numero de identificacion
    And En Consultar usuario visualiza campo nombre
    And En Consultar usuario visualiza campo apellidos
    And En Consultar usuario visualiza campo telefono
    And En Consultar usuario visualiza campo rol
    And En Consultar usuario visualiza campo usuario
    And En Consultar usuario visualiza el enlace tomar foto