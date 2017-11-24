package tour.donnees.nuvem.dao.repository;

import java.util.List;

public interface PlayListImpl<PlayList> extends Entity<PlayList> {

	List<PlayList> getAllPlaylist(Long accountId);
}
