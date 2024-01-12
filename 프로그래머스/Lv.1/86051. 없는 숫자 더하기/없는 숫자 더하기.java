import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int element: numbers){
            set.add(element);
        }
        
        for(int i=0;i<=9;i++){
            if(set.contains(i)) continue;
            else{
                answer += i;
            }
        }
        return answer;
    }
}