package CSVMain;

import javax.swing.SwingUtilities;

public class CSVMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readCSV.getWholeSheet();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new UserInterface();
			}
		});

	}

}
