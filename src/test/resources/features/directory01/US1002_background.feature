# iki Scenario olusturunuz

# her iki scenario'da ortak adım:  kullanici amazon anasayfasinda


# kullanici Nutella icin arama yapar
# sonuclarin Nutella icerdigini test eder
# sayfayi kapatir


# kullanici Java icin arama yapar
# sonuclarin Java icerdigini test eder
# sayfayi kapatir

Feature: US1002 Kullanici ortak adimlari Background ile calistirir

  Background: ortak adim

    Given kullanici Amazon sayfasinda

    Scenario: TC04 kullanici Amazonda Nutella aratir

      Given kullanici Nutella icin arama yapar
      Then sonuclarin Nutella icerdigini test eder
      And sayfayi kapatir

      Scenario: TC05 kullanici Amazonda Java aratir

        Given kullanici Java icin arama yapar
        Then sonuclarin Java icerdigini test eder
        And sayfayi kapatir
