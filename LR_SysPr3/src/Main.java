import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int Votes = 1000;
        final int Pairs = 16;
        int n = 0;
        System.out.println("Введите кол-во сообщений(огр. 1000):");
        while (true){
            n = in.nextInt();
            if(n <= Votes) break;
            else System.out.println("Неправильно введённое количество сообщений");
        }
        // HashMap для хранения количества голосов за каждую пару
        HashMap<Integer, Integer> votes = new HashMap<>();
        // заполнение кол-ва голосов 0 для того чтобы выводились все пары
        for (int i = 1; i <= Pairs; i++) {
            votes.put(i,0);
        }
        System.out.println("Введите номера пары за которую хотите проголосовать:");
        for (int i = 0; i < n; i++) {
            int pairNumber = in.nextInt();
            if (pairNumber <= 16) votes.put(pairNumber, votes.get(pairNumber) + 1);
        }
        // создание списка пар и их голосов
        List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>(votes.entrySet());
        // сортировка пузырьком списка пар в порядке убывания
        for (int i = 0; i < pairs.size() - 1; i++) {
            for (int j = 0; j < pairs.size() - i - 1; j++) {
                if (pairs.get(j).getValue() < pairs.get(j + 1).getValue()) {
                    Collections.swap(pairs, j, j + 1);
                }
            }
        }
        System.out.println("Итоги:");
        for (Map.Entry<Integer, Integer> pair : pairs) {
            System.out.println("Пара " + pair.getKey() + ": " + pair.getValue() + " голосов");
        }
    }
}