package programmers.level2;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DoingHomework {
    public String[] solution(String[][] plans) {
        List<Homework> homeworkList = new ArrayList<>();

        for (String[] plan : plans) {
            String[] stringTime = plan[1].split(":");
            LocalTime time = LocalTime.of(Integer.parseInt(stringTime[0]), Integer.parseInt(stringTime[1]));
            homeworkList.add(new Homework(time, plan[0], Integer.parseInt(plan[2])));
        }
        // 시간순으로 정렬
        homeworkList.sort(Comparator.comparing(Homework::getTime));

        // 비교 후 stack에 담기
        Stack<Homework> subject = new Stack<>();
        LocalTime now;
        for (int i = 0; i < homeworkList.size(); i++) {
            Homework homework = homeworkList.get(i);
            Homework nextHomework = homeworkList.get(i + 1);
            if (nextHomework == null) {
                break;
            }
            now = homework.time;

            if (nextHomework.time.isBefore(now.plusMinutes(homework.requiredTime))) {
                // 다음 숙제의 시간이 요청시간을 쓴 것보다 초과될 때

//                homework.setRequiredTime(now.plusMinutes(homework.requiredTime).minusMinutes();
                subject.push(homework);
            } else if (nextHomework.time.isAfter(now.plusMinutes(homework.requiredTime))) {

            } else {
                // 적을 때
            }
        }
        String[] answer = new String[plans.length];
        return answer;
    }


    public static class Homework {
        private LocalTime time;
        private String name;
        private int requiredTime;

        public Homework(LocalTime time, String name, int requiredTime) {
            this.time = time;
            this.name = name;
            this.requiredTime = requiredTime;
        }
        public LocalTime getTime() {
            return time;
        }

        public void setRequiredTime(int time) {
            this.requiredTime = time;
        }
    }
}
