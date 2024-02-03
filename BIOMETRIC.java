package VAULTPackage;

import java.io.Serializable;

public class BIOMETRIC extends Vault implements Serializable {
    private VAULTTYPE VaultType;

    private static int lockercounter = 0 ;
    public BIOMETRIC(int totalRooms, int lockersPerRoom) {
        super(totalRooms , lockersPerRoom);
        VaultType = VAULTTYPE.BIOMETRIC;
    }
        public int getTotalLockers() {
            return (super.getTotalLockers());
        }
}
