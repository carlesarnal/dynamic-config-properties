
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

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.string")
    private String appPropertiesStaticString;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.int")
    private Integer appPropertiesStaticInt;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.bool")
    private Boolean appPropertiesStaticBool;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.long")
    private Long appPropertiesStaticLong;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.string")
    private String appPropertiesDynamicString;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.int")
    private Integer appPropertiesDynamicInt;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.bool")
    private Boolean appPropertiesDynamicBool;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.long")
    private Long appPropertiesDynamicLong;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.string")
    public String getAppPropertiesStaticString() {
        return appPropertiesStaticString;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.string")
    public void setAppPropertiesStaticString(String appPropertiesStaticString) {
        this.appPropertiesStaticString = appPropertiesStaticString;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.int")
    public Integer getAppPropertiesStaticInt() {
        return appPropertiesStaticInt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.int")
    public void setAppPropertiesStaticInt(Integer appPropertiesStaticInt) {
        this.appPropertiesStaticInt = appPropertiesStaticInt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.bool")
    public Boolean getAppPropertiesStaticBool() {
        return appPropertiesStaticBool;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.bool")
    public void setAppPropertiesStaticBool(Boolean appPropertiesStaticBool) {
        this.appPropertiesStaticBool = appPropertiesStaticBool;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.long")
    public Long getAppPropertiesStaticLong() {
        return appPropertiesStaticLong;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.static.long")
    public void setAppPropertiesStaticLong(Long appPropertiesStaticLong) {
        this.appPropertiesStaticLong = appPropertiesStaticLong;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.string")
    public String getAppPropertiesDynamicString() {
        return appPropertiesDynamicString;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.string")
    public void setAppPropertiesDynamicString(String appPropertiesDynamicString) {
        this.appPropertiesDynamicString = appPropertiesDynamicString;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.int")
    public Integer getAppPropertiesDynamicInt() {
        return appPropertiesDynamicInt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.int")
    public void setAppPropertiesDynamicInt(Integer appPropertiesDynamicInt) {
        this.appPropertiesDynamicInt = appPropertiesDynamicInt;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.bool")
    public Boolean getAppPropertiesDynamicBool() {
        return appPropertiesDynamicBool;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.bool")
    public void setAppPropertiesDynamicBool(Boolean appPropertiesDynamicBool) {
        this.appPropertiesDynamicBool = appPropertiesDynamicBool;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.long")
    public Long getAppPropertiesDynamicLong() {
        return appPropertiesDynamicLong;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("app.properties.dynamic.long")
    public void setAppPropertiesDynamicLong(Long appPropertiesDynamicLong) {
        this.appPropertiesDynamicLong = appPropertiesDynamicLong;
    }

}
