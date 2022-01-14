package org.acme;

import org.acme.beans.SomeProperties;
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

        setStaticProperty("app.properties.static.string", "new value");
    }

    /**
     *
     */
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