package inspect.main.api.inspect_main_api.conf;

import org.springframework.stereotype.Component;

@Component
public class ColorLog {

    public static String error(String log){
        return "\u001B[31m" + log + "\u001B[0m";
    }

}
