package tests;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {

	private static final long serialVersionUID = -8408136075758876605L;	

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().getMin();
		}
	}

	public static void main(String[] args) {
		StackWithMin stack1 = new StackWithMin();
		stack1.push(5);
		stack1.push(1);
		stack1.push(3);
		stack1.push(10);
		System.out.print(stack1.min());
	}
}

class NodeWithMin {
	private int value;
	private int min;

	public NodeWithMin(int v, int min) {
		this.value = v;
		this.min = min;
	}
	
	public int getMin() {
		return min;
	}
}