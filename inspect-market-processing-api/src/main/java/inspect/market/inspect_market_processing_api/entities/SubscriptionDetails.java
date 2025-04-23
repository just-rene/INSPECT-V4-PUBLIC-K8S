package inspect.market.inspect_market_processing_api.entities;

import inspect.market.inspect_market_processing_api.events.event.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDetails {

    private String ticker;
    private UserType userType;
}
