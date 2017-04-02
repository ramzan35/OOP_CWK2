package model;

import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public enum Symbol implements ISymbol {

	// Constants
	SEVEN(7, "images/5.png"), BELL(6, "images/4.png"),WATERMELON(5, "images/3.png"), PLUM(4, "images/2.png"),
	LEMON(3,"images/1.png"), CHERRY(2, "images/0.png");

//	@SuppressWarnings("unused")
	private String icon; 			// Symbol file name
	private int value; 				// Symbol value
	private BufferedImage image; 	// Symbol image

	Symbol(int value, String icon) {
		this.icon = icon;
		try {
			setValue(value);
			setImage(icon);
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Error : "+e);
			System.exit(0);
		}
	}

	// return the image
	public BufferedImage getImage() {
		return image;
	}

	// set value for constants
	public void setValue(int value) {
		// value should be greater than zero
		if (value > 0)
			this.value = value;
		else
			throw new RuntimeException("Symbols' values are not valid");			
	}

	// return the value
	public int getValue() {
		return value;
	}

	// set the image for constants
	public void setImage(String icon) {
		// if image could not be loaded
		try {
		if (icon == null)
			throw new RuntimeException("Symbol file name is not valid");
			image = ImageIO.read(getClass().getResource(icon));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e);
		}
	}
}