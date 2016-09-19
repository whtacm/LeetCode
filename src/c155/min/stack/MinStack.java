/**
 * 
 */
package c155.min.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * <p>
 * push(x) -- Push element x onto stack. <br>
 * pop() -- Removes the element on top of the stack. <br>
 * top() -- Get the top element. <br>
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * 
 * Example:<br>
 * MinStack minStack = new MinStack();<br>
 * minStack.push(-2);<br>
 * minStack.push(0);<br>
 * minStack.push(-3);<br>
 * minStack.getMin(); --> Returns -3.<br>
 * minStack.pop();<br>
 * minStack.top(); --> Returns 0.<br>
 * minStack.getMin(); --> Returns -2.<br>
 * <p>
 * 
 * Hide Tags Stack Design<br>
 * Hide Similar Problems (H) Sliding Window Maximum
 * <p>
 * 
 * @author Jilvo
 *
 */
public class MinStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();

	/**
	 * 
	 * @param x
	 */
	public void push(int x) {
		if (min >= x) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	/**
	 * 
	 */
	public void pop() {
		if (stack.peek() == min) {
			stack.pop();
			min = stack.peek();
			stack.pop();
		} else {
			stack.pop();
		}
		if (stack.empty()) {
			min = Integer.MAX_VALUE;
		}
	}

	/**
	 * 
	 * @return
	 */
	public int top() {
		return stack.peek();
	}

	/**
	 * 
	 * @return
	 */
	public int getMin() {
		return min;
	}
}
