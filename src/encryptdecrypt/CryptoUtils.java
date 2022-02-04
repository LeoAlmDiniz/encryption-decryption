package encryptdecrypt;

public class CryptoUtils {

    public static String encryptShift(String input, int key) {

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i < input.length(); i++) {
            char c = algoShift( input.charAt(i) , key, true);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String decryptShift(String input, int key) {

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i < input.length(); i++) {
            char c = algoShift( input.charAt(i) , key, false);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String encryptUnicode(String input, int key) {

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i < input.length(); i++) {
            char c = algoUnicode( input.charAt(i) , key, true);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String decryptUnicode(String input, int key) {

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i < input.length(); i++) {
            char c = algoUnicode( input.charAt(i) , key, false);
            sb.append(c);
        }
        return sb.toString();
    }

    private static char algoShift(char c, int key, boolean enc) {
        int dir = 1;
        if (!enc) {
            dir = -1;
        }
        int charValue = (int)c;
        if (Character.isLetter(c)) {
            if (charValue >= 97) { //minusculas
                int retCharValue = charValue + dir*key;
                while (!(retCharValue >= 97 && retCharValue <= 122)) {
                    if (retCharValue > 122) {
                        retCharValue = 96 + (retCharValue - 122);
                    } else {
                        retCharValue = 123 - (97 - retCharValue);
                    }
                }
                c = (char) retCharValue;
            } else { //maisculas
                int retCharValue = charValue + dir*key;
                while (!(retCharValue >= 65 && retCharValue <= 90)) {
                    if (retCharValue > 90) {
                        retCharValue = 64 + (retCharValue - 90);
                    } else {
                        retCharValue = 91 - (65 - retCharValue);
                    }
                }
                c = (char) retCharValue;
            }
        }
        return c;
    }

    private static char algoUnicode(char c, int key, boolean enc) {
        int dir = 1;
        if (!enc) {
            dir = -1;
        }
        //range now is from 32 to 126
        int charValue = (int)c;
        if (charValue >= 32 && charValue <= 126) {
            int retCharValue = charValue + dir*key;
            while (!(retCharValue >= 32 && retCharValue <= 126)) {
                retCharValue = 32 + dir*(retCharValue - 126);
            }
            c = (char) retCharValue;
        }
        return c;
    }

}
