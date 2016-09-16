package com.waterdrawer.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ResourceUtil 
{
	public static ImageView getImageView(String imageName)
	{
		ImageView image = new ImageView(new Image("/com/waterdrawer/image/"+imageName));
		return image;
	}
}
