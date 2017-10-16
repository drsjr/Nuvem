package tour.donnees.nuvem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="playlist")
public class PlayList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_playlist")
	private Long IdPlayList;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="playlist_music",
				joinColumns=@JoinColumn(name="id_playlist"),
				inverseJoinColumns=@JoinColumn(name="id_music"))	
	private List<Music> musics = new ArrayList<>();

	public Long getIdPlayList() {
		return IdPlayList;
	}


	public void setIdPlayList(Long idPlayList) {
		IdPlayList = idPlayList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Music> getMusics() {
		return musics;
	}


	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
}
