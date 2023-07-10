package com.github.jdussouillez.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class TokenRequest implements Serializable {

    @JsonProperty
    protected String value;

    public TokenRequest(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
