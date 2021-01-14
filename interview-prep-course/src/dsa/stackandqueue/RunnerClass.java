package dsa.stackandqueue;

public class RunnerClass {

	public static void main(String[] args) {
		
		Integer i = null;
		Integer v = true ? null :Integer.valueOf(10);
		
		StackCCI<Integer> stk = new StackCCI<>();
		stk.isEmpty();
		stk.push(4);
		stk.push(10);
		stk.push(11);

		stk.peek();

		stk.pop();
		stk.pop();
		stk.pop();
		stk.isEmpty();

	}

}
