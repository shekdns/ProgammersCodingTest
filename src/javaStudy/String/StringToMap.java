package javaStudy.String;

import java.util.HashMap;

public class StringToMap {
  public static void main(String[] args) {
    String str = "tableName@:@TTATLV021!&utyInstCd@:@641000000!&vcaSeCd@:@03";
    String[] array1 = str.split( "!&" );

    HashMap<String,Object> map = new HashMap<>();
    for( String s : array1 ) {
      String[] inner = s.split( "@:@" );
      map.put( inner[0], inner[1] );
    }

    System.out.println( map );
  }
}
