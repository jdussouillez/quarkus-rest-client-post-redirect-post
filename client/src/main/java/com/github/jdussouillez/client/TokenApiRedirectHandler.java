package com.github.jdussouillez.client;

import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ContextResolver;
import org.jboss.resteasy.reactive.client.handlers.AdvancedRedirectHandler;

public class TokenApiRedirectHandler implements ContextResolver<AdvancedRedirectHandler> {

    @Override
    public AdvancedRedirectHandler getContext(final Class<?> type) {
        return context -> {
            var req = context.request();
            var resp = context.jaxRsResponse();
            if (req.getMethod() == HttpMethod.POST && Response.Status.Family.familyOf(resp.getStatus()) == Response.Status.Family.REDIRECTION) {
                var result = new RequestOptions();
                result.setMethod(HttpMethod.POST);
                result.setAbsoluteURI(resp.getLocation().toString());
                result.addHeader("X-Api-Version", req.headers().get("X-Api-Version"));
                return result;
            }
            return null;
        };
    }
}
