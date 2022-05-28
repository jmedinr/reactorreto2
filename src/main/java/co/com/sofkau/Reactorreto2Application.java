package co.com.sofkau;

import co.com.sofkau.domain.Players;
import co.com.sofkau.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableMongoRepositories
public class Reactorreto2Application implements CommandLineRunner {

    @Autowired
    PlayersRepository playersRepository;

    Flux<Player> listaJugadores = Flux.fromIterable(CsvUtilFile.getPlayers());

    public static void main(String[] args) {
        SpringApplication.run(Reactorreto2Application.class, args);
    }

    //Corre el método run() cuando se ejecuta el programa
    @Override
    public void run(String... args) throws Exception {
        //addDatos();
        //findAll();
        deleteAll();
    }

    //Agrega datos a la base de datos
    public void addDatos() throws InterruptedException {
        listaJugadores.map(player -> playersRepository.save(new Players(player.name, player.age,
				player.icon, player.national,
				player.winners, player.games, player.club)).subscribe()).subscribe();
    }

    //Busca todos los datos de la base de datos
    public void findAll() {
        playersRepository.findAll().subscribe(System.out::println);
    }

    //Borrado de datos
    public void deleteAll() {
        playersRepository.deleteAll().subscribe(System.out::println);
    }
}


