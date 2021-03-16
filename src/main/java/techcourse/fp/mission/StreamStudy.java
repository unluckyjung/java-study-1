package techcourse.fp.mission;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StreamStudy {
    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
//        for (String w : words) {
//            if (w.length() > 12) count++;
//        }

        count = words.stream()
                .filter(s -> s.length() > 12)
                .count();

        return count;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
//        return numbers.stream()
//                .mapToInt(Integer -> Integer)
//                .sum();

        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
//        return numbers.stream()
//                .filter(number -> number > 3)
//                .mapToInt(number -> number * 2)
//                .sum();

        return numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

//        System.out.println(words);
//        System.out.println(words.size());
        // TODO 이 부분에 구현한다.

        words.stream()
                .filter(word -> word.length() > 5)
                .sorted((o1, o2) -> -Integer.compare(o1.length(), o2.length()))
                .distinct()
                .limit(100)
                .forEach(word -> System.out.println(word.toLowerCase(Locale.ROOT)));
    }
}
