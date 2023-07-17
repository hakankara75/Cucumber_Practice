@US04_Edit
Feature: Edit
Scenario: TC04_Admin_Deanleri_Guncelleyebilmelidir
Given kullanıcı managementschool proje sayfasına gider
And kullanıcı sayfada login butonuna tiklar
And Kullanici Kayitli Username Bilgileri Ile Login Olur
When Kullanici Kayitli Password Bilgileri Ile Login Olur
And kullanici login butonuna tiklayarak sisteme giris yapar
And Kullanici Menu Butonuna Tiklar
And Kullanici Gelen Menuden Dean Management Menusune Tiklar
And Kullanici Dean List 'ini gorur
And Kullanici Sayfada Edit Butonuna Tiklar
And Kullanici Name Alanina Editlenecek Ismi Yazar
And Kullanici SurName Alanina Editlenecek Soyismi Yazar
And Kullanici BirthPlace Alanina Editlenecek BirthPlacei Yazar
And Kullanici Gender Alanina Editlenecek Gender Secenegini Secer
And Kullanici Date Of Birth Alanina Editlenecek Date Of Birthi Yazar
And Kullanici Phone Alanina Editlenecek Phone u Yazar
And Kullanici SSN Alanina Editlenecek SSN Numarasini Yazar
And Kullanici User Name Alanina Editlenecek Ismi Yazar
And Kullanici Password Alanina Editlenecek Parola Yazar
And Kullanici Submit Butonuna Tiklayarak KayitLari Onaylar
Then Kullanici driver'i kapatir