import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CaesarFrame caesarFrame = new CaesarFrame();
    }

    public static String caesarCode(String input, char offset) {
        char[] str = input.toUpperCase().toCharArray();
        String output = "";
        for (char c : str) {
            c = (char) ('A' + (((c - 'A') + (offset - 'A')) % 26));
            output += c;
        }
        return output;
    }

    public static String dEcaesarCode(String input, char offset) {
        char[] str = input.toUpperCase().toCharArray();
        String output = "";
        for (char c : str) {
            c = (char) ('A' + (((c - 'A') + (26 - (offset - 'A'))) % 26));
            output += c;
            System.out.print(c);
        }
        return output;
    }
}