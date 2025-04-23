package inspect.main.api.inspect_main_api.repos;


import inspect.main.api.inspect_main_api.entities.nlp.computed.SentimentDayAccumulated;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//todo remove day
@Repository
public interface  SentimentDayAccumulatorRepository extends ReactiveMongoRepository<SentimentDayAccumulated, Long> {

}
