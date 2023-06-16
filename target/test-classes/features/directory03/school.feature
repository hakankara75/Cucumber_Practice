@e2e
Feature: School Management
    Background: Kullanici siteye gider
Given Kullanici "url" adresine gider
Then Kullanici Login ikonunu tiklar
And Kullanici "username" girer
And Kullanici "password" girer
And Kullanici Login butonunu tiklar
And Kullanici Menu butonunu tiklar

Scenario: Admin, Dean'leri görebilmeli ve silebilmeli
    Given Admin "url" adresine gider
    When Login iconunu tiklar
    Then Admin rolu ile username ve password girer
    And Login butonunu tiklar
    And Admin sayfasi acilir
    Then Admin menu butonunu tiklar
    And Dean Management menusunu tiklar
    And Dean Management sayfasi acilir
    And Admin Dean List'i gorur
    And Admin Name bilgilerini gorur
    And Admin Gender bilgilerini gorur
    And Admin Phone Number bilgilerini gorur
    And Admin SSN bilgilerini gorur
    And Admin User Name bilgilerini gorur
    And Admin Delete butonunu gorur
    And Admin Delete butonuna basarak Dean siler
    And Admin Edit butonunu gorur

