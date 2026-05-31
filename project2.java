
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.plaf.FontUIResource;

interface StudentOperations{
    void AddStudent();
    void RemoveStudent(int rollno);
    void SearchStudent(int rollno);
    void UpdateMarks(int rollno);
    void DispalyStudent(int rollno);
    void CalculateGrade(int rollno);
    void CalculateTopper();
    void SortStudents();
    void DispalyAttandence(int rollno);
    void Dispalytop3();
    void AdminLogin();
    

}
class Student{
    
    private String name;
    private int rollno;
    private int marks;
    private float attendence;
    private char grade;

    public Student(float attendence, char grade, int marks, String name, int rollno) {
        this.attendence = attendence;
        this.grade = grade;
        this.marks = marks;
        this.name = name;
        this.rollno = rollno;
    }

    

    public void setName(String name) {
        this.name = name;
    }
     public String getName() {
        return name;
    }

    

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public int getRollno() {
        return rollno;
    }

    

    public void setMarks(int marks) {
        this.marks = marks;
    }
     public int getMarks() {
        return marks;
    }


   

    public void setAttendence(float attendence) {
        this.attendence = attendence;
    }
     public float getAttendence() {
        return attendence;
    }

    

    public void setGrade(char grade) {
        this.grade = grade;
    }
    public char getGrade() {
        return grade;
    }
    void CalculateGrade(int marks){
        
        if(getMarks()>=90){
            this.grade='s';
            
         System.out.println("oustanding perfromance");
        }else if(getMarks()>=80&&getMarks()<90){
            this.grade='A';
            System.out.println("Excellent performance");
        }else if(getMarks()>=70&&getMarks()<80){
            this.grade='B';
            System.out.println("good performance");
        }else if(getMarks()>=60&&getMarks()<70){
            this.grade='C';
            System.out.println("better luck next time");
        }else if(getMarks()>=50&&getMarks()<60){
            this.grade='D';
            System.out.println("do hardwork next time");
        }else if(getMarks()>=40&&getMarks()<50){
            this.grade='E';
            System.out.println("need more focus");
        }else{
            this.grade='F';
            System.out.println("you have failed");
        }
        

    }
    void DispalyStudent(int rollno){
        if(this.rollno== rollno){
          
           System.out.println(
            "Name:"+name+"|"+"RollNo:"+rollno+"|"+ "Marks:"+marks+" |"+"Grade:"+grade+"|"+"Attendence:"+attendence);
           
        }
    
         
    
            

     }

    
}
class StudentService implements StudentOperations{
    Scanner sc =  new Scanner(System.in);
    ArrayList<Student> l = new ArrayList<>();

    @Override
    public void AddStudent() {
        System.out.println("enter student name:");
        String name = sc.next();
        System.out.println("enter student rollno:");
        int rollno=sc.nextInt();
        System.out.println("enter student marks:");
        int marks = sc.nextInt();
        System.out.println("enter student attendence");
        float attendence= sc.nextFloat();
         for(Student a : l){
            if(a.getRollno() == rollno){
             System.out.println("Roll number already exists");
               return;
             }

         }
        Student s =new Student(attendence, ' ' , marks, name, rollno);
        s.CalculateGrade(marks);
        l.add(s);
        System.out.println("the student profile is creted succesfuly");
       
    }

    @Override
    public void RemoveStudent(int rollno) {
        System.out.println("enter rollno:");
        rollno=sc.nextInt();
        boolean found = false;
        Iterator<Student> it= l.iterator();
        while (it.hasNext()) {
            Student a =  it.next();
            
        
        
         if(a.getRollno()==rollno){
            found = true;
            it.remove();
            System.out.println("student removed susccfully");
            break;
         }

        }
        if(!found){
            System.out.println(" Student not found");
        }

    }

    @Override
    public void SearchStudent(int rollno) {
        System.out.println("enter rollno:");
        rollno=sc.nextInt();
        boolean found = false;
         for(Student a:l){
        
            if(a.getRollno()==rollno){
                 found = true;
                a.DispalyStudent(rollno);
                
                System.out.println("yeah found the student");
                break;
                

            }
            
        
        }
        if(!found){
            System.out.println("student not found");
        }
    }

    @Override
    public void UpdateMarks(int rollno) {
        System.out.println("enter your rollno:");
        rollno= sc.nextInt();
        boolean found = false;
         for(Student a:l){
        
            if(a.getRollno()==rollno){
                 found = true;
                 System.out.println("enter your marks:");
                 int newmarks = sc.nextInt();
                 a.setMarks(newmarks);
                 a.CalculateGrade(newmarks);
                System.out.println("the newly updated marks are:"+a.getMarks());
                

            }
            
        
        }
        if(!found){
            System.out.println("student not found");
        }
        
    }

    @Override
    public void DispalyStudent(int rollno) {
        System.out.println("enter your rollno:");
        rollno= sc.nextInt();
        boolean found= false;

         
         for(Student a:l){
        
            if(a.getRollno()==rollno){
                
                found= true;
                 
                a.DispalyStudent(rollno);
                
                

            }
            
        
        }
        if(!found){
            System.out.println("student not found");
        }
        

        

        
        
    }

    @Override
    public void CalculateGrade(int rollno) {
        System.out.println("enter your rollno:");
        rollno= sc.nextInt();
        boolean found= false;

         
         for(Student a:l){
        
            if(a.getRollno()==rollno){
                
                found= true;
                 
                a.CalculateGrade(a.getMarks());
                
                

            }
            
        
        }
        if(!found){
            System.out.println("student not found");
        }

    }
    

    @Override
    public void CalculateTopper() {
        if(l.isEmpty()){
            System.out.println("No students available");
            return;
         }
        Student topper =l.get(0);
        for(Student a:l){
            if(a.getMarks()>topper.getMarks()){
                topper=a;
                
                
            }
        }
        
           System.out.println("Topper: " + topper.getName());
            System.out.println("Topper: " + topper.getRollno());

            System.out.println("Marks: " + topper.getMarks());
        
         
                
    }

    @Override
    public void SortStudents() {
        Comparator<Student> com = new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return s2.getMarks()-s1.getMarks();
            }
        };
        Collections.sort(l,com);
        System.out.println("students sorted by:");
        for(Student a:l){
            a.DispalyStudent(a.getRollno());
        }
    }

    @Override
    public void DispalyAttandence(int rollno) {
        System.out.println("enter student roll no:");
        rollno =sc.nextInt();
        boolean found =false;
        for(Student a:l){
            if(a.getRollno()==rollno){
                found= true;
                System.out.println("the attendence is:"
                +a.getName()+" "+
                a.getRollno()+" "+
                a.getAttendence()+"%");
        
            }
        }
        if(!found){
            System.out.println("student not found");
        }
    }

    @Override
    public void Dispalytop3() {
        if(l.size() < 3){
            System.out.println("Less than 3 students available");
               return;
         }

    
        l.get(0).DispalyStudent(l.get(0).getRollno());
        l.get(1).DispalyStudent(l.get(1).getRollno());

        l.get(2).DispalyStudent(l.get(2).getRollno());
        

    }
    @Override
      public void AdminLogin() {

           System.out.println("Enter Username:");
          String username = sc.next();

            System.out.println("Enter Password:");
          String password = sc.next();

        if(username.equals("admin") &&password.equals("1234")) {

               System.out.println("Login Successful");

            } else {

                System.out.println("Invalid Credentials");
        }
    }
        public void SaveStudents() {

               try {

                    FileWriter fw =new FileWriter("students.txt");

                    for(Student s : l) {

                       fw.write(
                            s.getName() + "," +
                            s.getRollno() + "," +
                          s.getMarks() + "," +
                          s.getAttendence() + "\n"
                        );

                      }

                 fw.close();

                  System.out.println("Data Saved");

                 } catch(IOException e) {

        System.out.println("Error Saving File");

    }
         }
   
    
    


        

        
    
    
    

} 
public class project2{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StudentOperations st = new StudentService();
        while(true){
            System.out.println("//---STUDENT MANAGEMENT SYSTEM---//");
            
            System.out.println("1.Add Student");
            System.out.println("2.Remove student");
            System.out.println("3.Search Student");
            System.out.println("4.Update Student");
            System.out.println("5.Display Student");
            System.out.println("6.Calculate Grade");
            System.out.println("7.Calculate Topper");
            System.out.println("8.Sort Students");
             System.out.println("9.Display Attendance");
             System.out.println("10.Display Top 3");
             System.out.println("11.Admin Login");
             System.out.println("12.Save Students");
              System.out.println("13.Exit");
        

              
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> st.AddStudent();
                case 2 -> st.RemoveStudent(0);
                case 3 -> st.SearchStudent(0);
                case 4 -> st.UpdateMarks(0);
                case 5 -> st.DispalyStudent(0);
                case 6 -> st.CalculateGrade(0);
                case 7 -> st.CalculateTopper();
                case 8 -> st.SortStudents();
                case 9 -> st.DispalyAttandence(0);
                case 10 -> st.Dispalytop3();
                case 11 -> st.AdminLogin();
                case 12 -> ((StudentService)st).SaveStudents();
                case 13 -> {
                  System.out.println("Thank You");
                       return;
                 }
                default -> System.out.println(" choose corect option");
            }
        }
    }
}