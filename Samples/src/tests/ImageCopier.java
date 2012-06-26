package tests;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageCopier {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//http://wow.zamimg.com/images/wow/icons/medium/ability_monk_healthsphere.jpg
		URL url = new URL("http://wow.zamimg.com/images/wow/icons/large/ability_monk_healthsphere.jpg");
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
		FileOutputStream fos = new FileOutputStream("C://home//ability_monk_healthsphere.jpg");
	    fos.write(response);
	    fos.close();


	}

}
