package go.there.soon.educative.string;

public class ReverseWords {
    public static void main(String [] args) {
        String sentence = "The quick brown fox jumped over the lazy dog.";
        char [] arr = sentence.toCharArray();
        reverseWords(arr);
        System.out.println(sentence);
        System.out.println(String.valueOf(arr));
    }

    public static void reverseWords(char [] arr) {

        reverse(0, arr.length-1, arr);

        int p1 = 0;
        int p2 = 0;

        while(p1 < arr.length) {
            p2 = lastIndexOfWord(p1, arr);
            reverse(p1, p2, arr);
            p1 = p2 + 2;
        }
    }

    public static void reverse(int p1, int p2, char [] arr) {
        while(p1 < p2) {
            char ch = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = ch;
            p1++;
            p2--;
        }
    }

    public static int lastIndexOfWord(int index, char [] arr) {
        int p1 = index;
        int p2 = p1 + 1;

        while(p2 < arr.length && arr[p2] != ' ') {
            p1++;
            p2++;
        }

        return p1;
    }
}
