/*
 * There is an infinite series of bulbs indexed from 1. And there are 40 switches indexed 
 *  from 1 to 40. Switch with index x is connected to the bulbs with indexes that are multiple 
 * of x. i.e switch 2 is connected to bulb 4, 6, 8 ....
 * You can easily observe that some bulbs are connected to multiple switches and some are not 
 * connected to any switch.

 * Chotu is playing with these switches, he wants to know the Kth glowing bulb from the start 
 * if certain switches are in ON state. If any of the switch is ON, connected to any bulb then
 * bulb starts glowing. But chotu has special fond of prime numbers so he only puts prime 
 * indexed switches ON.

 * INPUT-
 *	First line contains number of test cases (T). Each test case contains two lines- First 
 *	line contains a string S of length 40 containing 0s and 1s that represents the state of 
 *	bulbs. 1 is ON , 0 is OFF. Second line contains one integer k. Atleast One switch is in 
 *	ON condition.
 * OUTPUT-
 *	Output one integer per test case representing kth glowing bulb.
 */
import java.util.*;
public class GlowingBulbs {
    public static void main(String args[] ) throws Exception {
      
        Scanner sc = new Scanner(System.in);
        long TestCases = Long.parseLong(sc.nextLine());
 
        while(TestCases>0)
        {
            String switches = sc.nextLine();
            
            long k = Long.parseLong(sc.nextLine());
            long ans = solution(switches, k);
            System.out.println(ans);
            TestCases--;
        }
        sc.close();
    }
    
    public static long solution(String switches, long k){
        ArrayList<Integer> On = new ArrayList<>();
        long first = 0;
        for(int i=0;i<switches.length();i++){
            if(switches.charAt(i) == '1'){
                if(first == 0)
                    first = i+1;
                On.add(i+1);
            }
        }
        
        long sol = 0;
        long l = 1, r=first*k;
        
        while(l<=r)
        {
            long mid = (l+r)/2;
            long ans = Multiples(mid, On);
            if(ans < k)
                l = mid+1;
            else
            {
                r = mid-1;
                sol = mid;
            }
        }
        return sol;
    }
    
    public static long Multiples(long a, ArrayList<Integer> primes){
        long ans = 0;
        for(long i=1;i<(1<<primes.size());i++){
            long p=1;
            long sign = -1;
            for(int j=0;j<primes.size();j++){
                if(((i >> j) & 1) == 1){
                    p*=primes.get(j);
                    sign *= -1;
                }
            }
            
            ans =ans+ (a/p)*sign;
        }
        return ans;
    }
}