package VAULTPackage;

import java.io.Serializable;

public class Vault implements Serializable {
    protected int TotalRooms;
    protected int LockersPerRoom;
    protected Locker[][] LOCKERS;
    protected int TotalLockers;
    enum VAULTTYPE {SINGLEKEY,DUALKEY,BIOMETRIC,SAFEDEPOSIT,CUSTOMIZED};

    public Vault(int totalRooms, int lockersPerRoom ) {
        TotalRooms = totalRooms;
        LockersPerRoom = lockersPerRoom;
        LOCKERS = new Locker[TotalRooms][LockersPerRoom];
        int counter = 0;
        for(int i = 0 ; i < totalRooms ; i++){
            for(int j = 0 ; j < lockersPerRoom ; j++){
                LOCKERS[i][j] = new Locker(counter++);
            }
        }
        TotalLockers = counter;
    }

    public int getTotalRooms() {
        return TotalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        TotalRooms = totalRooms;
    }

    public int getLockersPerRoom() {
        return LockersPerRoom;
    }

    public void setLockersPerRoom(int lockersPerRoom) {
        LockersPerRoom = lockersPerRoom;
    }
    public Locker[][] getLocker(){
        return LOCKERS;
    }
    public int getTotalLockers() {
        return TotalLockers;
    }
}

