package codingforjob;

import java.util.Arrays;

public class CommonSortAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 8, 7, 1, 6, 10, 4, 5, 2, 9};
//		bubble_sort(arr);
//		insert_sort(arr);
//		select_sort(arr);
//		quick_sort(arr);
//		shell_sort(arr);
//		heap_sort(arr);
		merge_sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	/***
	 * 冒泡排序
	 * @param arr
	 * @return
	 */
	public static int[] bubble_sort(int[] arr){
		
		for(int i=arr.length-1; i>=0; i--){
			for(int j=0; j<i; j++){
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}	
		return arr;
	}
	
	/***
	 *选择排序 
	 * @param arr
	 * @return
	 */
	public static int[] select_sort(int[] arr){
		int k;
		for(int i=0; i<arr.length; i++){
			k=i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[j]<arr[k])
					k=j;
			}
			int tmp = arr[k];
			arr[k] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}
	
	/***
	 * 插入排序
	 * @param arr
	 * @return int[]
	 */
	public static int[] insert_sort(int[] arr){
		
		for(int i=0; i<arr.length-1; i++){ //i的最大值要为倒数第二个数值
			for(int j=i+1; j>0; j--){
				if(arr[j]<arr[j-1]){
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;  //可以只记录要插入的位置，减少替换次数
				}
			}
		}
		return arr;
	}
	
	/***
	 * 获取中间点
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int _get_middle(int[] arr, int low, int high){
		
		int key = arr[low], tmp;
		while(low<high){
			while(low<high&&arr[high]>key)
				--high;
			tmp = arr[high]; arr[high] = key; key = tmp; //可以不替换，直接将arr[high] = key
			while(low<high&&arr[low]<key)
				++low;
			tmp = arr[low]; arr[low] = key; key = tmp;  //可以不替换，直接将arr[low] = key
		}
		return low;
	}
	
	/***
	 * 递归调用
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void _quick_sort(int[] arr, int low, int high){	
		if(low<high){
			int mid = _get_middle(arr, low, high);
			_quick_sort(arr, low, mid-1);
			_quick_sort(arr, mid+1, high);
		}
	}
	
	/***
	 * 快速排序
	 * @param arr
	 * @return
	 */
	public static int[] quick_sort(int[] arr){
		if(arr.length>0){
			_quick_sort(arr, 0, arr.length-1);
		}
		return arr;
	}
	
	/***
	 * 希尔排序
	 * @param arr
	 * @return
	 */
	public static int[] shell_sort(int[] arr){
		int i, j, tmp;
		for(int d=5; d>0; d-=2){
			for(i=0; i<arr.length-d; i+=d){
				for(j=i+d; j>0; j-=d){
					if(j<d)
						break;
					if(arr[j]<arr[j-d]){
						tmp = arr[j];
						arr[j] = arr[j-d];
						arr[j-d] = tmp;
					}
				}
			}
		}
		return arr;
	}
	
	/***
	 * 归并两个排好序的数组
	 * @param arr
	 * @param left
	 * @param center
	 * @param right
	 */
	public static void merge(int[] arr, int left, int center, int right){
		int[] tmp_arr = new int[arr.length];
		int i = left, j = center + 1, k = i;
		while(i<=center && j<=right){
			if(arr[i]<arr[j])
				tmp_arr[k++] = arr[i++];
			else
				tmp_arr[k++] = arr[j++];
		}		
		while(i<=center)
			tmp_arr[k++] = arr[i++];
		while(j<=right)
			tmp_arr[k++] = arr[j++];
		while(left<=right)
			arr[left] = tmp_arr[left++];
		
	}
	
	/***
	 * 递归调用归并
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void _merge_sort(int[] arr, int left, int right){
		if(left>=right)
			return;
		int center = (left+right)/2;
		_merge_sort(arr, left, center);
		_merge_sort(arr, center+1, right);
		merge(arr, left, center, right);
	}

	/***
	 * 归并排序
	 * @param arr
	 * @return
	 */
	public static int[] merge_sort(int[] arr){
		if(arr == null || arr.length == 0)
			return null;
		_merge_sort(arr, 0, arr.length-1);
		return arr;
	}
	
	/***
	 * 创建大顶堆
	 * @param arr
	 * @param heapsize
	 */
	public static void max_heap(int[] arr, int heapsize){
		
		for(int i=(heapsize-1)/2; i>=0; i--){
			int left = 2*i+1;
			int right = 2*i+2;
			int large = i;
			if(left<heapsize && arr[left]>arr[large])
				large = left;
			if(right<heapsize && arr[right]>arr[large])
				large = right;
			int tmp = arr[i];
			arr[i] = arr[large];
			arr[large] = tmp;
		} 
	}
	
	/***
	 * 堆排序
	 * @param arr
	 * @return
	 */
	public static int[] heap_sort(int[] arr){
		
		if(arr == null || arr.length == 0)
			return null;
		
		for(int i = arr.length; i>0; --i){
			max_heap(arr,i);
			int tmp = arr[0];
			arr[0] = arr[i-1];
			arr[i-1] = tmp;
		}
		return arr;
		
	}

}
