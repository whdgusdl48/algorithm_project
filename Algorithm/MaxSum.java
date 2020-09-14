package Algorithm;


public class MaxSum{
	

	public static void main(String[] args)
	{
		int[] A = { 100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97 };
		int[] test_2 = {10,13,11,16,15};
		Algorithm a = new Algorithm();
		int small = a.Devide_and_conquer(A, 0, A.length - 1);
		System.out.println("가장 작은날 " + small);
		int big = a.FindMaxIndex(A, small, A.length);
		System.out.println("큰날짜 : " + big);
		System.out.println("이윤 : " + (A[big] - A[small]));
		
		small = a.Devide_and_conquer(test_2, 0, test_2.length - 1);
		System.out.println("가장 작은날 " + small);
		big = a.FindMaxIndex(test_2, small, test_2.length);
		System.out.println("큰날짜 : " + big);
		System.out.println("이윤 : " + (test_2[big] - test_2[small]));
	}
}

