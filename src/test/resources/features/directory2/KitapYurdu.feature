@kitapyurdu
Feature: US001 Kitapyurdu sayfasına login olur

  Scenario: Kullanıcı Kitapyurdu sayfasına gider
    Given kullanici "kitapYurdu" sayfasinda
    Then Kullanıcı cok satan kitaplar menusu ustune gider
    And Kullanıcı cok satan edebiyat kitaplari menusunu tiklar
    Then Kullanıcı 20 dropdown'indan 100 urun ayni anda goruntulenmesini secer tıklar
    And Kullanıcı varsayilan dropdown'indan ucuzdan pahaliya secenegini secer
    Then Kullanıcı sayfadaki ilk urunun fiyatinin son urunun fiyatindan dusuk oldugunu dogrular