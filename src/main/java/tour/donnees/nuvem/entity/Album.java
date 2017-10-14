package tour.donnees.nuvem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_album")
	private Long idAlbum;
	
	@Column(name="name")
	private String name;
	
	@Column(name="artist")
	private Artist artist;
	
	@Column(name="music")
	private List<Music> music;
}
