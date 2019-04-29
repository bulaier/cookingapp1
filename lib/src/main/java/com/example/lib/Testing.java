package com.example.lib;

public final class Testing {
    private Exception e = new Exception();
    public static final Recipe[] store = new Recipe[1];
    public void main() {
        //Macaroni.
        store[0] = new Recipe("macaroni, tuna, chicken soup, cheddar cheese, onion", "Tuna Casserole");
        store[0].setIngredients("Ingredients:\n" +
                "3 cups macaroni\n" +
                "1 (5 ounce) can tuna, drained\n" +
                "1 (10.75 ounce) can condensed cream of chicken soup\n" +
                "1 cup shredded Cheddar cheese\n" +
                "1 1/2 cups French fried onions\n" +
                "           Recipe:\n" +
                "Preheat oven to 350 degrees F (175 degrees C).\n" +
                "In a 9x13-inch baking dish, combine the macaroni, tuna, and soup. Mix well, and then top with cheese.\n" +
                "Bake at 350 degrees F (175 degrees C) for about 25 minutes, or until bubbly. Sprinkle with fried onions, and bake for another 5 minutes. Serve hot.\n");
        try {
            store[0].setImage("https://www.spendwithpennies.com/wp-content/uploads/2018/10/SpendWithPennies-Tuna-Casserole-25.jpg");
        } catch (Exception e) {
        }
    }
}
