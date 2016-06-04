import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Exercises_1_1 {
	
	public static String toBinary(int n)
	{
		String s = "";
		
		for (; n > 0; n /= 2)
			s = (n % 2) + s;
		
		return s;
	}
	
	/* Usage
	 * int[][] m = new int[][]{
			new int[] {1, 2}, 
			new int[] {3, 4},
			new int[] {5, 6}
		};	
					
		int[][] t = transpose(m);
	 */
	public static int[][] transpose(int[][] m)
	{
		int n = m.length;
		int c = m[1].length;
		int[][] r = new int[c][n];
				
		for (int i=0; i < n; i++)
		{
			for (int j = 0; j < c; j++)
			{
				r[j][i] = m[i][j];
			}
		}
		
		// Print 
		for(int i = 0; i < r.length; i++)
		{
			for(int j = 0; j < r[1].length; j++)
			{
				System.out.format("%d ", r[i][j]);
			}
			
			System.out.format("%n");
		}

		return r;
	}

	public static int pow2(int n)
	{
		int result = 1;
		for (int i = 0; i < n; i++)
		{
			result = result * 2;
		}
		
		// System.out.format("%d%n", result);
		return result;
	}
	
	public static int lg(int n)
	{
		for (int i = 0; i < n; i++)
		{
			if(pow2(i) > n)
			{
				return i - 1;
			}
		}
		
		return 0;
	}
	
	public static int lg2(int n)
	{
		int result = 0;
		do
		{
			n /= 2;
			result++;
		}while(n > 0);
		
		return --result;
	}
	
	public static double ln(int n)
	{
		if (n <= 0) return 0;
		return Math.log(n) + ln(n-1);
	}
	
	/* Usage
	 * int[] a = new int[] {7, 2, 2, 8, 3, 2, 1, 6, 6, 0 };
	   int[] h = histogram(a, 10);
	   for (int i = 0; i < h.length; i++)
			System.out.format("%d%n", h[i]);
	 */
	public static int[] histogram(int[] a, int m)
	{
		int[] result = new int[m];
		for (int i = 0; i < a.length; i++)
		{
			result[a[i]]++;
		}
		
		return result;
	}
	
	public static String exR1(int n) 
	{ 
		if (n <= 0) return ""; 
		return exR1(n-3) + n + exR1(n-2) + n; 
	}
	
	public static int mystery(int a, int b)
	{
		if (b==0) return 0; 
		if (b % 2 == 0) return mystery(a + a, b/2);
		return mystery(a + a, b/2) + a; 
	}
	
	public static long F( int N) 
	{ 
		if (N==0) return 0; 
		if (N==1) return 1; 
		return F(N-1) + F(N-2); 
	} 

	public static int rank(int key, int[] a) 
	{ 
		int lo = 0; 
		int hi = a.length - 1; 
		while (lo <= hi) 
		{ 
			int mid = lo + (hi - lo) / 2; 
			if (key < a[mid]) hi = mid - 1; 
			else if (key > a[mid]) lo = mid + 1; 
			else return mid;
		} 
		return -1;
	}
	
	public static int rankSmallerThan(int key, int[] a) 
	{ 
		int lo = 0; 
		int hi = a.length - 1; 
		int locatedAt = -1;
		while (lo <= hi) 
		{ 
			int mid = lo + (hi - lo) / 2; 
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else
			{
				locatedAt = mid;
				break;
			}
		} 

		if(locatedAt == -1)
		{
			return -1;
		}
		else
		{
			int result = locatedAt;
			// Go Left
			int t = locatedAt;
			while(a[locatedAt] == a[--t])
					result--;
				
			// Go Right
			t = locatedAt;
			while(a[locatedAt] == a[++t])
				result--;
			
			return result + 1; //compensate for zero idx
		}
	}
	
	public static int rankR(int key, int[] a, int lo, int hi) 
	{ 
		System.out.format("%d %d%n", a[lo], a[hi]);
		if (lo > hi) return -1;
		
		int mid = lo + (hi - lo) / 2; 
		if (key < a[mid]) return rankR(key, a, lo, mid-1); 
		else if (key > a[mid]) return rankR(key, a, mid+1, hi); 
		else return mid; 
	}
	
	public static int gcd(int p, int q)
	{
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

    /*
    Boolean[][] m = new Boolean[10][10];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[1].length; j++) {
                if (AreRelativelyPrime(i, j)) m[i][j] = true;
                else m[i][j] = false;
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[1].length; j++) {
                System.out.format("%-10b  ", m[i][j]);
            }
            System.out.format("%n");
        }
     */
    public static Boolean AreRelativelyPrime(int a, int b)
    {
        return gcd(a, b) == 1;
    }
	
	public static List<Integer> RemoveDuplicates(int[] a)
	{
		List<Integer> result = new ArrayList<>();
		result.add(a[0]);
		
		for(int i = 1; i < a.length; i++)
			if (a[i-1] != a[i])
				result.add(a[i]);
				
		return result;
	}
	
	public static void main(String[] args) {

    }
}
