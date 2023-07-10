package com.github.jdussouillez.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Token implements Serializable {

    @JsonProperty
    protected final String token;

    @JsonProperty
    protected final LocalDateTime expiresOn;

    public Token(final String token, final LocalDateTime expiresOn) {
        this.token = token;
        this.expiresOn = expiresOn;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpiresOn() {
        return expiresOn;
    }
}
