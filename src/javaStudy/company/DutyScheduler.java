package javaStudy.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

class DutyPerson {
  String role;
  String name;
  String gender;

  public DutyPerson(String role, String name, String gender) {
    this.role = role;
    this.name = name;
    this.gender = gender;
  }
}

class DutyAssignment {
  String date;
  String shiftType;
  String role;
  String name;
  String dayType;

  public DutyAssignment(String date, String shiftType, String role, String name, String dayType) {
    this.date = date;
    this.shiftType = shiftType;
    this.role = role;
    this.name = name;
    this.dayType = dayType;
  }

  @Override
  public String toString() {
    return date + " " + shiftType + " " + role + " " + (name.isEmpty() ? "미배정" : name) + " " + dayType;
  }
}

public class DutyScheduler {
  public static void main(String[] args) {
    // 📌 1. 대상자 리스트 (배정 순서대로)
    Queue<DutyPerson> totalCandidates = new LinkedList<>(Arrays.asList(
            // 총사령(여자) → 총사령(남자) → 부사령(여자) → 부사령(남자) → 보조(여자) → 보조(남자) 순
            new DutyPerson("총사령", "여1", "여자"), new DutyPerson("총사령", "여2", "여자"),
            new DutyPerson("총사령", "여3", "여자"), new DutyPerson("총사령", "여4", "여자"),
            new DutyPerson("총사령", "여5", "여자"), new DutyPerson("총사령", "총사령6", "남자"),
            new DutyPerson("총사령", "총사령7", "남자"), new DutyPerson("총사령", "총사령8", "남자"),

            new DutyPerson("부사령", "부사령1", "여자"), new DutyPerson("부사령", "부사령2", "여자"),
            new DutyPerson("부사령", "부사령3", "여자"), new DutyPerson("부사령", "부사령4", "여자"),
            new DutyPerson("부사령", "부사령5", "남자"), new DutyPerson("부사령", "부사령6", "남자"),
            new DutyPerson("부사령", "부사령7", "남자"), new DutyPerson("부사령", "부사령8", "남자"),
            new DutyPerson("부사령", "부사령9", "남자"), new DutyPerson("부사령", "부사령10", "남자"),

            new DutyPerson("보조", "보조1", "여자"), new DutyPerson("보조", "보조2", "여자"),
            new DutyPerson("보조", "보조3", "여자"), new DutyPerson("보조", "보조4", "여자"),
            new DutyPerson("보조", "보조5", "여자"), new DutyPerson("보조", "보조6", "여자"),
            new DutyPerson("보조", "보조7", "여자"), new DutyPerson("보조", "보조8", "여자"),
            new DutyPerson("보조", "보조9", "여자"), new DutyPerson("보조", "보조10", "여자"),
            new DutyPerson("보조", "보조11", "남자"), new DutyPerson("보조", "보조12", "남자"),
            new DutyPerson("보조", "보조13", "남자"), new DutyPerson("보조", "보조14", "남자"),
            new DutyPerson("보조", "보조15", "남자"), new DutyPerson("보조", "보조16", "남자"),
            new DutyPerson("보조", "보조17", "남자"), new DutyPerson("보조", "보조18", "남자"),
            new DutyPerson("보조", "보조19", "남자"), new DutyPerson("보조", "보조20", "남자")
    ));

    List<DutyAssignment> assignments = new ArrayList<>();
    LocalDate startDate = LocalDate.of(2025, 2, 1);
    LocalDate endDate = LocalDate.of(2025, 2, 28);

    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
      boolean isWeekendOrHoliday = isWeekendOrHoliday(date);
      String dayType = isWeekendOrHoliday ? "휴일" : "평일";
      String[] shiftTypes = isWeekendOrHoliday ? new String[]{"일직", "숙직"} : new String[]{"숙직"};

      for (String shift : shiftTypes) {
        String[] roles = {"총사령", "부사령", "보조", "보조"};

        for (String role : roles) {
          String name = "";

          // 📌 4. 배정할 대상자를 찾음 (FIFO 방식)
          Iterator<DutyPerson> iterator = totalCandidates.iterator();
          while (iterator.hasNext()) {
            DutyPerson person = iterator.next();
            if (person.role.equals(role)) {
              name = person.name;
              iterator.remove(); // 📌 해당 대상자는 리스트에서 제거 (월 내 재배정 방지)
              break;
            }
          }

          // 📌 5. 결과 저장
          assignments.add(new DutyAssignment(date.toString().replace("-", ""), shift, role, name, dayType));
        }
      }
    }

    // 📌 6. 결과 출력
    assignments.forEach(System.out::println);
  }

  // 📌 주말 또는 공휴일 판별 (현재는 토요일/일요일만 적용)
  public static boolean isWeekendOrHoliday(LocalDate date) {
    DayOfWeek day = date.getDayOfWeek();
    return (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
  }
}
