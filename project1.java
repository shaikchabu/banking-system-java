
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Bank{
       void  createAcoount();
       void deposit(int amount);
       void withdraw(int amount);
       void checkbalance();
      void transaction();
}
class  Account{
    private long Accountnumber;
    private String Name;
    private double Balance;
    String DateOfBrith;

    public Account(long  Accountnumber, double Balance, String DateOfBrith, String Name) {
        this.Accountnumber = Accountnumber;
        this.Balance = Balance;
        this.DateOfBrith = DateOfBrith;
        this.Name = Name;
    }
    public void deposit(double amount){
        this.Balance+=amount;

    }
     public void withdraw(double amount){
        this.Balance-=amount;

    }

    public void setAccountnumber(long Accountnumber) {
        this.Accountnumber = Accountnumber;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public long  getAccountnumber() {
        return Accountnumber;
    }

    public String getName() {
        return Name;
    }

    public double getBalance() {
        return Balance;
    }

    public String getDateOfBrith() {
        return DateOfBrith;
    }
    
}
class Transaction{
    private long accountnumber;
    private double Balance;
    private  String type;
    private int amount;

    public Transaction(long Accountnumber, double Balance, int amount, String type) {
        this.accountnumber = Accountnumber;
        this.Balance = Balance;
        this.amount = amount;
        this.type = type;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public double getBalance() {
        return Balance;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }



}

class Bankoperations implements Bank{
    Map<Long,Account> m = new HashMap<>();
    ArrayList<Transaction> l = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void createAcoount() {
        
        System.out.println("enter your name:");
        String name= sc.next();
        
        
        System.out.println("enter your account number:");
        long Accountnumber= sc.nextLong();
        if(m.containsKey(Accountnumber)){
            System.out.println("account already existed");
            return;
        } 
        if(Accountnumber<0){
            System.out.println("account number cannot be negitive");
        }
        
        System.out.println("enter your intial balance:");
        double Balance= sc.nextDouble();
        if(Balance<0){
            System.out.println("no negitive balance");
            return;
        }
        
        System.out.println("enter your date of birth:");
        String DateOfBrith= sc.next();
        Account acc = new Account(Accountnumber, Balance, DateOfBrith, name);
        acc.setAccountnumber(Accountnumber);
        acc.setBalance(Balance);
        acc.setName(name);
        acc.getDateOfBrith();
    
        m.put(Accountnumber,acc);
    
       
        System.out.println("your acount has been created succssfully");
        
    }

    @Override
    public void checkbalance() {
        
    
        System.out.println("enter  your account number:");
        long Accountnumber = sc.nextLong();
        if (!m.containsKey(Accountnumber)) {
            System.out.println(" Account not");
            
        }

    
            
        Account acc= m.get(Accountnumber);
                
        System.out.println("this is your balance:"+acc.getBalance());
           
         System.out.println("successfully checked your balance");
                 
    }

    @Override
    public void deposit(int amount) {

        System.out.println("enter your account number:");

         long Accountnumber= sc.nextLong();
         System.out.println("entter your amount:");
         amount = sc.nextInt();
        if(!m.containsKey(Accountnumber)){
            System.out.println("Account not found");
        }
        if(amount<0){
            System.out.println("negitive amount can not be deposited");
            return;
        }
        Account acc= m.get(Accountnumber);
                
        acc.deposit(amount);
                        
        Transaction t = new Transaction(Accountnumber, acc.getBalance(), amount, "deposit");
        l.add(t);
        System.out.println("the new balance is:"+acc.getBalance());
        System.out.println("successfully deposited your amount");
        
        
       

        
    }

    @Override
    public void withdraw(int amount) {
    
        System.out.println("enter your account number:");
        long Accountnumber= sc.nextLong();
        System.out.println("entter your amount:");
        amount= sc.nextInt();
        if(!m.containsKey(Accountnumber)){
            System.out.println("Account not found");
        }
        if(amount<0){
            System.out.println("negitive amount can not withdraw");
            return;
        }

        Account acc= m.get(Accountnumber);
        
        if(amount<=acc.getBalance()){
         acc.withdraw(amount);
         Transaction t = new Transaction(Accountnumber,acc.getBalance(), amount, "withdraw");
         l.add(t);
         System.out.println("the new balance is :"+acc.getBalance());
         System.out.println("successfully withdrawed your amount");
        }else if(amount>acc.getBalance()){
             
         System.out.println("sorry your amount is greater than your balance ,we can not proceed your request");
         return;
        }else if(acc.getBalance()==0){
            System.out.println("please maintain required balance to proceed your request");
        }
            
       

    }

    @Override
    public void transaction() {
        System.out.println("enter your account number:");
        long Accountnumber = sc.nextLong();
        if(!m.containsKey(Accountnumber)){
            System.out.println("Account not found");
            return;
        }
        boolean found = false;
        for (Transaction t:l){
            if(t.getAccountnumber()== Accountnumber)
              System.out.println(
                t.getAccountnumber() + "|" +
                t.getType() + "|" +
                t.getAmount()+"|BALANCE:"+
                t.getBalance()
            );
               found =true;
        

        }
        if(!found){
            System.out.println("no transaction found");
        }
    }
}
public class project1{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Bank obj = new Bankoperations();
        
        while(true){
            System.out.println("//---BANKING SYSTEM MENU---//");
            
            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Check Balance");
            System.out.println("5.Transaction History");
        

              
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> obj.createAcoount();
                case 2 -> obj.deposit(0);
                case 3 -> obj.withdraw(0);
                case 4 -> obj.checkbalance();
                case 5 -> obj.transaction();
                default -> System.out.println("choose an correct option");
             }


        }
        
    }

}