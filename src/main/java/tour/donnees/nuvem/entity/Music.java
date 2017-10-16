package tour.donnees.nuvem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="music")
public class Music {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_music")
	private Long idMusic;
	
	@Column(name="title")
	private String title;
	
	@Column(name="size")
	private Long size;
	
	@Column(name="duration")
	private Long duration;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="genre")
	private String genre;
	
	@ManyToOne
	private Album album;

	public Long getIdMusic() {
		return idMusic;
	}

	public void setIdMusic(Long idMusic) {
		this.idMusic = idMusic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
