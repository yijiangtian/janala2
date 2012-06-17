/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package janala.analysis.inst;

public class IF_ICMPGT extends Instruction {
    int label;

    public IF_ICMPGT(int iid, int mid, int label) {
        super(iid, mid);
        this.label = label;
    }

    @Override
    public String toString() {
        return "IF_ICMPGT iid="+iid+" mid="+mid+" label="+label;
    }
}
