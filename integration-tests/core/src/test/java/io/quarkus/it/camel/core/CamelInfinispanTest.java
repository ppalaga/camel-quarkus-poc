package io.quarkus.it.camel.core;

import static org.hamcrest.Matchers.is;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import java.net.URI;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(InfinispanServerTestResource.class)
public class CamelInfinispanTest {

    @Test
    public void testInfinispan() throws Exception {
        RestAssured.with().body("Hello Infinispan").post(new URI("http://localhost:8999/put")).then();

        RestAssured.when().get(new URI("http://localhost:8999/get")).then().body(is("Hello Infinispan"));
    }
}
