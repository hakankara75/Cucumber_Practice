
@login2
Feature: DeanGuncelleme_Silme
  Background: Admin Girisi
  Scenario: Admin Girisi
    Given Admin "url" adresine gider
    Then Kullanici Login ikonunu tiklar
    And Kullanici username kutusununa "username" girer
    And Kullanici password kutusuna "password" girer
    And Kullanici Login butonunu tiklar
    And Kullanici Menu butonunu tiklar
    And Admin Dean Management sayfasına gider

  Scenario: US04 Admin Dean ekleyebilmeli
    Given Admin Add Dean bolumunu gorur
    Then Admin Name kutusuna deger girer
    When Admin Name kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Surname kutusuna deger girer
    When Admin Surnamekutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Birth Place kutusuna deger girer
    When Admin Birth Place kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Cinsiyet checkbox'indan deger secer
    When Admin Cinsiyet kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Date Of Birth kutusuna deger girer
    When Admin Date Of Birth kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Phone kutusuna deger girer
    When Admin Phonekutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin SSN kutusuna 3. ve 5. rakamdan sonra "-" içeren 9 rakamdan olusan deger girer
    When Admin SSN kutusunu bos biraktiginda "Required" uyarisini gorur
    And Admin SSN kutusunu invalid deger girer
    Then Admin User Name kutusuna deger girer
    When Admin User Name kutusunu bos biraktiginda "Required" uyarisini gorur
    Then Admin Password kutusuna deger girer
    When Admin  Password kutusuna 7 karakter girince "Minimum 8 character" uyarisini gorur
    And Admin  Password kutusuna en az 8 karakterden olusan bir deger girer
    And Admin Password kutusuna buyuk harf iceren deger girer
    And Admin Password kutusuna kucuk harf iceren deger girer
    And Admin  Password kutusuna bir rakam iceren deger girer
    And Admin Password olarak büyük harf, küçük harf ve bir rakam içeren deger girer


