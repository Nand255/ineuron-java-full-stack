package in.ineuron.comp;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo {
	
	private Map<Integer, String> facultyDetails;
	private Map<String, Date> datesInfo;
	private Properties unis;
	
	public void setUnis(Properties unis) {
		this.unis = unis;
		System.out.println("Implementation class of Properties is :: "+unis.getClass().getName());
	}

	public void setFacultyDetails(Map<Integer, String> facultyDetails) {
		this.facultyDetails = facultyDetails;
		System.out.println("Implementation class of Map is :: "+facultyDetails.getClass().getName());
	}

	public void setDatesInfo(Map<String, Date> datesInfo) {
		this.datesInfo = datesInfo;
	}

	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + ", datesInfo=" + datesInfo + ", unis=" + unis + "]";
	}
}
