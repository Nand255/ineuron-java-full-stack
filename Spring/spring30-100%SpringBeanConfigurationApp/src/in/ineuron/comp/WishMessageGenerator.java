package in.ineuron.comp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Componenet is used for creating object of user-defined class.
@Component(value = "wmg")
@Scope(scopeName = "singleton")
public class WishMessageGenerator {
	
	@Autowired(required = true)
	@Qualifier("obj1")
	public LocalDateTime date;
	
	static {
		System.out.println("WishMessageGenerator.class file is loading...");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator :: zero param constructor");
	}

	public String generateWishMessage(String userName) {
		System.out.println("WishMessageGenerator.generateWishMessage()");
		
		int hour = date.getHour();
		if (hour < 12) {
			return "Good Morning "+userName;
		} else if (hour < 16) {
			return "Good Afternoon "+userName;
		} else if (hour < 20) {
			return "Good Evening "+userName;
		} else {
			return "Good Night "+userName;
		}
	}
	
	@Override
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}
	
}
