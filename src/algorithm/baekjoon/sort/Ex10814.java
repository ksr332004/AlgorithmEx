package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * Created by Seran on 2018-06-10.
 * 10814. 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 */
public class Ex10814 {
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        List<Member> members = new ArrayList<Member>();
        for (int i = 0; i < N ; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int age = Integer.parseInt(tokenizer.nextToken());
            String name = tokenizer.nextToken();
            members.add(new Member(age, name));
        }

        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age >= o2.age) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < N ; i++) {
            writer.write(members.get(i).age + " " + members.get(i).name + "\n");
        }

        reader.close();
        writer.close();
    }
}
