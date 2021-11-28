package net.students.accounting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class StudentsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsAppApplication.class, args);
	}

}
