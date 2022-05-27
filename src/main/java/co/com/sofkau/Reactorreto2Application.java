package co.com.sofkau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
public class Reactorreto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Reactorreto2Application.class, args);
		Flux<Player> list = Flux.fromIterable(CsvUtilFile.getPlayers());


	}

}
