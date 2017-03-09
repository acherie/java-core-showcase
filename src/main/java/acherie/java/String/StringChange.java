package acherie.java.String;

import java.util.Arrays;

/**
 * <p>User: wangjie
 * <p>Date: 2/24/2017
 */
public class StringChange {

    public static void change(String s, char[] chars) {
        s = "def";
        chars[0] = 'd';
    }

    public static void main(String[] args) {
        String s = "adb";
        char[] chars = {'a', 'b', 'c'};

        change(s, chars);

        System.out.println("s:" + s);
        System.out.println("char[]:" + Arrays.toString(chars));
    }
}
