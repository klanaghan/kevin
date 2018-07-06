package com.kevin.generics.spike;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevinlanaghan on 1/24/17.
 */public class DatabaseRow {

    private Map<Column<?>, Object> mRowMap = new HashMap<>();

    //<T> void putColumn(Column<T> type, T instance)


    public <T> void putColumn(Column<T> type, T instance) {
        mRowMap.put(type, instance);
    }

    public <T> T getColumn(Column<T> type) {
        return type.cast(mRowMap.get(type));
    }

    public static void main(String[] args) {
        DatabaseRow db = new DatabaseRow();

        Column<Integer> colInt = new Column<>(Integer.class);
        Column<Double> colDouble = new Column<>(Double.class);

        db.putColumn(colInt, 1);
        db.putColumn(colDouble, 10.0);

        System.out.println(colInt.getClass().getName() + " " + colDouble.getClass());
        System.out.println(db.getColumn(colInt) + " " + db.getColumn(colDouble));
    }

}
