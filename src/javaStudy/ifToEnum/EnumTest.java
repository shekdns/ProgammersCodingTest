package javaStudy.ifToEnum;

import java.util.Arrays;

public enum EnumTest {
  CASE_A( "AAA", "A", 1 ),
  CASE_B( "BBB", "B", 2 ),
  CASE_C( "CCC", "C", 3 ),
  CASE_N( "NULL", "NULL", 0);

  private String name;
  private String type;
  private int number;

  EnumTest( String name, String type, int number ) {
    this.name   = name;
    this.type   = type;
    this.number = number;
  }

  public static EnumTest getClassInfo( String type, int number ) {
    return Arrays.stream( EnumTest.values() ).filter( x -> x.type.equals( type ) && x.number == number )
            .findAny()
            .orElse( CASE_N );
  }

  public static String getClassName( String type, int number ) {
    return getClassInfo( type, number ).getName();
  }

  public String getName() {
    return this.name;
  }
}