package in.ineuron.comp;

import java.util.Date;
import java.util.List;

public class College {
	
	private List<String> StdNames;
	private List<Date> DateList;
	
	public void setStdNames(List<String> stdNames) {
		StdNames = stdNames;
		System.out.println("Implementation Class of List is :: "+StdNames.getClass().getName());
	}

	public void setDateList(List<Date> dateList) {
		DateList = dateList;
	}

	@Override
	public String toString() {
		return "College [StudNames=" + StdNames + ", DateList=" + DateList + "]";
	} 
}
