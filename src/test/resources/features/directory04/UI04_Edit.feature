@US04_Edit
Feature: Edit

  Background: Admin Girisi
    Given Admin olarak "url" adresine gider
    Then Admin olarak Login ikonunu tiklar
    And Admin olarak username kutusununa "username" girer
    And Admin olarak password kutusuna "password" girer
    And Admin olarak Login butonunu tiklar
    And Admin olarak Menu butonuna basar
    And Admin olarak Dean Management linkini tiklar

Scenario: TC04_Admin_Deanleri_Guncelleyebilmelidir
And Kullanici Dean List ini gorur
And Kullanici Sayfada Edit Butonuna Tiklar
And Kullanici Name Alanina Editlenecek ismi Yazar
And Kullanici SurName Alanina Editlenecek Soyismi Yazar
And Kullanici BirthPlace Alanina Editlenecek BirthPlacei Yazar
And Kullanici Gender Alanina Editlenecek Gender Secenegini Secer
And Kullanici Date Of Birth Alanina Editlenecek Date Of Birthi Yazar
And Kullanici Phone Alanina Editlenecek Phone u Yazar
And Kullanici SSN Alanina Editlenecek SSN Numarasini Yazar
And Kullanici User Name Alanina Editlenecek ismi Yazar
And Kullanici Password Alanina Editlenecek Parola Yazar
And Kullanici Submit Butonuna Tiklayarak KayitLari Onaylar
Then Kullanici driver'i kapatir