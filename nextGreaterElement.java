package placement;
import java.util.Stack;

//public class nextGreaterElement {

    //BRUTE FORCE O(n^2)

//    public static void nextGreatestEle(int[] arr){
//        for(int i=0;i<arr.length;i++){
//            int max = Integer.MIN_VALUE;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i]<arr[j]){
//                    max = Math.max(arr[j],max);
//                    break;
//                }
//            }
//            if(max<=arr[i]){
//                System.out.print(-1+" ");
//            }
//            else {
//                System.out.print(max + " ");
//            }
//        }
//    }

    // Implementation using stack O(n)
public class nextGreaterElement {
    public static int[] nextGreatestEle(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] nextGreater = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){  //Begineers ke dimag me aayega nested loop! O(n^2) but
                // yaha ye while loop hamesha bas do bar chalega max to max which is constant hence O(n)
                stack.pop();
            }

            if(stack.isEmpty()) nextGreater[i] = -1;
            else nextGreater[i] = arr[stack.peek()];
            stack.push(i);
        }
         return nextGreater;
    }
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] res = new int[arr.length];
        res = nextGreatestEle(arr);
        for(int ans:res){
            System.out.print(ans+" ");
        }
    }
}
