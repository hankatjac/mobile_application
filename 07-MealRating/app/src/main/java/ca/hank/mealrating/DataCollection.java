package ca.hank.mealrating;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataCollection implements Serializable {

    protected List<MealRating> mealArray = new ArrayList<>();

    public List<MealRating> getMealArray() {
        return mealArray;
    }
}