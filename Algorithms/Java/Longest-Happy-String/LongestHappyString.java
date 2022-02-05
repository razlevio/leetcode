import java.util.PriorityQueue;
class LongestHappyString {
    public String longestDiverseString(int A, int B, int C) {
        boolean cons = false;
        StringBuilder str = new StringBuilder();
        PriorityQueue<Node> queue = new PriorityQueue<>((x,y) -> y.cnt - x.cnt);
        queue.offer(new Node('a', A));
        queue.offer(new Node('b', B));
        queue.offer(new Node('c', C));
        
        int i = 0;
        Node nd = null;
        
        while(!queue.isEmpty()){
            Node k = queue.poll();
            if(k.cnt > 0){
                str.append(k.ch);
                if(i > 0 && str.charAt(i-1) == k.ch){
                    cons = true;
                    nd = k;
                }
                else{
                    queue.offer(new Node(k.ch, k.cnt-1));

                    if(nd != null){
                        queue.offer(new Node(nd.ch, nd.cnt-1));
                        cons = false;
                        nd = null;
                    }
                }
                i++;
            }
            else
                return str.toString();
        }
        return str.toString();
    }
    
    class Node {
    char ch;
    int cnt;
    
    public Node(char ch, int cnt){
        this.ch = ch;
        this.cnt = cnt;
        }
    }
}
