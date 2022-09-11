public class Task3 {
    /**
     * Task3
     * Реализовать функцию нечеткого поиска
      */
    public static void fuzzySearch(String sub, String str){
        boolean answer = false;

        for (int i = 0, j = 0; i < sub.length(); i++){

            while (j < str.length() && sub.charAt(i) != str.charAt(j)) j++;

            if(j < str.length() && sub.charAt(i) == str.charAt(j)) j++;

            if(i == sub.length()-1) answer = true;

            if(j == str.length() || i == sub.length()-1) break;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        fuzzySearch("car", "ca6$$#_rtwheel"); // true
        fuzzySearch("cwhl", "cartwheel"); // true
        fuzzySearch("cwhee", "cartwheel"); // true
        fuzzySearch("cartwheel", "cartwheel"); // true
        fuzzySearch("cwheeel", "cartwheel"); // false
        fuzzySearch("lw", "cartwheel"); // false
    }
}
