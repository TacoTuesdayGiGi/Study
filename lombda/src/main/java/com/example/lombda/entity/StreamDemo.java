package com.example.lombda.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
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
