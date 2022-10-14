package services;

import dao.AutoDao;
import models.Auto;
public class AutoService {
    AutoDao autoDao;
    public void save(Auto auto) {
        autoDao.save(auto);
    }
    public void update(Auto auto) {
        autoDao.update(auto);
    }
    public void delete(Auto auto) {
        autoDao.delete(auto);
    }
    public Auto findById(int id) {
        return autoDao.findById(id);
    }
}
