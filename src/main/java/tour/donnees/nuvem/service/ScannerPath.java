package tour.donnees.nuvem.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.MP3Frame;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.hibernate.Session;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tour.donnees.nuvem.entity.Album;
import tour.donnees.nuvem.entity.Artist;
import tour.donnees.nuvem.entity.Music;

public class ScannerPath implements Runnable {

	private static final String PATH = "/home/junior/Music";
	
	private MP3Filter filter;
	
	private List<File>   folders;
	private List<Music>  musics;
	private List<Album>  albuns;
	private List<Artist> artists;
	
	private ContentHandler handler;
	private Parser 		   parser;
	private ParseContext   context;
	
	public ScannerPath(Session session) {
		this.folders = new ArrayList<File>();
		this.filter = new MP3Filter();
		this.handler = new DefaultHandler();
		this.parser  = new Mp3Parser();
		this.context = new ParseContext();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	private void folders() {
		File[] myFolders = new File(PATH).listFiles();
		for(File folder : myFolders) {
			if(folder.isDirectory()){
				folders.add(folder);
			}			
		}
	}
	
	private void scanFolder(File folder) throws IOException, SAXException, TikaException {
		File[] mp3s = folder.listFiles(filter);
		for(File mp3 : mp3s) {
			mountMusic(mp3);
		}
	}
	
	
	private void mountMusic(File mp3) throws IOException, SAXException, TikaException {
		
		Metadata meta = new Metadata();
		
		InputStream input = new FileInputStream(mp3);
		
		parser.parse(input, handler, meta, context);
		
		String musicTitle 	 = meta.get("title");
		String musicDuration = meta.get("xmpDM:duration");
		String musicYear 	 = meta.get("xmpDM:releaseDate");
		String musicSize 	 = String.valueOf(mp3.length());
		String musicPath	= mp3.getAbsolutePath();
		
		String albumTitle 	 = meta.get("xmpDM:album");
		
		String artistName 	 = meta.get("xmpDM:artist");
		
		
		if(!isExistArtist(artistName)) {
			artists.add(new Artist(artistName));
		}
		
		if(isExistMusic(musicTitle)){
			
			Music music = new Music(musicTitle, 
					new Long(musicSize), 
					new Long(musicDuration), 
					new Integer(musicYear),
					"Rock",
					musicPath);
			
			musics.add(music);
			
		}
	}
	
	
	private boolean isExistMusic(String MusicName){
		return false;
	}
	
	private boolean isExistArtist(String name) {
		return artists.contains(new Artist(name));
	}
	
	private boolean isExistAlbum(String name) {
		return true;//albuns.contains(new Album(name));
	}
	
	
}
