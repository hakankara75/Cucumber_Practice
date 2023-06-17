@login
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

  Scenario: US05 Admin, Dean leri görebilmeli ve silebilmeli
    Given And Admin Dean List'i gorur
    And Admin Name bilgilerini gorur
    And Admin Gender bilgilerini gorur
    And Admin Phone bilgilerini gorur
    And Admin SSN bilgilerini gorur
    And Admin User Name bilgilerini gorur
    And Admin Delete butonunu gorur
    And Admin Delete butonuna basar
    And Admin Dean List'i gorur
    And Admin Edit butonunu gorur
    And Admin Edit butonuna basar
    And Admin Edit Dean penceresini gorur
    And Admin degistirmek istedigi ismi Name kutusunda gorur
    And Admin degistirmek istedigi soyadi Surname kutusunda gorur
    And Admin degistirmek istedigi dogum yerini Birth Place kutusunda gorur
    And Admin degistirmek istedigi cinsiyeti Gender checkbox'inda gorur
    And Admin degistirmek istedigi dogum tarihini Date Of Birth kutusunda gorur
    And Admin degistirmek istedigi telefon numarasini Phone kutusunda gorur
    And Admin degistirmek istedigi ssn bilgisini SSN kutusunda gorur
    And Admin degistirmek istedigi username'i User Name kutusunda gorur
    And Admin degistirmek istedigi password'u Password kutusunda gorur
    And Admin Submit butonunu gorur
    And Admin Submit butonuna tiklar
    And Admin Submit butonuna tiklar
