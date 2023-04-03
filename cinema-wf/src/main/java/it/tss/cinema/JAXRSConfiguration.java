package it.tss.cinema;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */

@LoginConfig(authMethod = "MP-JWT", realmName = "MP-JWT")
@DeclareRoles({"USER","ADMIN"})
@ApplicationPath("api")
public class JAXRSConfiguration extends Application {
    
}
