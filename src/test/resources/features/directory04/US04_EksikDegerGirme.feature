Feature:Eksik Deger Girme

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