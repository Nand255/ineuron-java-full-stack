package in.ineuron.dto;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer sid;
	private String sname;
	private Integer sage;
	private String saddress;
	
	public Integer getSid() {
		return sid;
	}
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String name) {
		this.sname = name;
	}
	
	public Integer getSage() {
		return sage;
	}
	
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	
	public String getSaddress() {
		return saddress;
	}
	
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}
}
