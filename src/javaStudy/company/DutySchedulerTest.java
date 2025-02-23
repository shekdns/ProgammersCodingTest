package javaStudy.company;

import java.util.*;

class CalendarDay {
  String date;
  String dayType;
  String weekDay;

  public CalendarDay(String date, String dayType, String weekDay) {
    this.date = date;
    this.dayType = dayType;
    this.weekDay = weekDay;
  }
}

class DutyPerson {
  String role;
  String name;
  String gender;

  public DutyPerson(String role, String name, String gender) {
    this.role = role;
    this.name = name;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return role + " " + name + " " + gender;
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

public class DutySchedulerTest {
  public static void main(String[] args) {
    List<CalendarDay> calendarDays = Arrays.asList(
            new CalendarDay("20250201", "휴일", "토요일"),
            new CalendarDay("20250202", "휴일", "일요일"),
            new CalendarDay("20250203", "평일", "월요일"),
            new CalendarDay("20250204", "평일", "화요일"),
            new CalendarDay("20250205", "평일", "수요일"),
            new CalendarDay("20250206", "평일", "목요일"),
            new CalendarDay("20250207", "평일", "금요일"),
            new CalendarDay("20250208", "휴일", "토요일"),
            new CalendarDay("20250209", "휴일", "일요일")
    );

    Queue<DutyPerson> candidatesWoman = new LinkedList<>(Arrays.asList(
            new DutyPerson("총사령", "총사령여자1", "여자"), new DutyPerson("총사령", "총사령여자2", "여자"),
            new DutyPerson("총사령", "총사령여자3", "여자"), new DutyPerson("총사령", "총사령여자4", "여자"),
            new DutyPerson("총사령", "총사령여자5", "여자")
    ));

    Queue<DutyPerson> candidatesMan = new LinkedList<>(Arrays.asList(
            new DutyPerson("총사령", "총사령남자6", "남자"),
            new DutyPerson("총사령", "총사령남자7", "남자"), new DutyPerson("총사령", "총사령남자8", "남자")
    ));

    Queue<DutyPerson> candidates2Woman = new LinkedList<>(Arrays.asList(
            new DutyPerson("부사령", "부사령여자1", "여자"), new DutyPerson("부사령", "부사령여자2", "여자"),
            new DutyPerson("부사령", "부사령여자3", "여자"), new DutyPerson("부사령", "부사령여자4", "여자")
    ));

    Queue<DutyPerson> candidates2Man = new LinkedList<>(Arrays.asList(
            new DutyPerson("부사령", "부사령남자5", "남자"), new DutyPerson("부사령", "부사령남자6", "남자"),
            new DutyPerson("부사령", "부사령남자7", "남자"), new DutyPerson("부사령", "부사령남자8", "남자")
    ));

    Queue<DutyPerson> candidates3Woman = new LinkedList<>(Arrays.asList(
            new DutyPerson("보조", "보조여자1", "여자"), new DutyPerson("보조", "보조여자2", "여자"),
            new DutyPerson("보조", "보조여자3", "여자"), new DutyPerson("보조", "보조여자4", "여자"),
            new DutyPerson("보조", "보조여자5", "여자")
    ));

    Queue<DutyPerson> candidates3Man = new LinkedList<>(Arrays.asList(
            new DutyPerson("보조", "보조남자6", "남자"),
            new DutyPerson("보조", "보조남자7", "남자"), new DutyPerson("보조", "보조남자8", "남자")
    ));

    List<DutyAssignment> dutyAssignments = generateFinalDutyData(
            calendarDays, candidatesWoman, candidatesMan,
            candidates2Woman, candidates2Man,
            candidates3Woman, candidates3Man
    );

    dutyAssignments.forEach(System.out::println);
  }

  public static List<DutyAssignment> generateFinalDutyData(
          List<CalendarDay> calendarDays,
          Queue<DutyPerson> candidatesWoman, Queue<DutyPerson> candidatesMan,
          Queue<DutyPerson> candidates2Woman, Queue<DutyPerson> candidates2Man,
          Queue<DutyPerson> candidates3Woman, Queue<DutyPerson> candidates3Man) {

    List<DutyAssignment> assignments = new ArrayList<>();

    for (CalendarDay day : calendarDays) {
      boolean isHoliday = day.dayType.equals("휴일");

      List<String> shiftTypes = new ArrayList<>();
      if (isHoliday) {
        shiftTypes.add("일직");
        shiftTypes.add("숙직");
      } else {
        shiftTypes.add("숙직");
      }

      for (String shift : shiftTypes) {
        assignments.add(assignPerson(day.date, shift, "총사령", day.dayType, candidatesWoman, candidatesMan));
        assignments.add(assignPerson(day.date, shift, "부사령", day.dayType, candidates2Woman, candidates2Man));
        assignments.add(assignPerson(day.date, shift, "보조", day.dayType, candidates3Woman, candidates3Man));
        assignments.add(assignPerson(day.date, shift, "보조", day.dayType, candidates3Woman, candidates3Man));
      }
    }

    return assignments;
  }

  private static DutyAssignment assignPerson(String date, String shift, String role, String dayType,
                                             Queue<DutyPerson> womenQueue, Queue<DutyPerson> menQueue) {
    String name = "";

    if (shift.equals("일직")) {
      DutyPerson assignedPerson = womenQueue.isEmpty() ? menQueue.poll() : womenQueue.poll();
      name = (assignedPerson != null) ? assignedPerson.name : "미배정";
      System.out.println( womenQueue );
    } else if (shift.equals("숙직")) {
      DutyPerson assignedPerson = menQueue.poll();
      name = (assignedPerson != null) ? assignedPerson.name : "미배정";
    }

    return new DutyAssignment(date, shift, role, name, dayType);
  }
}
