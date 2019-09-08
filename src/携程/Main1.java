package 携程;

/**
 * 括号内字符串翻转，如果括号不匹配，返回空
 * ((ru)oi)
 * 结果:ioru
 */
import java.util.*;

public class Main1 {
	
    public static void main(String[] args){
        String str = "((ru)oi)";
        System.out.println(resolve(str));
    }

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

}
