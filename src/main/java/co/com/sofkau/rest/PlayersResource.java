package co.com.sofkau.rest;

import co.com.sofkau.domain.Players;
import co.com.sofkau.service.PlayersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayersResource {
    private final PlayersService playersService;


    public PlayersResource(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping("/players")
    public Flux<ResponseEntity<Players>> getPlayers() {
        return playersService.findAll()
                .map(ResponseEntity::ok);
    }

    @GetMapping("/players/{id}")
    public Mono<ResponseEntity<Players>> getPlayer(@PathVariable String id) {
        return playersService.findById(id)
                .map(ResponseEntity::ok);
    }

    @PostMapping("/players")
    public Mono<ResponseEntity<Players>> create(@RequestBody Players players) {
        return playersService.save(players)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/players/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return playersService.deleteById(id)
                .map(ResponseEntity::ok);
    }
}
