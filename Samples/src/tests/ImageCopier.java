package tests;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageCopier {
	
	public static void copySpellImage(String spellName, String spellId, String imageName, String className) throws IOException{
		URL url = new URL("http://wow.zamimg.com/images/wow/icons/large/" + imageName +".jpg");
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[4096];
		int n = 0;
		while (-1!=(n=in.read(buf)))
		{
		   out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();
		spellName = spellName.replace(":", "");
		System.out.println("Spell after replacing :" +spellName);
		File imageDir= new File("c://home2//" + className); 
		if (!imageDir.exists()){
			boolean success = imageDir.mkdirs();
			if (!success) {
			    System.out.println("Image Dir could not be created");
			}			
		}

		FileOutputStream fos = new FileOutputStream(imageDir +"//" +className + "_" + spellName.trim() + "_" +spellId +".jpg" );
	    fos.write(response);
	    fos.close();	
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String className = "WARR";
		boolean success = (new File("c://home2" + className)).mkdir();
		if (!success) {
		    System.out.println("Dir could not be created");
		}


	}

}
