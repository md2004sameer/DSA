import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, Integer> nameToId = new HashMap<>();
    private static int nextId = 0;
    private static final Map<Integer, List<List<Integer>>> recipes = new HashMap<>();
    private static int[] memo;
    private static final int INFINITY = 1_000_000;

    private static int getId(String name) {
        return nameToId.computeIfAbsent(name, k -> nextId++);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            String[] parts = line.split("=");
            int potionId = getId(parts[0].trim());

            String[] ingredientsStr = parts[1].split("\\+");
            List<Integer> ingredientIds = new ArrayList<>();
            for (String ingredient : ingredientsStr) {
                ingredientIds.add(getId(ingredient.trim()));
            }

            recipes.putIfAbsent(potionId, new ArrayList<>());
            recipes.get(potionId).add(ingredientIds);
        }

        String targetPotion = br.readLine().trim();

        if (!nameToId.containsKey(targetPotion)) {
            System.out.print(0);
            return;
        }

        int targetId = nameToId.get(targetPotion);
        
        memo = new int[nextId];
        Arrays.fill(memo, -2);

        int result = getMinOrbs(targetId);

        if (result >= INFINITY) {
            System.out.print("-1");
        } else {
            System.out.print(result);
        }
    }

    private static int getMinOrbs(int id) {
        if (memo[id] != -2) {
            if (memo[id] == -1) {
                return INFINITY;
            }
            return memo[id];
        }

        if (!recipes.containsKey(id)) {
            memo[id] = 0;
            return 0;
        }

        memo[id] = -1;

        int minTotalOrbs = INFINITY;

        for (List<Integer> recipe : recipes.get(id)) {
            int currentRecipeOrbs = recipe.size() - 1;
            
            long ingredientsOrbs = 0;
            for (int ingredientId : recipe) {
                ingredientsOrbs += getMinOrbs(ingredientId);
            }

            if (ingredientsOrbs < INFINITY) {
                 long totalCostForThisRecipe = currentRecipeOrbs + ingredientsOrbs;
                 minTotalOrbs = (int) Math.min(minTotalOrbs, totalCostForThisRecipe);
            }
        }

        memo[id] = minTotalOrbs;
        return minTotalOrbs;
    }
}

