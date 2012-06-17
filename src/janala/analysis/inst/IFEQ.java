/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package janala.analysis.inst;

public class IFEQ extends Instruction {
    int label;

    public IFEQ(int iid, int mid, int label) {
        super(iid, mid);
        this.label = label;
    }

    @Override
    public String toString() {
        return "IFEQ iid="+iid+" mid="+mid+" label="+label;
    }
}
