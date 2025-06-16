import java.util.Stack;
public class use{
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            
        }
        System.out.println("Elements in Stack : " +stack);
        while(!stack.isEmpty()){
           Integer popping = stack.pop();
           
        }
        System.out.println("all elements popped ");
    for(int i=0;i<6;i++){
            stack.push(i);
        }
        System.out.println("New Elemets: " +stack);
        System.out.println("peeking: "+stack.peek());
        stackSearch (stack , 3);
    }
        
        
        static void stackSearch(Stack<Integer> stack, int element) {
            Integer Pos = stack.search(element);
            if (Pos == -1) {
                System.out.println("element " + element + " not found");
            } else {
                System.out.println("element " + element + " found at position " + Pos);
            }
        }
    }