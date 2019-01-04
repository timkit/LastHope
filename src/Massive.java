
public class Massive {
	public static boolean reg(String s) {
		String s1=s.replaceAll("[^a-zA-Z0-9]+", "");
		String revers = new StringBuffer(s1).reverse().toString();
		System.out.println(s1);
		System.out.println(revers);
		return revers.equalsIgnoreCase(s1);

	}

	public static void main(String[] args) {

		System.out.println(reg("Madam, I'm Adam!"));
	}

}
