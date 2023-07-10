package com.github.jdussouillez.client;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class TokenService {

    @RestClient
    protected TokenServiceApiClient client;

    public void onStart(final @Observes StartupEvent ev) {
        var token = client.getToken(new TokenRequest("test"))
            .await()
            .indefinitely();
        System.out.println("Token: " + token);
    }
}
