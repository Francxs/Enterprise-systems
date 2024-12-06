package app.rest.controllers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.UserComponent;
import app.dto.LoginRequestDTO;
import app.entities.User;

@Component
@Path("/auth")
public class LoginController {
	
	@Autowired
    private UserComponent userComponent;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestDTO loginRequest) {
        try {
            User user = userComponent.authenticateUser(loginRequest.getIDNumber(), loginRequest.getPassword());
            // Use the user variable here, for example, generate a token or return user details
            String token = generateToken(user); // Example method to generate a token
            return Response.ok("Login successful. Token: " + token).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }

    private String generateToken(User user) {
        // Implement token generation logic here
        return "dummy-token-for-" + user.getIDNumber();
    }

}
