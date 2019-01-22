import java.io.Serializable;

public class User implements UserDataWork, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private String password;
	private int accessLevel = 0;

	final static int READ = 0;
	final static int WRITE = 1;
	final static int EDIT = 2;
	final static int DELETE = 4;

	public User(String name, String type, String password, int accessLevel) {
		this.name = name;
		this.type = type;
		this.password = password;
		this.accessLevel = accessLevel;

	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public String getPassword() {
		return this.password;
	}

	public int getAccesLevel() {
		return this.accessLevel;
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write() {

	}

	@Override
	public void delete() {

	}

}
