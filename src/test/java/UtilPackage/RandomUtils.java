package UtilPackage;

public class RandomUtils {

    public String randGeneratedStr(int l) {
        String lettersAndNumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        StringBuilder s = new StringBuilder(l);
        for (int i = 0; i < l; i++) {
            int a = (int) (lettersAndNumbers.length() * Math.random());
            s.append(lettersAndNumbers.charAt(a));
        }
        return s.toString();
    }
}