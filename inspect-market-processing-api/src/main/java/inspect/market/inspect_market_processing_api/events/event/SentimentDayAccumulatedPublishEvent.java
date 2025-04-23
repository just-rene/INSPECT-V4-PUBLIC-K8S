package inspect.market.inspect_market_processing_api.events.event;

import inspect.market.inspect_market_processing_api.dtos.SentimentDayAccumulatedDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class SentimentDayAccumulatedPublishEvent {
    private UUID processId;
    private List<SentimentDayAccumulatedDto> sentimentDayAccumulatedList;
}
