
@PozitifSenaryo
Feature: DeanGuncelleme_Silme
  Background: Admin Girisi
  Scenario: Admin Girisi
    Given Admin "url" adresine gider
    Then Kullanici Login ikonunu tiklar
    And Kullanici username kutusununa "username" girer
    And Kullanici password kutusuna "password" girer
    And Kullanici Login butonunu tiklar
    And Kullanici Menu butonunu tiklar
    And Admin Dean Management sayfasına gider

@senaryo1

  Scenario Outline: US04 Admin Dean ekleyebilmeli
    Given Admin Add Dean Management bolumunu gorur
    Then Admin Name kutusuna "<name>" girer
    When Admin Name kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Surname kutusuna "<surname>" girer
    When Admin Surnamekutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Birth Place kutusuna "<birthplace>"  girer
    When Admin Birth Place kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Gender radio'sundan gender secer
    When Admin Gender radio'sunu bos biraktiginda "You have entered an invalid value. Valid values are: MALE, FEMALE" uyarisini gorur
    Then Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    When Admin Date Of Birth kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Phone kutusuna "<phone>" girer
    When Admin Phonekutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin SSN kutusuna 3. ve 5. rakamdan sonra "-" içeren 9 rakamdan olusan "<ssn>" girer
    When Admin SSN kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin User Name kutusuna "<username>" girer
    When Admin User Name kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Password kutusuna en az 8 karakterden olusan "<password>" girer
    When Admin Password kutusunu bos biraktiginda "Required" uyarisini gorur
    And Admin Password olarak büyük harf, küçük harf ve bir rakam içeren deger girer
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


  @senaryo2

  Scenario Outline: US04 Admin Dean ekleyebilmeli
    Given Admin Add Dean Management bolumunu gorur
    Then Admin Name kutusuna "<name>" girer
    When Admin Name kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Surname kutusuna "<surname>" girer
    When Admin Surnamekutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Birth Place kutusuna "<birthplace>"  girer
    When Admin Birth Place kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Gender radio'sundan gender secer
    When Admin Gender radio'sunu bos biraktiginda "You have entered an invalid value. Valid values are: MALE, FEMALE" uyarisini gorur
    Then Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    When Admin Date Of Birth kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Phone kutusuna "<phone>" girer
    When Admin Phonekutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin SSN kutusuna 3. ve 5. rakamdan sonra "-" içeren 9 rakamdan olusan "<ssn>" girer
    When Admin SSN kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin User Name kutusuna "<username>" girer
    When Admin User Name kutusunu bos biraktiginda "Required" uyarisini gorur
    When Admin Password kutusunu bos biraktiginda "Required" uyarisini gorur
    And Admin Password olarak büyük harf, küçük harf ve bir rakam içeren "<password>" girer
    And Admin Submit butonuna basar
    And Admin girdiği verileri kaydeder
    Examples:
      | name    | surname | birthplace | dateofbirth | phone        | ssn         | username  | password |
      | hartabu | kara    | ardahan    | 01/01/2001  | 254-358-1151 | 257-11-3657 | hartabu | 123456Aa |

