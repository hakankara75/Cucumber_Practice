@PozitifSenaryo
Feature: DeanGuncelleme_Silme

  Background: Admin Girisi
    Given Admin olarak "url" adresine gider
    Then Admin olarak Login ikonunu tiklar
    And Admin olarak username kutusununa "username" girer
    And Admin olarak password kutusuna "password" girer
    And Admin olarak Login butonunu tiklar
    And Admin olarak Menu butonuna basar
    And Admin olarak Dean Management linkini tiklar


  Scenario Outline: US04 Admin Dean valid deger ile Dean ekleyebilmeli
    Given Admin Add Dean Management bolumunu gorur
    And Admin Name kutusuna "<name>" girer
    Then Admin Surname kutusuna "<surname>" girer
    Then Admin Birth Place kutusuna "<birthplace>"  girer
    Then Admin Gender radio'sundan gender secer
    Then Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    Then Admin Phone kutusuna "<phone>" girer
    Then Admin SSN kutusuna ucuncu ve besinci rakamdan sonra (-) içeren dokuz rakamdan olusan "<ssn>" girer
    Then Admin User Name kutusuna "<username>" girer
    Then Admin Password kutusuna en az sekiz karakterden olusan "<password>" girer
    And Admin Submit butonuna basar
    And Admin girdiği verileri kaydeder
    Examples:
      | name     | surname | birthplace | dateofbirth | phone        | ssn         | username    | password |
      | abaturib | akara   | ardahan    | 01/01/2001  | 214-318-1513 | 115-91-3517 | 1baturDeane | 12345678 |