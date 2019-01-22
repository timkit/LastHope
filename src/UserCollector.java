import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UserCollector {
	final static String FILE = "profile.ser";
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private int id;
	private static int nextId = 1;
	private static int currentId;
	static HashMap<Integer, User> hm;

	public UserCollector() {

		hm = new HashMap<Integer, User>();
	}

	public void setId() {
		id = currentId+nextId;
		System.out.println(id);
		nextId++;
	}

	public void Insert(User user) {
		setId();
		hm.put(id, user);		
	}
	public void Delete(int key) {
		hm.remove(key);
	}
	@SuppressWarnings("unchecked")
	public void Load() {

		try {
			FileInputStream fis=new FileInputStream(FILE);
			ObjectInputStream ois=new ObjectInputStream(fis);
			hm=((HashMap<Integer, User>) ois.readObject());
			ois.close();
			fis.close();
			currentId=hm.size();
			System.out.println("Size of map "+hm.size());
		}   catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	    	  c.printStackTrace();
	    	  return;
	      }
		  Set<?> set = hm.entrySet();
	      Iterator<?> iterator = set.iterator();
	      
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key: "+ mentry.getKey() + " & Value: ");
	         System.out.println(mentry.getValue());
	      }
	}

	public void Save() {
		try {
			FileOutputStream fos = new FileOutputStream(FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hm);
			oos.close();
			fos.close();
			System.out.println("Ok");
			} catch (Exception ei) {
				ei.printStackTrace();
			}
		

	}

	public static void main(String[] args) {

		

	}

}
