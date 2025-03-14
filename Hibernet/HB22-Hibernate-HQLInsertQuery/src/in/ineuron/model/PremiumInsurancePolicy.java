package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "HQL_TRANSFER_POLICIES", query = "INSERT INTO in.ineuron.model.PremiumInsurancePolicy(pid,pname,ptype,tenure) SELECT i.pid, i.pname, i.ptype, i.tenure FROM in.ineuron.model.InsurancePolicy as i where i.tenure>=:min")
public class PremiumInsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long pid;
	
	private String pname;
	private String ptype;
	private Integer tenure;
	
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
		return "InsurancePolicy [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", tenure=" + tenure
				+ ", count=]";
	}	
}
