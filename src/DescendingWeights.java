/*
 * You have been given an array A of size N and an integer K. This array consists of N 
 * integers ranging from 1 to 10^7
 * Each element in this array is said to have a Special Weight. The special weight of an 
 * element a[i] is a[i]%k
 * You now need to sort this array in Non-Increasing order of the weight of each element,
 * i.e the element with the highest weight should appear first, then the element with the 
 * second highest weight and so on. In case two elements have the same weight, the one with
 * the lower value should appear in the output first.

 *  Input Format:
 *	The first line consists of two space separated integers N and K. The next line consists
 *	of N space separated integers denoting the elements of array A.

 * Output Format:
 *	Print N space separated integers denoting the elements of the array in the order in which
 *	 they are required.
 */
import java.util.*;
 
public class DescendingWeights {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int a;
        ArrayList<Integer> b[]=new ArrayList[k];
        for(int i=0;i<k;i++)
        {
            b[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n;i++)
        {
            a=sc.nextInt();
            b[a%k].add(a);
        }
        for(int i=0;i<k;i++)
        {
            Collections.sort(b[i]);
        }
        for(int i=k-1;i>=0;i--)
        {
            for(int j=0;j<b[i].size();j++)
            {
                System.out.print(b[i].get(j)+" ");
            }
        }
    }
}