import java.io.Serializable;

/**
 * Created by Supercomp on 24.12.2016.
 */
public class Task implements Serializable{
    private String taskName;
    private Employee employee;
    private int taskPriority;
    private String taskDescription;
    private int tastDeadLine;

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTastDeadLine(int tastDeadLine) {
        this.tastDeadLine = tastDeadLine;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public int getTastDeadLine() {
        return tastDeadLine;
    }


}
