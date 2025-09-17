class Solution {
    public int findMinArrowShots(int[][] points) {
        quickSort(points, 0, points.length - 1);

        int arrowPos = points[0][1];
        int arrow = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrow++;
                arrowPos = points[i][1];
            }
        }
        return arrow;
    }

    public void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int partition(int[][] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        swap(arr, low, pivotIndex);

        int pivot = arr[low][1];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i][1] <= pivot)
                i++;
            while (j >= low && arr[j][1] > pivot)
                j--;
            if (i < j)
                swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    private int medianOfThree(int[][] arr, int a, int b, int c) {
        int valA = arr[a][1];
        int valB = arr[b][1];
        int valC = arr[c][1];

        if ((valA > valB) != (valA > valC))
            return a;
        else if ((valB > valA) != (valB > valC))
            return b;
        else
            return c;
    }

    public void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
