package inspect.market.inspect_market_processing_api.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import inspect.market.inspect_market_processing_api.entities.StockMarketSentimentCorrelation;
import inspect.market.inspect_market_processing_api.entities.Subscription;
import inspect.market.inspect_market_processing_api.entities.SubscriptionDetails;
import inspect.market.inspect_market_processing_api.events.event.StockSubscriptionEvent;
import inspect.market.inspect_market_processing_api.repositories.StockMarketSentimentCorrelationRepository;
import inspect.market.inspect_market_processing_api.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RestController
public class SubscriptionRest {

    @Autowired
    private StockMarketSentimentCorrelationRepository stockMarketSentimentCorrelationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/api/stock-market/ticker-subscriptions")
    public Flux<StockMarketSentimentCorrelation> getSubs() {
        return stockMarketSentimentCorrelationRepository.findAll();
    }
    @PostMapping("/api/stock-market/subscribe/")
    public void subscribe(@RequestBody StockSubscriptionEvent res) {
        subscriptionRepository.save(new Subscription(new SubscriptionDetails(res.getTicker(), res.getUserType()), LocalDate.now().toString(), res.getId()));
    }

}
