package test.sort.shell;

import java.util.Arrays;

//ϣ������,������в�������,��С�����㷨
public class ShellSort {

	public void shellSort(int[] array) {
		// ��ʼ������ʵ��Ϊÿ�ֵķ�����
		int step = initStep(array.length);

		//��һ��ѭ���Ƕ������ִν���ѭ����(step + 1) / 2 - 1 Ϊ��һ�ֲ���ֵ
		for (; step >= 1; step = (step + 1) / 2 - 1) {
			//��ÿ�����ÿ���������ѭ��   
            for (int groupIndex = 0; groupIndex < step; groupIndex++) {   
  
                //��ÿ�����ֱ�Ӳ�������   
                insertSort(array, groupIndex, step);   
            }
		}
	}

	/**
	 * ֱ�Ӳ��������㷨
	 */
	public void insertSort(int[] array, int groupIndex, int step) {
		int startIndex = groupIndex;//�����￪ʼ����   
        int endIndex = startIndex;//�ŵ�����   
        /*  
         * �ŵ�������Ҫ����õ����ӿ�ʼ����Ԫ�ؿ�ʼ����step�������������Ԫ���Ƿ������鷶Χ�ڣ�  
         * ��������鷶Χ�ڣ������ѭ����ֱ�������������鷶Χ  
         */  
       while ((endIndex + step) <= array.length-1) {   
            endIndex += step;   
        }   
  
        // iΪÿС����ĵڶ���Ԫ�ؿ�ʼ   
        for (int i = groupIndex + step; i <= endIndex; i += step) {   
        	int insertedElem = array[i];   
            for (int j = groupIndex; j < i; j += step) {   
                //��������������һ��Ԫ�ؿ�ʼ���ҵ�һ�����ڴ������Ԫ��   
                if (array[j]>insertedElem) {   
                    //�ҵ������󣬴Ӳ���㿪ʼ�������Ԫ�غ���stepλ   
                    move(array, j, i - step, step);   
                    array[j] = insertedElem;  //���� 
                    break;   
                }   
            }   
        } 
	}

	/**
	 * ����С����1�Ƶ������ʼ����ֵ�ķ���
	 * 
	 * @return
	 */
	public static int initStep(int len) {

		int step = 1;
		// С��4������
		while ((step + 1) * 2 - 1 < len - 1) {
			step = (step + 1) * 2 - 1;
		}
		return step;
	}
	
	public void move(int[] array, int startIndex, int endIndex, int step) {   
        for (int i = endIndex; i >= startIndex; i -= step) {   
            array[i + step] = array[i];   
        }   
    }  

	public static void main(String[] args) {
		 //int[] intArr = { 5, 9, 1, 4, 1, 2, 6, 3, 8, 0, 7 };  
			int[] intArr = new int[10];
			for(int i=0;i<intArr.length;i++){
				intArr[i] = (int)(Math.random()*50000);
			}
	        System.out.println("Դ : " + Arrays.toString(intArr));
	        ShellSort shell = new ShellSort();
	        shell.shellSort(intArr);
	        System.out.println("�� : " + Arrays.toString(intArr));
	}
}


