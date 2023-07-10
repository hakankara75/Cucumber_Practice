Feature:Admin Dean

  @US05Api @Admin
  Scenario Outline:US05 Admin Dean'lerin Name, Gender, Phone Number, SSN, User Name bilgilerini görebilmeli
    Given Admin Tum Dean bilgilerini cagirir
    Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>" API ile get yaparak dogrulanir
    Examples:
      | name     | surname | birthPlace | birthDay   | gender | phoneNumber  | ssn         | username    |
      | abaturib | akara   | ardahan    | 2001-01-01 | MALE   | 214-318-1513 | 115-91-3517 | 1baturDeane |
      | HAKAN    | KARA    | ardahan    | 1222-11-22 | MALE   | 131-544-5555 | 234-33-3457 | deanhakan5  |

  @US04ApiPost @Admin

  Scenario Outline: US04 Admin Dean ekleyebilmeli
    Given Admin Tum Dean bilgilerini post request yapar
    Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>" "<userId>"API ile dogrulanir
    Examples:
      | name      | surname | birthPlace | birthDay   | gender | phoneNumber  | ssn         | username | password | userId |
      | hakbaanis | akara   | ardahan    | 2001-01-01 | MALE   | 139-347-1113 | 164-77-3516 | hbature  | 12345678 |        |

  @US05ApiGet @Admin

  Scenario Outline: US05 Admin ekledigi Dean'i cagirabilir
    Given Admin Ekledigi Dean bilgilerine get request yapar
    Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>" API ile get yaparak dogrulanir
    Examples:
      | name   | surname | birthPlace | birthDay   | gender | phoneNumber  | ssn         | username | password |
      | bathak | kara    | ardahan    | 2000-11-11 | MALE   | 214-777-1153 | 142-77-4511 | bathak   | 12345678 |

  @US04ApiDelete @Admin

  Scenario Outline: US04 Admin  Dean'i sildigini dogrular
    Given Admin Silecegi Dean bilgilerini delete request yapar
    Then Silinen Dean bodysi "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>" "<userId>" API ile dogrulanir
    Examples:
      | name    | surname | birthPlace | birthDay   | gender | phoneNumber  | ssn         | username | password | userId |
      | hababis | akara   | ardahan    | 2001-01-01 | MALE   | 183-347-1113 | 834-77-3516 | hbatabbe | 12345678 |        |

  @US04ApiDeanEkleme @Admin

  Scenario Outline: US04 Admin  Dean'i bos veri gondererek kaydedemez
    Given Admin bos veri gondererek Dean eklemek icin request yapar
    Then Bos veri ile Dean bodysi "<no>" "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>" ekleyemedigi API ile dogrulanir
    Examples:
      | no | name      |  | surname      | birthPlace | birthDay | gender | phoneNumber      | ssn      | username      | password |
      | 1  |           |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |
      | 2  | fake.name |  |              | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |
      | 3  | fake.name |  | fake.surname |            | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |
      | 4  | fake.name |  | fake.surname | birthPlace | birthDay |        | fake.phoneNumber | fake.ssn | fake.username | password |
      | 5  | fake.name |  | fake.surname | birthPlace |          | gender | fake.phoneNumber | fake.ssn | fake.username | password |
      | 6  | fake.name |  | fake.surname | birthPlace | birthDay | gender |                  | fake.ssn | fake.username | password |
      | 7  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber |          | fake.username | password |
      | 8  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn |               | password |
      | 9  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username |          |

  @US04ApiSsnNegatif @Admin

  Scenario Outline: US04 Admin  Dean'i invalid Ssn gondererek kaydedemez
    Given Admin bos veri gondererek Dean eklemek icin request yapar
    Then Invalid Ssn degerli Dean bodysi "<no>" "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>"<userId>" ekleyemedigi API ile dogrulanir
    Examples:
      | no | name      |  | surname      | birthPlace | birthDay | gender | phoneNumber      | ssn      | username      | password | userId |
      | 1  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |
      | 2  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |
      | 3  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |
      | 4  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |
      | 5  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |
      | 6  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |
      | 7  | fake.name |  | fake.surname | birthPlace | birthDay | gender | fake.phoneNumber | fake.ssn | fake.username | password |        |