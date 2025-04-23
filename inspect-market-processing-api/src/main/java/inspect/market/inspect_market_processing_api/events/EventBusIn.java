package inspect.market.inspect_market_processing_api.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import inspect.market.inspect_market_processing_api.entities.SentimentDayAccumulatedCacheObject;
import inspect.market.inspect_market_processing_api.events.event.SentimentDayAccumulatedPublishEvent;
import inspect.market.inspect_market_processing_api.repositories.SentimentDayAccumulatedCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class EventBusIn {

    @Autowired
    private SentimentDayAccumulatedCache sentimentDayAccumulatedCache;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/event-api/sentiment-day-accumulated-publish-event")
    private void receiveSentimentDataEvent(@RequestBody  SentimentDayAccumulatedPublishEvent sentimentDayAccumulatedPublishEvent){
        System.err.println(sentimentDayAccumulatedPublishEvent);

        if (sentimentDayAccumulatedPublishEvent != null && !sentimentDayAccumulatedPublishEvent.getSentimentDayAccumulatedList().isEmpty()){
            if(sentimentDayAccumulatedCache.count() > 5){
                sentimentDayAccumulatedCache.deleteAll();
            }

            String result = "";
            try {
                result = objectMapper.writeValueAsString(sentimentDayAccumulatedPublishEvent);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            if (!Objects.equals(result, "")){
                sentimentDayAccumulatedCache.save(new SentimentDayAccumulatedCacheObject( result));
            }
        }




    }



}
