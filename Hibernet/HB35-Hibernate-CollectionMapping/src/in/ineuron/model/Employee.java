package in.ineuron.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;
//Collection ==> List<>,Set<>,Map<key,value>
@Entity
@Table(name = "EMPLOYEE_COLLECTION")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer eid;
	private String ename;
	private String eaddress;
	
	@ElementCollection
	@CollectionTable(name = "EMP_FRDS", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid")) // creates a table named="emp_frd" with foreign_key=emp_id and PK=eid
	@Column(name = "friend_name") // it will store list data
	@OrderColumn(name = "friend_no") // creates a column to store index of list
	@ListIndexBase(value = 1) // list index will start from 1
	private List<String> friendList;

	
	@ElementCollection
	@Column(name = "mobile_no")
	@CollectionTable(name = "EMP_PHONE", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid")) // creates a table named="emp_frd" with foreign_key=emp_id and PK=eid
	private Set<Long> phones;
	
	
	@ElementCollection
	@Column(name = "account_number")
	@CollectionTable(name = "EMP_ACCOUNTS", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid")) // creates a table named="emp_frd" with foreign_key=emp_id and PK=eid
	@MapKeyColumn(name = "bankName", length = 10)
	private Map<String, Long> bankAccounts;


	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public List<String> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}

	public Set<Long> getPhones() {
		return phones;
	}

	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}

	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friendList=" + friendList
				+ ", phones=" + phones + ", bankAccounts=" + bankAccounts + "]";
	}
	
}
