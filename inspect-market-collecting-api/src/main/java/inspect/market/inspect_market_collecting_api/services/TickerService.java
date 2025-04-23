package inspect.market.inspect_market_collecting_api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TickerService {

    @Autowired
    private ObjectMapper objectMapper;

    //todo: store eventually in db
    public Set<String> getAllTickers() throws IOException {
        String contents = "";
        try (InputStream inputStream = getClass().getResourceAsStream("/all-stock-ticker.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
             contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        }

        System.err.println(contents);
        var stockTicker =  objectMapper.readTree(contents);
        return stockTicker.findValues("ticker").stream().map(x -> x.asText()).collect(Collectors.toSet());
    }

}
