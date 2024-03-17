# [level 1] 자연수 뒤집어 배열로 만들기 - 12932 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12932) 

### 성능 요약

메모리: 65.5 MB, 시간: 0.05 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 03월 17일 17:36:30

### 문제 설명

<p>자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.</p>

<h5>제한 조건</h5>

<ul>
<li>n은 10,000,000,000이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>12345</td>
<td>[5,4,3,2,1]</td>
</tr>
</tbody>
      </table>
      
1. 입력받은 숫자를 문자열로 변환하기 
> 입력받은 정수 long형의 static 메서드 toString()을 사용하여 변환

``` String str = Long.toString(n); ```

2. 문자열을 뒤집기 
> StringBuilder 클래스의  reverse() 메서드를 통해서 뒤집기 
3. 뒤집힌 문자열을 문자의 배열로 변환 
> String 클래스의 toCharArray() 메서드를 사용하여 문자 배열로 변환 
4. 배열의 각 문자를 정수로 변환 
> 문자를 아스키 코드를 활용하여 정수로 변환하는 작업을 통해서 int 배열에 할당 
```
int[] result = new int[arr.length];
for(int i = 0;i < result.length; i++) {
     result[i] = arr[i] - '0';
}
return result; 
```
출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
