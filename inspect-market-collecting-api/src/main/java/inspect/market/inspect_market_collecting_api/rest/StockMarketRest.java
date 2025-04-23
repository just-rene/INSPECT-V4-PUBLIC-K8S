package inspect.market.inspect_market_collecting_api.rest;


import inspect.market.inspect_market_collecting_api.dtos.StockMarketDayDto;
import inspect.market.inspect_market_collecting_api.events.EventBusIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.Set;

@RestController
public class StockMarketRest {

    @Autowired
    private EventBusIn eventBusIn;

    @GetMapping("/api/stock-market/ticker")
    public HttpEntity<Set<String>> getAllStockMarketTickers() throws IOException {
        return eventBusIn.getAllStockMarketTickers();
    }

    @GetMapping("/api/get-market-data/ticker/{ticker}")
    public Flux<StockMarketDayDto> getMarketDataForTicker(@PathVariable String ticker) {
        return eventBusIn.getMarketDataForTicker(ticker);
    }
}
