package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String pname;
	private LocalDate dob;
	private LocalDateTime dom;
	private LocalTime doj;
	
	public PersonInfo() {
		System.out.println("Zero argument constructor used by hibernate...");
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public LocalDateTime getDom() {
		return dom;
	}
	
	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}
	
	public LocalTime getDoj() {
		return doj;
	}
	
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", pname=" + pname + ", dob=" + dob + ", dom=" + dom + ", doj=" + doj + "]";
	}
	
}
