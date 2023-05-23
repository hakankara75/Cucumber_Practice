@tumu
  Feature: US001 Amazon sayfasına login olur

    Scenario: Kullanıcı Amazon sayfasına login yapar
      Given kullanici "amazonUrl" sayfasinda
      Then Kullanıcı Sign In menüsünü tıklar
      And Kullanıcı email kutusuna mail girer
      Then Kullanıcı continue butonunu tıklar
      And Kullanıcı password kutusuna password girer
      Then Kullanıcı Sign In butonunu tıklar