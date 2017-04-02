package view;
/**
 * Created by Ramzan on 13/12/2016.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import controller.SlotMachineController;
import model.SlotMachine;

@SuppressWarnings("serial")
public class StatsGUIInterface extends JFrame {

	private JButton save;
	private JLabel statsLabel;
	private JLabel wonCountLabel;
	private JLabel lostCountLabel;
	private JLabel averageLabel;
	// End of variables declaration

	// start the designing and initialising
	public StatsGUIInterface() {
		SlotMachine object = new SlotMachine();
		setContentPane(new JLabel(new ImageIcon("src/images/background.jpg")));
		design();
		wonCountLabel.setText("Wins : " + object.getWin());
		lostCountLabel.setText("Losses : " + object.getLoses());
		float profit = object.getWin() - object.getLoses();
		// number of games is zero set label as "--"
		try {
			averageLabel.setText("Average of netted credit : " + profit / object.getNumberOfGames());
		} catch (ArithmeticException e) {
			averageLabel.setText("Average of netted credit : -- ");
		}
		// design the frame
		setTitle("Statistics");
		setSize(580, 350);
		ImageIcon img = new ImageIcon("src/images/icon.png");
		setIconImage(img.getImage());
		setMinimumSize(new Dimension(580, 350));
	}

	// stats GUI Interface
	@SuppressWarnings("unchecked")
	private void design() {
		GridBagConstraints gridBagConstraints;

		// initialise the graphical components
		statsLabel = new JLabel();
		wonCountLabel = new JLabel();
		lostCountLabel = new JLabel();
		averageLabel = new JLabel();
		save = new JButton();

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());

		// title
		statsLabel.setFont(new Font("Tahoma", 0, 24));
		statsLabel.setText("Statistics");
		statsLabel.setForeground(new Color(0, 128, 255));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(0, 0, 0, 200);
		Font font = statsLabel.getFont();
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		statsLabel.setFont(font.deriveFont(attributes));
		getContentPane().add(statsLabel, gridBagConstraints);

		// wins labels
		wonCountLabel.setForeground(new Color(0, 128, 255));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(52, 21, 0, 0);
		getContentPane().add(wonCountLabel, gridBagConstraints);

		// losses label
		lostCountLabel.setForeground(new Color(0, 128, 255));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(45, 21, 0, 0);
		getContentPane().add(lostCountLabel, gridBagConstraints);

		// average label
		averageLabel.setForeground(new Color(0, 128, 255));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(39, 21, 0, 0);
		getContentPane().add(averageLabel, gridBagConstraints);

		// save button
		save.setText("Save");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(34, 20, 25, 0);
		getContentPane().add(save, gridBagConstraints);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveActionPerformed(evt);
			}
		});
		pack();
	}

	// Action to perform when Save button is pressed
	private void saveActionPerformed(ActionEvent evt) {
		// call the save method
		new SlotMachineController().save();
	}

}
