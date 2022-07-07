package to21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TorunApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorunApplication.class, args); 
	}
	public static void main3(String[] args) {
		SpringApplication.run(TorunApplication.class, args);
		System.out.println("Torun");
		System.out.println("hello torun");
	}
}
