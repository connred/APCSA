public class Main {
    public static void main(String[] args){
        int x = countOdds(args);
        System.out.println(x);
    }
    public static int countOdds(String[] args){
        int c = 0;
        for (String s: args){
            if (s.length() % 2 != 0){
                c++;
            }
        }
        return c;
    }
    
}