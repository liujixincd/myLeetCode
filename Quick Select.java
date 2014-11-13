public class QuickSelect {
    public int QuickSelect(int[] A, int left, int right, int k) {
        int pivot = partition(A, left, right);
        int leftLen = pivot - start + 1;
        if (leftLen == k) {
            return A[pivot];
        } else if (leftLen > k) {
            return QuickSelect(A, left, pivot - 1, k);
        } else {
            return QuickSelect(A, pivot + 1, k - leftLen);
        }
    }
    public int partition(int[] A, int left, int right) {
        int pivot = A[right];
        int pos = left;// very important
        for (int i = left; i < right; i++) {
            if (A[i] <= pivot) {
                swap(A, i, pos);
                pos++;
            }
        }
        swap(A, pos, right);
        return pos;
    }
    public void swap(int[]A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

