@twitter
Feature: Twitter
  Scenario: TC01 Twitter
    Given kullanici "twitter" sitesine gider
    Then kullanici giris yap tusuna basar
    And 3 saniye bekle
    And kullanici eposta kutusuna mail adresini girer
    And kullanici ileri tusuna basar
    And kullanici password kutusuna sifresini girer
    And kullanici sifre girisi sonrasi giris yap tusuna basar
    And kullanici ara tusuna basar
    And 3 saniye bekle
    And kullanici hastagleri alir
     And kullanici tweet at tusuna basar
    And 3 saniye bekle
    And kullanici tweetini yazar ve atar
    And 3 saniye bekle


