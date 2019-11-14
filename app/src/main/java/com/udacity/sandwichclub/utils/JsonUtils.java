package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        Sandwich sandwich = new Sandwich();
        JSONObject jsonSandwich = new JSONObject(json);
        JSONObject name = jsonSandwich.getJSONObject("name");

        sandwich.setMainName(name.getString("mainName"));
        JSONArray jsonAlsoKnownAsArray = name.getJSONArray("alsoKnownAs");

        sandwich.setPlaceOfOrigin(jsonSandwich.getString("placeOfOrigin"));
        sandwich.setDescription(jsonSandwich.getString("description"));
        sandwich.setImage(jsonSandwich.getString("image"));
        JSONArray jsonIngredientsArray = jsonSandwich.getJSONArray("ingredients");

        List<String> alsoKnownAsList = new ArrayList<>();
        for (int i = 0; i < jsonAlsoKnownAsArray.length(); i++) {
            alsoKnownAsList.add(jsonAlsoKnownAsArray.getString(i));
        }
        sandwich.setAlsoKnownAs(alsoKnownAsList);

        List<String> ingredientsList = new ArrayList<>();
        for (int i = 0; i < jsonIngredientsArray.length(); i++) {
            ingredientsList.add(jsonIngredientsArray.getString(i));
        }
        sandwich.setIngredients(ingredientsList);

        return sandwich;
    }
}