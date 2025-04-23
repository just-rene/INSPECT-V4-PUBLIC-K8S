package inspect.market.inspect_market_collecting_api.events;


import inspect.market.inspect_market_collecting_api.dtos.StockMarketDayDto;
import inspect.market.inspect_market_collecting_api.repositories.StockMarketGroupedDailyRepository;
import inspect.market.inspect_market_collecting_api.services.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
public class EventBusIn {

    @Autowired
    private TickerService tickerService;

    @Autowired
    private StockMarketGroupedDailyRepository stockMarketGroupedDailyRepository;

    //get all possible ticker (AMZN, ...)
    public HttpEntity<Set<String>> getAllStockMarketTickers() throws IOException {

            return ResponseEntity.status(HttpStatus.OK).body(tickerService.getAllTickers());


    }
    //get market data for specific ticker
    public Flux<StockMarketDayDto> getMarketDataForTicker(@PathVariable String ticker) {
        return stockMarketGroupedDailyRepository.findByTicker(ticker);
    }



}
