package placement;

public class shortestPathString {
    public static void main(String[] args) {
      String directions = "WNEENESENNN";
      int x=0,y=0;
      for(int i=0;i<directions.length();i++){
          if(directions.charAt(i)=='W'){
              x-=1;
          }
          else if(directions.charAt(i)=='N'){
              y+=1;
          }
          else if(directions.charAt(i)=='E'){
              x+=1;
          }
          else if(directions.charAt(i)=='S'){
              y-=1;
          }
          else System.out.println("Invalid direction");
      }
      double res = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
      System.out.println("The shortest distance is : "+ res);

    }
}
