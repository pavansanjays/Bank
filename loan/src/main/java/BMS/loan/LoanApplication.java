package BMS.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanApplication {

	public static void main(String[] args) {

		System.out.println("Starting application..."); // This will print
		SpringApplication.run(LoanApplication.class, args);
		System.out.println("Application has finished running.");
	}

}
