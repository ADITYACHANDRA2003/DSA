package placement;

class StockandSell {
    public static int stock(int[] arr) {
       int buyprice = Integer.MAX_VALUE,sellprice=0,maxProfit=0;
       for (int i = 0; i < arr.length; i++) {
           if(buyprice<arr[i]){
               sellprice = arr[i] - buyprice;
               maxProfit = Math.max(maxProfit,sellprice);
           }
           else
               buyprice = arr[i];
       }
       if(maxProfit > 0)
         return maxProfit;
       else
           return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,4,3,2,1};
        System.out.println(stock(arr));
    }
}