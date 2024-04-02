# [Silver V] 수들의 합 5 - 2018 

[문제 링크](https://www.acmicpc.net/problem/2018) 

### 성능 요약

메모리: 14180 KB, 시간: 164 ms

### 분류

수학, 두 포인터

### 제출 일자

2024년 3월 21일 23:09:20

### 문제 설명

<p>어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.</p>

<p>예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.</p>

<p>N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 줄에 정수 N이 주어진다.</p>

### 출력 

 <p>입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오</p>

## 문제 풀이

### 1. 문제 분석 단계 
   
먼저 시간 복잡도를 확인 해보면 주어진 시간은 2초이고 N의 최대값은 10,000,000입니다 <br>
그러므로 O(nlogn)의 시간 복잡도를 사용하게 되면 시간을 초과하기 때문에 O(n)의 시간복잡도를 사용하여 문제를 해결해야 합니다

해당 문제는 투포인터를사용해서 풀어보겠습니다<br>
시작 인덱스와 종료 인덱스를 지정하여 투포인터로 지정후 연속된 수로 표현

### 2. 풀어 보기 
1. 입력받은 값을 N에 저장후 사용할 변수 초기화  
- sum = 1 <br>
- count = 1 (count는 마지막 수를 뽑는 경우의 수를 미리넣어 초기화) <br>
- start_index = 1 <br>
- end_index = 1 

2. 투포인터 이동 원칙에 따라 배열 끝까지 탐색 

`투포인터 이동 원칙` 
> - sum > N: sum = sum - start_index; start_index++; <br>
> - sum < N: end_index++; sum = sum + end_index; <br>
> - sum == N: end_index++; sum = sum + end_index; count++; <br>

`s = start_index e = end_index` <br>

s가 오른쪽으로 한 칸 이동하는 것은 연속된 자연수에서 왼쪽 값을 삭제 <br>
e가 오른쪽으로 한 칸 이동하는 것은 연석된 자연수의 범위를 한 칸 확장  <br> 

같은 경우 경우의 수를 1증가 시키고 e를 오른쪽으로 이동 

- 해당 방법을 end_index가 N이 될 때까지 반복

``` 
while(end_index != N){}

N = 5;
start_index,end_index,sum,count = 1;
``` 
1. sum 값이 N의 값보다 작으니 end_index 1 증가 시키고 sum 값에 end_index 값을 더함 (sum 값이 N값 보다 크거나 같을때까지 반복)
```
else {
    end_index++;
    sum += end_index;
}

end_index++; 
sum += end_index;
```
반복 하여 더한 값이 찾아야 하는 값보다 작다면 다음에 위치한 수를 더했을때 찾아야 하는 값이 나오는지 확인하는 과정입니다 

1 + 2 = 3 <br>
1 + 2 + 3 = 6

2. 1 + 2 + 3 = (sum) 6 sum이 N 보다 크니 start_index 값을 감소  
``` 
else if(sum>N){
    sum-=start_index;
    start_index++;
}

sum-=start_index;   // 왼쪽값 감소 
start_index++;      // 왼쪽값 삭제
```
반복 하여 더한 값이 찾아야 하는 값보다 크다면 이전에 더했던 값을 빼면서 찾아야 할 값을 찾는 과정입니다 

2 + 3 = 5

3. 2 + 3 = (sum) 5 sum이 N과 같으니 count,end_index를 1증가 sum값에 end_index를 더하기 
```
if(sum==N){
    count++;
    end_index++;
    sum+=end_index;
}

count++;            // 경우의 수 증가  
end_index++;        // 마지막 값 증가 
sum += end_index;   // 2 + 3 + 4 = ?
```
하나의 경우의 수를 찾아기 때문에 다른 경우의 수를 찾기 위해서 <br>
위 방법을 순서대로 end_index값이 N이 될때까지 반복 

1 + 2 = 3 `false`<br> 
1 + 2 + 3 = 6 `false`<br>
2 + 3 = 5 `true count++`<br>
2 + 3 + 4 = 8 `false`<br>
3 + 4 = 7 `false`<br>
3 + 4 + 5 = 12 `false`<br>
4 + 5 = 9 `false`<br>
5 = 5 `true coutn++`<br>

count = 2
 
