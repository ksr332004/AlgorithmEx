package algorithm.baekjoon.sort;

import java.util.*;

/**
 * Created by Seran on 2018-06-10.
 * 10825. 국영수
 * https://www.acmicpc.net/problem/10825
 */
public class Ex10825 {
    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < N ; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math  = sc.nextInt();
            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.korean < o2.korean) {
                    return 1;
                } else if (o1.korean == o2.korean) {
                    if (o1.english > o2.english) {
                        return 1;
                    } else if (o1.english == o2.english) {
                        if (o1.math < o2.math) {
                            return 1;
                        } else if (o1.math == o2.math) {
                            if (o1.name.compareTo(o2.name) >= 0) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
