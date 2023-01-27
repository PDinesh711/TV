import java.io.Serializable;

public class subscriber implements Serializable {
    private String fname;
    private String lname;
    private String city ;
    private long phone;
    private long pincode;


    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public subscriber(String fname, String lname, String city, long phone , long pincode) {
    this.fname = fname;
    this.lname = lname;
    this.city = city;
    this.phone = phone;
    this.pincode = pincode;
}


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPhone() {
       return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setpincode(long pincode){
        this.pincode=pincode;
    }

    public long getpincode(){
        return pincode;
    }

 @Override
        public String toString() {
            return "subscriber{" +
                    "fname='" + fname + '\'' +
                    ", lname='" +  lname + '\'' +
                    ", city='" + city +'\'' +
                ", phone='" + phone + '\'' +
                '}'; 
    }
}
