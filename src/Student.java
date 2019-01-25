import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
public class Student
{
   public static void main(String [] args)
   {
      HashMap<Integer, String> map = null;
      try
      {
         FileInputStream fis = new FileInputStream("hashmap.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         map = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized HashMap..");
      // Add foreach
      for(HashMap.Entry<Integer, String> go: map.entrySet()) {
    	  System.out.println("key: "+go.getKey()+" value: "+go.getValue());
      }
    }
}