import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RecipeJava {


        public static void main(String[] args) {
            ArrayList<Recipe> craftingList = new ArrayList<>();
            List<CraftCost> testList = new ArrayList();
            testList.add(new CraftCost(103, 5));
            testList.add(new CraftCost(100, 4));
            craftingList.add(new Recipe("Tent", testList, 301));

            Gson gson = new Gson();
            System.out.println(gson.toJson(craftingList));


        }

}
