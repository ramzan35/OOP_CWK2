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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.SlotMachineController;
import model.SlotMachine;

@SuppressWarnings("serial")
public class MainGUIInterface extends JFrame {

	private final Color LABEL_COLOR = new Color(0, 128, 255);
	private final Font MED_LABEL_FONT = new Font("Sans Serif", Font.BOLD, 14);
	private final Font LG_LABEL_FONT = new Font("Sans Serif", Font.BOLD, 32);
	private static SlotMachine obj;
	private JButton spin;
	private JButton addCoin;
	private JButton reset;
	private JButton stats;
	private static JButton addOne;
	private static JButton addMax;
	private static JLabel creditLabel;
	private static JLabel betLebal;
	private JLabel titleLebal;
	private JPanel reel1;
	private JPanel reel2;
	private JPanel reel3;
	private static boolean isSpining;
	// End of variables declaration

	//set boolean value for reel spinning 
	public void setIsSpinning(boolean isSpining) {
		MainGUIInterface.isSpining = isSpining;
	}

	//start the designing and initialising
	public void start() {
		obj = new SlotMachine();
		setContentPane(new JLabel(new ImageIcon("src/images/background.jpg")));
		//design the main interface
		design();

		//Initialise the 3 reels
		new SlotMachineController().initializeReels();
		//add 3 reels of panel to slotmachines panels
		reel1.add(new SlotMachineController(reel1, 1));
		reel2.add(new SlotMachineController(reel2, 2));
		reel3.add(new SlotMachineController(reel3, 3));
		//add mouselistners to 3 reels
		new SlotMachineController().stopSpinning();
		//design the frame
		setTitle("Slot Machine");
		ImageIcon img = new ImageIcon("src/images/icon.png");
		setIconImage(img.getImage());
		setSize(580, 720);
		setMinimumSize(new Dimension(580, 720));
		setVisible(true);
	}
	//main GUI Interface
	@SuppressWarnings("unchecked")
	private void design() {
		GridBagConstraints gridBagConstraints;

		//initialise the graphical components
		reel1 = new JPanel();
		reel2 = new JPanel();
		reel3 = new JPanel();
		spin = new JButton();
		addCoin = new JButton();
		creditLabel = new JLabel();
		betLebal = new JLabel();
		addOne = new JButton();
		addMax = new JButton();
		reset = new JButton();
		stats = new JButton();
		titleLebal = new JLabel();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());

		reel1.setOpaque(false); //make reel1 transparent

		GroupLayout reel1Layout = new GroupLayout(reel1);
		reel1.setLayout(reel1Layout);
		reel1Layout
				.setHorizontalGroup(reel1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 140, Short.MAX_VALUE));
		reel1Layout
				.setVerticalGroup(reel1Layout.createParallelGroup(Alignment.LEADING).addGap(0, 242, Short.MAX_VALUE));

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;		// column 0
		gridBagConstraints.gridy = 1;		// row 1
		gridBagConstraints.gridwidth = 3;	//3 columns wide
		gridBagConstraints.ipadx = 140;		// increases components width
		gridBagConstraints.ipady = 242;		// increases components height
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;		//Put the component at the top-left corner of its display area.
		gridBagConstraints.insets = new Insets(21, 35, 0, 0);  //padding around the components
		getContentPane().add(reel1, gridBagConstraints);		//add the component

		reel2.setOpaque(false); //make reel2 transparent

		GroupLayout reel2Layout = new GroupLayout(reel2);
		reel2.setLayout(reel2Layout);
		reel2Layout
				.setHorizontalGroup(reel2Layout.createParallelGroup(Alignment.LEADING).addGap(0, 141, Short.MAX_VALUE));
		reel2Layout.setVerticalGroup(reel2Layout.createParallelGroup(Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;			// column 3
		gridBagConstraints.gridy = 1;			// row 1
		gridBagConstraints.gridwidth = 8;		//8 columns wide
		gridBagConstraints.ipadx = 141;			// increases components width
		gridBagConstraints.ipady = 242;			// increases components height
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;		//Put the component at the top-left corner of its display area.
		gridBagConstraints.insets = new Insets(21, 6, 0, 0);			 //padding around the components
		getContentPane().add(reel2, gridBagConstraints);				//add the component

		reel3.setOpaque(false);	//make reel3 transparent

		GroupLayout reel3Layout = new GroupLayout(reel3);
		reel3.setLayout(reel3Layout);
		reel3Layout
				.setHorizontalGroup(reel3Layout.createParallelGroup(Alignment.LEADING).addGap(0, 140, Short.MAX_VALUE));
		reel3Layout.setVerticalGroup(reel3Layout.createParallelGroup(Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 14;			// column 14
		gridBagConstraints.gridy = 1;			// row 1
		gridBagConstraints.gridwidth = 15;		//15 columns wide
		gridBagConstraints.ipadx = 140;			// increases components width
		gridBagConstraints.ipady = 242;			// increases components height
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;		//Put the component at the top-left corner of its display area.
		gridBagConstraints.insets = new Insets(21, 6, 0, 36);			 //padding around the components
		getContentPane().add(reel3, gridBagConstraints);				//add the component

		spin.setText("Spin");
		spin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SpinActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 29;
		gridBagConstraints.ipadx = 380;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(30, 35, 0, 36);
		getContentPane().add(spin, gridBagConstraints);

		addCoin.setText("Add Coin");
		addCoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addCoinActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 5;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(40, 40, 0, 0);
		getContentPane().add(addCoin, gridBagConstraints);

		// creditLabel.setText("Bet : 0");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 58;
		gridBagConstraints.ipady = 45;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(16, 35, 0, 0);
		TitledBorder cardsLeftTitle = new TitledBorder(new LineBorder(LABEL_COLOR, 2), "Credits");
		cardsLeftTitle.setTitleFont(MED_LABEL_FONT);
		cardsLeftTitle.setTitleColor(LABEL_COLOR);
		cardsLeftTitle.setTitleJustification(TitledBorder.CENTER);
		creditLabel = new JLabel();
		updateLabels();
		creditLabel.setFont(LG_LABEL_FONT);
		creditLabel.setForeground(LABEL_COLOR);
		JPanel creditPanel = new JPanel();
		creditPanel.setBorder(cardsLeftTitle);
		creditPanel.setOpaque(false);
		creditPanel.add(creditLabel);
		getContentPane().add(creditPanel, gridBagConstraints);

		// betLebal.setText("Bet : 0");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 14;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 15;
		gridBagConstraints.ipadx = 56;
		gridBagConstraints.ipady = 45;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(16, 30, 0, 36);
		TitledBorder scoreTitle = new TitledBorder(new LineBorder(LABEL_COLOR, 2), "Bet");
		scoreTitle.setTitleFont(MED_LABEL_FONT);
		scoreTitle.setTitleColor(LABEL_COLOR);
		scoreTitle.setTitleJustification(TitledBorder.CENTER);
		betLebal = new JLabel();
		updateLabels();
		betLebal.setFont(LG_LABEL_FONT);
		betLebal.setForeground(LABEL_COLOR);
		JPanel betAmountPanel = new JPanel();
		betAmountPanel.setBorder(scoreTitle);
		betAmountPanel.setOpaque(false);
		betAmountPanel.add(betLebal);
		getContentPane().add(betAmountPanel, gridBagConstraints);

		addOne.setText("Bet One");
		addOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addOneActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(34, 35, 0, 0);
		getContentPane().add(addOne, gridBagConstraints);

		addMax.setText("Bet Max");
		addMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addMaxActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 14;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 15;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(34, 71, 0, 36);
		getContentPane().add(addMax, gridBagConstraints);

		reset.setText("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.ipadx = 129;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 35, 0, 0);
		getContentPane().add(reset, gridBagConstraints);

		stats.setText("Statistics");
		stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				statsActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 7;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = 22;
		gridBagConstraints.ipadx = 115;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 53, 0, 36);
		getContentPane().add(stats, gridBagConstraints);

		titleLebal.setFont(new Font("Felix Titling", 1, 36));
		titleLebal.setForeground(LABEL_COLOR);
		titleLebal.setText("BONUS STORES");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 14;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(-50, 0, 0, 0);
		getContentPane().add(titleLebal, gridBagConstraints);
		Font font = titleLebal.getFont();
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		titleLebal.setFont(font.deriveFont(attributes));

		//add action listener for the window
		WindowListener listener = new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				int response = JOptionPane.showConfirmDialog(null, " Are you sure you want exit?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		};
		addWindowListener(listener);
		pack();
	}

	//Action to perform when Spin button is pressed
	private void SpinActionPerformed(ActionEvent evt) {
		//player has to bet before spinning the reels
		if (obj.getBet() > 0) {
			isSpining = true;
			new SlotMachineController().startSpining();
		} else {
			JOptionPane.showMessageDialog(null, "You should bet first.");
		}
	}

	//Action to perform when Add Coin button is pressed
	private void addCoinActionPerformed(ActionEvent evt) {
		//if the reels are nor spinning perform the the actio
		if (!isSpining) {
			//add 1 to the credit and update the labels and buttons
			obj.setCredit(obj.getCredit() + 1);
			updateLabels();
			updateDisabledButtons();
		}
	}

	//Action to perform when Add One button is pressed
	private void addOneActionPerformed(ActionEvent evt) {
		//if the reels are nor spinning perform the the action
		if (!isSpining) {
			//credit should be above 1
			if (obj.getCredit() > 0) {
				//add 3 to the bet and update the labels and buttons
				obj.setBet(obj.getBet() + 1);
				obj.setCredit(obj.getCredit() - 1);
				updateLabels();
				updateDisabledButtons();
			}
		}
	}

	//Action to perform when Add Max button is pressed
	private void addMaxActionPerformed(ActionEvent evt) {
		//if the reels are nor spinning perform the the action
		if (!isSpining) {
			//credit should be above three
			if (obj.getCredit() >= 3) {
				//add 3 to the bet and update the labels and buttons
				obj.setBet(obj.getBet() + 3);
				obj.setCredit(obj.getCredit() - 3);
				updateLabels();
				updateDisabledButtons();
			}
		}
	}

	//Action to perform when Reset button is pressed
	private void resetActionPerformed(ActionEvent evt) {
		//if the reels are nor spinning perform the the action
		if (!isSpining) {
			int betAm = obj.getBet();
			//reset the bet amount and return the credit amount and update the labels and buttons
			obj.setCredit(obj.getCredit() + betAm);
			obj.setBet(0);
			updateLabels();
			updateDisabledButtons();
		}
		//restart
//		obj.setBet(0);
//		obj.setWin(0);
//		obj.setLoses(0);
//		obj.setCredit(10);
//		dispose();
//		start();
	}

	//Action to perform when Statistic button is pressed
	private void statsActionPerformed(ActionEvent evt) {
		//if the reels are nor spinning perform the the action
		if (!isSpining)
			new StatsGUIInterface().setVisible(true);
	}

	//update labels after each and every action
	public void updateLabels() {
		//if credit less than 9 add 0 in front of the credit value 
		if (obj.getCredit() < 10)
			creditLabel.setText("0" + String.valueOf(obj.getCredit()));
		else
			creditLabel.setText(String.valueOf(obj.getCredit()));
		//if bet less than 9 add 0 in front of the credit value
		if (obj.getBet() < 10)
			betLebal.setText("0" + String.valueOf(obj.getBet()));
		else
			betLebal.setText(String.valueOf(obj.getBet()));
	}

	//update buttons after each and every action
	public void updateDisabledButtons() {
		//at least 3 credits should be there for perform add max action
		if (obj.getCredit() < 3)
			addMax.setEnabled(false);
		//at least a credit should be there for perform add max action
		if (obj.getCredit() == 0)
			addOne.setEnabled(false);
		if (obj.getCredit() >= 3)
			addMax.setEnabled(true);
		if (obj.getCredit() > 0)
			addOne.setEnabled(true);
	}
}
