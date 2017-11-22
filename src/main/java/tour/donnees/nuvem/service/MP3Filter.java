package tour.donnees.nuvem.service;

import java.io.File;
import java.io.FileFilter;

public class MP3Filter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().toLowerCase().contains(".mp3");
	}
}
