package test.sort.insertionSort;

import test.sort.RedType;
import test.sort.SqList;

//直接插入排序
public class InsertionSort {

	public static void insertSort(SqList sqList) {
		// 对SqList作直接插入排序
		for (int i = 2; i <= sqList.getLength(); i++) {
			// 1.判断右边无序序列第一个是否小于左边最后一个
			if (sqList.redType[i].compareTo(sqList.redType[i - 1]) < 0) {// 小于说明要插入排序到有序序列
				// 2.监视哨
				sqList.redType[0] = sqList.redType[i];
				// 3.左边最后一个后移
				sqList.redType[i] = sqList.redType[i - 1];
				// 4.一趟插入排序
				int k = i - 2;
				for (int j = i - 2; sqList.redType[0]
						.compareTo(sqList.redType[j]) < 0; --j) {
					// 后移
					sqList.redType[j + 1] = sqList.redType[j];
					k--;
				}
				sqList.redType[k + 1] = sqList.redType[0];
			}
		}
	}

	public static void insertSort2(int[] array) {
		// 从第二个开始比较
		for (int i = 1; i < array.length; i++) {
			int x = array[i];// 待排记录项
			for (int j = 0; j < i; j++) {
				if (array[j] > x) {
					// move
					for (int end = i - 1; end >= j; end--) {
						array[end + 1] = array[end];
					}
					// insert
					array[j] = x;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * SqList sqList = new SqList(); RedType[] redType = new RedType[900];
		 * for (int i = 0; i < redType.length; i++) { if (i == 0) { redType[i] =
		 * new RedType(0, ""); } else { redType[i] = new RedType((int)
		 * (Math.random() * 900), "记录项" + i); } }
		 * System.out.println("\n------------------");
		 * sqList.setRedType(redType); sqList.setLength(redType.length - 1);
		 * 
		 * insertSort(sqList);
		 * 
		 * for (int j = 1; j <= sqList.getLength(); j++) {
		 * System.out.print(sqList.getRedType()[j].key + " "); }
		 */
		int[] array = new int[10];
		for(int i =0;i<array.length;i++){
			array[i] = (int)(Math.random()*10);
		}
		for(int i =0;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		insertSort2(array);
		System.out.println("\n-------------------");
		for(int i =0;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
	}
}
