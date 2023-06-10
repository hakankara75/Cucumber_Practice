@hakan
Feature: US01 Cok satan edebiyat kitapları


  Background: Kullanici Kitap Yurdu Sayfasina Gider
    Given Kullanici "url" e gider
    Then giris yap linkini tiklar
    And eposta kutusuna mailini girer
    And sifre kutusuna sifresini girer
    And giris yap butonunu tiklar


  Scenario: TC01 cok satan edebiyat kitaplari sayfasi testi
    Given kullanici cok satan kitaplar menusu ustune gelir
    Then Sayfanin resmini ceker
    Given Kullanici "url" e gider
    Then Sayfanin resmini ceker
    Given kullanici cok satan kitaplar menusu ustune gelir
    And 3 saniye bekleme yapar
    Then acilan menude cok satan edebiyat kitaplari linki oldugunu dogrular
    And 1 saniye bekleme yapar
    And cok satan edebiyat kitaplari linkini tiklar
    And 1 saniye bekleme yapar
    When kullanici cok satan edebiyat kitaplari sayfasinda oldugunu dogrular
    And 1 saniye bekleme yapar
    And edebiyat butonunun secilmis oldugunu dogrular
    Then edebiyat butonunun resmini ceker
    And 1 saniye bekleme yapar
    And satista olanlar checkboxinin secili oldugunu dogrular
    And 1 saniye bekleme yapar
    Then yirmi urun dropdownina tiklar
    And 1 saniye bekleme yapar
    And yuz urunu secer
    And 1 saniye bekleme yapar
    And yuz urun seceneginin secildigini dogrular
    And 1 saniye bekleme yapar
    And sayfada yuz urun gorundugunu dogrular









