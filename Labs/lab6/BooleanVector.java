import java.util.Random;

class BooleanVector {
    private int dimension;
    private boolean vector[];
    Random rand;

    public BooleanVector(int dimension) {
        this.dimension = dimension;
        this.vector = new boolean[dimension];
        this.rand = new Random();
        for(int i = 0; i < dimension; i++) {
            vector[i] = rand.nextBoolean();
        }
    }

    public BooleanVector(boolean values[]) {
        this.dimension = values.length;
        vector = new boolean[dimension];
        for(int i = 0; i < dimension; i++) {
            vector[i] = values[i];
        }
    }

    public String toString() {
        String retValue = "";
        for(int i = 0; i < dimension; i++) {
            retValue += vector[i] + "|";
        }
        return retValue;
    }

    public boolean equals(BooleanVector other) {
        if(this.dimension != other.dimension) return false;
        for(int i = 0; i < dimension; i++) {
            if(this.vector[i] != other.vector[i]) return false;
        }
        return true;
    }

    public void and(BooleanVector other) {
        if(this.dimension != other.dimension) return;
        for(int i = 0; i < dimension; i++) {
            this.vector[i] = this.vector[i] && other.vector[i];
        }
    }

    public BooleanVector complement() {
        boolean v[] = new boolean[this.dimension];
        for(int i = 0; i < dimension; i++) {
            v[i] = !vector[i];
        }

        BooleanVector vec = new BooleanVector(v);
        return vec;
    }

    public static void main(String args[]) {
        BooleanVector rb1 = new BooleanVector(3);
        boolean v[] = {true, false, false};
        
        BooleanVector rb2 = new BooleanVector(v);
        System.out.println(rb1);
        System.out.println(rb2);

        if(rb1.equals(rb2)) {
            System.out.println("The two vectors are the same");
        }
        else {
            System.out.println("The two vectors are different");
        }

        rb1.and(rb2);
        System.out.println(rb1);
        System.out.println(rb2.complement());
    }
}
