package tests;

import java.util.Arrays;

public class Stack {
	private static int MAX_CAPACITY = 10;
	private Object array[];
	private int head = -1;
	
	public int getHead(){
		return head;
	}
	
	public Object[] getData(){
		return this.array;
	}
	
	public Stack(){
		array = new Object[Stack.MAX_CAPACITY];
	}
	
	public void push(Object node){
		if (head < Stack.MAX_CAPACITY - 1){
			head++;
			array[head] = node;
		}
		else {
			System.out.println("Stack is full");
		}
	}
	
	public void pop(){
		if (head >= 0){
			array[head] = null;
			head--;	
		}
		else {
			System.out.println("Stack is empty");
		}
	}
	
	public int size(){
		return 0;
	}
	
	public static void main(String[] args){
		Stack stack = new Stack();
		System.out.println(Arrays.toString(stack.getData()));
		stack.push(5);
		stack.push(3);
		stack.push(10);
		stack.push(7);
		stack.push(7);
		
		stack.push(7);
		stack.push(7);
		stack.push(7);
		stack.push(7);
		stack.push(7);
		System.out.println(Arrays.toString(stack.getData()));
		stack.push(11);
		System.out.println(Arrays.toString(stack.getData()));
		
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		
		
		//stack.push(11);
		
		System.out.println(Arrays.toString(stack.getData()));
		stack.pop();
		System.out.println(stack.getHead());
		stack.pop();
		System.out.println(stack.getHead());
		
	}
	
}
