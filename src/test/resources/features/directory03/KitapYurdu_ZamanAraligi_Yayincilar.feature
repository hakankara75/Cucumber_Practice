@yayimcilar
  Feature: KitapYurdu Cok Satan Edebiyat Kitaplari Yayincilar
    Scenario: TC04 KitapYurdu Cok Satan Edebiyat Kitaplari Yayincilar Secme
      Given Kullanici "url" e gider
      Then kullanici cok satan kitaplar menusu ustune gelir
      And 3 saniye bekleme yapar
      And cok satan edebiyat kitaplari linkine sol klik yapar
      Then kullanici yayinci kategorisinden yayimevlerini sirayla secer
      And kullanici sectigi yayimciya gore goruntulenen kitaplarin degistigini dogrular
      And kullanici goruntulenen kitaplarin sectigi yayimcinin kitaplari oldugunu dogrular
