/*
  *  Protection of the Indian border and safe transport of items from one point to another along
  *  the border are the paramount jobs for the Indian army. However they need some information 
  *  about the protection status along the length of the border. The border can be viewed as 
  *  the real x-axis. Along the axis, Indian army has N checkpoints for lookout. 

  *	We know that each checkpoint is located at an integer location xi. Each checkpoint must
  *	have a fleet of armed men which are responsible for guarding the neighboring areas of the 
  *	checkpoint and provide military assistance of all kinds. The size of the fleet is based 
  *	on the location of the checkpoint and how active the region is for terrorist activities. 

  *	Given the number of armed men assigned at the ith checkpoint, as pi, this information is
  *	available for all checkpoints. 
  *	With the skills of the armed men, it is known that if for the ith checkpoint, the length 
  *	on the x axis that they can defend is a closed interval [xi-pi, xi+pi].

  *	Now, your task is to transport some military items from position S to the end position E 
  *	on the x-axis. 

  *	Input:
  *	First line of the input contains 3 integers N, S and E. N is the number of checkpoints 
  *	that the Indian Army has on the border.
  *	Then N lines follow. ith line contains 2 integers, xi and pi.

  *	Output:
  *	Print the total distance of the x-axisfrom S to E, that is not protected by the armed 
		forces.
 */
import java.util.*;
public class HelpOutTheIndianArmy {
    public static void main(String args[] ) throws Exception {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        long min[]=new long[n+2];
        long max[]=new long[n+2];
        min[0]=scan.nextLong();
        min[1]=scan.nextLong();
        max[0]=min[0];
        max[1]=min[1];
        for(int i=2;i<n+2;i++)
        {
            long position=scan.nextLong();
            long distance=scan.nextLong();
            if((min[0]<=position+distance)&&(max[1]>=position-distance)){
                min[i]=position-distance;
                max[i]=position+distance;
            }
            else if(min[0]<position+distance){
                min[i]=min[1];
                max[i]=min[1];
            }
            else
            {
                min[i]=min[0];
                max[i]=min[0];
            }
        }
        Arrays.sort(min);
        Arrays.sort(max);
        long sum=0;
        for(int j=1;j<min.length;j++)
        {
            if(min[j]-max[j-1]>0)
                sum+=min[j]-max[j-1];
            
        }
          System.out.print(sum);
          scan.close();
    }
}