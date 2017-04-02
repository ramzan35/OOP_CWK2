package controller;

import javax.swing.*;

import model.Reel;
import model.SlotMachine;
import model.Symbol;
import view.MainGUIInterface;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by hp on 15/12/2016.
 */

@SuppressWarnings("serial")
public class SlotMachineController extends JComponent implements Runnable {

	private static Symbol[] sym;
	private static JPanel panel1, panel2, panel3;
	private static int row = 60;
	private static int index;
	private static boolean finished;
	private static Reel[] reels = new Reel[3];
	private int count;

	public SlotMachineController() {
	}

	// Create a object reference to the main GUIs' reels
	public SlotMachineController(JPanel panel, int reelNmb) {
		// pass reel1 reference to the panel1
		if (reelNmb == 1) {
			SlotMachineController.panel1 = panel;
			setBounds(0, 0, panel.getWidth(), panel.getHeight());
			// pass reel2 reference to the panel2
		} else if (reelNmb == 2) {
			SlotMachineController.panel2 = panel;
			setBounds(0, 0, panel.getWidth(), panel.getHeight());
			// pass reel3 reference to the panel3
		} else if (reelNmb == 3) {
			SlotMachineController.panel3 = panel;
			setBounds(0, 0, panel.getWidth(), panel.getHeight());
			// initialise the symbol array with value "Seven"
			sym = Symbol.values();
			for (int index = 0; index < 3; index++)
				sym[index] = Symbol.SEVEN;

		}
	}

	// add mouse listeners to to reels
	public void stopSpinning() {
		panel1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finished = false;
				calculatePayout(sym);
			}
		});

		panel2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finished = false;
				calculatePayout(sym);
			}
		});

		panel3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				finished = false;
				calculatePayout(sym);
			}
		});
	}

	// save the statistics
	public void save() {
		// create a file name with current time
		String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		SlotMachine object = new SlotMachine();
		File file = new File("src/files/" + fileName + ".txt");
		try (FileWriter fw = new FileWriter(file);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw)) {
			out.println("Wins : " + object.getWin());
			out.println("Losses : " + object.getLoses());
			float profit = object.getWin() - object.getLoses();
			try {
				out.println("Average of netted credit : " + profit / object.getNumberOfGames());
			} catch (ArithmeticException e) {
				out.println("Average of netted credit : -- ");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// start to spin the reels
	public void startSpining() {
		initializeReels();
		finished = true;
		// get new symbols to the reels
		sym = getSymbol();
		// start the thread
		Thread kf1 = new Thread(new SlotMachineController());
		kf1.start();
	}

	// animate the symbol through reels
	public synchronized void paint(Graphics g) {
		int column = 10;

		g.drawImage(sym[index].getImage(), column, row, 130, 130, null);

		index++;

		if (index == 3)
			index = 0;
	}

	// spin the reels
	public void run() {
		while (finished) {
			panel1.repaint();
			panel2.repaint();
			panel3.repaint();
			row += 10;
			if (row > 160) {
				sym = getSymbol();
				row = 0;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	// calculate the the pay out
	public void calculatePayout(Symbol[] sym) {
		SlotMachine slotMachineObj = new SlotMachine();
		// player should bet first before stop the spin
		if (slotMachineObj.getBet() > 0) {
			int win = 0;
			String msg = "";
			// if the not even two symbols are matched
//			System.out.println(sym[0].getValue()+" "+sym[1].getValue()+" "+sym[2].getValue());
			if (sym[0].getValue() != sym[1].getValue() && sym[0].getValue() != sym[2].getValue()
					&& sym[1].getValue() != sym[2].getValue()) {
				msg = "LOOSER";
				slotMachineObj.setLoses(slotMachineObj.getLoses() + slotMachineObj.getBet());
				slotMachineObj.setBet(0);
				slotMachineObj.setNumberOfGames(slotMachineObj.getNumberOfGames() + 1);
				// if all three symbols are matched
			} else if (sym[0].getValue() == sym[1].getValue() && sym[0].getValue() == sym[2].getValue()
					&& sym[1].getValue() == sym[2].getValue()) {
				win = slotMachineObj.getBet() * (sym[0].getValue());
				msg = "WINNER \nYou have won $" + win;
				slotMachineObj.setBet(0);
				slotMachineObj.setWin(slotMachineObj.getWin() + win);
				slotMachineObj.setNumberOfGames(slotMachineObj.getNumberOfGames() + 1);
				// if two symbols are matched
			} else if (sym[0].getValue() == sym[1].getValue() && sym[0].getValue() != sym[2].getValue()) {
				msg = "You have got a free spin";
				// if two symbols are matched
			} else if (sym[0].getValue() == sym[2].getValue() && sym[0].getValue() != sym[1].getValue()) {
				msg = "You have got a free spin";
				// if two symbols are matched
			} else if (sym[1].getValue() == sym[2].getValue() && sym[0].getValue() != sym[1].getValue()) {
				msg = "You have got a free spin";
			}
			slotMachineObj.setCredit(slotMachineObj.getCredit() + win);
			JOptionPane.showMessageDialog(null, msg);

			new MainGUIInterface().setIsSpinning(false);
			new MainGUIInterface().updateLabels();
			new MainGUIInterface().updateDisabledButtons();
		}
	}

	// initialise 3 reels with symbols each of them will have symbols in different order
	public void initializeReels() {
		Random rand = new Random();
		int index = rand.nextInt(6);
		reels[0] = new Reel(index);
		reels[1] = new Reel(index + 1);
		reels[2] = new Reel(index + 2);

	}

	// return a array with 3 symbols to display in the reel
	public synchronized Symbol[] getSymbol() {
		Symbol[] symbols = new Symbol[3];

		if (count == reels[0].spin().length) {
			count = 0;
		}

		symbols[0] = reels[0].spin()[count];
		symbols[1] = reels[1].spin()[count];
		symbols[2] = reels[2].spin()[count];

		count++;
		return symbols;
	}
}
