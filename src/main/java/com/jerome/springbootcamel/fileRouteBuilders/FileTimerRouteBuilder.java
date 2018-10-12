package com.jerome.springbootcamel.fileRouteBuilders;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileTimerRouteBuilder extends SpringRouteBuilder {

    public static final String ROUTE_ID = "Timer";

    private List<String> fileEndpoints;

    @Autowired
    public FileTimerRouteBuilder(List<? extends FileRouteBuilder> fileRouteBuilders) {
        this.fileEndpoints = fileRouteBuilders.stream()
                .map(FileRouteBuilder::getEndpoint)
                .collect(Collectors.toList());
    }

    @Override
    public void configure() {
        from("timer:testTimer?fixedRate=true&period=3000")
                .routeId(ROUTE_ID)
                .multicast()
                .to(fileEndpoints.toArray(new String[0]));
    }
}
