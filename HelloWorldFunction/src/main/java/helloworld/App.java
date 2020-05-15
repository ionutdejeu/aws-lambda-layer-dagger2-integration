package helloworld;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.ionutdejeu.businesslayer.FeatureModule;
//import com.ionutdejeu.components.AppComponent;
//import com.ionutdejeu.components.DaggerAppComponent;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.ionutdejeu.utils.*;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Object, Object> {
    //private final AppComponent component;
    //private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public App(){

            //component = DaggerAppComponent.builder().build();
            //LOGGER.debug("App::Constructor Called");
    }
    public Object handleRequest(final Object input, final Context context) {
        //LOGGER.debug("Lambda Handler called");
        //component.getAdapter().getAdapterMethodA();
        //component.getFeature().executeFeatureAMethodB();

        context.getLogger().log("This is a test log");
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        try {
            final String pageContents = this.getPageContents("https://checkip.amazonaws.com");
            String output = String.format("{ \"message\": \"hello world\", \"location\": \"%s\" }", pageContents);
            return new GatewayResponse(output, headers, 200);
        } catch (IOException e) {
            return new GatewayResponse("{}", headers, 500);
        }
    }

    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
