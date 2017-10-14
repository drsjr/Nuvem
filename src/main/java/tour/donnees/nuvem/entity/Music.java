package tour.donnees.nuvem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="album")
	private Album album;
	
	@Column(name="artist")
	private Artist artist;
	
	
	
}
