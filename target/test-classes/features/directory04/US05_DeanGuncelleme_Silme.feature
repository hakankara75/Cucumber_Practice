@login
Feature: DeanGuncelleme_Silme
  Background: Admin Girisi
    Scenario: Admin Girisi
      Given Admin "url" adresine gider
      Then Kullanici Login ikonunu tiklar
      And Kullanici username kutusununa "username" girer
      And Kullanici password kutusuna "password" girer
      And Kullanici Login butonunu tiklar
      And Kullanici Menu butonunu tiklar
      And Kullanici dean management menusunu secer