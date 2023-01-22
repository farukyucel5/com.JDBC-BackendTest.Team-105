package dbStepDefinition;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.*;
import static utilities.DBUtils.getColumnData;

public class StepDefinition {

    List<Object> staffIdList = new ArrayList<Object>();
    List<Object> usersPhoneList = new ArrayList<Object>();

    List<Object> usersEmailList = new ArrayList<Object>();

    List<Object> adresList = new ArrayList<Object>();
    List<Object> UsersIdList = new ArrayList<Object>();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        createConnection();

    }
    @Given("Staff tablosundaki {string} leri listelenir.")
    public void staff_tablosundaki_leri_listelenir(String id) {

        staffIdList = getColumnData("SELECT * FROM u480337000_tlb_training.staff",id);
        System.out.println(staffIdList);
    }
    @Given("Verilen {string} dogrulanir.")
    public void verilen_dogrulanir(String arananId) {
        System.out.println(arananId);
        assertTrue(staffIdList.toString().contains(arananId));

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        closeConnection();
    }


    @Given("Users tablosundaki {string} numaralari listelenir.")
    public void users_tablosundaki_numaralari_listelenir(String phone) {

        usersPhoneList = getColumnData( "SELECT * FROM u480337000_tlb_training.users", phone);

        System.out.println(usersPhoneList);
    }

    @Given("Verilen {string} numarasi dogrulanir.")
    public void verilen_numarasi_dogrulanir(String arananPhone) {

        System.out.println(arananPhone);
        assertTrue(usersPhoneList.toString().contains(arananPhone));
    }


    @Given("Users tablosundaki {string} 'ler listelenir.")
    public void users_tablosundaki_ler_listelenir(String email) {

        usersEmailList = getColumnData( "SELECT * FROM u480337000_tlb_training.users",email);
        System.out.println(usersEmailList);

    }
    @Given("Verilen {string} in listede oldugu dogrulanir.")
    public void verilen_in_listede_oldugu_dogrulanir(String arananEmail) {

        assertTrue(usersEmailList.toString().contains(arananEmail));
    }




    @Given("{string} numarasi verilen customerin {string} güncellenir.")
    public void numarasi_verilen_customerin_güncellenir(String id, String adresi) throws SQLException {

        update("UPDATE u480337000_tlb_training.customer_addresses SET address= '"+adresi+"' WHERE id="+id);

    }
    @Given("customer {string} tablosundaki adsress bilgileri listelenir.")
    public void customer_tablosundaki_adsress_bilgileri_listelenir(String adres) {

          adresList = getColumnData("SELECT * FROM u480337000_tlb_training.customer_addresses",adres);
        System.out.println(adresList);

    }
    @Given("{string} guncellendigi dogrulanir.")
    public void guncellendigi_dogrulanir(String adres) {

        assertTrue(adresList.toString().contains(adres));

    }


    @Given("{string},{string},{string},{string},{string},{string},{string} girilerek user kaydi olusturulur.")
    public void girilerek_user_kaydi_olusturulur(String first_name, String last_name, String username, String email, String id, String role_id, String password) throws SQLException {

        String query = "INSERT INTO u480337000_tlb_training.users(first_name, last_name, username, email, `password`,id,role_id)\n" +
                "VALUES ('" + first_name + "', '" + last_name + "', '" + username + "', '" + email + "', '" + password + "', " + id + ", " + role_id + ")";

        update(query);
    }

    @Given("OLusturulan User'in {string} sinin listede oldugu dogrulanir.")
    public void o_lusturulan_user_in_sinin_listede_oldugu_dogrulanir(String id) {
        assertTrue(UsersIdList.toString().contains(id));
    }


    @Given("users tablosundaki {string} ler listte listelenir")
    public void users_tablosundaki_ler_listte_listelenir(String id) {
        UsersIdList= getColumnData( "SELECT * FROM u480337000_tlb_training.users",id);
        System.out.println(UsersIdList);
    }
}



