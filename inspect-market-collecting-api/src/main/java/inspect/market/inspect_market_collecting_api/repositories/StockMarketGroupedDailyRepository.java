package inspect.market.inspect_market_collecting_api.repositories;


import inspect.market.inspect_market_collecting_api.dtos.StockMarketDayDto;
import inspect.market.inspect_market_collecting_api.entities.StockMarketGroupedDaily;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StockMarketGroupedDailyRepository extends ReactiveMongoRepository<StockMarketGroupedDaily, String> {

    @Aggregation(pipeline = {
            "{$unwind: '$result' }",
            "{ $match: { 'result.ticker': ?0 } }"
    })
    Flux<StockMarketDayDto> findByTicker(String ticker);
}
