package services;

import dataBase.ItemsDAO;
import dataBase.ItemsDAOImp;
import pojo.Items;
import java.util.List;

public class ItemsServiceImp implements ItemsService {
    ItemsDAO gdao = new ItemsDAOImp();

    @Override
    public List<Items> findAll() {
        return gdao.findAll();
    }
}