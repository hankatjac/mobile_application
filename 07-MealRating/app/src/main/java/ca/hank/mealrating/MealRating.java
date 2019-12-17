package ca.hank.mealrating;

import java.io.Serializable;

public class MealRating implements Comparable, Serializable {

    private String mealName;
    private int rating;

    public MealRating(String mealName, int rating) {
        this.mealName = mealName;
        this.rating = rating;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MealRating{" +
                "mealName='" + mealName + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        MealRating otherObject = (MealRating) o;
        return mealName.compareTo(otherObject.getMealName());
    }
}
