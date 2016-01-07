package test.sort.quickSort;

import test.sort.RedType;
import test.sort.SqList;

//���������㷨,ʹ�õݹ��㷨
public class QuickSort {

	public static void quickSort(SqList sqList, int l, int r) {
		if(l < r){
			
		int i = l, j = r, k;
		RedType x = sqList.redType[l];// ��׼��

		k = partition(sqList, x, i, j);// �з�

		quickSort(sqList, l, k - 1);// �ݹ�
		quickSort(sqList, l + 1, r);
		}
	}

	public static int partition(SqList sqList, RedType x, int i, int j) {
		
		
		while (i < j) {
			while (i < j && sqList.redType[j].compareTo(x) > 0) {// ��j��i��ǰ,�ҳ��Ȼ�׼xС�ļ�¼��
				j--;
			}
			if (i < j) {
				sqList.redType[i++] = sqList.redType[j];//���ڳ��ļ�¼�����һ����,i++
			}
			while (i < j && sqList.redType[i].compareTo(x) < 0) {// ��i��j���,�ҳ��Ȼ�׼x��ļ�¼��
				i++;
			}
			if (i < j) {
				sqList.redType[j--] = sqList.redType[i];//���ڳ��ļ�¼�����һ����,j--
			}
		}
		sqList.redType[i] = x;//i��j���,�ѻ�׼����зֵĵط�
		return i;//�����з�λ��
	}

	public static void main(String[] args) {
		SqList sqList = new SqList();
		RedType[] redType = new RedType[900];
		sqList.setRedType(redType);
		for (int i = 0;i<redType.length;i++) {
			redType[i] = new RedType((int) (Math.random()*900), "��¼��" + i);
		}
		for (int j = 0; j < redType.length; j++) {
			System.out.print(" " + redType[j].key);
		}
		System.out.println("\n-------------------------------");
		QuickSort.quickSort(sqList, 0, redType.length - 1);
		for (int j = 0; j < redType.length; j++) {
			System.out.print(" " + redType[j].key);
		}
	}
}
