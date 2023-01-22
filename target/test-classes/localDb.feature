@deneme
Feature: localDb


  Scenario Outline:
    Given Local database baglantisi kurulur.
    And elemanlar listelenir
    Then listede "<id>" olup olmadığı dogrulanır
    Examples:
      | id |
      |111 |
      |114 |
      |115 |
