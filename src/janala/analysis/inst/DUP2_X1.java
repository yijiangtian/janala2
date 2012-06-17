/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package janala.analysis.inst;

public class DUP2_X1 extends Instruction {
    public DUP2_X1(int iid, int mid) {
        super(iid, mid);
    }

    @Override
    public String toString() {
        return "DUP2_X1 iid="+iid+" mid="+mid;
    }
}
