@db05
Feature: Admin Deanleri Gorebilmeli Guncelleyebilmeli Silebilmeli
Scenario Outline: Dean Bilgilerini Gorme
  Given "<username>" ile dean'i cagir
  Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<gender>" "<dateOfBirth>" "<phone>" "<ssn>" "<username>" dogrulanir
  Examples:
    | name     | surname | birthPlace | dateOfBirth | gender | phone        | ssn         | username         |
    | abaturib | akara   | ardahan    | 2001-01-01  | 0      | 214-318-1513 | 115-91-3517 | 1baturDeane      |
    | HAKAN    | KARA    | ardahan    | 2001-11-11  | 0      | 124-658-9856 | 784-37-3777 | Team10hakanBatur |
    | Lakisha  | Waters  | ardahan    | 2001-01-01  | 0      | 376-042-8045 | 825-46-6647 | stanley.weimann  |



