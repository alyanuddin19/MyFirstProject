import java.util.LinkedList;
import java.util.Queue;
public class QUEUE {
    public static void main(String[] args) {
        Queue<String> q =  new LinkedList <String>();
            q.add("SCD");
            q.add("WEB");
            q.add("IS");
            q.add("MKT");
            System.out.println("Queue: "+q);
            System.out.println("First Element: "+q.peek());

        String removedelmnt= q.remove ();
        System.out.println("Queue after removing element: "+q);

        String head = q.peek();
        System.out.println("Head of the queue: "+head);

        int  size = q.size();
        System.out.println("size of queue: "+size);

        

        }
    
}
