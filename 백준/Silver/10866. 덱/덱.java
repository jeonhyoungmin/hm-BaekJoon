import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int N = Integer.parseInt(br.readLine());

      Deque<Integer> deq = new LinkedList<Integer>();

      while (N-- > 0) {

         String[] cmd = br.readLine().split(" ");

         if (cmd[0].equals("push_front")) {
            deq.offerFirst(Integer.parseInt(cmd[1]));
         } else if (cmd[0].equals("push_back")) {
            deq.offerLast(Integer.parseInt(cmd[1]));
         } else if (cmd[0].equals("pop_front")) {
            bw.append(deq.isEmpty() ? "-1\n" : deq.pollFirst() + "\n");
         } else if (cmd[0].equals("pop_back")) {
            bw.append(deq.isEmpty() ? "-1\n" : deq.pollLast() + "\n");
         } else if (cmd[0].equals("size")) {
            bw.append(deq.size() + "\n");
         } else if (cmd[0].equals("empty")) {
            bw.append(deq.isEmpty() ? "1\n" : "0\n");
         } else if (cmd[0].equals("front")) {
            bw.append(deq.isEmpty() ? "-1\n" : deq.peekFirst() + "\n");
         } else if (cmd[0].equals("back")) {
            bw.append(deq.isEmpty() ? "-1\n" : deq.peekLast() + "\n");
         }

      }
      
      bw.flush();

   }

}