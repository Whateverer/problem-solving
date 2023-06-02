package programmers.level1;

import java.util.*;

public class YearningScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        // Map에 key=name, value=yearning으로 저장해서 꺼내오기
        Map<String, Integer> nameScoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameScoreMap.put(name[i], yearning[i]);
        }

        for (int i=0; i<photo.length; i++) {
            int sum = 0;
            for (int j=0; j<photo[i].length; j++) {
               if(nameScoreMap.containsKey(photo[i][j])) {
                    sum +=nameScoreMap.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }

}
