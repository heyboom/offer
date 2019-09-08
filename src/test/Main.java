package test;

import java.util.*;

public class Main {

    static String resolve(String expr) {
        Deque<Character> stack = new LinkedList<>();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == ')') {
                while (stack.peek() != '(' && !stack.isEmpty()) {
                    queue.offer(stack.poll());
                }
                if(stack.isEmpty()) {
                    return "";
                }
                stack.pop();
                count--;
                while(!queue.isEmpty()) {
                    stack.push(queue.poll());
                }
            } else if (c == '('){
                stack.push(c);
                count++;
            } else {
                stack.push(c);
            }
        }
        if (count > 0) return "";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
            
        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }
  
        res = resolve(_expr);
        System.out.println(res);
    }
}
