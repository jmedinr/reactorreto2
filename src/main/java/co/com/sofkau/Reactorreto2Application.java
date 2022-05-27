package co.com.sofkau;

import co.com.sofkau.domain.Players;
import co.com.sofkau.repository.PlayersRepository;
import co.com.sofkau.rest.PlayersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
@EnableMongoRepositories
public class Reactorreto2Application implements CommandLineRunner {

	@Autowired
	PlayersRepository playersRepository;

	Flux<Player> listaJugadores = Flux.fromIterable(CsvUtilFile.getPlayers());

	public static void main(String[] args) {
		SpringApplication.run(Reactorreto2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addDatos();
	}
	 public void addDatos(){
		listaJugadores.map(player -> playersRepository.save(new Players(player.name, player.age, player.icon, player.national, player.winners, player.games, player.club))).subscribe();
	 }
}


