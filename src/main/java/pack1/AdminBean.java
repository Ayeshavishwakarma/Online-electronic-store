package pack1;

import java.io.Serializable;

public class AdminBean implements Serializable
{
private String uName,upword,fname,lname,addr,mid,phno;

public String getuName() {
	return uName;
}

public void setuName(String uName) {
	this.uName = uName;
}

public String getUpwd() {
	return upword;
}

public void setUpwd(String upword) {
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

public String getaddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public String getmid() {
	return mid;
}

public void setmid(String mid) {
	this.mid = mid;
}

public String getphno() {
	return phno;
}

public void setMobile(String phno) {
	this.phno = phno;
}
public AdminBean() {}


	
}


