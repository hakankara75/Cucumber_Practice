

@BosBirakmaSenaryosu
Feature: Bos Veri Girisi

  Scenario: US04 Admin bos veri gonderince Dean ekleyememeli
Given Admin Add Dean Management bolumunu gorur
When Admin Name kutusunu bos biraktiginda uyarı yazısını gorur
Then Admin  Surname  kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Birth Place  kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Date Of Birth  kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Phone  kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Ssn  kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Username kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Password kutusunu bos biraktiginda uyarı yazısını gorur
And Admin Submit butonuna basar
And Admin girdiği verileri kaydeder


  @EksikDegerGirme
Feature:Eksik Deger Girme
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
      | name   | surname | birthplace | dateofbirth | phone        | ssn           | username    | password |
      | batura | kara    | ardahan    | 01/01/2001  | 254.358.6951 | 257-95-3657   | qbaturDeana | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254A358A6951 | 257-95-3657   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  |              | 257-95-3657   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257.95.3657   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 111 111 1254 | 257_95_3657   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257 95 3657   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-365    | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 257-95-365711 | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 25-795-26518  | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 25-795-6518   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | AAA-AA-AAAA   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | ???-??-????   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-??-5187   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-AAAA   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543A45A5643   | baturDean   | 12345678 |
      | b      | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   |          |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 2        |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | AAAAAAAA |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 123456Aa |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 123456AA |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 123456aa |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 123456?? |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 12345678 |
      | batur  | kara    | ardahan    | 01/01/2001  | 254-358-6951 | 543-45-5603   | baturDean   | 123456   |


  @GenderBosBirakma
Feature: Gender Bos Birakma

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
Feature: Gender Bos Birakma ve Diger Alanlara Eksik Deger Girme
  Scenario Outline: US04 Gender Bos Gecme
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