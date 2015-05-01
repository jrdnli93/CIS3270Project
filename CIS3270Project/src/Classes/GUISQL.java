package Classes;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class GUISQL extends JFrame{
	
	//create text fields
	private JTextArea jftSQL = new JTextArea();
	private JTextArea output = new JTextArea();
	//jtable for select results
	private JTable output2 = new JTable();
			
	//create submit button			
	private JButton submitSQL = new JButton("Submit");
			
			
	public GUISQL() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(jftSQL,BorderLayout.CENTER);
		p.add(submitSQL, BorderLayout.SOUTH);
			    
			    
		JPanel p2 = new JPanel(new BorderLayout());
	    JScrollPane scrollPane = new JScrollPane(output2);
	    p2.add(scrollPane, BorderLayout.CENTER);
	    p2.add(output, BorderLayout.SOUTH);
			
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2,1));
		p3.add(p);
		p3.add(p2);
			   
		add(p3);
			   
		//register listener
		submitSQL.addActionListener(new ButtonListener());
		}
			
		// Handles submitSQL button
		private class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
			//get values from text fields
			String sql = jftSQL.getText();
					
			// if statement to determine what type of SQL Statement
				if (statement(sql) == true) {
							
					SQLStatements a = new SQLStatements();
					try {
						ResultSet rs = a.select(sql);
						//display result
							
						//JTable table = new JTable(buildTableModel(rs));
						//JOptionPane.showMessageDialog(null, new JScrollPane(table));
							
						//builds TableModel object and outputs into JTable
						output2.setModel(buildTableModel(rs));
						output.setText("Complete");
							
					} catch (ClassNotFoundException e1) {
						output.setText("Not a valid SQL Statement");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						output.setText("Not a valid SELECT Statement");
					} 
					} else {
						SQLStatements a = new SQLStatements();
						try {
							String x = a.update(sql);
							output.setText(x);
						} catch (ClassNotFoundException e1) {
							output.setText("Not a valid SQL Statement");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							output.setText("Not a valid SQL Statement");
							} 
						}
					
					}
			}
			
			// main
		public static void main(String []args){
				
			GUISQL main = new GUISQL();
			main.setSize(500,500);
			main.setVisible(true);
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
			
		// check to see if Select Statement else Update/Delete or error
		public boolean statement(String x) {
			boolean a = false;
				
			if (x.length() >= 6) {
				
				if (x.substring(0,6).compareToIgnoreCase("select") == 0) {
					a = true;
				} else a = false;
			} else a = false;
			return a;
			
		}
			
		//build TableModel from resultSet
			
		public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		    ResultSetMetaData metaData = rs.getMetaData();

		    // names of columns
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
			    }

		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rs.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		        	vector.add(rs.getObject(columnIndex));
			        }
			    data.add(vector);
			    }

			return new DefaultTableModel(data, columnNames);

			}

				
		}
		
		
		






