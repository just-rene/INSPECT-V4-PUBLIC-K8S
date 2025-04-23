package io.ft.stock_market_data_collector.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class KafkaStreams {

    @Autowired
    private ObjectMapper objectMapper;

    //consumer
    @Bean("stock-market-subscription")
    public Consumer<String> stockMarketSub() {
        return System.out::println;
    }


    //only for testing
    @Bean("user-events")
    public Supplier<String> UserEventsOut() {
        return () -> {
            return null;
        };
    }
}
