package inspect.market.inspect_market_processing_api.repositories;

import inspect.market.inspect_market_processing_api.entities.StockMarketTopicSentimentCorrelation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMarketTopicSentimentCorrelationRepository extends MongoRepository<StockMarketTopicSentimentCorrelation, Long> {



}
