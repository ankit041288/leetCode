import java.util.Stack;

class MinStack {
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();


    }
    private static Integer Gmin;
    private Stack<Node> s = new Stack<>();

    public class Node{
        int val;
        int min;
    }

    /** initialize your data structure here. */
    public MinStack() {
         Gmin=Integer.MAX_VALUE;
    }

    public void push(int x) {
        Node n = new Node();
        n.val=x;
        if(x<Gmin){
            Gmin=x;
        }
        n.min=Gmin;
        s.push(n);


    }

    public void pop() {
        s.pop();

    }

    public int top() {
       return  s.peek().val;
    }

    public int getMin() {
        return  s.peek().min;

    }
}