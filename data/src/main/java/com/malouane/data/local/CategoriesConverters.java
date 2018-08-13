package com.malouane.data.local;

import android.arch.persistence.room.TypeConverter;

import com.malouane.data.local.model.venue.Category;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CategoriesConverters {
    @TypeConverter
    public static List<Category> stringToMeasurements(String json) {
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Moshi.class); JsonAdapter<List> adapter = moshi.adapter(type);
        try {
            return (List<Category>) adapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @TypeConverter
    public static String measurementsToString(List<Category> list) {
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Moshi.class);
        JsonAdapter<List> adapter = moshi.adapter(type);
        return adapter.toJson(list);
    }
}