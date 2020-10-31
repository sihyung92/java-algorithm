package programmers.winterCoding2020;

public class Solution2 {
    public String solution(String encrypted_text, String key, int rotation) {
        char[] encryptedChars = encrypted_text.toCharArray();
        char[] keyChars = key.toCharArray();

        int sign = 1;
        if (rotation > 0) {
            sign = -1;
        }
        int rotateNumber = Math.abs(rotation) % encrypted_text.length();

        char[] temp = new char[encryptedChars.length];

        for (int i = 0; i < encryptedChars.length; i++) {
            int rotatedIndex = (i + sign * rotateNumber) % encryptedChars.length;
            if (rotatedIndex < 0) {
                rotatedIndex += encryptedChars.length;
            }
            temp[rotatedIndex] = encryptedChars[i];
        }

        encryptedChars = temp;

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < encryptedChars.length; i++) {
            int decryptedKey = keyChars[i] % 'a' + 1;

            if (encryptedChars[i] - 'a' <= decryptedKey - 1) {
                encryptedChars[i] += 26;
            }

            result.append((char) (encryptedChars[i] - decryptedKey));
        }

        return result.toString();
    }
}
