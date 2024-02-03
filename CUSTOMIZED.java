package VAULTPackage;

import java.io.Serializable;

public class CUSTOMIZED  extends Vault implements Serializable {
    private VAULTTYPE VaultType;

    private static int lockercounter = 0 ;
    public CUSTOMIZED(int totalRooms, int lockersPerRoom) {
        super(totalRooms , lockersPerRoom);
        VaultType = VAULTTYPE.CUSTOMIZED;
    }
    public int getTotalLockers() {
        return (super.getTotalLockers());
    }
}