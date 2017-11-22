package tour.donnees.nuvem.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tour.donnees.nuvem.controller.PlayListController;
import tour.donnees.nuvem.entity.PlayList;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayListResource {

	private PlayListController controller = new PlayListController();
	
	@GET
	public List<PlayList> getAllPlaylist(@PathParam("accountId") Long id) {
		return controller.getAllPlayList(id);
	}
	
	@POST
	public PlayList newPlaylist(@PathParam("accountId") Long id,  PlayList playList) {
		return controller.newPlayList(id, playList);
	}
	
}
