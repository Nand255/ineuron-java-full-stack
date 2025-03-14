package in.ineuron.cfg;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "in.ineuron" })
public class AppConfig {
	
	static {
		System.out.println("AppConfig.class file is loading...");
	}
	
	public AppConfig() {
		System.out.println("AppConfig :: Zero param constructor");
	}
	
	//It is used to create object of pre-defined classes.
	@Bean(value = "obj1")
	public LocalDateTime createTime() {
		System.out.println("AppConfig.createTime()");
		return LocalDateTime.now();
	}
	@Bean(value = "obj2")
	public LocalDateTime giveTime() {
		System.out.println("AppConfig.giveTime()");
		return LocalDateTime.now();
	}
}
