package com.jerome.springbootcamel.fileRouteBuilders;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ThirdFileRouteBuilder extends SpringRouteBuilder implements FileRouteBuilder {

    public static final String THIRD_FILE_ROUTE = "Third file route";

    public static final String ENDPOINT = "direct:third";

    @Override
    public void configure() {
        from(ENDPOINT)
                .routeId(THIRD_FILE_ROUTE)
                .log("Processing file");
    }

    @Override
    public String getEndpoint() {
        return ENDPOINT;
    }
}
