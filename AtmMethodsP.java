package Presentation.CostumerAccessories;

import ATMPackage.AtmCard;

import java.io.File;
import java.util.Scanner;

public class AtmMethodsP {
    public static AtmCard.CARDTYPE generatingCardType() {
        Scanner sc = new Scanner(System.in);
        boolean cardcondition = false;
        AtmCard.CARDTYPE CARDType = AtmCard.CARDTYPE.CREDITCARD;
        while (!cardcondition) {
            System.out.println("Enter the Card Type You Want");
            String CardType = sc.next();
            if(CardType.equals("VISACARD") || CardType.equals("MASTERCARD") || CardType.equals("DEBITCARD") || CardType.equals("CREDITCARD") || CardType.equals("VIRTUALCARD") )
            {
                CARDType = AtmCard.CARDTYPE.valueOf(CardType);
                cardcondition = true;
            }else{
                System.out.println("Enter the Card Type You Want");
                CardType = sc.next();
            }
        }
        return CARDType;
    }
}
