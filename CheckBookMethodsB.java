package BusinessLogicLayer.CostumerAccessoriesB;

import java.util.Random;

public class CheckBookMethodsB {
    public static String generateRandomCheckbookID() {
        StringBuilder checkbookID = new StringBuilder();
        // Generate 8 random alphanumeric characters for the checkbook ID
        String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alphanumericCharacters.length());
            char randomChar = alphanumericCharacters.charAt(index);
            checkbookID.append(randomChar);
        }
        return checkbookID.toString();
    }
}
