package com.github.jdussouillez.client;

import io.quarkus.rest.client.reactive.ClientRedirectHandler;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient(configKey = "token-service")
public interface TokenServiceApiClient {

    @POST
    @Path("token")
    @ClientHeaderParam(name = "X-Api-Version", value = "v1.0")
    Uni<Token> getToken(final TokenRequest req);

    @ClientRedirectHandler
    public static URI handleRedirect(final Response resp) {
        // https://quarkus.io/guides/rest-client-reactive#redirection
        return Response.Status.Family.familyOf(resp.getStatus()) == Response.Status.Family.REDIRECTION
            ? resp.getLocation()
            : null;
    }
}
