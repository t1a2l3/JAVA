package VAULTPackage;

import java.io.Serializable;

public class SINGLEKEY extends Vault implements Serializable{
    private VAULTTYPE VaultType;

    private static int lockercounter = 0 ;
    public SINGLEKEY(int totalRooms, int lockersPerRoom) {
        super(totalRooms , lockersPerRoom);
        VaultType = VAULTTYPE.SINGLEKEY;
    }
    public int getTotalLockers() {
        return (super.getTotalLockers());
    }
}
