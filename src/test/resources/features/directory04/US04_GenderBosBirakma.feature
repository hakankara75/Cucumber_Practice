Feature: Gender Bos Birakma
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