package lk.ijse.dmi.entity;

public class Supplier {
    private String sId;
    private String name;
    private String address;
    private int tel_no;



    public Supplier() {
    }

    public Supplier(String sId, String name, String address, int tel_no) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.tel_no = tel_no;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
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
