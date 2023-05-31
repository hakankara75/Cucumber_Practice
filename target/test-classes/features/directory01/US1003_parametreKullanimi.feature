
  # Bir Scenario olusturunuz

# kullanici amazon anasayfasinda
# kullanici "Nutella" icin arama yapar
# sonuclarin "Nutella" icerdigini test eder
# sayfayi kapatir

    Feature: US1003 kullanici parametre kullanarak arama yapabilmeli

      Scenario: TC06 kullanici parametre ile Amazonda arama yapar

        Given kullanici Amazon sayfasinda
        Then kullanici "Nutella" icin arama yapar
        And kullanici "Nutella" icerdigini test eder
        And sayfayi kapatir