package createreportview;

import java.awt.*;
import javax.swing.*;

class AdvancedTableExample
		extends 	JPanel
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Instance attributes used in this example
	private	JTable		table;

	private	String		columnNames[];
	private	String		dataValues[][];


	// Constructor of main frame
	public AdvancedTableExample()
	{
		// Set the frame characteristics
	
		setSize( 300, 200 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		//

		// Create columns
		CreateColumns();
		CreateData();

		// Create a new table instance
		table = new JTable( dataValues, columnNames );

		// Configure some of JTable's paramters
		table.setShowHorizontalLines( false );
		table.setRowSelectionAllowed( true );
		table.setColumnSelectionAllowed( true );

		// Change the selection colour
		table.setSelectionForeground( Color.white );
		table.setSelectionBackground( Color.red );

		// Add the table to a scrolling pane
		//scrollPane = table.createScrollPaneForTable( table );
		//topPanel.add( scrollPane, BorderLayout.CENTER );
	}

	public void CreateColumns()
	{
		// Create column string labels
		columnNames = new String[8];

		for( int iCtr = 0; iCtr < 8; iCtr++ )
			columnNames[iCtr] = "Col:" + iCtr;
	}

	public void CreateData()
	{
		// Create data for each element
		dataValues = new String[100][8];

		for( int iY = 0; iY < 100; iY++ )
		{
			for( int iX = 0; iX < 8; iX++ )
			{
				dataValues[iY][iX] = "" + iX + "," + iY;
			}
		}
	}

}
