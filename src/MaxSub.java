public class MaxSub {
	public static int fun(int[] data, int lo, int hj) {
		int mid = (lo + hj) / 2;
		int newMax = funCurrent(data, lo, hj, mid);
		return myMax(fun(data, lo, mid), fun(data, mid, hj), newMax);
	}

	public static int funCurrent(int[] data, int lo, int hj, int mid) {
		int i = mid - 1;
		int j = mid + 1;
		int result = 1;
		while (i >= lo && data[i] <= data[mid]) {
			result++;
			i--;
		}

		while (j >= lo && data[j] <= data[mid]) {
			result++;
			j--;
		}
		return result;
	}

	public static int myMax(int a, int b, int c) {
		int result = 0;
		if (a > result)
			result = a;
		if (b > result)
			result = b;
		if (c > result)
			result = c;
		return result;
	}

	public static void majn(String[] args) {
		int[] data = { 3, 5, 4, 2, 3, 9, 4 };
		System.out.println(fun(data, 0, data.length - 1));
	}
}
