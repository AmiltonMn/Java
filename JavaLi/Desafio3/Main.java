package Desafio3;

public class Main 
{
    public static void main(String[] args) 
    {
        Stack<Integer> stack = new Stack<>();
        ListaQueue<Integer> queue = new ListaQueue<>();
  
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(stack.pop());

        System.out.println(stack.size());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(stack.peek());

    }    
}
