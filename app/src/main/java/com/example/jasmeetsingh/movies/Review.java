package com.example.jasmeetsingh.movies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jasmeetsingh on 21/04/17.
 */

public class Review {
    @SerializedName("id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("content")
    private String content;
    @SerializedName("url")
    private String url;

    public Review(String id, String author, String content, String url) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //"id": "58bbf107c3a368666b032be5",
//        "author": "anythingbutfifi",
//        "content": "**LOGAN REVIEW: THE WOLVERINE GETS A SUPER SEND-OFF**\r\n\r\n\"Owing to its agitated hero’s misfortunes through the ages, this is a film that’s acutely aware of the dangers of emotional exploitation, and it spares its audience a similar fate. With Logan, Mangold and co-writer Scott Frank tell the definitive story of the Wolverine, in an involving and deeply satisfying series finale. It shows the fate of mutants when age starts to weary them, with stakes that feel real, and empathy that’s earned.\"\r\n\r\nREAD THE FULL REVIEW AT SBS MOVIES: http://www.sbs.com.au/movies/review/logan-review-wolverine-gets-super-send",
//        "url": "https://www.themoviedb.org/review/58bbf107c3a368666b032be5"


}
