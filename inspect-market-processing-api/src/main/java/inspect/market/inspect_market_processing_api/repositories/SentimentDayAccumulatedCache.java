package inspect.market.inspect_market_processing_api.repositories;

import inspect.market.inspect_market_processing_api.entities.SentimentDayAccumulatedCacheObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SentimentDayAccumulatedCache extends MongoRepository<SentimentDayAccumulatedCacheObject, Long> {
}
