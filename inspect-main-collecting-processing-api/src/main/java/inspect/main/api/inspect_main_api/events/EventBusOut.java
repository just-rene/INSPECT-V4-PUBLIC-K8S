package inspect.main.api.inspect_main_api.events;

import inspect.main.api.inspect_main_api.entities.nlp.computed.SentimentDayAccumulated;
import inspect.main.api.inspect_main_api.events.event.SentimentDayAccumulatedPublishEvent;
import inspect.main.api.inspect_main_api.events.event.StockSubscriptionEvent;
import inspect.main.api.inspect_main_api.services.SentimentDayAccumulatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class EventBusOut {

    @Autowired
    private SentimentDayAccumulatedService sentimentDayAccumulatedService;

    @Autowired
    private WebClient.Builder webClient;

    @Value("${uri.inspect-market-processing-api}")
    String marketProcessingApiUri;


    @Value("${uri.inspect-market-collecting-api}")
    String marketCollectingApiUri;

    //send sentiment data for correlation computation with stock data -> market-processing-api
    @Scheduled(fixedRate = 3_600_00)
    private void sendSentimentDayAccumulatedPublishDataEvent() {
        System.err.println("SentimentDayAccumulatedPublisher");

        //todo only publish data for day
        List<SentimentDayAccumulated> sentimentDayAccumulatedList = sentimentDayAccumulatedService.getAll().collectList().block();

        SentimentDayAccumulatedPublishEvent event = new SentimentDayAccumulatedPublishEvent(UUID.randomUUID(), sentimentDayAccumulatedList);

        webClient.build().post().uri(marketProcessingApiUri + "/event-api/sentiment-day-accumulated-publish-event").bodyValue(event).retrieve().bodyToMono(Void.class).subscribe();

        System.err.println("Event published: " + event);
    }

    //http://localhost:9002/api/stock-market/subscribe/ -> market-processing-api
    //TODO: send via std http
    public void sendStockSubscriptionEvent(StockSubscriptionEvent stockSubscriptionEvent) {
        var result = webClient.build().post().uri(marketProcessingApiUri + "/api/stock-market/subscribe/").body(Mono.just(stockSubscriptionEvent), StockSubscriptionEvent.class).retrieve().bodyToMono(String.class);
        System.err.println(result.block());
    }

    //   //fetches all current subs  -> market-processing-api
    public HttpEntity<Flux<String>> getSubs() {
        var ss  = ResponseEntity.ok().body(webClient.build().get().uri(marketProcessingApiUri + "/api/stock-market/ticker-subscriptions").retrieve().bodyToFlux(String.class));
        System.err.println(ss);
        return ss;
    }

    //fetches all ticker (AMZN, ...) from ->  market-data-collector
    public HttpEntity<Mono<String>> getStockTickers() {
        System.err.println("getStockTickers");
        return ResponseEntity.ok().body(webClient.build().get().uri(marketCollectingApiUri + "/api/stock-market/ticker").retrieve().bodyToMono(String.class));
    }




}
