package rest;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.UserBusiness;
import rest.object.ListRest;
import util.Filter;



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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response getUsers(Object params) {
		try {
			Map mapParams = (Map) params;

			String direction = null;
			if (mapParams.get("direction") != null) {
				direction = mapParams.get("direction").toString();
			}
				
			String sort = null;
			if (mapParams.get("sort") != null) {
				sort = mapParams.get("sort").toString();
			}

			Integer pageIndex = null;
			if (mapParams.get("pageIndex") != null) {
				pageIndex = Integer.parseInt(mapParams.get("pageIndex").toString());

			}
				
			Integer pageSize = null;
			if (mapParams.get("pageSize") != null) {
				pageSize = Integer.parseInt(mapParams.get("pageSize").toString());
			}

			mapParams.remove("direction");
			mapParams.remove("sort");
			mapParams.remove("pageIndex");
			mapParams.remove("pageSize");

			Filter filter = new Filter();
			filter.setAmountRecords(pageSize);
			filter.setFirstRecord(pageSize * pageIndex);	
			if (direction.equals("desc")) {
				filter.setAscendant(false);
			} else {
				filter.setAscendant(true);
			}
			if (!sort.isBlank()) {
				filter.setPropertyOrder(sort);
			}

			List<Object> listGridDTO;
			

			listGridDTO = userBusiness.getAllUsers(mapParams, filter);
			Integer length = userBusiness.searchCount(mapParams);

			ListRest<Object> resultado = new ListRest<Object>();
			resultado.setList(listGridDTO);
			resultado.setLength(length);

			return Response.ok().entity(resultado).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@POST
	@Path("/teste")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response getUsers() {
		try {
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/testeget")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Response oi() {
		try {
			return Response.status(Response.Status.OK).entity("FUNCIONOU").build();
			//return Response.ok("FUNCIONOU").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
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
