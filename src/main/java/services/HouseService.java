package services;
import dao.HouseDao;
import models.House;

public class HouseService {
    HouseDao houseDao;
    public void save(House house) {
       houseDao.save(house);
    }
    public void update(House house) {
        houseDao.update(house);
    }
    public void delete(House house) {
        houseDao.delete(house);
    }
    public House findById(int id) {
        return houseDao.findById(id);
    }
}
