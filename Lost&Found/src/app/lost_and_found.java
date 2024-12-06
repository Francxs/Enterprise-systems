package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// this will disable the DB initialization which we do not need at this point
public class lost_and_found {

	public static void main(String[] args) {
		SpringApplication.run(lost_and_found.class, args);
	}
}