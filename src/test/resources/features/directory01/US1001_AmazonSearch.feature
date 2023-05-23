# uc Scenario olusturunuz

# kullanici amazon sayfasında
# kullanici Nutella icin arama yapar
# sonuclarin Nutella icerdigini test eder
# Sayfayı kapatir

# kullanici amazon anasayfasinda
# kullanici Java icin arama yapar
# sonuclarin Java icerdigini test eder
# Sayfayi kapatir

# kullanici amazon anasayfasinda
# kullanici iphone icin arama yapar
# sonuclarin iphone icerdigini test eder
# sayfayi kapatir


  Feature: US1001 Kullanici Amazon Sayfadsinda Arama yapar
    @nutella
    Scenario: TC01 kullanici Amazonda Nutella aratir
      Given kullanici Amazon sayfasinda
      Then kullanici Nutella icin arama yapar
      And sonuclarin Nutella icerdigini test eder
      And sayfayi kapatir


@java
    Scenario: TC01 kullanici Amazonda Java aratir
      Given kullanici Amazon sayfasinda
      Then kullanici Java icin arama yapar
      And sonuclarin Java icerdigini test eder
      And sayfayi kapatir

  @iphone
  Scenario: TC03 kullanici Amazonda iphone aratir
    Given kullanici Amazon sayfasinda
    Then kullanici iphone icin arama yapar
    And sonuclarin iphone icerdigini test eder
    And sayfayi kapatir
