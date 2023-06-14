@e2e
Feature: School Management
Scenario: Admin, Dean'leri görebilmeli ve silebilmeli
    Given Admin "url" adresine gider
    When Login iconunu tiklar
    Then Admin rolu ile username ve password girer
    And Login butonunu tiklar
    And Admin sayfasi acilir
    Then Admin menu butonunu tiklar
    And Dean Management menusunu tiklar
    And Dean Management sayfasi acilir
    And Admin Dean List'i görebilmeli
    And Admin Name bilgilerini görebilmeli
    And Admin Gender bilgilerini görebilmeli
    And Admin Phone Number bilgilerini görebilmeli
    And Admin SSN bilgilerini görebilmeli
    And Admin User Name bilgilerini görebilmeli
    And Admin Delete butonunu görmeli
    And Admin Delete butonuna basarak Dean silebilmeli
    And Admin Edit butonunu görmeli

