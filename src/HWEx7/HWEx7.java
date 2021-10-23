package HWEx7;

import java.util.Scanner;

public class HWEx7 {

    public static void main(String[] args) {
        Process();
    }
    
    static FulltimeEmployee Ftem;
    static ParttimeEmployee Ptem;
    
    private static void CreateObjFullTime(){
        Ftem = new FulltimeEmployee();
    }
    
    private static void CreateObjPartTime(){
        Ptem = new ParttimeEmployee();
    }
    
    private static FulltimeEmployee TestInsertFullTimeObj(){
        FulltimeEmployee test = new FulltimeEmployee();
        
        test.setName("Jo");
        test.setSalary(5000);
        
        FullTimeDBController.insertFulltimeEmployee(test);
        return test;
    }
    
    private static ParttimeEmployee TestInsertPartTimeObj(){
        ParttimeEmployee test = new ParttimeEmployee();
        
        test.setName("Jane");
        test.setHoursWork(400);
        
        PartTimeDBController.insertParttimeEmployee(test);
        return test;
    }
    
    private static void Process(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please Choose Jobtype [1 for FullTime] [2 for Parttime] : ");
        int option = sc.nextInt();
        if(option == 1){
            CreateObjFullTime();
            System.out.println("\tYou Selected Fulltime Job");
            System.out.print("\t\tPlease Select Function [1 for Insert] [2 for Update] [3 for Delete] : ");
            int function = sc.nextInt();
            
            switch(function){
                case 1 : 
                    System.out.println("\t\t\t>>> Choose Insert <<<");
                    System.out.print("\t\t\tPlease Input Name : ");
                    Ftem.setName(sc.next());
                    System.out.print("\t\t\tPlease Input Salary : ");
                    Ftem.setSalary(sc.nextInt());
                    FullTimeDBController.insertFulltimeEmployee(Ftem);
                    System.out.println("\t\t\tInput Successfull");
                    break;
                case 2 :
                    FulltimeEmployee Ob = TestInsertFullTimeObj();
                    System.out.println("\t\t\t>>> Choose Update <<<");
                    Ftem.setId(Ob.getId());
                    System.out.print("\t\t\tPlease Input Name : ");
                    Ftem.setName(sc.next());
                    System.out.print("\t\t\tPlease Input Salary : ");
                    Ftem.setSalary(sc.nextInt());
                    FullTimeDBController.updateFulltimeEmployee(Ftem);
                    System.out.println("\t\t\tUpdate Successfull");
                    break;
                case 3 :
                    TestInsertFullTimeObj();
                    System.out.println("\t\t\t>>> Choose Delete <<<");
                    System.out.print("\t\t\tPlease Input ID : ");
                    Ftem.setId(Long.valueOf(sc.nextInt()));
                    FullTimeDBController.removeFulltimeEmployee(Ftem);
                    System.out.println("\t\t\tDelete Successfull");                  
                    break;
                default: System.exit(0);
            }
        } else if(option == 2){
            CreateObjPartTime();
            System.out.println("\tYou Selected Parttime Job");
            System.out.print("\t\tPlease Select Function [1 for Insert] [2 for Update] [3 for Delete] : ");
            int function = sc.nextInt();
            
            switch(function){
                case 1 : 
                    System.out.println("\t\t\t>>> Choose Insert <<<");
                    System.out.print("\t\t\tPlease Input Name : ");
                    Ptem.setName(sc.next());
                    System.out.print("\t\t\tPlease Input Hourswork : ");
                    Ptem.setHoursWork(sc.nextInt());
                    PartTimeDBController.insertParttimeEmployee(Ptem);
                    System.out.println("\t\t\tInput Successfull");
                    break;
                case 2 :
                    ParttimeEmployee Ob = TestInsertPartTimeObj();
                    System.out.println("\t\t\t>>> Choose Update <<<");
                    Ptem.setId(Ob.getId());
                    System.out.print("\t\t\tPlease Input Name : ");
                    Ptem.setName(sc.next());
                    System.out.print("\t\t\tPlease Input Salary : ");
                    Ptem.setHoursWork(sc.nextInt());
                    PartTimeDBController.updateParttimeEmployee(Ptem);
                    System.out.println("\t\t\tUpdate Successfull");
                    break;
                case 3 :
                    TestInsertPartTimeObj();
                    System.out.println("\t\t\t>>> Choose Delete <<<");
                    System.out.print("\t\t\tPlease Input ID : ");
                    Ptem.setId(Long.valueOf(sc.nextInt()));
                    PartTimeDBController.removeParttimeEmployee(Ptem);
                    System.out.println("\t\t\tDelete Successfull");
                    break;
                default: System.exit(0);
            }
        }
    }
}
