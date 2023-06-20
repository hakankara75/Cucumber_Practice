Feature: Gender Bos Birakma

  @TekDegerGirme
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