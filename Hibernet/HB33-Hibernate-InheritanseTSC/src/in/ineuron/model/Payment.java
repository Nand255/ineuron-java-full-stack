package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_TBSC") // TBSC -- table per sub-class
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_method", discriminatorType = DiscriminatorType.STRING) // not required when we use JOINED strategy
public abstract class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer pid;
	private Float amount;
		
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amount=" + amount + "]";
	}
	
}
