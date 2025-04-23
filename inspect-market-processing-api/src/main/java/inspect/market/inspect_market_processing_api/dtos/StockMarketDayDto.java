package inspect.market.inspect_market_processing_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StockMarketDayDto {
    private String date;
    private StockMarketDayDetailsDto result;
}
