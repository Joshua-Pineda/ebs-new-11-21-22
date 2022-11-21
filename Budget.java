


import java.util.Date;


public class Budget {
   
    private int budgetID;
     private Date date;
    private String categoryName;
    private float budget;
    private int userID;
    
    public Budget(int budgetID, Date date, String categoryName, float budget, int userID) {
        this.date = date;
        this.budgetID = budgetID;
        this.categoryName = categoryName;
        this.budget = budget;
        this.userID = userID;
    }
    
    public Date getDate() {
        return date;
    }
    
    public int getBudgetID() {
        return budgetID;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public float getBudget() {
        return budget;
    }
    
    public int getUserID() {
        return userID;
    }
    
}
