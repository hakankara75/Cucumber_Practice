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
      | no | name |  | surname | birthPlace | birthDay | gender | phoneNumber | ssn | username | password |
      | 1  |      |  | surname | birthPlace | birthDay | gender | phoneNumber | ssn | username | password |
      | 2  | name |  |         | birthPlace | birthDay | gender | phoneNumber | ssn | username | password |
      | 3  | name |  | surname |            | birthDay | gender | phoneNumber | ssn | username | password |
      | 4  | name |  | surname | birthPlace | birthDay |        | phoneNumber | ssn | username | password |
      | 5  | name |  | surname | birthPlace |          | gender | phoneNumber | ssn | username | password |
      | 6  | name |  | surname | birthPlace | birthDay | gender |             | ssn | username | password |
      | 7  | name |  | surname | birthPlace | birthDay | gender | phoneNumber |     | username | password |
      | 8  | name |  | surname | birthPlace | birthDay | gender | phoneNumber | ssn |          | password |
      | 9  | name |  | surname | birthPlace | birthDay | gender | phoneNumber | ssn |          |          |