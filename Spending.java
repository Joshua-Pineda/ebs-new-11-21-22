


import java.util.Date;


public class Spending {
    private int spendingID;
    
    private Date monthYear;
    private String categoryName;
    private float spendingAmount;
   
    
    
    public Spending(int spendingID, Date monthYear, String categoryName, float spendingAmount) {
        this.spendingID = spendingID;
      
        this.monthYear = monthYear;
        this.categoryName = categoryName;
        this.spendingAmount = spendingAmount;
        
    }
    
    
    public int getSpendingID() {
        return spendingID;
    }
    
    
    
    public Date getMonthYear() {
        return monthYear;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public float getSpendingAmount() {
        return spendingAmount;
    }
    
  
}
