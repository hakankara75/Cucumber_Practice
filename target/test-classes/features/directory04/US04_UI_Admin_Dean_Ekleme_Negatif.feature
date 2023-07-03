Feature: Bos Veri Girisi

  Background: Admin Girisi
    Given Admin olarak "manageUrl" adresine gider
    Then Admin olarak Login ikonunu tiklar
    And Admin olarak username kutusununa "username" girer
    And Admin olarak password kutusuna "password" girer
    And Admin olarak Login butonunu tiklar
    And Admin olarak Menu butonuna basar
    And Admin olarak Dean Management linkini tiklar

  @BosBirakmaSenaryosu
  Scenario: US04 Admin bos veri gonderince Dean ekleyememeli
    Given Admin Add Dean Management bolumunu gorur
    When Admin Name kutusunu bos biraktiginda uyari yazisini gorur
    Then Admin  Surname  kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Birth Place  kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Date Of Birth  kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Phone  kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Ssn  kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Username kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Password kutusunu bos biraktiginda uyari yazisini gorur
    And Admin Submit butonuna basar
    And Admin girdiği verileri kaydeder

  @TelefonaYanlisDegerGirme

  Scenario Outline: US04 Eksik Deger Girme
    Given Admin Add Dean Management bolumunu gorur
    And Admin Name kutusuna "<name>" girer
    And Admin Surname kutusuna "<surname>" girer
    And Admin Birth Place kutusuna "<birthplace>"  girer
    And Admin Gender radio'sundan gender secer
    And Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    And Admin Phone kutusuna "<phone>" girer
    And Admin SSN kutusuna ucuncu ve besinci rakamdan sonra (-) içeren dokuz rakamdan olusan "<ssn>" girer
    And Admin User Name kutusuna "<username>" girer
    And Admin Password kutusuna en az sekiz karakterden olusan "<password>" girer
    And Admin Submit butonuna basar
    Then Admin kayit yapamadigini dogrular
    Examples:
      | name    | surname | birthplace | dateofbirth | phone        | ssn         | username | password |
      | fghdfmh | kara    | ardahan    | 01/01/2001  | 654.411.6651 | 214-95-1664 | feekfd   | 12345678 |

  @EksikDegerGirme

  Scenario Outline: US04 Eksik Deger Girme
    Given Admin Add Dean Management bolumunu gorur
    And Admin Name kutusuna "<name>" girer
    And Admin Surname kutusuna "<surname>" girer
    And Admin Birth Place kutusuna "<birthplace>"  girer
    And Admin Gender radio'sundan gender secer
    And Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    And Admin Phone kutusuna "<phone>" girer
    And Admin SSN kutusuna ucuncu ve besinci rakamdan sonra (-) içeren dokuz rakamdan olusan "<ssn>" girer
    And Admin User Name kutusuna "<username>" girer
    And Admin Password kutusuna en az sekiz karakterden olusan "<password>" girer
    And Admin Submit butonuna basar
    Then Admin kayit yapamadigini dogrular
    Examples:
      | name  | surname | birthplace | dateofbirth | phone         | ssn           | username     | password |
      | batur | kara    | ardahan    | 01/01/2001  | 254A358A6951  | 217-95-3657   | aseeeesgfds  | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  |               | 257-92-3657   | asdffdgfds   | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 214-351-6951  | 257.45.3657   | assffdgfds   | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 111 131 1257  | 257_95_3407   | asdfAfgds    | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-378-6771  | 257 95 3097   | asloıfds     | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 288-318-6951  | 257-95-315    | asdfgpgfds   | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 234-398-6901  | 257-95-315711 | asdffdgfdsmk | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 204-358-0051  | 25-785-26518  | asdrtfdgfds  | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 250-358-6951  | 25-795-6118   | asdfuyfds    | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-350-69500 | AAA-AA-AAAA   | asdffwfdser  | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-398-9951  | ???-??-????   | asdwscfds    | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 299-358-9951  | 543-??-5187   | astergfds    | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 954-398-6951  | 543-45-AAAA   | asuycdsadf   | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-888-6999  | 543A45A5643   | aspovfdsa    | 12345678 |
      | b     | kara    | ardahan    | 01/01/2001  | 884-378-6951  | 543-45-5603   | fgtdvfdsaa   | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-7777  | 543-45-5603   | ustdvfdsa    |          |
      | batur | kara    | ardahan    | 01/01/2001  | 777-358-6951  | 543-45-5603   | fgtdvftuq    | 2        |
      | batur | kara    | ardahan    | 01/01/2001  | 234-8766-6951 | 543-45-5603   | fgtdvfdsoo   | AAAAAAAA |
      | batur | kara    | ardahan    | 01/01/2001  | 154-358-6151  | 543-45-5603   | olptdvfdse   | 123456Aa |
      | batur | kara    | ardahan    | 01/01/2001  | 004-358-6951  | 543-45-5603   | olpnmlvfds   | 123456AA |
      | batur | kara    | ardahan    | 01/01/2001  | 254-000-6951  | 543-45-5603   | olpxdslvfds  | 123456aa |
      | batur | kara    | ardahan    | 01/01/2001  | 832-358-6951  | 543-45-5603   | apnmlvfdse   | 123456?? |
      | batur | kara    | ardahan    | 01/01/2001  | 270-308-6951  | 543-45-5603   | zafgdgfdf    | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 259-318-0000  | 543-45-5603   | xfgruyetrg   | 123456   |


  @GenderBosBirakma
  Scenario Outline: US04 Gender Bos Gecme
    Given Admin Add Dean Management bolumunu gorur
    Then Admin Name kutusuna "<name>" girer
    Then Admin Surname kutusuna "<surname>" girer
    Then Admin Birth Place kutusuna "<birthplace>"  girer
    Then Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    Then Admin Phone kutusuna "<phone>" girer
    Then Admin SSN kutusuna ucuncu ve besinci rakamdan sonra (-) içeren dokuz rakamdan olusan "<ssn>" girer
    Then Admin User Name kutusuna "<username>" girer
    Then Admin Password kutusuna en az sekiz karakterden olusan "<password>" girer
    And Admin Submit butonuna basar
    And Admin Gender radio'sunu bos biraktiginda "You have entered an invalid value. Valid values are: MALE, FEMALE" uyarisini gorur
    Examples:
      | name  | surname | birthplace | dateofbirth | phone        | ssn         | username  | password |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |


  @TekDegerGirme

  Scenario Outline: US04 Tek Deger Girme
    Given Admin Add Dean Management bolumunu gorur
    And Admin Name kutusuna "<name>" girer
    And Admin Surname kutusuna "<surname>" girer
    And Admin Birth Place kutusuna "<birthplace>"  girer
    And Admin Gender radio'sundan gender secer
    And Admin Date Of Birth kutusuna "<dateofbirth>"  girer
    And Admin Phone kutusuna "<phone>" girer
    And Admin SSN kutusuna ucuncu ve besinci rakamdan sonra (-) içeren dokuz rakamdan olusan "<ssn>" girer
    And Admin User Name kutusuna "<username>" girer
    And Admin Password kutusuna en az sekiz karakterden olusan "<password>" girer
    And Admin Submit butonuna basar
    Then Admin kayit yapamadigini dogrular
    Examples:
      | name  | surname | birthplace | dateofbirth | phone        | ssn         | username  | password |
      | a     | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | a       | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | a          | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/0001  | 254-358-6951 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 111 111 1254 | 257-95-3657 | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 25795113657 | baturDean | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | bat       | 12345678 |
      | batur | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-3657 | baturDean | 1234567  |

  @BosDegerGonderme
  Scenario Outline: US04 Admin bos  deger gondererek Dean ekleyememeli
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
    And Admin eksik giris ile kayit yapamadigini dogrular
    Examples:
      | name   | surname | birthplace | dateofbirth | phone        | ssn         | username   | password |
      |        | kara    | ardahan    | 01/01/2001  | 154-358-6951 | 257-95-3657 | baturDean2 | 12345678 |
      | baturi |         | ardahan    | 01/01/2001  | 224-358-6351 | 257-95-3657 | baturDean3 | 12345678 |
      | baturi | kara    |            | 01/01/2001  | 251-358-6451 | 257-95-3657 | baturDean4 | 12345678 |
      | baturi | kara    | ardahan    |             | 254-158-6751 | 257-95-3657 | baturDean5 | 12345678 |
      | baturi | kara    | ardahan    | 01/01/2001  |              | 257-95-3657 | baturDean6 | 12345678 |
      | baturi | kara    | ardahan    | 01/01/2001  | 254-352-6431 |             | baturDean7 | 12345678 |
      | baturi | kara    | ardahan    | 01/01/2001  | 214-358-1251 | 257-95-3657 |            | 12345678 |
      | baturi | kara    | ardahan    | 01/01/2001  | 252-352-6211 | 257-95-3657 | baturDean8 |          |