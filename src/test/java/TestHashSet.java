import java.util.HashSet;

public class TestHashSet {
    public static void main(String[] args) {
       HashSet<String> hSet= new HashSet<>();
       
       hSet.add("tu");
       hSet.add("nguyen");
       hSet.add("tu");

       for(String std: hSet){
       System.out.println(std);
    }
}
}
