package co.com.sofkau.rest;

import co.com.sofkau.domain.Players;
import co.com.sofkau.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayersResource {

    @Autowired
    private PlayersService playersService;

    @PostMapping("/create/players")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Players players) {
        playersService.save(players);
    }

    @GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Players> findAll() {
        return playersService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<Players>> findById(@PathVariable("id") Integer id) {
        Mono<Players> players = playersService.findById(id.toString());
        return new ResponseEntity(players, players != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        playersService.deleteById(id.toString());
    }

}