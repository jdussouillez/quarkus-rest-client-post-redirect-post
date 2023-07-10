package com.github.jdussouillez.server;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Path("/token")
public class TokenResource {

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> getToken(final TokenRequest req) {
        return Uni.createFrom().item(
            Response.status(Status.TEMPORARY_REDIRECT)
                .location(URI.create("http://localhost:8080/token/2"))
                .build()
        );
    }

    @POST
    @Path("2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Token> getToken2(final TokenRequest req) {
        return Uni.createFrom().item(
            new Token(
                "token-for-" + req.getValue(),
                LocalDateTime.now(ZoneOffset.UTC).plusHours(6L)
            )
        );
    }
}
