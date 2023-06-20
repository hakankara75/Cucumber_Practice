@US01_DBTest
  Feature: Aday öğrenciler sisteme kayıt olabilirler. DB

    Scenario Outline: US01_GuestUser_Validation
      Given "<username>" ile guest useri cagir
      Then body sunları icermeli: "<name>", "<surename>", "<birtplace>", "<phone>", "<gender>", "<dateofbirth>","<ssn>", "<username>", "<password>"
      Examples:
        | username | name | surename | birtplace | phone | gender | dateofbirth | ssn | password |
        | john129  | John | Doe     | Ankara     | 333-555-1234 | 0      | 2023-06-01    | 333-66-0987 | John.123 |


  #Loop Deneme Scenariosu
  @LoopDB
  Scenario: Loop Deneme Scenariosu
    Given birthplace "batch129" ile quest useri cagir
    Then kac tane user oldugunu bul


    @DBNegative
    Scenario: Silinen guest useri dogrula
      Given silinen "alican129" ile guest useri cagir
      Then tablein bos oldugunu dogrula









