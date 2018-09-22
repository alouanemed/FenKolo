package com.malouane.data.local;

import android.arch.persistence.room.TypeConverter;
import com.malouane.data.local.model.venue.Category;
import com.malouane.data.local.model.venue.HereNowLocal;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CategoriesConverters {

    private static Moshi moshi = new Moshi.Builder().build();

    @TypeConverter public static List<Category> stringToCategories(String json) {
        Type type = Types.newParameterizedType(List.class, Category.class);
        JsonAdapter<List> adapter = moshi.adapter(type);
        try {
            return (List<Category>) adapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @TypeConverter public static String categoriesToString(List<Category> list) {
        Type type = Types.newParameterizedType(List.class, Category.class);
        JsonAdapter<List> adapter = moshi.adapter(type);
        return adapter.toJson(list);
    }

    @TypeConverter public static HereNowLocal stringToHereNow(String json) {
        Type type = Types.newParameterizedType(Category.class);
        JsonAdapter adapter = moshi.adapter(type);
        try {
            return (HereNowLocal) adapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @TypeConverter public static String hereNowToString(HereNowLocal hereNowLocal) {
        Type type = Types.newParameterizedType(HereNowLocal.class);
        JsonAdapter adapter = moshi.adapter(type);
        return adapter.toJson(hereNowLocal);
    }
}