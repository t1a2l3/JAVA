package CHECKBOOKPackage;

import java.io.Serializable;

public class Check implements Serializable {
    private int CheckNumber;

    public Check(int checkNumber) {
        CheckNumber = checkNumber;
    }

    public int getCheckNumber() {
        return CheckNumber;
    }

    public void setCheckNumber(int checkNumber) {
        CheckNumber = checkNumber;
    }
}

