package inspect.market.inspect_market_processing_api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Subscription {

    private SubscriptionDetails _id;

    private String since;

    @Indexed(unique = true)
    private UUID uuid;

}
