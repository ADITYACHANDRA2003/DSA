package placement;

import java.util.Stack;

// Time Complexity O(n)
public class maxRectagularAreaInHistogram {

    public static void findMaxArea(int[] height){
        int maxArea = 0, n = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int[] sla = new int[n];
        int[] sra = new int[n];


        // This part is similar to nextGreatestElement
        for (int i = n-1; i >= 0; i--) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.isEmpty()) sra[i] = n;
            else sra[i] = s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = 0; i < n; i++) {
            while(!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.isEmpty()) sla[i] = -1;
            else sla[i] = s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            int h = height[i];
            int width = sra[i] - sla[i] -1;  // width is i-j-1
            int area = h * width;
            maxArea = Math.max(area, maxArea);
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        findMaxArea(height);
    }
}
