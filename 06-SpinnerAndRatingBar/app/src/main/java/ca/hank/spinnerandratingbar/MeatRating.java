package ca.hank.spinnerandratingbar;

import androidx.annotation.NonNull;

public class MeatRating implements Comparable {

    private String mealName;
    private int rating;

    public MeatRating(String mealName, int rating) {
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
        return "MeatRating{" +
                "mealName='" + mealName + '\'' +
                ", rating=" + rating +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        MeatRating otherObject = (MeatRating) o;
        return mealName.compareTo(otherObject.getMealName());
    }
}
