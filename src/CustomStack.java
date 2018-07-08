import java.util.ArrayList;

public class CustomStack<T> {
    private static int maxSize = 10;

    private static int size;

    private ArrayList<T> stackArray = null;

    private int top;


     CustomStack() {
        size = 0;
        stackArray = new ArrayList<>();
        top = -1;
        for (int i = 0; i <= maxSize; i++) {
            stackArray.add(null);
        }
    }
        public boolean isEmpty(){
            return top<0;
        }

        public T pop() {
            T val;
        if(!isEmpty()) {
           val  = stackArray.get(top);
            top--;
        }
        else { return null; }
            return  val;
    }
    public boolean push(T val){
        if(top+1 == maxSize){
            return false;
        }
        else {        top++;

        stackArray.set(top,val);}

        return true;
    }


}
