package VAULTPackage;

import java.io.Serializable;

public class DUALKEY extends Vault implements Serializable{
    private VAULTTYPE VaultType;

    private static int lockercounter = 0 ;
    public DUALKEY(int totalRooms, int lockersPerRoom) {
        super(totalRooms , lockersPerRoom);
        VaultType = VAULTTYPE.DUALKEY;
    }
    public int getTotalLockers() {
        return (super.getTotalLockers());
    }
}

