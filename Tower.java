import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class Tower {
        private Stack<Integer> left = new Stack<>();
        private Stack<Integer> middle = new Stack<>();
        private Stack<Integer> right = new Stack<>();
        private final int n;

        public Tower(int n) {
            this.n = n;
            for (int i = n; i > 0; i--) {
                left.push(i);
            }
        }

        public void solve() {
            solve(n, left, middle, right);
        }

        private void solve(int n, Stack<Integer> l, Stack<Integer> m, Stack<Integer> r) {
            if (n == 1) {
                r.push(l.pop());
                print();
                return;
            }
            solve(n - 1, l, r, m);
            r.push(l.pop());
            print();
            solve(n - 1, m, l, r);
        }

        public void print() {
            String[] leftT = buildC(left);
            String[] middleT = buildC(middle);
            String[] rightT = buildC(right);

            for (int i = 0; i < n; i++) {
                System.out.printf("  %-4s    %-4s    %-4s%n", leftT[i], middleT[i], rightT[i]);
            }
            System.out.println("---------------------\n");
        }

        private String[] buildC(Stack<Integer> stack) {
            String[] col = new String[n];
            Arrays.fill(col, "|");
            ArrayList<Integer> list = new ArrayList<>(stack);
            for (int i = 0; i < list.size(); i++) {
                col[n - 1 - i] = list.get(i).toString();
            }
            return col;
        }
}