package co.com.sofkau.repository;

import co.com.sofkau.domain.Players;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends ReactiveMongoRepository<Players, String>{
}
