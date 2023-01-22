
Feature: DB_sorgulama

#Database baglantisi kurarak staff tablosundaki Id'lerin icinde "5" id numarasina sahip staff var mi kontrol ediniz?
#SELECT * FROM u480337000_tlb_training.staff;

  Scenario Outline: Staff tablosundan "ID" sorgulama

    * Database baglantisi kurulur.
    * Staff tablosundaki "id" leri listelenir.
    * Verilen "<id>" dogrulanir.
    * Database baglantisi kapatilir.

    Examples:
    |id|
    |5|


    #Bir yönetici olarak DataBase üzerinden kullanici telefon numaralarini
    # listeleyebilmeli ve istenen telefon numarasinin Users tablosunda olup
    # olmadigini dogrulayabilmeliyim

    Scenario Outline: Users tablosundan phone sorgulama

      * Database baglantisi kurulur.
      * Users tablosundaki "phone" numaralari listelenir.
      * Verilen "<phone>" numarasi dogrulanir.
      * Database baglantisi kapatilir.


      Examples:

      |phone|
      |+1 (922) 361-3194|



    #Bir yönetici olarak DataBase üzerinden kullanici email adreslerini
    # listeleyebilmeli ve istenen e_mail adresinin
    # Users tablosunda olup olmadigini dogrulayabilmeliyim
    #a@a.com



    Scenario Outline: Users tablosundan email sorgulama

      * Database baglantisi kurulur.
      * Users tablosundaki "email" 'ler listelenir.
      * Verilen "<email>" in listede oldugu dogrulanir.
      * Database baglantisi kapatilir.


      Examples:
     |email|
     |a@a.com|



    #Bir yönetici olarak DataBase üzerinden customer_addresses tablosundaki
    # istenen Customer'in adress bilgisini güncelleyebilmeli ve güncellenen
    # adresi customer_addresses tablosunda oldugunu dogrulayabilmeliyim


  #UPDATE u480337000_tlb_training.customer_addresses
  #SET address= "Ankara/Polatli"
  #WHERE id=10;


  @deneme
  Scenario Outline:
    * Database baglantisi kurulur.
    * "<id>" numarasi verilen customerin "<adresi>" güncellenir.
    * customer "address" tablosundaki adsress bilgileri listelenir.
    * "<adresi>" guncellendigi dogrulanir.
    *  Database baglantisi kapatilir.


    Examples:
    |id|adresi|
    |8| bolu  |



    #Bir yonetici olarak DataBase üzerinden User kaydi olusturabilmeli,
    # ve olusturdugum kayidin User listesinde oldugunu dogrulayabilmeliyim.

    #INSERT INTO u480337000_tlb_training.users(first_name, last_name, username, email, id, role_id, password) values ('ahmet', 'karli', 'karliahmet', 'ahmetkarli@gmail.com', 72,2, '123123123');

  Scenario Outline:
        * Database baglantisi kurulur.
        * "<first_name>","<last_name>","<username>","<email>","<id>","<role_id>","<password>" girilerek user kaydi olusturulur.
        * users tablosundaki "id" ler listte listelenir
        * OLusturulan User'in "<id>" sinin listede oldugu dogrulanir.
        * Database baglantisi kapatilir.


        Examples:

        |first_name|last_name|username|email|id|role_id|password|
        |faruk|buraya|bi ugradı gecti| farukbak@gmail.com   |98| 2 | 123123123  |



