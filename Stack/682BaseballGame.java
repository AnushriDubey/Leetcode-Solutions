682. Baseball Game


https://leetcode.com/problems/baseball-game/


class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        int val = 0;
        for(int i=0;i<ops.length;i++) {
            if(ops[i].equals("C")) {
                int a = stk.pop();
                val -= a;
            }
            else if(ops[i].equals("D")) {
                stk.push(stk.peek()*2);
                val += stk.peek();
            }
            else if(ops[i].equals("+")) {
                int b = stk.pop();
                int a = stk.peek();
                stk.push(b);
                stk.push(a+b);
                val += stk.peek();
            }
            else {
                stk.push(Integer.parseInt(ops[i]));
                val += stk.peek();
            }
        }
        // int res =0;
        // while(!stk.isEmpty()) {
        //     res += stk.pop();
        // }
        // return res;
        return val;
    }
}
