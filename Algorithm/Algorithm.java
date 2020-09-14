package Algorithm;

public class Algorithm {
	
	
	public int Find_Maximum_SubArray(int arr[], int low,  int high) { 
		if (low == high) 
			return arr[low]; 
		int mid = (low + high)/2; 
		return Math.max(Math.max(Find_Maximum_SubArray(arr, low, mid), Find_Maximum_SubArray(arr, mid+1, high)), cross_value(arr, low, mid, high)); 
	} 
	

	int cross_value(int arr[], int low, int mid, int high) { 
		int sum = 0; 
		int left_sum = Integer.MIN_VALUE; 
		for (int i = mid; i >= low; i--) { 
			sum = sum + arr[i]; 
			if (sum > left_sum) 
				left_sum = sum; 
		} 
		sum = 0; 
		int right_sum = Integer.MIN_VALUE; 
		for (int i = mid + 1; i <= high; i++) { 
			sum = sum + arr[i]; 
			if (sum > right_sum) 
				right_sum = sum; 
		} 

		return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum)); 
	} 
	
	public int Devide_and_conquer(int arr[], int low, int high) {
		if(low == high) {
			return low;
		}
	
		else {
			int mid = (low + high)/2; 
			int left = Devide_and_conquer(arr, low, mid);
			int right = Devide_and_conquer(arr, mid + 1, high);
			
			if(arr[left] > arr[right]) {
				return right;
			}
			else if(arr[left] == arr[right]) {
				return left;
			}
			else {
				return left;
			}
		}
	}
	
	public int FindMaxIndex(int arr[], int low, int high) {
		int sum = arr[low];
		int index = low;
		for(int i = low + 1; i<high;i++) {
		
			if(sum < arr[i]) {
				sum = arr[i];
				index = i;
			}
		}
		
		return index;
		
	}
	
	
	
}
