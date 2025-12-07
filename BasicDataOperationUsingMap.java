// BasicDataOperationUsingMap.java
// Generated GitHub‑ready version for Snail variant

import java.util.*;
import java.util.Map.Entry;

class Snail implements Comparable<Snail> {
    private String nickname;
    private Double speed;

    public Snail(String nickname, Double speed) {
        this.nickname = nickname;
        this.speed = speed;
    }

    public String getNickname() {
        return nickname;
    }

    public Double getSpeed() {
        return speed;
    }

    @Override
    public int compareTo(Snail other) {
        int res = other.nickname.compareTo(this.nickname);
        if (res != 0) return res;
        return Double.compare(this.speed, other.speed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Snail)) return false;
        Snail s = (Snail) obj;
        return nickname.equals(s.nickname) && speed.equals(s.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, speed);
    }

    @Override
    public String toString() {
        return "Snail{nickname='" + nickname + "', speed=" + speed +
                ", hashCode=" + this.hashCode() + "}";
    }
}

public class BasicDataOperationUsingMap {

    public static void printMap(Map<Snail, String> map) {
        for (Entry<Snail, String> e : map.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    public static void sortHashMap(Map<Snail, String> map) {
        List<Entry<Snail, String>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByKey());
        System.out.println("=== Пари ключ-значення після сортування (HashMap) ===");
        for (Entry<Snail, String> e : list) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    public static void main(String[] args) {

        Snail addKey = new Snail("Ковзак", 0.35);
        String addValue = "Захар";

        Snail searchKey = new Snail("Равлик", 0.5);
        String searchValue = "Пилип";

        Map<Snail, String> hashMap = new HashMap<>();
        Map<Snail, String> hashtable = new Hashtable<>();

        List<Snail> keys = List.of(
                new Snail("Черепашка", 0.3),
                new Snail("Равлик", 0.5),
                new Snail("Повзун", 0.2),
                new Snail("Мушля", 0.4),
                new Snail("Равлик", 0.6),
                new Snail("Гвинт", 0.7),
                new Snail("Вулик", 0.1),
                new Snail("Спіраль", 0.8),
                new Snail("Круч", 0.9),
                new Snail("Борозна", 0.25)
        );
        List<String> owners = List.of(
                "Остап", "Каріна", "Пилип", "Уляна",
                "Христина", "Пилип", "Юліан", "Тетяна",
                "Каріна", "Володимир"
        );

        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), owners.get(i));
            hashtable.put(keys.get(i), owners.get(i));
        }

        long start, end;

        System.out.println("\n========= Операції з HashMap =========");

        start = System.nanoTime();
        String owner = hashMap.get(searchKey);
        end = System.nanoTime();
        System.out.println("\nПошук за ключем: " + (end - start) + " нс");
        System.out.println("Власник: " + owner);

        start = System.nanoTime();
        List<Entry<Snail,String>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(Entry.comparingByValue());
        int pos = Collections.binarySearch(
                list,
                Map.entry(new Snail("",0.0), searchValue),
                Comparator.comparing(Entry::getValue)
        );
        end = System.nanoTime();
        System.out.println("\nПошук за значенням: " + (end - start) + " нс");

        if (pos >= 0)
            System.out.println("Знайдено: " + list.get(pos));

        System.out.println("\n=== Виведення HashMap ===");
        start = System.nanoTime();
        printMap(hashMap);
        end = System.nanoTime();
        System.out.println("Виведення: " + (end - start) + " нс");

        start = System.nanoTime();
        sortHashMap(hashMap);
        end = System.nanoTime();
        System.out.println("Сортування HashMap: " + (end - start) + " нс");

        start = System.nanoTime();
        hashMap.put(addKey, addValue);
        end = System.nanoTime();
        System.out.println("Додавання: " + (end - start) + " нс");

        start = System.nanoTime();
        hashMap.remove(searchKey);
        end = System.nanoTime();
        System.out.println("Видалення за ключем: " + (end - start) + " нс");

        start = System.nanoTime();
        hashMap.values().removeIf(v -> v.equals(searchValue));
        end = System.nanoTime();
        System.out.println("Видалення за значенням: " + (end - start) + " нс");

        System.out.println("\n========= Операції з Hashtable =========");

        start = System.nanoTime();
        owner = hashtable.get(searchKey);
        end = System.nanoTime();
        System.out.println("\nПошук за ключем: " + (end - start) + " нс");

        start = System.nanoTime();
        List<Entry<Snail,String>> list2 = new ArrayList<>(hashtable.entrySet());
        list2.sort(Entry.comparingByValue());
        pos = Collections.binarySearch(
                list2,
                Map.entry(new Snail("",0.0), searchValue),
                Comparator.comparing(Entry::getValue)
        );
        end = System.nanoTime();
        System.out.println("\nПошук за значенням: " + (end - start) + " нс");

        if (pos >= 0)
            System.out.println("Знайдено: " + list2.get(pos));

        System.out.println("\n=== Виведення Hashtable ===");
        start = System.nanoTime();
        printMap(hashtable);
        end = System.nanoTime();
        System.out.println("Виведення: " + (end - start) + " нс");

        start = System.nanoTime();
        hashtable.put(addKey, addValue);
        end = System.nanoTime();
        System.out.println("Додавання: " + (end - start) + " нс");

        start = System.nanoTime();
        hashtable.remove(searchKey);
        end = System.nanoTime();
        System.out.println("Видалення за ключем: " + (end - start) + " нс");

        start = System.nanoTime();
        hashtable.values().removeIf(v -> v.equals(searchValue));
        end = System.nanoTime();
        System.out.println("Видалення за значенням: " + (end - start) + " нс");
    }
}
