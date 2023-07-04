@US05Api @Admin
Feature:Admin Dean bilgilerini gorebilmeli

  Scenario Outline:US05 Admin Dean'lerin Name, Gender, Phone Number, SSN, User Name bilgilerini görebilmeli
    Given Admin Tum Dean bilgilerini cagirir
    Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<dateOfBirth>" "<gender>"  "<phone>" "<ssn>" "<username>" API ile dogrulanir
    Examples:
      | name     | surname | birthPlace | dateOfBirth | gender | phone        | ssn         | username    |
      | abaturib | akara   | ardahan    | 2001-01-01  | MALE   | 214-318-1513 | 115-91-3517 | 1baturDeane |
      | HAKAN    | KARA    | ardahan    | 1222-11-22  | MALE   | 131-544-5555 | 234-33-3457 | deanhakan5  |

@US04Api @Admin
  Scenario Outline:US04 Admin Dean ekleyebilmeli
    Given Admin Tum Dean bilgilerini post request yapar
    Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<birthDay>" "<gender>"  "<phoneNumber>" "<ssn>" "<username>" "<password>" API ile dogrulanir
    Examples:
      | name    | surname | birthPlace | birthDay   | gender | phoneNumber  | ssn         | username    | password |
      | hakanii | akara   | ardahan    | 2001-01-01 | MALE   | 114-318-1113 | 114-11-3516 | hbaturDeane | 12345678 |