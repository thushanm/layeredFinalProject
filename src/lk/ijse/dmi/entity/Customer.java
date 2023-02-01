package lk.ijse.dmi.entity;

public class Customer {
    private String cid;
    private String name;
    private String address;

    public Customer() {
    }

    private int tel_no;


    public Customer(String cid, String name, String address, int tel_no) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.tel_no = tel_no;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel_no() {
        return tel_no;
    }

    public void setTel_no(int tel_no) {
        this.tel_no = tel_no;
    }
}
