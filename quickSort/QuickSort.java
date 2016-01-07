package test.sort.quickSort;

import test.sort.RedType;
import test.sort.SqList;

//快速排序算法,使用递归算法
public class QuickSort {

	public static void quickSort(SqList sqList, int l, int r) {
		if(l < r){
			
		int i = l, j = r, k;
		RedType x = sqList.redType[l];// 基准数

		k = partition(sqList, x, i, j);// 切分

		quickSort(sqList, l, k - 1);// 递归
		quickSort(sqList, l + 1, r);
		}
	}

	public static int partition(SqList sqList, RedType x, int i, int j) {
		
		
		while (i < j) {
			while (i < j && sqList.redType[j].compareTo(x) > 0) {// 由j往i向前,找出比基准x小的记录项
				j--;
			}
			if (i < j) {
				sqList.redType[i++] = sqList.redType[j];//把挖出的记录项填到上一个坑,i++
			}
			while (i < j && sqList.redType[i].compareTo(x) < 0) {// 由i往j向后,找出比基准x大的记录项
				i++;
			}
			if (i < j) {
				sqList.redType[j--] = sqList.redType[i];//把挖出的记录项填到上一个坑,j--
			}
		}
		sqList.redType[i] = x;//i与j相等,把基准项填到切分的地方
		return i;//返回切分位置
	}

	public static void main(String[] args) {
		SqList sqList = new SqList();
		RedType[] redType = new RedType[900];
		sqList.setRedType(redType);
		for (int i = 0;i<redType.length;i++) {
			redType[i] = new RedType((int) (Math.random()*900), "记录项" + i);
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
