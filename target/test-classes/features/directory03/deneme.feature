@deneme
Feature: US01 Cok satan edebiyat kitapları
  Scenario: Kullanici Kitap Yurdu Sayfasina Gider
    Given Kullanici "url" e gider
    Then kullanici cok satan kitaplar menusu ustune gelir
    And 3 saniye bekleme yapar
    And cok satan edebiyat kitaplari linkini tiklar
    Then kullanici yayinci kategorisinden yayimevlerini secer