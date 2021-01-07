package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/account")
@Produces(APPLICATION_JSON)

public class AccountResource {
    @Inject
    AccountRepository repository;

    @GET
    @Path("/accountName/{name}")
    public Response getAccountName(@PathParam("name") String name) {
        Account accountname = repository.findByName(name);
        return Response.ok(accountname).build();
    }
}
