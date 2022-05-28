package co.com.sofkau.service;

import co.com.sofkau.domain.Players;
import co.com.sofkau.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayersService {

    @Autowired
    private final PlayersRepository playersRepository;


    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public Mono<Players> save(Players players) {
        return playersRepository.save(players);
    }

    public Mono<Players> findById(String id) {
        return playersRepository.findById(id);
    }

    public Flux<Players> findAll() {
        return playersRepository.findAll();
    }

    public Mono<Void> deleteById(String id) {
        return playersRepository.deleteById(id);
    }

    public void deleteAll() {
        playersRepository.deleteAll();
    }
}
