
public class Main {

	public static int flip(int a, int b) {
		int x;

		System.out.println("A=" + String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
		System.out.println("B=" + b+"\n");
		
		System.out.println("S=" + String.format("%32s", Integer.toBinaryString(a << b)).replace(' ', '0'));
		System.out.println("B=" + String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0')+"\n");
		x =a ^ (1 << (b-1));
		System.out.println("X=" + String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0')+"\n");
		return x;
	}

	public static void main(String[] args) {

		System.out.println("Decimal:" + (flip(2, 1)));

	}
}
