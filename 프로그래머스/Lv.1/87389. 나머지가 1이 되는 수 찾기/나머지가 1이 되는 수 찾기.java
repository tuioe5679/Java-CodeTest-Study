class Solution {
    public int solution(int n) {
        int answer = 0;
        int min_nu = n;
        for(int i=2;i<n;i++){
            if(n%i==1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}