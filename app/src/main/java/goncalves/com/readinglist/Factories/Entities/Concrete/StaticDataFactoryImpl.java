package goncalves.com.readinglist.Factories.Entities.Concrete;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import goncalves.com.readinglist.Entities.Concrete.CategoryImpl;
import goncalves.com.readinglist.Factories.Entities.Abstract.StaticDataFactory;

/**
 * Created by rafagonc on 1/9/16.
 */
public class StaticDataFactoryImpl implements StaticDataFactory {

    //region Create
    @Override
    public void createStaticData(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Boolean staticDataCreationAlreadyHappened = sharedPreferences.getBoolean(StaticDataFactory.STATIC_DATA_ALREADY_CREATED, false);
        if (!staticDataCreationAlreadyHappened) {
            for (String categoryName : categories()) {
                CategoryImpl newCategory = new CategoryImpl();
                newCategory.setName(categoryName);
                newCategory.save();
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(StaticDataFactory.STATIC_DATA_ALREADY_CREATED, true);
            editor.apply();
        }
    }
    //endregion

    //region Static Data
    private static List<String> categories() {
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Arts & Photohgraphy");
        categories.add("Biographies & Memories");
        categories.add("Business & Money");
        categories.add("Christian Books");
        categories.add("Comics");
        categories.add("Children's Book");
        categories.add("Computers & Technology");
        categories.add("Cookbooks, Food & Wine");
        categories.add("Crafts, Hobbies & Home");
        categories.add("Education & Teaching");
        categories.add("Engineering & Transportation");
        categories.add("Gay & Lesbian");
        categories.add("Health & Fitness");
        categories.add("History");
        categories.add("Humor & Entertainment");
        categories.add("Law");
        categories.add("Literatute & Fiction");
        categories.add("Medical Books");
        categories.add("Mystery, Thriller & Suspense");
        categories.add("Parenting & Relationships");
        categories.add("Politics & Social");
        categories.add("Reference");
        categories.add("Religion");
        categories.add("Science & Math");
        categories.add("Science Fiction");
        categories.add("Spots & Outdoors");
        categories.add("Teen & Young Adult");
        categories.add("Test Preparation");
        categories.add("Travel");
        return categories;
    }
    //endregion

}
