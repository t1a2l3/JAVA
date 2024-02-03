package VAULTPackage;

import java.io.Serializable;

public class SAFEDDEPOSIT extends Vault implements Serializable {
    private VAULTTYPE VaultType;

    private static int lockercounter = 0 ;
    public SAFEDDEPOSIT(int totalRooms, int lockersPerRoom) {
        super(totalRooms , lockersPerRoom);
        VaultType = VAULTTYPE.SAFEDEPOSIT;
    }
    public int getTotalLockers() {
        return (super.getTotalLockers());
    }
}
