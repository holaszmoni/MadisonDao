package com.models;

import java.util.Objects;

public class ProductReview {
    private String summary;
    private String comment;
    private String nickname;
    private int nrStars;
    private String criteria;


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getNrStars() {
        return nrStars;
    }

    public void setNrStars(int nrStars) {
        this.nrStars = nrStars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "summary='" + summary + '\'' +
                ", comment='" + comment + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nrStars=" + nrStars +
                ", criteria='" + criteria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReview review = (ProductReview) o;
        return nrStars == review.nrStars && Objects.equals(summary, review.summary) && Objects.equals(comment, review.comment) && Objects.equals(nickname, review.nickname) && Objects.equals(criteria, review.criteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, comment, nickname, nrStars, criteria);
    }

    //TODO define the rest of the fields

}
