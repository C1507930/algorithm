package test.quicksort;

//�ݹ��������ʵ��
public class QuickSortByRecurtion {

	public static void quick_sort(int[] s, int l, int r) {
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x)
					// ���������ҵ�һ��С��x����
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x)
					// ���������ҵ�һ�����ڵ���x����
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, l, i - 1); // �ݹ����
			quick_sort(s, i + 1, r);
		}
	}
	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 76, 13, 27 };
		QuickSortByRecurtion.quick_sort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
