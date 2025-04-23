package inspect.market.inspect_market_processing_api.conf;

import org.springframework.stereotype.Component;

@Component
public class ColorLog {

    public static String error(String log){
        return "\u001B[31m" + log + "\u001B[0m";
    }

}
