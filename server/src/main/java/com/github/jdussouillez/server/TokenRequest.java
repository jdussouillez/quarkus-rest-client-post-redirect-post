package com.github.jdussouillez.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class TokenRequest implements Serializable {

    @JsonProperty
    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
