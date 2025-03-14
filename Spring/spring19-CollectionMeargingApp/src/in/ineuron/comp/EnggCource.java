package in.ineuron.comp;

import java.util.Set;

public class EnggCource {
	private Set<String> subjects;
	
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "EnggCource [subjects=" + subjects + "]";
	}
	
}
