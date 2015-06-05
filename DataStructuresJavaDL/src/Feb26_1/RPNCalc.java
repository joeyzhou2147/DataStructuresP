package Feb26_1;
import java.util.Scanner;


public class RPNCalc {

	public void driver() {
		MyStack stack = new LinkedStack();

		boolean done = false;
		Scanner kbd = new Scanner(System.in);
		String input;

		while (!done) {
			System.out.print("(Enter H for Help) ->");
			input = kbd.nextLine();

			switch(input.trim().toUpperCase().charAt(0)) {
			case 'Q':
				done = true;
				break;

			case 'H':
			case '?':
				System.out.println("Help yourself");
				break;
				
			case 'D':
				System.out.println(stack);
			break;
			
			case 'C':
				stack.clear();
				break;
				
			case '+':
				if (stack.stackDepth() < 2) {
					System.out.println("Error: insufficient operands on stack");
				} else {
					Integer a = stack.pop();
					Integer b = stack.pop();
					stack.push(a + b);
				}
				break;

			case '-':
				if (stack.stackDepth() < 2) {
					System.out.println("Error: insufficient operands on stack");
				} else {
					Integer a = stack.pop();
					Integer b = stack.pop();
					stack.push(b - a);
				}
				break;

			case '/':
				if (stack.stackDepth() < 2) {
					System.out.println("Error: insufficient operands on stack");
				} else {
					Integer a = stack.pop();
					Integer b = stack.pop();
					if (a == 0) {
						System.out.println("Error division by 0");
						stack.push(b);
						stack.push(a);
					} else {
						stack.push(b / a);
					}
				}
				break;

			case '*':
				if (stack.stackDepth() < 2) {
					System.out.println("Error: insufficient operands on stack");
				} else {
					Integer a = stack.pop();
					Integer b = stack.pop();
					stack.push(a * b);
				}
				break;

			case '=':
				System.out.println(stack.stackTop());
				break;

			default:
				stack.push(Integer.valueOf(input.trim()));
			}
		}

		System.out.println("Thank you for using this calculator");
	}

}
