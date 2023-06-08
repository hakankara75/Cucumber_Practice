@hakan3
Feature: US01 Cok satan edebiyat kitapları
#  Background: Kullanici Kitap Yurdu Sayfasina Gider
#    Given Kullanici "url" e gider
#    Then giris yap linkini tiklar
#    And eposta kutusuna mailini girer
#    And sifre kutusuna sifresini girer
#    And giris yap butonunu tiklar

  Scenario Outline: TC03 Zaman Araligi dropdown  testi
    Given Kullanici "url" e gider
    Then kullanici cok satan kitaplar menusu ustune gelir
    And 3 saniye bekleme yapar
    And cok satan edebiyat kitaplari linkini tiklar
    Given kullanici zaman araligi dropdown'inin secilebilir oldugunu dogrular
    And 1 saniye bekleme yapar
    And  kullanici zaman araligi dropdown'inindan "<secenek>" seceneklerini sirayla secer
    Then kullanici secim sonucunda kitaplarin degistigini dogrular
    Examples:
      | secenek  |
      | Haftalık |
      | Aylık    |
      | Yıllık   |
