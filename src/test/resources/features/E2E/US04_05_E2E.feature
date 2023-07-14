@DeanEkleme_UI
Feature: DeanGuncelleme_Silme

  Background: Admin Girisi
    Given Admin olarak "url" adresine gider
    Then Admin olarak Login ikonunu tiklar
    And Admin olarak username kutusununa "username" girer
    And Admin olarak password kutusuna "password" girer
    And Admin olarak Login butonunu tiklar
    And Admin olarak Menu butonuna basar
    And Admin olarak Dean Management linkini tiklar


  Scenario: US04 Admin Dean valid deger ile Dean ekler
    Given Admin Add Dean Management bolumunu gorur
    Then Admin Dean eklemek icin valid degerler girer
    And Admin Submit butonuna basar
    And Admin girdiği verileri kaydettigini dogrular

  @US04ApiGet @Admin
  Scenario:US04 Admin UI'da kaydettigi Dean'i API'da dogrular
    Given Admin Tum Dean bilgilerini cagirir
    Then Dean bodysi get yaparak API ile dogrulanir

  @US04DBGet @Admin
  Scenario:US04 Admin UI'da kaydettigi Dean'i DB'da dogrular
    Given Admin Tum Dean bilgilerini DB'den cagirir
    Then Dean bodysi DB'de dogrulanir