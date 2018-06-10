package algorithm.baekjoon.sort;

import java.util.*;

/**
 * Created by Seran on 2018-06-10.
 * 11652. 카드
 * https://www.acmicpc.net/problem/11652
 */
public class Ex11652 {
    static class Card {
        String number;
        int count;

        public Card(String number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<String, Integer> cards = new HashMap<String, Integer>();
        for (int i = 0; i < N ; i++) {
            String number = sc.next();
            if (cards.containsKey(number)) {
                cards.put(number, cards.get(number) + 1);
            } else {
                cards.put(number, 1);
            }
        }

        Iterator<String> iterator = cards.keySet().iterator();

        List<Card> countedCards = new ArrayList<Card>();
        while (iterator.hasNext()) {
            String number = iterator.next();
            int count = cards.get(number);
            countedCards.add(new Card(number, count));
        }

        Collections.sort(countedCards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (o1.count < o2.count) {
                    return 1;
                } else if (o1.count == o2.count) {
                    if (o1.number.compareTo(o2.number) >= 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        System.out.println(countedCards.get(0).number);

    }
}
