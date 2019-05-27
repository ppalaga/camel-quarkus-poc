package io.quarkus.it.camel.core;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import java.net.URI;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(InfinispanServerTestResource.class)
public class CamelTest {
    @Test
    public void testRoutes() {
        RestAssured.when().get("/test/routes").then().body(containsString("timer"));
    }

    @Test
    public void testProperties() {
        RestAssured.when().get("/test/property/camel.context.name").then().body(is("quarkus-camel-example"));
    }

    @Test
    public void testNetty4Http() throws Exception {
        RestAssured.when().get(new URI("http://localhost:8999/foo")).then().body(is("Netty Hello World"));
    }
}
