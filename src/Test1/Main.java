package Test1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String d = "let start coding";
        String collect = Arrays.stream(d.split("\\s+"))
                        .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                                .collect(Collectors.joining(" "));
        long total = Arrays.stream(d.split("\\s+")).count();
        System.out.println("Total strings "+ total);


        System.out.println(collect);

        int[] arr = { 5, 13, 20, 23, 30 };

        int square = Arrays.stream(arr).filter(num -> num % 5 == 0)
                .map(num -> num *num)
                .sum();
        System.out.println(square);
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> anagramGroups = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] charArray = str.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }));
        String a = "aabbbccc";

        System.out.println();
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        List<String> list =  Arrays.asList(wordsDict);

        OptionalInt diff = list.stream()
                .filter(word -> word.equals(word1) || word.equals(word2))
                .mapToInt(list::indexOf)
                .reduce((x1,y)-> Math.abs(x1-y));

        String[] strings = {"flower", "flour", "flight"};
        if (strings == null || strings.length == 0) {
        }

        String prefix = strings[0];

        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    prefix =  "";
                }
            }
        }

        int[] nonZero = {1,0,0,0,1,1,0,0,1};
        int size = nonZero.length;
        int temp = size-1;

        for(int i = size-1 ; i>=0 ; i--){
            if(nonZero[i] != 0){
                nonZero[temp--] = nonZero[i];
            }
        }
        while (temp>= 0)
            nonZero[temp--] = 0 ;
        int[] nonZero1 = {2,0,7,3,4,5,0,0,6,9,0};
        int start = 0;
        for(int i = 0 ;i<nonZero1.length;i++){
            if(nonZero1[i] !=0)
                nonZero1[start++] = nonZero1[i];
        }
        while(start< nonZero1.length){
            nonZero1[start++] = 0;
        }

        List<Integer> square1 = new ArrayList<>();
        square1.add(2);
        square1.add(3);
        square1.add(1);
        square1.add(4);
        square1.stream().filter(x -> x %2 ==0).map(num -> num * num).collect(Collectors.toList());

        Arrays.stream(nonZero).forEach(i -> System.out.print(i + " "));
        List<Integer> marks1 = new ArrayList<>();
        List<Integer> marks2 = new ArrayList<>();
        marks1.add(10);
        marks1.add(20);
        marks1.add(30);
        marks2.add(40);
        marks2.add(50);
        marks2.add(60);
        marks2.add(10);

        Student s1 = new Student("A", marks1,100,"M");
        Student s2 = new Student("B", marks2,300,"F");
        Student s3 = new Student("C" , marks2, 200,"M");




        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Map<Object, Long> genderMap =
        students.stream().collect(Collectors.groupingBy(student -> student.gender() ,Collectors.counting()));

        Optional<Student> student2 =
                students.stream().sorted(Comparator.comparingInt(Student::salary)).skip(1).findFirst();

        Optional<Integer> salary = students.stream().map(Student::salary).sorted().skip(1).findFirst();

        Set<Integer> a2 = students.stream()
                .flatMap(student -> student.marks().stream())
                .collect(Collectors.toSet());

        int a1 = students.stream().filter(s -> s.name().equals("A"))
                .flatMap(student -> student.marks().stream())
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum is " + a1);

        String removeChar = "abcdefxjghix";
        char remove = 'x';
        String afterRemoval = removeChar.chars().filter(chartoremove -> chartoremove != remove).
                collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println(afterRemoval);

       String countOccurences = "The String is the count the .";

      Long count =
              Arrays.stream(countOccurences.split("\\s+")).filter(word -> word.toLowerCase().equals("the")).count();

        System.out.println("Count of the" + count);

        String s = removeChar.chars().mapToObj(c-> (char)c)
                .filter(character -> removeChar.indexOf(character) == removeChar.lastIndexOf(character))
                .findFirst().toString();
        System.out.println("asas" + s);
}
}