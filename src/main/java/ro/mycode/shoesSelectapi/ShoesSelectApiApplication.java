package ro.mycode.shoesSelectapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.shoesSelectapi.repository.ShoesRepo;

@SpringBootApplication
public class ShoesSelectApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShoesSelectApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ShoesRepo shoesRepo){
		return args -> {

		};
	}

}

