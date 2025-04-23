package inspect.market.inspect_market_processing_api.events;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaStreams {


//    @Autowired
//    private StockMarketSentimentCorrelationRepository stockMarketSentimentCorrelationDailyRepository;
//
//    @Autowired
//    private SubscriptionRepository subscriptionRepository;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private ComputeDailyCorrelation computeDailyCorrelation;
//
//    @Autowired
//    private SentimentDayAccumulatedCache sentimentDayAccumulatedCache;

    //when someone subscribes to a new ticker -> triggers correlation computation
    @Bean("stock-market-subscription")
    public Consumer<String> stockMarketSub() {
        return x -> {

        };
    }

    //upcoming feature will be later computed with stock data
    @Bean("topic-publisher")
    public Consumer<String> topicPublisherSub() {
        return x -> {

        };
    }

    @Bean("sentiment-day-accumulated-publisher")
    public Consumer<String> sentimentPublisherSub() {
        return x -> {

        };
    }
}
