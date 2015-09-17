package EsSeparable;
import java.util.Random;

public class PruebaEsSeparable {

	    public static double timeTrial(int N) {
	        int MAX = 1000000;
	        int[] a = new int[N];
	        Random randomGenerator = new Random();

	        for (int i = 0; i < N; i++) {
	            a[i] =  randomGenerator.nextInt(MAX);
	        }
	        Stopwatch timer = new Stopwatch();
	        Separable sepa = new Separable();
	        sepa.esSeparable1(a);
//	        sepa.esSeparable2(a);
	        return timer.elapsedTime();
	    }

	    public static void main(String[] args) { 
	        for (int N = 250; true; N += N) {
	            double time = timeTrial(N);
	            System.out.printf("%7d %5.1f\n", N, time);
	        } 
	    } 
	}
