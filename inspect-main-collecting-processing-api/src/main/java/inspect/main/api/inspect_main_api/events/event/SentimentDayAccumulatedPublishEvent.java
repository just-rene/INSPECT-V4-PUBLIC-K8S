package inspect.main.api.inspect_main_api.events.event;

import inspect.main.api.inspect_main_api.entities.nlp.computed.SentimentDayAccumulated;
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
    private List<SentimentDayAccumulated> sentimentDayAccumulatedList;
}
