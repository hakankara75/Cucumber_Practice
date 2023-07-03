@login
Feature: Admin Deanleri Gorebilmeli Guncelleyebilmeli Silebilmeli

  Background: Admin Girisi
    Given Admin olarak "url" adresine gider
    Then Admin olarak Login ikonunu tiklar
    And Admin olarak username kutusununa "username" girer
    And Admin olarak password kutusuna "password" girer
    And Admin olarak Login butonunu tiklar
    And Admin olarak Menu butonuna basar
    And Admin olarak Dean Management linkini tiklar

  @DeleteButonu
  Scenario: US05 Admin, Dean leri görebilmeli ve silebilmeli
    Given Admin Dean List'i gorur
    And Admin Name bilgilerini gorur
    And Admin Gender bilgilerini gorur
    And Admin Phone bilgilerini gorur
    And Admin SSN bilgilerini gorur
    And Admin User Name bilgilerini gorur
    And Admin Delete butonunu gorur
    And Admin Delete butonuna basar

  @CinsiyetBilgisi
  Scenario: US05 Admin, Dean leri guncelleyebilmeli(1)
    Given Admin Dean List'i gorur
    And Admin Edit butonunu gorur
    And Admin Edit butonuna basar
    And Admin Edit Dean penceresini gorur
    And Admin degistirmek istedigi ismi Name kutusunda gorur
    And Admin degistirmek istedigi soyadi Surname kutusunda gorur
    And Admin degistirmek istedigi dogum yerini Birth Place kutusunda gorur
    And Admin degistirmek istedigi cinsiyeti Gender checkbox'inda gorur

  @Password
  Scenario: US05 Admin, Dean leri guncelleyebilmeli(2)
    Given Admin Dean List'i gorur
    And Admin Edit butonunu gorur
    And Admin Edit butonuna basar
    And Admin Edit Dean penceresini gorur
    And Admin degistirmek istedigi ismi Name kutusunda gorur
    And Admin degistirmek istedigi soyadi Surname kutusunda gorur
    And Admin degistirmek istedigi dogum yerini Birth Place kutusunda gorur
    And Admin degistirmek istedigi dogum tarihini Date Of Birth kutusunda gorur
    And Admin degistirmek istedigi telefon numarasini Phone kutusunda gorur
    And Admin degistirmek istedigi ssn bilgisini SSN kutusunda gorur
    And Admin degistirmek istedigi username'i User Name kutusunda gorur
    And Admin degistirmek istedigi password'u Password kutusunda gorur

  @Submit
  Scenario: US05 Admin, Dean leri guncelleyebilmeli(3)
    Given Admin Dean List'i gorur
    And Admin Edit butonunu gorur
    And Admin Edit butonuna basar
    And Admin Edit Dean penceresini gorur
    And Admin degistirmek istedigi ismi Name kutusunda gorur
    And Admin degistirmek istedigi soyadi Surname kutusunda gorur
    And Admin degistirmek istedigi dogum yerini Birth Place kutusunda gorur
    And Admin degistirmek istedigi dogum tarihini Date Of Birth kutusunda gorur
    And Admin degistirmek istedigi telefon numarasini Phone kutusunda gorur
    And Admin degistirmek istedigi ssn bilgisini SSN kutusunda gorur
    And Admin degistirmek istedigi username'i User Name kutusunda gorur
    And Admin Submit butonunu gorur
    And Admin Submit butonuna tiklar
    And Admin kayit yapar
