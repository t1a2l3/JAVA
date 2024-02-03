package VAULTPackage;

import java.io.Serializable;

public class Locker implements Serializable {
    private int LockerNumber;

    public enum ISOCCUPY {OCCUPIED , EMPTY};
    private ISOCCUPY IsOccupy;
    public Locker(int lockerNumber) {
        LockerNumber = lockerNumber;
        this.IsOccupy = ISOCCUPY.EMPTY;
    }

    public int getLockerNumber() {
        return LockerNumber;
    }

    public void setLockerNumber(int lockerNumber) {
        LockerNumber = lockerNumber;
    }

    public ISOCCUPY getIsOccupy() {
        return IsOccupy;
    }

    public void setIsOccupy(ISOCCUPY isOccupy) {
        IsOccupy = isOccupy;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "LockerNumber=" + LockerNumber +
                ", IsOccupy=" + IsOccupy +
                '}';
    }
}

