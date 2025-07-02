package placement;

import java.util.ArrayList;

public class indianCoin {

    public static void noOfChange(int val){
        int[] coins = {500,200,100,50,20,10,5,2,1};
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=val){
                while(val>=coins[i]) {
                    list.add(coins[i]);
                    count++;
                    val -= coins[i];
                }
            }
        }
        System.out.println("No. of denominations taken: "+count);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int val = 669;
        noOfChange(val);
    }
}
