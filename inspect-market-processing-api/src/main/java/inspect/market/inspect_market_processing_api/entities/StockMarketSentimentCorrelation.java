package inspect.market.inspect_market_processing_api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import types.CorrelationType;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class StockMarketSentimentCorrelation {
    private ObjectId _id;
    @Indexed(unique = true)
    private String ticker;
    private CorrelationType correlationType;
    private float correlationPositive;
    private float correlationNegative;
    private float correlationNeutral;
    private int dataPoints = 0;
}
