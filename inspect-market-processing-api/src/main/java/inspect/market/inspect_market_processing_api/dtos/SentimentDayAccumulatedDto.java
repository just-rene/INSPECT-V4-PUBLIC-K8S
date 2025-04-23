package inspect.market.inspect_market_processing_api.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SentimentDayAccumulatedDto {
    public SentimentDayAccumulatedKeyDto _id;
    public float result;
}
