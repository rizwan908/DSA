package dsa.stacks;

public class RunnerClass {

	public static void main(String[] args) {
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
