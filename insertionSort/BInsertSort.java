package test.sort.insertionSort;

import test.sort.RedType;
import test.sort.SqList;

//�۰���Ҳ�������
public class BInsertSort {

	public static void bInsertSort(SqList sqList) {
		for (int i = 2; i <= sqList.getLength(); i++) {
			// �ݴ���ż�¼
			sqList.redType[0] = sqList.redType[i];
			
			int low = 1, high = i - 1;
			//��low-high�����۰������������λ��
			while(low <= high){
				int m = (low + high)/2;//�۰�
				if(sqList.redType[0].compareTo(sqList.redType[m])<0){//������ż�¼���۰��¼С,�����Ͱ���
					high = m - 1;
				}else{
					low = m + 1;
				}
			}
			
			for(int j= i - 1;j >= high + 1;j--){
				sqList.redType[j + 1] = sqList.redType[j];
			}
			sqList.redType[high + 1] = sqList.redType[0];
		}
	}
	
	public static void main(String[] args) {
		SqList sqList = new SqList();
		RedType[] redType = new RedType[930];
		for (int i = 0; i < redType.length; i++) {
			if (i == 0) {
				redType[i] = new RedType(0, "");
			} else {
				redType[i] = new RedType((int) (Math.random() * 900), "��¼��" + i);
			}
		}
		System.out.println("\n------------------");
		sqList.setRedType(redType);
		sqList.setLength(redType.length - 1);

		bInsertSort(sqList);

		for (int j = 1; j <= sqList.getLength(); j++) {
			System.out.print(sqList.getRedType()[j].key + " ");
		}
	}
}
