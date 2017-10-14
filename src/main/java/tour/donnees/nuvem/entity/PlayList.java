package tour.donnees.nuvem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PlayList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_playlist")
	private Long IdPlayList;
	
	@Column(name="id_playlist")
	private String name;
	
	@Column(name="account")
	private Account account;
	
	@Column(name="musics")
	private List<Music> musics;

}
