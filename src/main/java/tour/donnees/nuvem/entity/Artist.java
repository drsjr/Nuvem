package tour.donnees.nuvem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_artist")
	private Long idArtist;
	
	@Column(name="name")
	private String  name;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="artist")
	private List<Album>	album = new ArrayList<>(); 
	
	public Long getIdArtist() {
		return idArtist;
	}

	public void setIdArtist(Long idArtist) {
		this.idArtist = idArtist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}
	
}
