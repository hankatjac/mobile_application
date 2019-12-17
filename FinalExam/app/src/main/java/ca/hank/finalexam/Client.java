package ca.hank.finalexam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client implements Comparable,Serializable  {

    private String clientName;
    private String clientFamily;
    private String phone;
    private String sin;
    private Account account;



    public Client(String clientName, String clientFamily, String phone, String sin, Account account) {
        this.clientName = clientName;
        this.clientFamily = clientFamily;
        this.phone = phone;
        this.sin = sin;
        this.account = account;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientFamily() {
        return clientFamily;
    }

    public void setClientFamily(String clientFamily) {
        this.clientFamily = clientFamily;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int compareTo(Object o) {

        Client otherObject = (Client) o;
        return clientFamily.compareTo(otherObject.getClientFamily());
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientFamily='" + clientFamily + '\'' +
                ", phone='" + phone + '\'' +
                ", sin='" + sin + '\'' +
                '}';
    }


//    public static final Client[] clients = {
//
//            new Client("Tom", "Cat", "111-111-1111", "123456", new Account("000", "2019-01-01", "0")),
//            new Client("Snoopy", "Dog", "222-222-222", "122555", new Account("111", "2019-01-01", "0")),
//            new Client("Jerry", "Mouse", "333-333-3333", "636452", new Account("222", "2019-01-01", "0"))
//
//
//    };

//   public static  List<Client> clientList = Arrays.asList(clients);


}
