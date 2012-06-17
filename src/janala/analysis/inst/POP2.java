/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package janala.analysis.inst;

public class POP2 extends Instruction {
    public POP2(int iid, int mid) {
        super(iid, mid);
    }

    @Override
    public String toString() {
        return "POP2 iid="+iid+" mid="+mid;
    }
}
