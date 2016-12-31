import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Supercomp on 24.12.2016.
 */
public class TaskMaster {
    private Manager manager = new Manager();
    private Scanner scanner;


    public void startTaskMaster() {

        System.out.println("Press 1 to add new task: ");
        System.out.println("Press 2 to delete a task:  ");
        System.out.println("Press 3 to show the tasks of an employee:  ");
        System.out.println("Press 4 to show all task");
        System.out.println("Press 5 to change a task:  ");
        System.out.println("Press 6 to go out:  ");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                addNewTask();
                break;

            case 2:
                removeTask();
                break;

            case 3:
                showEmployeesTask();
                break;
            case 4:
                showAllTasks();
                break;

            case 5:
                changeTask();
            case 6:
                manager.startInfo();
                break;
        }
    }

    public void addNewTask() {


        scanner = new Scanner(System.in);
        System.out.println("Please give a name of the employee:    ");
        String userInput = scanner.nextLine();

        for (Employee i : manager.getAllEmployess()) { // Vopros po if else
            if (!i.getName().equalsIgnoreCase(userInput)) {
                continue;
            } else if (i.getName().equalsIgnoreCase(userInput)) {
                startTaskAddingProcess(i);
                startTaskMaster();
            } else {
                System.out.println("There is now employee with such name. Would you like to create an new employee?" +
                        "  Y / N");
                scanner = new Scanner(System.in);
                String userChoice = scanner.nextLine();
                if (userChoice.equalsIgnoreCase("Y")) {
                    manager.startAddingProcess();
                    addNewTask();
                } else {
                    startTaskMaster();
                }

            }

        }
    }

    public void removeTask() {
        scanner = new Scanner(System.in);
        System.out.println("Please give a name of the task which you would like to remove:   ");
        String userInput = scanner.nextLine();
        for (Employee e : manager.getAllEmployess()) {
            for (Task t : e.getTasks())
                if (userInput.equalsIgnoreCase(t.getTaskName())) {
                    e.getTasks().remove(t);
                    System.out.println("Removed successful");
                } else {
                    System.out.println("There is no task with name like this");
                    removeTask();
                }
        }
        startTaskMaster();

    }


    public void showEmployeesTask() {
        scanner = new Scanner(System.in);
        System.out.println("Please give the name of employee:   ");
        String userInput = scanner.nextLine();
        for (Employee e : manager.getAllEmployess()) {
            if (userInput.equalsIgnoreCase(e.getName())) {
                for (Task t : e.getTasks()) {
                    System.out.println(t.getTaskName());
                }
            } else {
                System.out.println("There is no task with name like this");
                removeTask();
            }
        }
    }


    public void showAllTasks() {
        for (Employee e : manager.getAllEmployess()) {
            for (Task t : e.getTasks()) {
                if (e.getTasks().isEmpty()) {
                    System.out.println("There is no tasks");
                } else {

                    System.out.println(t.getTaskName());
                }

            }
        }

    }


    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void changeTask() {
        scanner = new Scanner(System.in);
        System.out.println("Please give the name of the task:  ");
        String userInput = scanner.nextLine();
        for (Employee e : manager.getAllEmployess()) {
            for (Task t : e.getTasks()) {
                if (userInput.equalsIgnoreCase(t.getTaskName())) {
                    System.out.println("You can now change the task: ");
                    System.out.println("Please give the new name for the task:   ");
                    scanner = new Scanner(System.in);
                    userInput = scanner.nextLine();
                    t.setTaskName(userInput);
                    System.out.println("The new name of the Task is " + userInput);
                    startTaskMaster();
                }
            }
        }


    }

    public static void startTaskAddingProcess(Employee employee) {
        Scanner scanner;
        String userInput;
        Task task = new Task();
        task.setEmployee(employee);
        scanner = new Scanner(System.in);
        System.out.println("Please give set a name for the task:    ");
        task.setTaskName(userInput = scanner.nextLine());
        scanner = new Scanner(System.in);
        System.out.println("Please give an description for the task:    ");
        task.setTaskDescription(userInput = scanner.nextLine());
        scanner = new Scanner(System.in);
        System.out.println("Please give the Prio for the task:    ");
        task.setTaskPriority(scanner.nextInt());
        scanner = new Scanner(System.in);
        System.out.println("Please give the deadline for the task (ddmmyyyy):    ");
        task.setTastDeadLine(scanner.nextInt());
        employee.addTask(task);

    }


}