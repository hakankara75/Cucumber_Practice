@db05
Feature: Admin Deanleri Gorebilmeli Guncelleyebilmeli Silebilmeli
Scenario Outline: Dean Bilgilerini Gorme
  Given "<username>" ile dean'i cagir
  Then Dean bodysi "<name>" "<surname>" "<birthPlace>" "<gender>" "<dateOfBirth>" "<phone>" "<ssn>" "<username>" dogrulanir
  Examples:
    | name     | surname | birthPlace | dateOfBirth | gender | phone        | ssn         | username    |
    | abaturib | akara   | ardahan    | 2001-01-01  | 0      | 214-318-1513 | 115-91-3517 | 1baturDeane |
    | HAKAN    | KARA    | ardahan    | 1222-11-22  | 0      | 131-544-5555 | 234-33-3457 | deanhakan5  |



