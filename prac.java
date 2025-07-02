package placement;

import java.util.*;

public class prac {
    public static void main(String[] args) {
        String[] names = new String[5];
        names[0] = "Tarun";
        names[1] = "travis";
        names[2] = "John";
        names[3] = "Mary";
        names[4] = "Aditya";

        TreeSet<String> ts = new TreeSet<>();
        for(String name : names){
            ts.add(name);
        }
        while(!ts.isEmpty()){
            String out = ts.pollFirst();
            System.out.println(out);
        }
    }
}
