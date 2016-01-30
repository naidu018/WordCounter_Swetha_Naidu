package com.company.guioperations;

/*
 * This class adds the filter to the type of file that is being chosen by the user.
 * The main program only accepts read-me and word files. 
 * So, two file filters can be added to make the work of selecting text and read-me files easier.
 */

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileTypeFilters extends FileFilter{	
	private final String extension;
	private final String description;	
	public FileTypeFilters(String extension,String description) 
	{
		this.extension=extension;
		this.description=description;
	}	
	@Override
	public boolean accept(File file) {
		
		if(file.isDirectory())
			return true;
		return file.getName().endsWith(extension);
	}
	@Override
	public String getDescription() {
		return description+String.format("(*%s)", extension);
	}

	
}
