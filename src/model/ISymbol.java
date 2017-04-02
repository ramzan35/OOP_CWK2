package model;

import java.awt.image.BufferedImage;

/**
 * Created by Ramzan on 13/12/2016.
 */

public interface ISymbol {

	BufferedImage getImage();

	void setImage(String icon);

	void setValue(int value);

	int getValue();
}
