package rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import business.UserBusiness;
import entity.User;


/**
 * @author  Vinicius Pedro da Silveira
 */

@Path("/user")
@RequestScoped
public class UserRestService {
	
	@Inject
	private UserBusiness userBusiness;
	
	@POST
	@Path("/allUsers")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		List<User> users;
		try {
			users = userBusiness.getAllUsers();
		} catch (Exception e) {
			users = new ArrayList<User>();
			e.printStackTrace();
		}
		return users;
	}
	
//	@POST
//	@Path("/register")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response registerUser(UserRest uRest) {
//		
//		String resultado = "";
//		try {
//
//			resultado = userBusiness.register(User.to);
//			if (resultado.contains("id:")) {
//				IdRest id_r = new IdRest();
//				id_r.setId(resultado.replaceAll("id:", ""));
//				return Response.ok().entity(id_r).build();
//			} else {
//				Erro erro = new Erro();
//				erro.setDescricao(resultado);
//				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(erro).build();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return error(e.getMessage());
//		}
//		
//		List<User> users;
//		try {
//			users = userBusiness.getAllUsers();
//		} catch (Exception e) {
//			users = new ArrayList<User>();
//			e.printStackTrace();
//		}
//		return users;
//	}

}
