package placement;

public class lowerToUpperCaseString {
    public static void main(String[] args) {
        String str = "hello my name is adi";
        StringBuilder str1 = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str1.append(' ');
            }
            else {
                str1.append((char) (str.charAt(i) - 32));
            }
        }
        str1.toString(); // CONVERTION TO STRING
        System.out.println(str1);
    }
}
