/**
 * Created by triest on 17.08.2017.
 */


public class Main {


    public static void main(String[] args) {
        String text = "deny1999@yandex.ru";
        text = text.replaceAll("[0-9]{4}", "5")
                .replaceAll("..$", "com")
                .replaceAll("[^a-z]y.*x", "@google");
        System.out.println(text);
    }
}
