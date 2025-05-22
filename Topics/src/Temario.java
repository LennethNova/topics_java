import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.ToIntFunction;

public class Temario {
    public static void main(String[]args) {
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();

        // Topics
        temas.add(new Tema("Lecture", 2));
        temas.add(new Tema("Basic Math", 1));
        temas.add(new Tema("Environmental care",3));

        // Resources
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();

        recursos.put("Lecture", "https://recursos.edu/lecture");
        recursos.put("Basic Math", "https://recursos.edu/math");
        recursos.put("Environmental Care", "https://recursos.edu/environment");

        // Per title
        Collections.sort(temas);
        System.out.println("\n Topics ordered alphabetically");
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        // Priority (ascending)
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\n Topics by priority (1 = URGENT)");
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        // Resources per topic
        System.out.println("\n Resources per topic");
        for (String clave : recursos.keySet()) {
            System.out.println(clave + " : " + recursos.get(clave));
        }

    }
}
