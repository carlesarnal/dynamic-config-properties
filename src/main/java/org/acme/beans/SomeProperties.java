
package org.acme.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Type for SomeProperties
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app.properties.static.string",
    "app.properties.static.int",
    "app.properties.static.bool",
    "app.properties.static.long",
    "app.properties.dynamic.string",
    "app.properties.dynamic.int",
    "app.properties.dynamic.bool",
    "app.properties.dynamic.long"
})
@Generated("jsonschema2pojo")
@io.quarkus.runtime.annotations.RegisterForReflection
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class SomeProperties {

    @JsonProperty("app.properties.static.string")
    private String appPropertiesStaticString;
    @JsonProperty("app.properties.static.int")
    private String appPropertiesStaticInt;
    @JsonProperty("app.properties.static.bool")
    private String appPropertiesStaticBool;
    @JsonProperty("app.properties.static.long")
    private String appPropertiesStaticLong;
    @JsonProperty("app.properties.dynamic.string")
    private String appPropertiesDynamicString;
    @JsonProperty("app.properties.dynamic.int")
    private String appPropertiesDynamicInt;
    @JsonProperty("app.properties.dynamic.bool")
    private String appPropertiesDynamicBool;
    @JsonProperty("app.properties.dynamic.long")
    private String appPropertiesDynamicLong;

    @JsonProperty("app.properties.static.string")
    public String getAppPropertiesStaticString() {
        return appPropertiesStaticString;
    }

    @JsonProperty("app.properties.static.string")
    public void setAppPropertiesStaticString(String appPropertiesStaticString) {
        this.appPropertiesStaticString = appPropertiesStaticString;
    }

    @JsonProperty("app.properties.static.int")
    public String getAppPropertiesStaticInt() {
        return appPropertiesStaticInt;
    }

    @JsonProperty("app.properties.static.int")
    public void setAppPropertiesStaticInt(String appPropertiesStaticInt) {
        this.appPropertiesStaticInt = appPropertiesStaticInt;
    }

    @JsonProperty("app.properties.static.bool")
    public String getAppPropertiesStaticBool() {
        return appPropertiesStaticBool;
    }

    @JsonProperty("app.properties.static.bool")
    public void setAppPropertiesStaticBool(String appPropertiesStaticBool) {
        this.appPropertiesStaticBool = appPropertiesStaticBool;
    }

    @JsonProperty("app.properties.static.long")
    public String getAppPropertiesStaticLong() {
        return appPropertiesStaticLong;
    }

    @JsonProperty("app.properties.static.long")
    public void setAppPropertiesStaticLong(String appPropertiesStaticLong) {
        this.appPropertiesStaticLong = appPropertiesStaticLong;
    }

    @JsonProperty("app.properties.dynamic.string")
    public String getAppPropertiesDynamicString() {
        return appPropertiesDynamicString;
    }

    @JsonProperty("app.properties.dynamic.string")
    public void setAppPropertiesDynamicString(String appPropertiesDynamicString) {
        this.appPropertiesDynamicString = appPropertiesDynamicString;
    }

    @JsonProperty("app.properties.dynamic.int")
    public String getAppPropertiesDynamicInt() {
        return appPropertiesDynamicInt;
    }

    @JsonProperty("app.properties.dynamic.int")
    public void setAppPropertiesDynamicInt(String appPropertiesDynamicInt) {
        this.appPropertiesDynamicInt = appPropertiesDynamicInt;
    }

    @JsonProperty("app.properties.dynamic.bool")
    public String getAppPropertiesDynamicBool() {
        return appPropertiesDynamicBool;
    }

    @JsonProperty("app.properties.dynamic.bool")
    public void setAppPropertiesDynamicBool(String appPropertiesDynamicBool) {
        this.appPropertiesDynamicBool = appPropertiesDynamicBool;
    }

    @JsonProperty("app.properties.dynamic.long")
    public String getAppPropertiesDynamicLong() {
        return appPropertiesDynamicLong;
    }

    @JsonProperty("app.properties.dynamic.long")
    public void setAppPropertiesDynamicLong(String appPropertiesDynamicLong) {
        this.appPropertiesDynamicLong = appPropertiesDynamicLong;
    }

}
