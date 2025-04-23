package inspect.market.inspect_market_processing_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SentimentDayAccumulatedKeyDto {
    public String label;
    public String date;
}
