import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] temp;
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(answer);
    }

    static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
                answer += (mid - l + 1);
            }
        }

        while (l <= mid) {
            temp[idx++] = arr[l++];
        }

        while (r <= right) {
            temp[idx++] = arr[r++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}