import java.util.*;

/*
CO3: Lists and Abstract Data Types
Student class stores student information and calculates performance score.
*/
class Student {

    String name, roll;
    int attendance, m, p, c, cs, e;
    double score;

    Student(String n,String r,int a,int m,int p,int c,int cs,int e){

        name=n;
        roll=r;
        attendance=a;

        this.m=m;
        this.p=p;
        this.c=c;
        this.cs=cs;
        this.e=e;

        /*
        CO1: Algorithm Analysis
        Average marks calculated using formula
        */
        double avg=(m+p+c+cs+e)/5.0;

        /*
        Score calculated using weighted formula
        */
        score=(avg*0.7)+(attendance*0.3);
    }
}

/*
CO3: Lists and Abstract Data Types
Employee class stores employee performance data.
*/
class Employee{

    String name,id;
    int pr,pf,bh,tw,mt,ex;
    double score;

    Employee(String n,String id,int pr,int pf,int bh,int tw,int mt,int ex){

        name=n;
        this.id=id;

        this.pr=pr;
        this.pf=pf;
        this.bh=bh;
        this.tw=tw;
        this.mt=mt;
        this.ex=ex;

        /*
        CO1: Algorithm / Formula based performance score calculation
        */
        score=(pf*3)+(tw*2.5)+(bh*2)+(mt*1.5)+(pr*0.5)+(ex*0.5);
    }
}

public class PerformanceRankingSystem {

    static Scanner sc=new Scanner(System.in);

    /*
    CO3: Using ArrayList (List ADT) to store data dynamically
    */
    static ArrayList<Student> students=new ArrayList<>();
    static ArrayList<Employee> employees=new ArrayList<>();

    /*
    CO5: Hashing and Data Organization
    HashMap used for fast searching
    */
    static HashMap<String,Student> studentMap=new HashMap<>();
    static HashMap<String,Employee> employeeMap=new HashMap<>();

    public static void main(String[] args){

        /*
        CO4: Sequential processing similar to queue
        Menu driven system handles operations one by one
        */
        while(true){

            System.out.println("\n1 School Mode");
            System.out.println("2 Company Mode");
            System.out.println("3 Exit");

            int ch=sc.nextInt();

            if(ch==1) schoolMode();
            else if(ch==2) companyMode();
            else System.exit(0);
        }
    }

    static void schoolMode(){

        while(true){

            System.out.println("\n--- SCHOOL MODE ---");
            System.out.println("1 Add Student");
            System.out.println("2 Show Students");
            System.out.println("3 Sort Ranking");
            System.out.println("4 Search Student");
            System.out.println("5 Back");

            int ch=sc.nextInt();

            if(ch==1) addStudent();
            else if(ch==2) showStudents();
            else if(ch==3) sortStudents();
            else if(ch==4) searchStudent();
            else return;
        }
    }

    static void companyMode(){

        while(true){

            System.out.println("\n--- COMPANY MODE ---");
            System.out.println("1 Add Employee");
            System.out.println("2 Show Employees");
            System.out.println("3 Sort Ranking");
            System.out.println("4 Search Employee");
            System.out.println("5 Back");

            int ch=sc.nextInt();

            if(ch==1) addEmployee();
            else if(ch==2) showEmployees();
            else if(ch==3) sortEmployees();
            else if(ch==4) searchEmployee();
            else return;
        }
    }

    /*
    CO3: Insert operation in List
    */
    static void addStudent(){

        System.out.print("Name: ");
        String n=sc.next();

        System.out.print("Roll: ");
        String r=sc.next();

        System.out.print("Attendance: ");
        int a=sc.nextInt();

        System.out.print("Math Physics Chemistry CS English: ");
        int m=sc.nextInt(),p=sc.nextInt(),c=sc.nextInt(),cs=sc.nextInt(),e=sc.nextInt();

        Student s=new Student(n,r,a,m,p,c,cs,e);

        students.add(s);
        studentMap.put(r,s);
    }

    /*
    CO3: Traversing a list
    */
    static void showStudents(){

        int rank=1;

        for(Student s:students){
            System.out.println(rank+" "+s.name+" "+s.roll+" Score:"+s.score);
            rank++;
        }
    }

    /*
    CO2: Sorting Algorithm
    Ranking students using Collections.sort()
    */
    static void sortStudents(){

        Collections.sort(students,(a,b)->Double.compare(b.score,a.score));

        System.out.println("Ranking Sorted");
    }

    /*
    CO5: HashMap Searching
    */
    static void searchStudent(){

        System.out.print("Roll: ");
        String r=sc.next();

        Student s=studentMap.get(r);

        if(s!=null)
            System.out.println("Found "+s.name+" Score:"+s.score);
        else
            System.out.println("Not Found");
    }

    /*
    CO3: Adding employees to list
    */
    static void addEmployee(){

        System.out.print("Name: ");
        String n=sc.next();

        System.out.print("ID: ");
        String id=sc.next();

        System.out.print("Projects: ");
        int pr=sc.nextInt();

        System.out.print("Performance Behaviour Teamwork Meeting Experience: ");
        int pf=sc.nextInt(),bh=sc.nextInt(),tw=sc.nextInt(),mt=sc.nextInt(),ex=sc.nextInt();

        Employee e=new Employee(n,id,pr,pf,bh,tw,mt,ex);

        employees.add(e);
        employeeMap.put(id,e);
    }

    /*
    CO3: Traversing employee list
    */
    static void showEmployees(){

        int rank=1;

        for(Employee e:employees){
            System.out.println(rank+" "+e.name+" "+e.id+" Score:"+e.score);
            rank++;
        }
    }

    /*
    CO2: Sorting employees based on score
    */
    static void sortEmployees(){

        Collections.sort(employees,(a,b)->Double.compare(b.score,a.score));

        System.out.println("Ranking Sorted");
    }

    /*
    CO5: Searching using HashMap
    */
    static void searchEmployee(){

        System.out.print("ID: ");
        String id=sc.next();

        Employee e=employeeMap.get(id);

        if(e!=null)
            System.out.println("Found "+e.name+" Score:"+e.score);
        else
            System.out.println("Not Found");
    }
}