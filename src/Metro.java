/*
 * A city subway line has become huge and it is hard to take the shortest path through them. 
 * You have to find the shortest path in subway lines. In the second 0 you are in the station
 *  start and you want to go to the station end.
 *  The city has n stations. The subway has m lines. Each subway line goes to some stations.
 *  The i-th subway goes to stations ui,1;ui,2;ui,3...ui,k(in order) and this train takes wi,j
 *  to travel from ui,j to ui,j+1
 *  Trains are ready for the passengers to get in, but the last train goes in the second ti
 *  (and you are allowed to board it in between the path).
 *	Input 
 *		The first line contains n,m (in order).
 *		Next 3*m lines describe subway lines.
 *		The first line contains ki,ti and next line contains ui,1;ui,2...ui,k and the next line 
 *		contains w1,w2,...
 *		The last line containts start end.
 *		It is guaranteed  start is not equal to end and no subway line intersects itself.
 *	Output 
 *		Print the shortest path in subway lines from the station  to .
 *		If there is no way from  to , print -1.
 * 
 */
import java.util.*;
public class Metro {
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args)  {
        Metros	 solver = new Metros();
        solver.solve();
    }
    static class Metros {
        public void solve() {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<pair> arrayList[] = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList();
            for (int i = 0; i < m; i++) {
                int s = in.nextInt();
                long t = in.nextLong();
                int arr[] = new int[s];
                for (int j = 0; j < s; j++) arr[j] = in.nextInt();
                for (int j = 0; j < s - 1; j++) {
                    int we = in.nextInt();
                    arrayList[arr[j]].add(new pair(arr[j + 1], we,t));
                    t += we;
                }
            }
            int st = in.nextInt();
            int end = in.nextInt();
            long dis[] = new long[n + 1];
            Arrays.fill(dis, Long.MAX_VALUE / 2);
            dis[st] = 0;
            PriorityQueue<pair2> pq = new PriorityQueue<>(12,new Comparator<pair2>() {
                public int compare(pair2 o1, pair2 o2) {
                    return Long.compare(o1.dis, o2.dis);
                }
            });
            pq.add(new pair2(st, dis[st]));
            boolean visited[] = new boolean[n + 1];
            visited[st] = true;
            while (!pq.isEmpty()) {
                pair2 p = pq.poll();
                if (p.node == end) {
                    System.out.println(dis[p.node]);
                    return;
                }
                for (pair pp : arrayList[p.node]) {
                    if (dis[p.node] <= pp.t && dis[pp.u] > dis[p.node] + pp.w) {
                        dis[pp.u] = dis[p.node] + pp.w;
                        pq.add(new pair2(pp.u, dis[pp.u]));
                    }
                }
            }
            System.out.println(-1);
        }
        class pair2 {
            int node;
            long dis;
 
            public pair2(int node, long dis) {
                this.node = node;
                this.dis = dis;
            }
        }
        class pair {
            int u;
            long w;
            long t;
 
            public pair(int u, long w, long t) {
                this.u = u;
                this.w = w;
                this.t = t;
            }
        }
    }
}
