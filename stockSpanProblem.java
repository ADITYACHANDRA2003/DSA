
// WITH ARRAYS

//package placement;
//import java.util.Stack;
//
//public class stockSpanProblem {
//
//    public static void stockSpan(int[] stocks, int[] span){
//        Stack<Integer> stack = new Stack<Integer>();
//        span[0] = 1;   // first value of span will be always 1
//        stack.push(0);
//        for(int i = 1; i < stocks.length; i++){
//            int currPrice = stocks[i];
//            while(!stack.isEmpty() && stocks[stack.peek()] < currPrice){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                span[i] = i+1;  // if Stack empty assign first value of span as 1
//            }
//            span[i] = i - stack.peek();
//            stack.push(i);
//        }
//    }
//    public static void main(String[] args) {
//        int[] stocks = {100,80,60,70,60,85,100};
//        int[] span = new int[stocks.length];
//        stockSpan(stocks,span);
//        for(int i = 0; i<span.length; i++){
//            System.out.print(span[i]+" ");
//        }
//    }
//}

// WITH ARRAYLIST

package placement;

import java.util.*;

public class stockSpanProblem {

    public static void stockSpan(ArrayList<Integer> stock, ArrayList<Integer> span){
        if(stock.size() == 0){
            System.out.println("enter the stocks please!");
            return;
        }
        Stack<Integer> s = new Stack<Integer>();
        span.add(1);
        s.push(0);
        for(int i = 1; i < stock.size(); i++){
            int currPrice = stock.get(i);
            while(!s.isEmpty() && stock.get(s.peek()) < currPrice){
                s.pop();
            }
            if(s.isEmpty()){
                span.add(i+1);
            }

            int prevHigh = s.peek();
            span.add(i-prevHigh);
            s.push(i);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> span = new ArrayList<>();
        list.add(100);
        list.add(80);
        list.add(60);
        list.add(70);
        list.add(60);
        list.add(85);
        list.add(100);
        stockSpan(list,span);
        for(Integer i : span){
            System.out.print(i+" ");
        }
    }
}

