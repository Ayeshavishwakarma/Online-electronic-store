package pack1;

import java.io.Serializable;

public class CustomerBean implements Serializable {
    private String uName;
    private String upword;
    private String fname;
    private String lname;
    private String addr;
    private String mid;
    private String phno;

    // Getters and Setters
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getUpword() {
        return upword;
    }

    public void setUpword(String upword) {
        this.upword = upword;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }
}