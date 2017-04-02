package view;

import javax.swing.JOptionPane;

public class Project_1 {

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		// start the GUI design
		new MainGUIInterface().start();
	}
}