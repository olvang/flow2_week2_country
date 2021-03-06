package rest;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CorsResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestCtx, ContainerResponseContext res )
            throws IOException {
        System.out.println("Executing REST response filter");
        res.getHeaders().add("Access-Control-Allow-Origin", "*" );
        res.getHeaders().add("Access-Control-Allow-Credentials", "true" );
        res.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        res.getHeaders().add("Access-Control-Allow-Headers", "Origin, Accept, Content-Type");
    }
}