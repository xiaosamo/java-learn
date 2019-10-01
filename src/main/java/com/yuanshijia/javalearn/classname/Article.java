package com.yuanshijia.javalearn.classname;

/**
 * @author yuan
 * @date 2019/10/1
 * @description
 */
public class Article {
    private String id;
    private String title;
    private String content;

    private Category category;


    public Article(){

    }

    public Article(String id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    static  class Category{
        private String categoryId;

        public Category(String id) {
            this.categoryId = id;
        }
    }
}
