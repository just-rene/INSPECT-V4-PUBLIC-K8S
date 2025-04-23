package inspect.main.api.inspect_main_api.repos;


import inspect.main.api.inspect_main_api.entities.nlp.computed.NamedEntityRecognitionDayAccumulated;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface NamedEntityRecognitionDayAccumulatedRepository extends ReactiveMongoRepository<NamedEntityRecognitionDayAccumulated, String> {

    @Query("{ '_id.date' : ?0 , '_id.entityGroup' : ?1 }")
    Flux<NamedEntityRecognitionDayAccumulated> getByDate(String date, String entityGroup);

}
