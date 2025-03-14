package in.ineuron.dto;

import java.io.Serializable;

public class InsurancePolicyDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long pid;
	private String pname;
	private String ptype;
	private String compny;
	private Integer tenure;
	
	
	public String getCompny() {
		return compny;
	}

	public void setCompny(String compny) {
		this.compny = compny;
	}

	public Long getPid() {
		return pid;
	}
	
	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", compny=" + compny
				+ ", tenure=" + tenure + "]";
	}

}
