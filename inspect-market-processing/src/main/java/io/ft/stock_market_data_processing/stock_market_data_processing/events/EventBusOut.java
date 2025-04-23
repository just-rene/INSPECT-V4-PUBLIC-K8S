package io.ft.stock_market_data_processing.stock_market_data_processing.events;

import io.ft.stock_market_data_processing.stock_market_data_processing.dtos.StockMarketDayDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Component
public class EventBusOut {

    @Value("${uri.inspect-market-collecting-api}")
    private String inspectMarketCollectingApi;

    @Autowired
    private WebClient.Builder webClient;

    Logger logger = LoggerFactory.getLogger(EventBusOut.class);


    private boolean isServiceAvailable() {
        return true;
    }

    // requests stock performance data for correlation computation -> market-collector
    public List<StockMarketDayDto> fetchDataForTicker(String ticker) {
        if (isServiceAvailable()) {
            List<StockMarketDayDto> marketDataPoints = ResponseEntity.ok().body(webClient.build().get().uri(inspectMarketCollectingApi + "/api/get-market-data/ticker/" + ticker)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<StockMarketDayDto>>() {
                    })).getBody().block(Duration.ofSeconds(20));
            return marketDataPoints;
        }
        return List.of();
    }


}
