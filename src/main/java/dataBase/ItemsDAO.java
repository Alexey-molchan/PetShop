package dataBase;

import pojo.Items;

import java.util.List;

public interface ItemsDAO {
    List <Items> findAll();
}