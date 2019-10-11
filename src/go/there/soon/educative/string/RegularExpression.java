package go.there.soon.educative.string;

public class RegularExpression {

    public static void main(String [] args) {
        String text = "aabbbbbcddaxxx";
        System.out.println(text.indexOf("a"));
        System.out.println(text.indexOf("bb"));
        System.out.println(text.indexOf("cdda"));
        System.out.println(text.substring(text.indexOf("cdda")+4));
        String [] patterns = {
                "a*bb*cdda",
                "a*bb*.dda",
                "aab*e*cd*a",
                "a*b*c*d*a*",
                ".*b*c*d*a*",
                "aabbbbbcdda",
                "aabbbbbcdd",
                "a*b*c*da"
        };

        for(String pattern : patterns) {
            System.out.printf("%s, %s: %b\n", text, pattern, regx_match(text, pattern));
        }
    }

    public static boolean regx_match(String text, String pattern) {
        String [] pieces = pattern.split("\\*");
        int index = -1;

        for(int i = 0; i < pieces.length; i++) {
            String p = pieces[i];

            if(i == 0) {

            }

            if(p.equalsIgnoreCase(".")) {
                continue;
            } else if(p.isEmpty()) {
                continue;
            } else {
                int curr = text.substring(index+1).indexOf(p);
                boolean isNotFound = curr == -1;
                index = curr + p.length();

                if(isNotFound)
                    return false;
            }
        }

        return true;
    }
}
