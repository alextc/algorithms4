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

	public static double dot(double[] x, double[] y)
    {
        double result = 0;
        if (x.length != y.length)
            throw new RuntimeException("size of x must be equal size of y");

        for(int i = 0; i < x.length; i++)
        {
            result = result + (x[i] * y[i]);
        }

        return result;
    }

    public static double[] getColumn(double[][] m, int colIdx)
    {
        double[] result = new double[m.length];
        for(int i=0; i < m.length; i++)
        {
            result[i] = m[i][colIdx];
        }

        return result;
    }

    public static double[][] mult(double[][]a, double[][]b)
    {
        if(a[0].length != b.length)
            throw new RuntimeException("A's number of column must match B's number of rows");

        int n = a.length;
        int m = b[0].length;
        double[][] result = new double[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                double[] row = a[i];
                double[] col = getColumn(b, j);
                result[i][j] = dot(row, col);
            }
        }

        return result;
    }

    public static double[] mult(double[][]a, double[]b)
    {
        if(a[0].length != b.length)
            throw new RuntimeException("A's number of column must match B's number of rows");

        int n = a.length;
        double[] result = new double[n];

        for(int i = 0; i < n; i++)
        {
            double[] row = a[i];
            double[] col = b;
            result[i] = dot(row, col);
        }

        return result;
    }

    public static double[] mult(double[]a, double[][]b)
    {
        if(a.length != b.length)
            throw new RuntimeException("A's number of column must match B's number of rows");

        int n = a.length;
        double[] result = new double[n];

        for(int i = 0; i < n; i++)
        {
            double[] row = a;
            double[] col = getColumn(b, i);
            result[i] = dot(row, col);
        }

        return result;
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

    public static void drawRandomConn(int N, double p)
    {
        StdDraw.setCanvasSize(640, 640);
        StdDraw.setScale(-1.2, 1.2);
        StdDraw.setPenRadius(0.05);
        double[][] dotCoordinates = new double[N][2];
        for(int i = 0; i < N; i++)
        {
            dotCoordinates[i][0] = Math.cos(2 * Math.PI * i/N);
            dotCoordinates[i][1] = Math.sin(2 * Math.PI * i/N);
            StdDraw.point(dotCoordinates[i][0], dotCoordinates[i][1]);
        }

        StdDraw.setPenRadius(0.005);
        for(int i = 0; i < N - 1; i++)
        {
            for(int j = i + 1; j < N; j++)
            {
                if(StdRandom.bernoulli(p))
                {
                    StdDraw.line(
                            dotCoordinates[i][0], dotCoordinates[i][1],
                            dotCoordinates[j][0], dotCoordinates[j][1]);
                }
            }
        }
    }

    public static void Histogram(double[] s, int N, double l, double r)
    {
        int[] buckets = new int[N];

        for(int i = 0; i < s.length; i++)
        {
            int idx = GetInterval(s[i], N, l, r);
            buckets[idx]++;
        }

        int maxCount = StdStats.max(buckets);
        StdDraw.setCanvasSize(720, 512);
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, maxCount);

        double w = (r - l) / N;
        for(int i =0; i < buckets.length; i++)
        {
            double x = l + (i + 0.5) * w;
            double y = buckets[i] / 2.0;
            double rw = 0.5 * w;
            double rh = buckets[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static int GetInterval(double v, int N, double l, double r)
    {
        if(v >= r)
        {
            StdOut.printf("Right must be greater than v");
            return -1;
        }

        double step = (r - l) / N;
        return  (int)((v - l) / step);
    }

    public static void main(String[] args) {
        double[][] a = new double[][]{
                new double[] {1, 2, 3},
                new double[] {3, 2, 1},
                new double[] {2, 1, 3}
        };

        /*
        double[][] b = new double[][]{
                new double[] {4, 5, 6},
                new double[] {6, 5, 4},
                new double[] {4, 6, 5}
        };

        double[][] m = mult(a, b);
        */

        double[] b = new double[]{ 4, 6, 5};
        double[] m = mult(b, a);

        for(int i = 0; i < a.length; i++)
        {
            System.out.format("%f ", m[i]);
        }
    }
}
