package model;

import java.util.Random;

/**
 * Created by hp on 15/12/2016.
 */
public class Reel {

	private Symbol[] symbols;

	// initialise the symbol array
	public Reel(int index) {
		Random r = new Random((long) index);
		// initialise the icon array
		Symbol[] icons = Symbol.values();
		this.symbols = new Symbol[icons.length];
		int unique = 0;

		// loop through the array and initialise with unique objects
		while (unique < icons.length) {
			int choice = r.nextInt(icons.length);
			// check the uniqueness
			if (!this.contains(this.symbols, icons[choice])) {
				symbols[unique++] = icons[choice];
			}
		}
	}

	// return the symbol array
	public Symbol[] spin() {
		return symbols;
	}

	// check the uniqueness of the symbol array
	private boolean contains(Symbol[] symbols, Symbol s) {
		// if the array already contain this object return true
		for (int i = 0; i < symbols.length; ++i) {
			if (symbols[i] == s) {
				return true;
			}
		}
		return false;
	}
}
