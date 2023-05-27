@mynet
  Feature: Mynet sitesi
    Scenario: TC01 Mynet sitesi
      Given kullanici "https://www.mynet.com/" sitesine gider
      Then kullanici egitim linkini tiklar
      And 7 saniye bekle
      And yeni acilan sayfaya gecis yapar
      Then yeni sayfaya gectigini dogrular
      And universite taban puanlarina kadar sayfayi asagi goruturur
      And 3 saniye bekle
      Then sayisal bolumlerin taban puanlari linkine tiklar
      And 3 saniye bekle
      And acilan sayfanin "Sayısal Bölümler" icerdigini dogrular
      And 3 saniye bekle
      Then tip linkini tiklar
      And 3 saniye bekle
      And sayfa basliginda "Tıp" oldugunu dogrular
      And testi bitirir



