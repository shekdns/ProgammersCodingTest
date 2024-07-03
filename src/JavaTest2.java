import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public class JavaTest2 {
  public static void main(String[] args) {
    YearMonth today1 = YearMonth.now();
    LocalDate start1 = today1.atDay(1);
    LocalDate end1 = today1.atEndOfMonth();


    System.out.println("오늘 날짜 : " + today1);
    System.out.println("해당 월의 시작일(1일) : " + start1);
    System.out.println("해당 월의 마지막일 : " + end1);
  }
}

