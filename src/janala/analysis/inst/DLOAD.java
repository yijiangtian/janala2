/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package janala.analysis.inst;

public class DLOAD extends Instruction {
    int var;

    public DLOAD(int iid, int mid, int var) {
        super(iid, mid);
        this.var = var;
    }

    @Override
    public String toString() {
        return "DLOAD iid="+iid+" mid="+mid+" var="+var;
    }
}
