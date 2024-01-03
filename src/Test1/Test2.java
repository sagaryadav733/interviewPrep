package Test1;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String args[]){
        String input = "let start coding";
        String output = Arrays.stream(input.split("\\s+")).
                map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));

        System.out.println(output);

        int[] arr =  { 5, 13, 20, 23, 30 };

        int sum = Arrays.stream(arr).filter(num -> num %5 ==0).
                map(num -> num * num)
                .sum();
        System.out.println(sum);

        HashMap<String , List<String>> stringList = new HashMap<>();

        String[] stringInput =  {"eat","tea","tan","ate","nat","bat"};
        for (String i:stringInput) {
            char[] temp = i.toCharArray();
            Arrays.sort(temp);
            if(stringList.containsKey(new String(temp))){
                List<String> values = stringList.get(new String(temp));
                values.add(i);
            }
            else {
                List<String> newValues = new ArrayList<>();
                newValues.add(i);
                stringList.put(new String(temp), newValues);
            }
        }
        Map<Object, List<String>> stringList1 = new HashMap<>();

        System.out.println(stringList.values());
        stringList1 = Arrays.stream(stringInput).
                collect(Collectors.groupingBy(str ->{
                    char[] temp = str.toCharArray();
                    Arrays.sort(temp);
                    return new String(temp);
                }));
        System.out.println(stringList1.values());

        String[] strs = {"flower","flow","flight"};
        String prefix = strs[0];

        for(int i=1 ; i< strs.length; i++){
            while(prefix.length() > 0){
                if(strs[i].contains(prefix)){
                    break;
                }
                else
                    prefix = prefix.substring(0 , prefix.length() -1);
            }
        }
        System.out.println(prefix);

    }


}
