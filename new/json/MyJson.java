import java.io.*;
import java.nio.file.*;
import java.util*;
import com.google.gson.*;

public class MyJson{
  public static void main(String[] args){
    MyJson myJson = new MyJson();
    Department department = myJson.readJsonFile();
    myJson.saveJsonFile(department);
  }
  
  public Department readJsonFile(){
    Department department = null;
    try{
      Gson gson = new Gson();
      Reader reader = Files.newBufferedReader(Paths.get("user.json"));
      department = gson.fromJson(reader, Department.class);
      for( int i =0; i <department.users.length; i++ ){
        User user = department.users[i];
        System.out.println(user.name);
      }
      reader.close();
    } catch (Exception ex){
      ex.printStackTrace();
    }
    
    return department
  }
  
  public void saveJsonFile(Department department){
    try{
      Gson gson = new Gson();
      FileWriter writer = new FileWriter("user_out.json");
      writer.close();
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
