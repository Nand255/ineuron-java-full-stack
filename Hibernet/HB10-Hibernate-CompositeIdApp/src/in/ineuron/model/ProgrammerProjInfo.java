package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgrammerProjId id;
	
	private String pname;
	private Integer deptno;
	private String projname;
	
	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public Integer getDeptno() {
		return deptno;
	}
	
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	public String getProjname() {
		return projname;
	}
	
	public void setProjname(String projname) {
		this.projname = projname;
	}

	public ProgrammerProjId getId() {
		return id;
	}

	public void setId(ProgrammerProjId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProgrammerProjInfo [id=" + id + ", pname=" + pname + ", deptno=" + deptno + ", projname=" + projname+ "]";
	}

	
	
}
