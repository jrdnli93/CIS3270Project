package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test {


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		SQLStatements s = new SQLStatements();

		
		
		try {
			ArrayList<String> results = s.select("select * from flights");
			Object[] r = results.toArray();
			for (int i = 0; i < r.length; i++) {
				p3.add();
				if (i == 10) {
					System.out.println();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

