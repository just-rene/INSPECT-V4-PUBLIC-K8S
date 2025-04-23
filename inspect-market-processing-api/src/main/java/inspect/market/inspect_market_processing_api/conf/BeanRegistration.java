package inspect.market.inspect_market_processing_api.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanRegistration {

    @Bean
    public WebClient.Builder lbWebClient() {
        return WebClient.builder();
    }
}
