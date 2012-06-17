/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package janala.analysis.inst;

public class LCONST_0 extends Instruction {
    public LCONST_0(int iid, int mid) {
        super(iid, mid);
    }

    @Override
    public String toString() {
        return "LCONST_0 iid="+iid+" mid="+mid;
    }
}
