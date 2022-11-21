

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;


public class report {

	private JFrame frame;
	private JTable table;
	private JTable table2;
	private JTable table3;
	private JTable table4;
	private JTable table5;
	private int year = 0;
	User usr = LoginFrame.getUsr();
	public JFrame getFrame() {
		return frame;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getCurrentMonth() {
		int current =0;
		try {
			
		Statement stmt = MyConnection.getConnection().createStatement();
		
		
		String query= "SELECT MONTH(NOW())";
       
      
  	    ResultSet rs = stmt.executeQuery(query);  
  	  
        if(rs.next()) {
        
         
         current = rs.getInt("MONTH(NOW())");
        
        
        }
        MyConnection.getConnection().close();

   } catch (SQLException ex){
	   System.out.print(ex);
   }
		return current; 
	}
	
	public int getPrevious(int month) {
		int previousMonth;
		
		if(month == 1) {
			previousMonth = 11;
			setYear(-1);
		}
		else
		{
			previousMonth = -1;
		}
		return previousMonth;
	}
	
	public int getPrevious2(int month) {
		int previousMonth;
		
		if(month == 1) {
			previousMonth = 10;
			setYear(-1);
		}
		else
		{
			previousMonth = -2;
		}
		return previousMonth;
	}
	
	public int getYear() {
		return year; 
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report window = new report();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public report() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(37, 150, 190));
		frame.setBounds(100, 100, 655, 426);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
                frame.setLocation(350,170 );
		
		//SELECT sum(spending_amount) FROM spending WHERE user_id = 1 AND EXTRACT(MONTH FROM date)=(EXTRACT(MONTH FROM now())-1);
		//SELECT sum(spending_amount) FROM spending WHERE user_id = 1 AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now());
		
		//SELECT categories.name,SUM(spending.spending_amount),categories.budget FROM spending 
		//LEFT JOIN categories ON spending.category_id = categories.categoryID WHERE spending.user_id = 1 
		//AND EXTRACT(MONTH FROM spending.date) BETWEEN (EXTRACT(MONTH FROM NOW())+('"+getPrevious2(getCurrentMonth())+"')) AND EXTRACT(MONTH FROM NOW()) 
		//AND EXTRACT(YEAR FROM spending.date) BETWEEN (EXTRACT(YEAR FROM NOW())+('"+getYear+"')) AND EXTRACT(YEAR FROM NOW()) 
		//GROUP BY categories.budget,categories.name HAVING SUM(spending.spending_amount) >=(categories.budget * 0.90) 
		//ORDER BY SUM(spending.spending_amount) DESC;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 70, 220, 46);
		scrollPane.setBackground(new Color(255, 222, 89));
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		Object column [] = {"Budget","Spending"};
		
		DefaultTableModel model2 = new DefaultTableModel();
		Object column2 [] = {"Category","Budget"};
		
		DefaultTableModel model3 = new DefaultTableModel();
		Object column3 [] = {"Category","Spending"};
		
		DefaultTableModel model4 = new DefaultTableModel();
		Object column4 [] = {"Current Month","Previous Month"};
		
		DefaultTableModel model5 = new DefaultTableModel();
		Object column5 [] = {"Category","Spending", "Budget"};
		
		table = new JTable();
		table.setModel(model);
		table.setBackground(new Color(255, 222, 89));
		table.setBounds(90, 90, 90, 90);
		model.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		
		JLabel totalLabel = new JLabel("Monthly Totals");
		totalLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		totalLabel.setBounds(105, 53, 94, 16);
                totalLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(totalLabel);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBackground(new Color(255, 222, 89));
		scrollPane2.setBounds(26, 137, 151, 181);
		frame.getContentPane().add(scrollPane2);
		
		table2 = new JTable();
		table2.setModel(model2);
		table2.setBackground(new Color(255, 222, 89));
		table2.setBounds(90, 90, 90, 90);
		model2.setColumnIdentifiers(column2);
		scrollPane2.setViewportView(table2);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBackground(new Color(255, 222, 89));
		scrollPane3.setBounds(189, 137, 151, 181);
		frame.getContentPane().add(scrollPane3);
		
		table3 = new JTable();
		table3.setModel(model3);
		table3.setBackground(new Color(255, 222, 89));
		table3.setBounds(90, 90, 90, 90);
		model3.setColumnIdentifiers(column3);
		scrollPane3.setViewportView(table3);
		
		JLabel totalLabel2 = new JLabel("By Category");
		totalLabel2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		totalLabel2.setBounds(105, 119, 83, 16);
                totalLabel2.setForeground(Color.WHITE);
		frame.getContentPane().add(totalLabel2);
		
		//shape panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 222, 89));
		panel.setBounds(391, 59, 220, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBackground(new Color(255, 222, 89));
		scrollPane4.setBounds(0, 25, 220, 46);
		panel.add(scrollPane4);
		
		table4 = new JTable();
		table4.setModel(model4);
		table4.setBackground(new Color(255, 222, 89));
		table4.setBounds(90, 90, 90, 90);
		model4.setColumnIdentifiers(column4);
		scrollPane4.setViewportView(table4);
		
		JLabel comparisonLabel = new JLabel("Comparison");
		comparisonLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		comparisonLabel.setBounds(64, 6, 120, 16);
		panel.add(comparisonLabel);
		
		JLabel reportLabel = new JLabel("Monthly Report");
		reportLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		reportLabel.setBounds(276, 6, 133, 21);
                reportLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(reportLabel);
		
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.setBackground(new Color(255, 222, 89));
		scrollPane5.setBounds(391, 189, 220, 129);
		frame.getContentPane().add(scrollPane5);
		
		table5 = new JTable();
		table5.setModel(model5);
		table5.setBackground(new Color(255, 222, 89));
		table5.setBounds(90, 90, 90, 90);
		model5.setColumnIdentifiers(column5);
		scrollPane5.setViewportView(table5);
		
		
		JLabel rankLabel = new JLabel("Top 3 Categories at 90% of budget");
		rankLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		rankLabel.setBounds(391, 171, 220, 16);
                rankLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(rankLabel);
		
	
		
		
		 try{

				Statement stmt_budget = MyConnection.getConnection().createStatement();
				Statement stmt_spending = MyConnection.getConnection().createStatement();
				
				//String test = "SELECT sum(budget) FROM categories WHERE user_id = '"+usr.getId()+"' AND (EXTRACT(MONTH FROM date)=1+()) AND (EXTRACT(YEAR FROM date)=2022+(0))";
				String query_budget= "SELECT sum(budget) FROM categories WHERE user_id = '"+usr.getId()+"' "
						+ "AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now()) AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now())";
	            String query_spending= "SELECT sum(spending_amount) FROM spending WHERE user_id = '"+usr.getId()+"' "
	            		+ "AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now())  AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now())";
	            
	          
	      	    ResultSet rs_budget = stmt_budget.executeQuery(query_budget);  
	      	    ResultSet rs_spending =  stmt_spending.executeQuery(query_spending);
	            while(rs_budget.next()&&rs_spending.next()) {
	            
	             String budget = String.valueOf(rs_budget.getDouble("sum(budget)"));
	             String spending = String.valueOf(rs_spending.getDouble("sum(spending_amount)"));
	            
	             
	            String data [] = {budget,spending};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)table.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		 
		 //
		 
		 try{

				Statement stmt_budget = MyConnection.getConnection().createStatement();
				
				
				String query_budget= "SELECT name,budget FROM categories WHERE user_id = '"+usr.getId()+"' "
						+ "AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now())  AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now())";
	           
	          
	      	    ResultSet rs_budget = stmt_budget.executeQuery(query_budget);  
	      	  
	            while(rs_budget.next()) {
	            
	             String category_budget = rs_budget.getString("name");
	         
	             String budget = String.valueOf(rs_budget.getDouble("budget"));
	            
	            
	             
	            String data [] = {category_budget,budget};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)table2.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		 
		 try{

				
				Statement stmt_spending = MyConnection.getConnection().createStatement();
				
				
	            String query_spending= "SELECT category_name,sum(spending_amount) FROM spending WHERE user_id = '"+usr.getId()+"' "
	            		+ "AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now())  AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now()) GROUP BY category_name";
	            
	          
	      	 
	      	    ResultSet rs_spending =  stmt_spending.executeQuery(query_spending);
	            while(rs_spending.next()) {
	            
	           
	             String category_spending = rs_spending.getString("category_name");
	             
	             String spending = String.valueOf(rs_spending.getDouble("sum(spending_amount)"));
	            
	             
	            String data [] = {category_spending,spending};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)table3.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		 //
		 try{

				Statement stmt_budget = MyConnection.getConnection().createStatement();
				Statement stmt_spending = MyConnection.getConnection().createStatement();
				Statement stmt_budgetC = MyConnection.getConnection().createStatement();
				Statement stmt_spendingC = MyConnection.getConnection().createStatement();
				
				
				String query_budget= "SELECT sum(budget) FROM categories WHERE user_id = '"+usr.getId()+"' "
						+ "AND (EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now())+('"+getPrevious(getCurrentMonth())+"')) AND (EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now())+('"+getYear()+"'))";
	            String query_spending= "SELECT sum(spending_amount) FROM spending WHERE user_id = '"+usr.getId()+"'"
	            		+ " AND (EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now())+('"+getPrevious(getCurrentMonth())+"')) AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now()+('"+getYear()+"'))";
	            String query_budgetC= "SELECT sum(budget) FROM categories WHERE user_id = '"+usr.getId()+"' "
	            		+ "AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now()) AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now())";
	            String query_spendingC= "SELECT sum(spending_amount) FROM spending WHERE user_id = '"+usr.getId()+"' "
	            		+ "AND EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM now()) AND EXTRACT(YEAR FROM date)=EXTRACT(YEAR FROM now())";
	            
	          
	      	    ResultSet rs_budget = stmt_budget.executeQuery(query_budget);  
	      	    ResultSet rs_spending =  stmt_spending.executeQuery(query_spending);
	      	  ResultSet rs_budgetC = stmt_budgetC.executeQuery(query_budgetC);  
	      	    ResultSet rs_spendingC =  stmt_spendingC.executeQuery(query_spendingC);
	      	//
	      	    
	            if(rs_budget.next()&&rs_spending.next()&rs_budgetC.next()&&rs_spendingC.next()) {
	            
	            	 Double budget = rs_budget.getDouble("sum(budget)");
		             Double spending = rs_spending.getDouble("sum(spending_amount)");
		             Double budgetC = rs_budgetC.getDouble("sum(budget)");
		             Double spendingC = rs_spendingC.getDouble("sum(spending_amount)");
		             Double difference = (double) Math.round(spending.doubleValue() - budget.doubleValue()); 
		             Double differenceC = (double) Math.round(spendingC.doubleValue() - budgetC.doubleValue());
		             String previousMonth = String.valueOf(difference);
		             String currentMonth = String.valueOf(differenceC);
	             
	            String data [] = {currentMonth,previousMonth};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)table4.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		 //
		 try{

				
				Statement stmt = MyConnection.getConnection().createStatement();
				
				
	            String query= "SELECT categories.name,SUM(spending.spending_amount),categories.budget FROM spending "
	            		+ "LEFT JOIN categories ON spending.category_id = categories.categoryID WHERE spending.user_id = '"+usr.getId()+"' "
	            		+ "AND EXTRACT(MONTH FROM spending.date) BETWEEN (EXTRACT(MONTH FROM NOW())+('"+getPrevious2(getCurrentMonth())+"')) "
	            				+ "AND EXTRACT(MONTH FROM NOW()) AND EXTRACT(YEAR FROM spending.date) BETWEEN (EXTRACT(YEAR FROM NOW())+('"+getYear()+"')) "
	            						+ "AND EXTRACT(YEAR FROM NOW()) "
	            						+ "GROUP BY categories.budget,categories.name HAVING SUM(spending.spending_amount) >=(categories.budget * 0.90) "
	            						+ "ORDER BY SUM(spending.spending_amount) DESC LIMIT 3";
	          
	      	 
	      	    ResultSet rs_spending =  stmt.executeQuery(query);
	            while(rs_spending.next()) {
	            
	           
	             String category = rs_spending.getString("name");
	             
	             String spending = String.valueOf(rs_spending.getDouble("SUM(spending.spending_amount)"));
	             String budget = String.valueOf(rs_spending.getDouble("budget")); 
	             
	            String data [] = {category,spending,budget};
	           
	            DefaultTableModel tbModel =(DefaultTableModel)table5.getModel();
	          
	            
	            tbModel.addRow(data);
	            }
	            MyConnection.getConnection().close();
	  
	       } catch (SQLException ex){
	    	   System.out.print(ex);
	       }
		
	}
}
