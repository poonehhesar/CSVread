package CSVMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserInterface {

	static ArrayList<ArrayList<String>> currentSheet;
	static String[][] myArray;

	public static void updateValues() {

		currentSheet = readCSV.getWholeSheet();
		int col = (readCSV.getWholeSheet().get(0).size());

		System.out.println(" col num" + col);
		myArray = new String[readCSV.getWholeSheet().toArray().length - 1][col];

		for (int i = 1; i < readCSV.getWholeSheet().toArray().length; i++) {
			ArrayList<String> row = new ArrayList<>();
			row = readCSV.getWholeSheet().get(i);
			myArray[i - 1] = row.toArray(new String[col]);
		}
	}

	public UserInterface() {
		updateValues();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(0, 1));

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Spreadsheet");
		frame.pack();
		frame.setVisible(true);
		JTable table = new JTable(new DefaultTableModel(myArray, currentSheet.get(0).toArray()));
		table.setBounds(30, 40, 200, 300);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane);

	}


}
