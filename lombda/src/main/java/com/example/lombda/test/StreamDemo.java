package com.example.lombda.test;

import com.example.lombda.entity.Author;
import com.example.lombda.entity.Book;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
//        test01(authors);
//        test02();
//        test03();
//        test04(authors);
//        test05(authors);
//        test06(authors);
//        test07(authors);
//        test08(authors);
//        test09(authors);
//        test10(authors);
//        test11(authors);
//        test11(authors);
//        test12(authors);
//        test13(authors);
//        test14(authors);
//        test15(authors);
//        test16(authors);
        test17(authors);
    }

    private static void test17(List<Author> authors) {
        Integer reduce = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, Integer::sum);
        Integer reduce1 = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(Integer.MIN_VALUE, (integer, integer2) -> integer < integer2 ? integer : integer2);
        Integer reduce2 = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(Integer.MAX_VALUE, (integer, integer2) -> integer > integer2 ? integer : integer2);
        Optional<Integer> reduce3 = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce((integer, integer2) -> integer < integer2 ? integer : integer2);
        System.out.println(reduce);
        System.out.println(reduce1);
        System.out.println(reduce2);
        System.out.println(reduce3);

    }

    private static void test16(List<Author> authors) {
        Optional<Author> first = authors.stream()
                .sorted()
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test15(List<Author> authors) {
        boolean flag01 = authors.stream()
                .anyMatch(author -> author.getAge() > 18);
        boolean flag02 = authors.stream()
                .allMatch(author -> author.getAge() > 18);
        boolean flag03 = authors.stream()
                .noneMatch(author -> author.getAge() > 18);
        System.out.println(flag01);
        System.out.println(flag02);
        System.out.println(flag03);
    }

    private static void test14(List<Author> authors) {
        Map<String, List<Book>> collect = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBookList));
        System.out.println(collect);
    }

    private static void test13(List<Author> authors) {
        List<String> collect = authors.stream()
                .map(Author::getName)
                .collect(Collectors.toList());
        Set<Book> books = authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .collect(Collectors.toSet());

        System.out.println(collect);
        System.out.println(books);
    }

    private static void test12(List<Author> authors) {
        long count = authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test11(List<Author> authors) {
        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);


    }

    private static void test10(List<Author> authors) {
        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test09(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test08(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test07(List<Author> authors) {
        authors.stream()
                .distinct()
                .sorted()
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test06(List<Author> authors) {
        authors.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void test05(List<Author> authors) {
        authors.stream()
                .map(Author::getAge)
                .forEach(System.out::println);
    }

    private static void test04(List<Author> authors) {
        authors.stream()
                .filter(author -> author.getName().length() > 2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test03() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("周星星", 1);
        map.put("张月月", 2);
        map.put("王阳阳", 3);
        map.put("李天天", 4);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        entrySet.stream()
                .distinct()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() > 3)
                .forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + ":" + stringIntegerEntry.getValue()));
    }

    private static void test02() {
        Integer[] arr = {1, 2, 3, 4, 5};
//        Stream<Integer> stream = Arrays.stream(arr);
        Stream<Integer> stream = Stream.of(arr);
        stream.filter(integer -> integer > 2)
                .forEach(System.out::println);

    }

    private static void test01(List<Author> authors) {
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "诺手", "臣服于我大诺克萨斯", 18, null);
        Author author2 = new Author(2L, "德玛", "德玛西亚", 19, null);
        Author author3 = new Author(3L, "盲仔", "我用双手成就你的梦想", 14, null);
        Author author4 = new Author(4L, "易大师", "我的剑就是你的剑", 15, null);
        Author author5 = new Author(4L, "易大师", "我的剑就是你的剑", 15, null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "诺克萨斯", "战争,侵略", 45D, "诺克萨斯是一个威名震天的强大帝国。"));
        books1.add(new Book(2L, "德玛西亚", "和平,光明", 84D, "德玛西亚是一个法理至上的强大王国，战功赫赫，久负盛名。"));

        books1.add(new Book(3L, "艾欧尼亚", "科技", 83D, "在凶险海域环绕中，诸多同盟省份在一片被称为“初生之土”的庞大群岛上组成了艾欧尼亚。"));
        books2.add(new Book(3L, "艾欧尼亚", "科技", 65D, "在凶险海域环绕中，诸多同盟省份在一片被称为“初生之土”的庞大群岛上组成了艾欧尼亚。"));
        books2.add(new Book(4L, "班德尔城", "幸福,发达", 89D, "班德尔城历史悠久，其主要居民都是身高1m左右的约德尔人，是个不折不扣的“小人国”。"));

        books3.add(new Book(5L, "弗雷尔卓德", "凛冬,残酷", 45D, "弗雷尔卓德是一片环境恶劣、残酷无情的土地。"));
        books3.add(new Book(6L, "恕瑞玛", "飞升", 44D, "恕瑞玛帝国曾经是一个繁荣昌盛的文明，统治着一整块大陆。"));
        books3.add(new Book(6L, "恕瑞玛", "飞升", 81D, "恕瑞玛帝国曾经是一个繁荣昌盛的文明，统治着一整块大陆。"));

        author1.setBookList(books1);
        author2.setBookList(books2);
        author3.setBookList(books2);
        author4.setBookList(books3);
        author5.setBookList(books3);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5));
    }
}
