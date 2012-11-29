public class MaxSub {
	public static int fun(int[] data, int lo, int hi) {
		if (hi - lo < 2)
			return 1;
		int mid = (lo + hi) / 2;
		int newMax = funCurrent(data, lo, hi, mid);
		return myMax(fun(data, lo, mid), fun(data, mid, hi), newMax);
	}

	public static int linearFind(int[] data, int lo, int hi) {
		int maxSofar = 1;
		int result = 1;
		for (int i = lo; i < hi; i++) {
			if (data[i] <= data[i + 1])
				maxSofar++;
			else
				maxSofar = 1;
			result = Math.max(maxSofar, result);
		}
		return result;
	}

	public static int funCurrent(int[] data, int lo, int hi, int mid) {
		int i = mid;
		int j = mid;
		int result = 1;
		while (i > lo && data[i - 1] <= data[i]) {
			result++;
			i--;
		}

		while (j < hi && data[j + 1] >= data[j]) {
			result++;
			j++;
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

	public static void main(String[] args) {
		int[] data = { 3, 5, 6, 7 };// 4

		data = new int[] { 3, 5, 6, 7 };// 4
		System.out.println(fun(data, 0, data.length - 1));
		System.out.println(linearFind(data, 0, data.length - 1));

		data = new int[] { 3, 5, 4, 2, 3, 9, 4 };// 3
		System.out.println(fun(data, 0, data.length - 1));
		System.out.println(linearFind(data, 0, data.length - 1));

		data = new int[] { 3, 5, 6, 7, 4, 2, 3, 9, 4 };// 4
		System.out.println(fun(data, 0, data.length - 1));
		System.out.println(linearFind(data, 0, data.length - 1));
	}
}
