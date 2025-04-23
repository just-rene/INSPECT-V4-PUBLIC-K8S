package inspect.market.inspect_market_processing_api.repositories;

import inspect.market.inspect_market_processing_api.entities.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Long> {


}
