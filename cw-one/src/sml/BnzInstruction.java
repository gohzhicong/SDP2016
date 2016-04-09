package sml;

/**
 * Created by zgoh on 08/04/2016.
 */
public class BnzInstruction extends Instruction {

        private int op1;
        private String dest;

        public BnzInstruction(String label, String op) {
            super(label, op);
        }

        public BnzInstruction(String label, int op1, String dest) {
            this(label, "bnz");
            this.op1 = op1;
            this.dest=dest;
        }

        @Override
        public void execute(Machine m) {
            int value1 = m.getRegisters().getRegister(op1);
            Labels labels = m.getLabels();
            int pcLocation = labels.indexOf(dest);
            if(value1!=0){
                Instruction ins = m.getProg().get(pcLocation);
                ins.execute(m);
            }
        }

        @Override
        public String toString() {
            return super.toString() + " if " + op1 + " ≠ 0 go to " + dest;
        }
    }


