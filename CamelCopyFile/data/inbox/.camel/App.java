package com.evolvus.examples.camel.fileCopy;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class App {
    public static void main(final String[] args) throws Exception {
        final String sourceFolder = "file:data/inbox";
        final String destinationFolder = "file:data/outbox";

        final CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
           
            public void configure() {
                from(sourceFolder).to(destinationFolder);
            }
        });

        camelContext.start();
        Thread.sleep(30000);
        camelContext.stop();
    }
}
