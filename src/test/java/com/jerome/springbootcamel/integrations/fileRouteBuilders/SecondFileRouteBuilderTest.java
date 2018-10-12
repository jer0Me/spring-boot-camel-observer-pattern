package com.jerome.springbootcamel.integrations.fileRouteBuilders;

import com.jerome.springbootcamel.fileRouteBuilders.SecondFileRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.EnableRouteCoverage;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@EnableRouteCoverage
@MockEndpoints(SecondFileRouteBuilder.ENDPOINT)
public class SecondFileRouteBuilderTest {

    @Autowired
    private CamelContext camelContext;

    @EndpointInject(uri = "mock:" + SecondFileRouteBuilder.ENDPOINT)
    private MockEndpoint mock;

    @Test
    public void shouldReceiveFileMessagesFromTheTimer() throws Exception {
        mock.expectedMessageCount(1);
        new NotifyBuilder(camelContext).whenDone(1).create();
        mock.assertIsSatisfied();
    }
}
