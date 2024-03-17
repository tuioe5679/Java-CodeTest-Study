class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        
        int[] answer = new int[arr.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = arr[i] - '0';
        }
        return answer;
    }
}