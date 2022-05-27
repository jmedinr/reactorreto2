package co.com.sofkau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Reactorreto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Reactorreto2Application.class, args);
		List<Player> list = CsvUtilFile.getPlayers();

		list.forEach(System.out::println);
	}

}
