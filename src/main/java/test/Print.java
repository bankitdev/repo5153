/**
 * 
 */
package test;

/**
 * @author Sunil Kashyap
 *
 *         Created Date 21-Feb-2019
 */
public class Print {
	public static void main(String[] args) {
		String name = "65463&B6546*&^A76N5556K@#(I+_:^T%*()*";

		for (int i = 0; i < name.length(); i++) {
			char nam = name.charAt(i);
			if ((nam >= 'a' && nam <= 'z') || (nam >= 'A' && nam <= 'Z')) {
				System.out.print(nam);
			}
		}
		/*for(int j=0; j<name.length();j++) {
			char num = name.charAt(j);
			if ((num >= '0' && num <= '9')) {
				//System.out.println("/");
				System.out.print(num);
			}
		}*/
	}
}
