package inspect.main.api.inspect_main_api.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import inspect.main.api.inspect_main_api.dtos.SubscriptionDto;
import inspect.main.api.inspect_main_api.events.EventBusOut;
import inspect.main.api.inspect_main_api.events.event.StockSubscriptionEvent;
import inspect.main.api.inspect_main_api.events.event.SubsciptionAction;
import inspect.main.api.inspect_main_api.events.event.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


//TODO rebuild for kubernetes
@RestController
public class StockMarketRest {

//    Logger logger = LoggerFactory.getLogger(StockMarketRest.class);

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private ObjectMapper objectMapper;

    private boolean isServiceAvailable(String service) {
        return true;
    }

    //fetches all ticker (AMZN, ...) from market-data-collector
    @GetMapping("/api/stock-market/ticker")
    public HttpEntity<Mono<String>> getStockTicker() {
        return eventBusOut.getStockTickers();
    }

    @Autowired
    private EventBusOut eventBusOut;

    //creates a subscription for a specific stock, correlations will now be computed for this stock from now on
    @PostMapping("/api/stock-market/create-subscription")
    public Mono<ResponseEntity<String>> subscribeToStockMarketTicker(@RequestBody SubscriptionDto body) {

        //trigger event
        StockSubscriptionEvent stockSubscriptionEvent =
                new StockSubscriptionEvent(UUID.randomUUID(), UserType.ADMIN, body.getTicker(), SubsciptionAction.SUBSCRIBE);
        eventBusOut.sendStockSubscriptionEvent(stockSubscriptionEvent);

        //response
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("name", "successful");
        return Mono.just(ResponseEntity.ok().body(rootNode.toString()));
    }

    //fetches all current subs
    @GetMapping("/api/stock-market/ticker-subscriptions")
    public HttpEntity<Flux<String>> getSubs() {
        return eventBusOut.getSubs();
    }


}
