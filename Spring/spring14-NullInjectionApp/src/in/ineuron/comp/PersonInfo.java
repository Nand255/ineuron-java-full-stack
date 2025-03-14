package in.ineuron.comp;

import java.util.Date;

public class PersonInfo {
	
	private Integer pid;
	private String pname;
	private String paddress;
	private Date dob;
	private Date doj;
	private Date dom;
	
	public PersonInfo(Integer pid, String pname, String paddress, Date dob, Date doj, Date dom) {
		System.out.println("PersonInfo :: 6 param constructor...");
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}
	
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", dob=" + dob + ", doj="
				+ doj + ", dom=" + dom + "]";
	}
	
}
