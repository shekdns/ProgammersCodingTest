import java.util.HashMap;
import java.util.Map;

public class JavaTest {
  public static void main(String[] args) {
    HashMap<Integer, String> map = new HashMap<>();
    map.put( 1, "A" );
    map.put( 2, "B" );
    map.put( 3, "C" );

    for(Map.Entry<Integer, String> entry : map.entrySet() ) {
      int key      = entry.getKey();
      String value = entry.getValue();

      System.out.println( "KEY = " + key + " VALUE = " + value );
    }

    System.out.println( "======================" );
    map.forEach(( key, value ) -> {
      System.out.println( "KEY = " + key + " VALUE = " + value );
    });
  }
}
