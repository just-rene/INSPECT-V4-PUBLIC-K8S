package inspect.main.api.inspect_main_api.repos;


import inspect.main.api.inspect_main_api.entities.general.Topic;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TopicRepository extends ReactiveMongoRepository<Topic, String> {

    @Query("{'name': {$regex : ?0, $options: 'i'}})")
    Flux<Topic> findLike(String name);
}
