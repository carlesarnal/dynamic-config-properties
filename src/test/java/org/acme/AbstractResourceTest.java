/*
 * Copyright 2022 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acme;

import static io.restassured.RestAssured.given;

import org.acme.beans.ConfigurationProperty;
import org.acme.beans.SomeProperties;
import org.hamcrest.CoreMatchers;

import io.restassured.http.ContentType;

/**
 * @author eric.wittmann@gmail.com
 */
public abstract class AbstractResourceTest {

    protected void setDynamicProperty(String name, String value) {
        ConfigurationProperty property = ConfigurationProperty.builder().name(name).value(value).build();
        given().body(property)
            .when()
                .contentType(ContentType.JSON)
                .post("/admin/config/properties")
            .then()
            .statusCode(204);
    }

    protected void assertDynamicPropertyInvalid(String name, String value) {
        ConfigurationProperty property = ConfigurationProperty.builder().name(name).value(value).build();
        given().body(property)
            .when()
                .contentType(ContentType.JSON)
                .post("/admin/config/properties")
            .then()
            .statusCode(409);
    }

    protected void setStaticProperty(String name, String value) {
        ConfigurationProperty property = ConfigurationProperty.builder().name(name).value(value).build();
        given().body(property)
            .when()
                .contentType(ContentType.JSON)
                .post("/admin/config/properties")
            .then()
            .statusCode(409); // should fail with a 409
    }

    protected void assertDynamicPropertyEquals(String name, String expectedValue) {
        given()
            .when()
                .pathParam("name", name)
                .get("/admin/config/properties/{name}")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("value", CoreMatchers.is(expectedValue));
    }

    protected void assertDynamicPropertyNotFound(String name) {
        given()
            .when()
                .pathParam("name", name)
                .get("/admin/config/properties/{name}")
            .then()
            .statusCode(404);
    }

    protected void assertDynamicPropertyIsNull(String name) {
        given()
            .when()
                .pathParam("name", name)
                .get("/admin/config/properties/{name}")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("value", CoreMatchers.nullValue());
    }

    protected void assertPropertyEquals(String name, String expectedValue) {
        given()
            .when()
                .pathParam("name", name)
                .get("/properties/{name}")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("value", CoreMatchers.is(expectedValue));
    }

    protected void assertPropertyIsNull(String name) {
        given()
            .when()
                .pathParam("name", name)
                .get("/properties/{name}")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("value", CoreMatchers.nullValue());
    }

    protected SomeProperties getSomeProperties() {
        return given()
            .when()
                .get("/test")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract().body().as(SomeProperties.class);
    }

}
