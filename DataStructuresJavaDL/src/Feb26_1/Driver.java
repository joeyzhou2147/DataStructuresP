package Feb26_1;
import javax.swing.JOptionPane;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
//		me.doIt();
		me.calc();
	}
	
	private void calc() {
		RPNCalc calc = new RPNCalc();
		calc.driver();
	}
	
	private void doIt() {
		MyStack stack = new LinkedStack();
		System.out.println(stack.isEmpty());
		stack.push(10);
		stack.push(20);
		System.out.println(stack);
		stack.push(30);
		System.out.println(stack);
		
		System.out.println("Stack top is = " + stack.stackTop());
		stack.clear();
		System.out.println(stack);
		
		// Don't do this...
		//((LinkedStack) stack).printHi();
		
		// You can do this, but it is a bit weird 
		if (stack instanceof LinkedStack) {
			((LinkedStack) stack).printHi();
		}
		int reply = JOptionPane.showConfirmDialog(null, "hi", "This is cool", 
				JOptionPane.YES_NO_OPTION);
	}

}
