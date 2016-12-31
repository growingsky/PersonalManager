import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ServiceConfigurationError;


public class Manager {

    private int userChoice;
    private Employee employee;
    private ArrayList<Employee> employees = new ArrayList<>();
    private SourceFileManager sourceFileManager = new SourceFileManager();
    Scanner in = new Scanner(System.in);


    public void startInfo() {
        System.out.println("Menü");
        System.out.println("If you want to add new employee press 1");
        System.out.println("If you want to see all employees press 2");
        System.out.println("If you want to remove an employee press 3");
        System.out.println("If you want to find an employee press 4");
        System.out.println("For Taskmaster press 5");
        System.out.println("For exit press 0 ");
        employeeDBpopulation();
        userChoice = in.nextInt();
        if(userChoice == 0){

        }
        while (userChoice != 0) {

            if (userChoice == 1) {
                startAddingProcess();
            } else if (userChoice == 3) {
                startRemovingProcess();
            } else if (userChoice == 2) {
                startPrintAllDataProcess();
            } else if (userChoice == 4) {
                findEmployeeByName();
            } else if (userChoice == 5) {
                TaskMaster taskMaster = new TaskMaster();
                taskMaster.setManager(this);
                taskMaster.startTaskMaster();

            }


            startInfo();

        }
    }

    public void startAddingProcess() {

        employee = new Employee();
        System.out.print("Please give a name of the employee:   ");
        employee.setName(in.next());
        System.out.print("Please give a position of the employee:   ");
        employee.setPosition(in.next());
        System.out.print("Please give a salary for the employee:   ");
        employee.setSalary(in.nextInt());
        addEmployee(employee);
        SourceFileManager sourceFileManager = new SourceFileManager();
        sourceFileManager.writeInFile(employees);




    }

    public void startRemovingProcess() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please give a name of the employee:   ");
        removeEmployeeByName(in.nextLine());

    }

    public void startPrintAllDataProcess() {
        getEmployeesData();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployeeByName(String name) {

        if (!employees.isEmpty()) {

            for (Employee i : employees) {
                if (name.equalsIgnoreCase(i.getName())) {
                    employees.remove(this);
                    System.out.println("Employee has been removed successfuly ");
                } else {
                    System.out.println("There is no employee with such name");
                }
            }
        }
        System.out.println("The list of employees is empty");
    }

    public void getEmployeesData() {

        for (Employee i : employees) {
            System.out.println(i.getName());
            System.out.println(i.getPosition());
            System.out.println(i.getSalary());

        }
    }


    public void findEmployeeByName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name of the employee:    ");
        String name = in.nextLine();
        for (Employee i : employees) {
            if (name.equalsIgnoreCase(i.getName())) {
                System.out.println(i.getName() + " " + i.getPosition() + " " + i.getSalary());
            } else {
                System.out.println(" I couldn't find employee with name like this, try again");


            }
        }


    }

    public ArrayList<Employee> getAllEmployess() {
        return employees;
    }


    public void employeeDBpopulation() {
        employees.addAll(sourceFileManager.readFromFile());

    }



}


