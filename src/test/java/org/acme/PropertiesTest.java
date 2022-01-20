package org.acme;

import org.acme.beans.SomeProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PropertiesTest extends AbstractResourceTest {

    @Test
    public void testProperties() {
        printPropertyValues();

        assertPropertyEquals("greeting.hello", "Hello!!");

        assertDynamicPropertyNotFound("app.properties.dynamic.string");
        setDynamicProperty("app.properties.dynamic.string", "Hello world");
        assertDynamicPropertyEquals("app.properties.dynamic.string", "Hello world");

        printPropertyValues();

        SomeProperties someProperties = getSomeProperties();
        Assertions.assertEquals("Foo Bar", someProperties.getAppPropertiesStaticString());
        Assertions.assertEquals(10, someProperties.getAppPropertiesStaticInt());
        Assertions.assertEquals(Boolean.TRUE, someProperties.getAppPropertiesStaticBool());
        Assertions.assertEquals(182934758136113l, someProperties.getAppPropertiesStaticLong());

        // Note: once everything is working as we want, attempting to update a static property
        //       should fail with a 409 (conflict)
        setStaticProperty("app.properties.static.string", "new value");

        // Note: once everything is working as we want, attempting to update a dynamic property
        //       with a value that does not match the property's type should fail with a 409 (conflict)
        assertDynamicPropertyInvalid("app.properties.dynamic.bool", "INVALID_VALUE");
    }

    public void printPropertyValues() {
        SomeProperties someProperties = getSomeProperties();
        System.out.println("---");
        System.out.println("app.properties.static.string: " + someProperties.getAppPropertiesStaticString());
        System.out.println("app.properties.static.int: " + someProperties.getAppPropertiesStaticInt());
        System.out.println("app.properties.static.bool: " + someProperties.getAppPropertiesStaticBool());
        System.out.println("app.properties.static.long: " + someProperties.getAppPropertiesStaticLong());
        System.out.println("app.properties.dynamic.string: " + someProperties.getAppPropertiesDynamicString());
        System.out.println("app.properties.dynamic.int: " + someProperties.getAppPropertiesDynamicInt());
        System.out.println("app.properties.dynamic.bool: " + someProperties.getAppPropertiesDynamicBool());
        System.out.println("app.properties.dynamic.long: " + someProperties.getAppPropertiesDynamicLong());
    }

}