package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	private String policyName;
	private String policyType;
	private String compny;
	private Integer tenure;
		
	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompny() {
		return compny;
	}

	public void setCompny(String compny) {
		this.compny = compny;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}


	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", compny=" + compny + ", tenure=" + tenure + "]";
	}
}
