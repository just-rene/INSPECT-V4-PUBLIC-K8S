package inspect.market.inspect_market_processing_api.repositories;

import inspect.market.inspect_market_processing_api.entities.StockMarketSentimentCorrelation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StockMarketSentimentCorrelationRepository extends ReactiveMongoRepository<StockMarketSentimentCorrelation, Long> {


    @Query("{ ticker : ?0 }")
    Mono<StockMarketSentimentCorrelation> findByTicker(String ticker);


}
