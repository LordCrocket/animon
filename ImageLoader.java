import javax.swing.ImageIcon;
import java.net.URL;
class ImageLoader {
	private static final ImageLoader loader = new ImageLoader();	
	private static final String IMAGEPATH = "images/";
	private static ImageLoader getImageLoader(){
		return loader;
	}

	public static ImageIcon loadImage(String url){
		URL path = loader.getClass().getResource(IMAGEPATH+url);
		if(path != null)
			return new ImageIcon(path);
		else {
			System.err.println("Could not load:"+ url);
			return null;
		}
	}

}
