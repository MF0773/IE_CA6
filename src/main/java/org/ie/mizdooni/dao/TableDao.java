package org.ie.mizdooni.dao;

import org.ie.mizdooni.model.TableModel;

public class TableDao extends BaseDao<TableModel> {
    public TableDao() {
        super(TableModel.class);
    }

    // public static List<TableModel> findByRestaurantName(String restaurantName){
    // return allObjects.stream()
    // .filter(model -> model.getRestaurantName().compareTo(restaurantName) == 0)
    // .collect(Collectors.toList());
    // }

    // public static void addObject(TableModel table){
    // allObjects.add(table);
    // }

    // public static TableModel findByRestaurantNameAndNumber(String restaurantName,
    // int tableNumber){
    // var allResults = allObjects.stream()
    // .filter(
    // model -> model.getRestaurantName().compareTo(restaurantName) == 0 &&
    // model.getTableNumber() == tableNumber
    // ).collect(Collectors.toList());
    // if(allResults.isEmpty()){
    // return null;
    // }
    // assert allResults.size() == 1;
    // return allResults.get(0);
    // }
}
