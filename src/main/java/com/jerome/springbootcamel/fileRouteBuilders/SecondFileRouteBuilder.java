package com.jerome.springbootcamel.fileRouteBuilders;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SecondFileRouteBuilder extends SpringRouteBuilder implements FileRouteBuilder {

    public static final String ROUTE_ID = "Second file route";

    public static final String ENDPOINT = "direct:second";

    @Override
    public void configure() {
        from(ENDPOINT)
                .routeId(ROUTE_ID)
                .log("Processing file");
    }

    @Override
    public String getEndpoint() {
        return ENDPOINT;
    }

}
