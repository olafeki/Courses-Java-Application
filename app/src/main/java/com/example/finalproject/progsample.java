package com.example.finalproject;

public class progsample {
    //course_id,course_title,url,price,num_subscribers,num_reviews
    // ,num_lectures,level,Rating,content_duration,published_timestamp,subject
    private   int course_id;
    private String course_title;
    private String url ;
    private String price;
    private String num_subscribers;
    private String num_reviews;
    private String num_lectures;
    private String level;
    private String Rating;
    private String content_duration;
    private String published_timestamp;
    private String subject;
    public progsample()
    {
        //nothing specified!
    }
    public progsample(String id ,String courseName, String courseprice
                      ,String courselevl ,
                      String rate,String sub) {
        this.course_id= Integer.parseInt(id);
        this.course_title = courseName;
       // this.url = courseurl;
        this.price = courseprice;
       // this.num_subscribers = coursesub;
       // this.num_reviews=courserev;
        this.level=courselevl;
        this.Rating=rate;
       // this.content_duration=duration;
       // this.published_timestamp=time;
        this.subject=sub;

    }



    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = String.valueOf(price);
    }

    public String getNum_subscribers() {
        return num_subscribers;
    }

    public void setNum_subscribers(int num_subscribers) {
        this.num_subscribers = String.valueOf(num_subscribers);
    }

    public String getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = String.valueOf(num_reviews);
    }

    public String getNum_lectures() {
        return num_lectures;
    }

    public void setNum_lectures(int num_lectures) {
        this.num_lectures = String.valueOf(num_lectures);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = String.valueOf(rating);
    }

    public String getContent_duration() {
        return content_duration;
    }

    public void setContent_duration(Double content_duration) {
        this.content_duration = String.valueOf(content_duration);
    }

    public String getPublished_timestamp() {
        return published_timestamp;
    }

    public void setPublished_timestamp(String published_timestamp) {
        this.published_timestamp = published_timestamp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    @Override
    public String toString() {
        return "progsample{" +
                "course_id=" + course_id +
                ", course_title='" + course_title + '\'' +
                ", price=" + price +
                ", num_subscribers=" + num_subscribers +
                ", num_reviews=" + num_reviews +
                ", num_lectures=" + num_lectures +
                ", level='" + level + '\'' +
                ", Rating=" + Rating +
                ", content_duration=" + content_duration +
                ", published_timestamp='" + published_timestamp + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
