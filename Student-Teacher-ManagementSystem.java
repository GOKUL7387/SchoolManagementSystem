//========================================================COMMON CLASS========================================================//

import java.util.ArrayList;

public class person
{
    private int id;
    private String name;
    private int age;
    private String address;
    private int leaveBalance;

    public person(int id, String name, int age, String address)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
        this.leaveBalance=10;
    }

    public void  setId(int id)
    {
        this.id=id;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setAge(int age)
    {
        this.age=age;
    }

    public void setAddress(String address)
    {
        this.address=address;
    }
    
    public void setLeave(int leaveBalance)
    {
        this.leaveBalance = leaveBalance;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getAddress() 
    {
        return address;
    }

    public int getLeave()
    {
        return leaveBalance;
    }

    public boolean applyLeave(int days)
    {
        if(leaveBalance>=days)
        {
            leaveBalance-=days;
            System.out.println(name+" has taken "+days+" days of leave. Remaining balance: "+leaveBalance);
            return true;
        }
        else
        {
            System.out.println(name+" does not have enough leave balance.");
            return false;
        }
    }

    public void display(){
            System.out.println("The name :"+name);
            System.out.println("The Id :"+id);
            System.out.println("The Age :"+age);
            System.out.println("The Address :"+address);
            System.out.println("The number Leave Balance : "+leaveBalance);
        }
}

//========================================================STUDENT CLASS========================================================//

public class student extends person
{
    private String student_grade;
    private String student_id;

    public student(int id,String name, int age, String address,String student_grade,String student_id)
    {
        //super to access the details in person class....
        super(id,name,age,address);
        this.student_id=student_id;
        this.student_grade=student_grade;
    }

    public String getStudent_id() 
    {
        return student_id;
    }
    
    public String getStudent_grade() 
    {
        return student_grade;
    }

    public void setStudent_id(String student_id) 
    {
        this.student_id = student_id;
    }

    public void setStudent_grade(String student_grade) 
    {
        this.student_grade = student_grade;
    }

    public void calculateGrade(int marks)
    {
        if(marks>=90)
        {
            student_grade="A";
        }
        else if(marks>=75)
        {
            student_grade="B";
        }
         else if(marks>=50)
        {
            student_grade="C";
        }
        else
        {
            student_grade="F";
        }
        System.out.println(getName()+"'s grade is updated to: "+student_grade);
    }
    //override for using same display function........
    @Override
    public void display()
    {
        super.display();
        System.out.println("The Grade :"+student_grade);
        System.out.println("The StudentId :"+student_id);
    }
}

//========================================================TEACHER CLASS========================================================//

public class Teacher extends person
{
    private String subject;
    private int salary;
    private String timetable ;

    public Teacher(int id,String name, int age, String address,String subject,int salary)
    {
        super(id,name,age,address);
        this.subject=subject;
        this.salary=salary;
        this.timetable = "Not Assigned";
    }

    public String getsubject() 
    {
        return subject;
    }
    
    public int getteacher_grade() 
    {
        return salary;
    }

    public String getTimetable()
    {
        return timetable;
    }

    public void setsubject(String subject) 
    {
        this.subject = subject;
    }

    public void setteacher_grade(int salary) 
    {
        this.salary = salary;
    }

    
    public void setTimetable(String timetable)
    {
        this.timetable = timetable;
        System.out.println(getName()+" have been assigned with the timetable : "+timetable);
    }

    //override for using same display function........
    @Override
    public void display(){
        super.display();
        System.out.println("The Subject :"+subject);
        System.out.println("The Salary :"+salary);
    }
}

//========================================================ADMISSION-STAFF CLASS========================================================//

public class AdmissionStaff extends person
{
    private String department;
    private String roll;

    public AdmissionStaff(int id,String name, int age, String address,String department,String roll)
    {
        super(id,name,age,address);
        this.department=department;
        this.roll=roll;
    }

    public String getRoll()
    {
        return roll;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public void assignTask(String task) 
    {
        System.out.println(getName() + " from " + department + " department is assigned task: " + task);
    }
    
    //override for using same display function........
    @Override
    public void display()
    {
        super.display();
        System.out.println("The Department :"+department);
        System.out.println("The Role :"+roll);
    }
}

//========================================================MAIN CLASS========================================================//

public class SchoolManagementSystem
{
    public static void main(String[] args)
    {
        ArrayList<person> Person = new ArrayList<>();

        //directly call the constructor....

        student student1 = new student(1, "John Doe", 16, "123 Street", "10th Grade", "S101");
        student student2 = new student(2, "Jane Smith", 17, "456 Street", "11th Grade", "S102");
        Person.add(student1);
        Person.add(student2);

        // Add Teachers
        Teacher teacher1 = new Teacher(3, "Mr. Wilson", 35, "789 Street", "Mathematics", 50000);
        Teacher teacher2 = new Teacher(4, "Ms. Taylor", 29, "321 Street", "English", 48000);
        Person.add(teacher1);
        Person.add(teacher2);

        // Add Admin Staff
        AdmissionStaff admin1 = new AdmissionStaff(5, "Anna Johnson", 40, "654 Street", "Finance", "Accountant");
        AdmissionStaff admin2 = new AdmissionStaff(6, "Paul Brown", 45, "987 Street", "HR", "HR Manager");
        Person.add(admin1);
        Person.add(admin2);

        System.out.println("Student Mangement System:");

        for(person Person1:Person)
        {
            System.out.println("-------------------------------------------------------------------");
            Person1.display();
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

        student1.calculateGrade(85);
        teacher1.setTimetable("Mon-Wed: 9 AM to 12 PM");
        admin1.assignTask("Prepare monthly financial report");

        student1.applyLeave(2);
        teacher1.applyLeave(5);
        admin2.applyLeave(12);
    }
}
