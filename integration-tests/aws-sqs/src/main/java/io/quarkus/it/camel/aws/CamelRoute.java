package io.quarkus.it.camel.aws;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.camel.builder.RouteBuilder;

@RegisterForReflection
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:quarkus?repeatCount=1").setBody(constant("Quarkus is great!")).to("aws-sqs://camel-1")
                .to("log:sf?showAll=true");

    }

}
