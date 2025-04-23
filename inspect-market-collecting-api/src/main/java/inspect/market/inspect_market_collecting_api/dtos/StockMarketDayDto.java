package inspect.market.inspect_market_collecting_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StockMarketDayDto {
    private String date;
    private Map<String,String> result;
}
