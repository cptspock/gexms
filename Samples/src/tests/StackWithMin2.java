package tests;

import java.util.Stack;

public class StackWithMin2 extends Stack<NodeWithMin2> {

	private static final long serialVersionUID = -8408136075758876605L;	
	private int minValue; 
	
	public void push(int value) {
		if (this.empty()) minValue = value;
		else { 
			minValue = Math.min(value, minValue);
		}
		super.push(new NodeWithMin2(value));
	}
	
	public int getMin() {
		return this.minValue;
	}

	public static void main(String[] args) {
		StackWithMin2 stack1 = new StackWithMin2();
		stack1.push(5);
		stack1.push(1);
		stack1.push(3);
		stack1.push(10);
		System.out.print(stack1.getMin());
	}
}

class NodeWithMin2 {
	private int value;

	public NodeWithMin2(int v) {
		this.value = v;	
	}	
}