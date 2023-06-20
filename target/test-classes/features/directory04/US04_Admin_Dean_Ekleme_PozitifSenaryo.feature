
@PozitifSenaryo
Feature: DeanGuncelleme_Silme
  Background: Admin Girisi
    Given Admin "url" adresine gider
    Then Kullanici Login ikonunu tiklar
    And Kullanici username kutusununa "username" girer
    And Kullanici password kutusuna "password" girer
    And Kullanici Login butonunu tiklar
    And Kullanici Menu butonunu tiklar
    And Admin Dean Management sayfasına gider



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
      | name  | surname | birthplace | dateofbirth | phone        | ssn         | username  | password |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      |       | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur |         | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    |            | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | ardahan    |             | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  |              | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 |             | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 |           | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean |          |



