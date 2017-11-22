package tour.donnees.nuvem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_album")
	private Long idAlbum;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_artist")
	private Artist artist;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="album")
	private List<Music> music = new ArrayList<>();

	public Album(String title, Artist artist){
		this.title = title;
		this.artist = artist;
	}
	
	public Album(String title, Artist artist, List<Music> music){
		this(title, artist);
		this.music = music;
	}
	
	public Album() {
		
	}
	
	public Long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Music> getMusic() {
		return music;
	}

	public void setMusic(List<Music> music) {
		this.music = music;
	}
	
	
	
}
