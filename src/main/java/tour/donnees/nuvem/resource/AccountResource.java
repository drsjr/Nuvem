package tour.donnees.nuvem.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tour.donnees.nuvem.controller.AccountController;
import tour.donnees.nuvem.entity.Account;

@Path("account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {
	
	private AccountController controller = new AccountController();
	
	private PlayListResource  playlist;
	
	@GET
	@Path("/{accountId}")
	public Account getById(@PathParam("accountId") Long id) {
		Account acc = controller.accountById(id);
		return acc;
	}
	
	@POST
	public Account insertAccount(Account account) {
		return controller.insertAccount(account);
	}
	
	@PUT
	@Path("/{accountId}")
	public Account updateAccount(Account account, @PathParam("accountId") Long id){
		return controller.updateAccount(account, id);
	}
	
	@DELETE
	@Path("/{accountId}")
	public Account deleteAccount(@PathParam("accountId") Long id) {
		return controller.deleteAccount(id);
	}
	
	@Path("/{accountId}/playlist")
	public PlayListResource getPlayList(@PathParam("accountId") Long id) {
		if(playlist != null) {
			playlist = new PlayListResource();
		}

		return new PlayListResource();
	}
	

}
