package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "bankaccountdetail")
@SQLDelete(sql = "UPDATE bankaccountdetail SET status='closed' WHERE accno=?")
@Where(clause = "status not in('blocked', 'closed')")
public class BankAccountDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer accno;
	private String holderName;
	private Float balance;
	private String status;
	
	static {
		System.out.println("BankAccountDetail.class file is loading...");
	}

	public BankAccountDetail() {
		System.out.println("BankAccountDetail object is used by HIBERNATE...");
	}
	
	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BankAccountDetail [accno=" + accno + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	
}
