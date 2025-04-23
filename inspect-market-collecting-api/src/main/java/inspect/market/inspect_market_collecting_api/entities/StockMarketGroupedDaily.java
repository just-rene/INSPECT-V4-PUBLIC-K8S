package inspect.market.inspect_market_collecting_api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class StockMarketGroupedDaily {

    @Indexed(unique = true)
    private String date;

    @JsonProperty("results")
    private List<StockMarketDaily> result;
}
