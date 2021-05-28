import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Erudite {
    //эта программа выводит реально существующие слова из комбинаций букв(первая запись в консоль);
    //вторая запись в консоль - количество букв, которое необходимо получить.
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите комбинацию букв без разделяющих знаков (в том числе пробелы):");
        char[] s = scanner.nextLine().toCharArray();
        System.out.println("Введите длину слов которою хотите получить (число или цифра):");
        int count =Integer.parseInt(scanner.nextLine());
        BufferedReader reader = new BufferedReader(new FileReader("D:\\words.txt"));
        ArrayList<String> arrayList = new ArrayList<>();
        while (reader.ready()){
            String q = reader.readLine();
            if (q.length()==count){
                char[] qq = q.toCharArray();
                int z = 0;
                for (char w : qq){
                    for (char e : s){
                        if (w == e){
                            z++;
                            break;
                        }
                    }
                }
                if (z == count){
                    arrayList.add(q);
                }
            }
        }
        Map<Character,Integer> map = new TreeMap<>();
        for (char q : s) {
            if (map.containsKey(q)) {
                map.put(q,map.get(q)+1);
            } else {
                map.put(q,1);
            }
        }
        for (String d : arrayList) {
            int qqq = 0;
            char[] k = d.toCharArray();
            Map<Character, Integer> ttt = new TreeMap<>();
            for (char q : k) {
                if (ttt.containsKey(q)) {
                    ttt.put(q, ttt.get(q) + 1);
                } else {
                    ttt.put(q, 1);
                }
            }
            //System.out.println("ttt: " + ttt + "\n" + "слово: " + d);
            for (Map.Entry<Character, Integer> e : ttt.entrySet()) {
                char z = e.getKey();
                int x = e.getValue();
                for (Map.Entry<Character, Integer> g : map.entrySet()) {
                    char a = g.getKey();
                    int f = g.getValue();
                    if (z==a) {
                        //System.out.println("прошло z==a");
                        if (x == f) {
                            //System.out.println("прошло x == f");
                            qqq+=x;
                        }
                    }
                }
            }
            if (qqq == count) {
                System.out.println(d);
            }
        }
    }
}