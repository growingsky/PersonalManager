import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Comp on 29.12.2016.
 */
public class SourceFileManager {
    private File file = new File("C:\\Users\\Comp\\Documents\\GitHub\\filesource.out");
    private static final String PATH = "C:\\Users\\Comp\\Documents\\GitHub\\filesource.out";



    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void writeInFile(Object object){
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream  outputStream = new FileOutputStream (getFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();

        }catch (IOException x){
            x.printStackTrace();
        }

    }

    public ArrayList<Employee> readFromFile() {
        ArrayList<Employee> employees = null;

        try {
            FileInputStream inputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            employees = (ArrayList) objectInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
