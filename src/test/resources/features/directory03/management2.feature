@management2
Feature: Management
  Scenario: TC01
    Given Kullanici "url" adresine gider
    Then Kullanici Login ikonunu tiklar
    And Kullanici username kutusununa "username" girer
    And Kullanici password kutusuna "password" girer
    And Kullanici Login butonunu tiklar
    And Kullanici Menu butonunu tiklar
    And Kullanici admin management menusunu secer
    Then Kullanici edit butonuna basar
    And Kullanici name kutusuna "name" girer
    And Kullanici surname kutusuna "surname" girer
    And Kullanici birth place kutusuna "birth place" girer
    And Kullanici email kutusuna "email" girer
    And Kullanici gender checkboxtan gender secer
    And Kullanici is advisor teacher checkbox'ini secer
    And Kullanici date of birth kutusuna "date of birth" girer
    And Kullanici phone kutusuna "phone" girer
    And Kullanici ssn kutusuna "ssn" girer
    And Kullanici user name kutusuna "user name" girer
    And Kullanici pass kutusuna "pass" girer
    And Kullanici submit butonuna basar
