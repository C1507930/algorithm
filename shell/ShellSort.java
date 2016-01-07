package test.sort.shell;

import java.util.Arrays;

//希尔排序,分组进行插入排序,缩小增量算法
public class ShellSort {

	public void shellSort(int[] array) {
		// 初始步长，实质为每轮的分组数
		int step = initStep(array.length);

		//第一层循环是对排序轮次进行循环。(step + 1) / 2 - 1 为下一轮步长值
		for (; step >= 1; step = (step + 1) / 2 - 1) {
			//对每轮里的每个分组进行循环   
            for (int groupIndex = 0; groupIndex < step; groupIndex++) {   
  
                //对每组进行直接插入排序   
                insertSort(array, groupIndex, step);   
            }
		}
	}

	/**
	 * 直接插入排序算法
	 */
	public void insertSort(int[] array, int groupIndex, int step) {
		int startIndex = groupIndex;//从哪里开始排序   
        int endIndex = startIndex;//排到哪里   
        /*  
         * 排到哪里需要计算得到，从开始排序元素开始，以step步长，可求得下元素是否在数组范围内，  
         * 如果在数组范围内，则继续循环，直到索引超现数组范围  
         */  
       while ((endIndex + step) <= array.length-1) {   
            endIndex += step;   
        }   
  
        // i为每小组里的第二个元素开始   
        for (int i = groupIndex + step; i <= endIndex; i += step) {   
        	int insertedElem = array[i];   
            for (int j = groupIndex; j < i; j += step) {   
                //从有序数组中最一个元素开始查找第一个大于待插入的元素   
                if (array[j]>insertedElem) {   
                    //找到插入点后，从插入点开始向后所有元素后移step位   
                    move(array, j, i - step, step);   
                    array[j] = insertedElem;  //插入 
                    break;   
                }   
            }   
        } 
	}

	/**
	 * 从最小步长1推导出最长初始步长值的方法
	 * 
	 * @return
	 */
	public static int initStep(int len) {

		int step = 1;
		// 小于4不分组
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
	        System.out.println("源 : " + Arrays.toString(intArr));
	        ShellSort shell = new ShellSort();
	        shell.shellSort(intArr);
	        System.out.println("升 : " + Arrays.toString(intArr));
	}
}


