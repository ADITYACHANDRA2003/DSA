package placement;

import java.util.HashMap;

public class findItineraryTicket {

    public static String getStart(HashMap<String,String> map){
        HashMap<String,String> rev = new HashMap<>();
        for(String key : map.keySet()){
            rev.put(map.get(key),key);
        }
        for(String key : map.keySet()){
            if(!rev.containsKey(key)){
                return key;
            }
        }
        return null;  // Usually this will never occur
    }
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Chennai","Bengluru");
        map.put("Mumbai","Delhi");
        map.put("Goa","Chennai");
        map.put("Delhi","Goa");

        String Start = getStart(map);
        System.out.print(Start);
        for(String key : map.keySet()){
            System.out.print(" -> " + map.get(Start));
            Start = map.get(Start);
        }
    }
}
