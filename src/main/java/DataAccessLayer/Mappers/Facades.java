package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.CladdingMapper;
import DataAccessLayer.Mappers.MaterialMapper;
import DataAccessLayer.Mappers.OrderMapper;
import DataAccessLayer.Mappers.RoofingMapper;
import Entities.*;

public class Facades {
    CladdingMapper claddingMapper;
    RoofingMapper roofingMapper;
    MaterialMapper materialMapper;
    UnitMapper unitMapper;
    OrderMapper orderMapper;
    UserMapper userMapper;
    PredefinedShedMapper predefinedShedMapper;
    PredefinedCarportMapper predefinedCarportMapper;

    public Facades(Database database) throws ClassNotFoundException {
        claddingMapper = new CladdingMapper(database);
        roofingMapper = new RoofingMapper(database);
        materialMapper = new MaterialMapper(database);
        unitMapper = new UnitMapper(database);
        orderMapper = new OrderMapper(database);
        userMapper = new UserMapper(database);
        predefinedShedMapper = new PredefinedShedMapper(database);
        predefinedCarportMapper = new PredefinedCarportMapper(database);

    }


    public Cladding createCladding(int material_id) throws Exception {
        Cladding cladding = new Cladding(material_id);
        claddingMapper.createCladding(cladding);
        return cladding;
    }


    public Roofing createRoofing(int material_id) throws Exception {
        Roofing roofing = new Roofing(material_id);
        roofingMapper.createRoofing(roofing);

        return roofing;
    }


    public Material creatMaterial(String name, String description, double price, int unit_id, Double length, Double height, Double width) throws Exception {
        Material material = new Material(name, description, price, unit_id, length, height, width);
        materialMapper.createMaterial(material);
        return material;

    }


    public Order createOrder(int user_id, double price, int carport_length, int carport_width, int cladding_id, int roofing_id, int shed_width, int shed_length) throws Exception {
        Order order = new Order(user_id, price, carport_length, carport_width, cladding_id, roofing_id, shed_width, shed_length);
        orderMapper.createOrder(order);
        return order;

    }

    public Unit creatUnit(String name) throws Exception {
        Unit unit = new Unit(name);
        unitMapper.createUnit(unit);

        return unit;
    }

    public Unit deleteUnit(String name) {
        Unit unit = new Unit(name);
        unitMapper.deleteUnit(unit);
        return unit;
    }

    public User login(String email, String password) {
        // return userMapper.login(email, password);
        return null;
    }

    public void createUser(String name, String address, String zipCode, String phoneNumber, String email, String password) throws Exception {
        User user = new User(name, address, zipCode, phoneNumber, email, password);
        userMapper.createUser(user);
    }

    public void editUser(int user_id, String name, String address, String zipCode, String phoneNumber, String email, String password) {
        User user = new User(user_id, name, address, zipCode, phoneNumber, email, password);
        userMapper.editUser(user);
    }

    public void createPredefinedShed(int width, int length) throws Exception {
        PredefinedShed predefinedShed = new PredefinedShed(width, length);
        predefinedShedMapper.createPredefinedShed(predefinedShed);
    }

    public void editPredefinedShed(int id, int width, int length) throws Exception {
        PredefinedShed predefinedShed = new PredefinedShed(id, width, length);
        predefinedShedMapper.editPredefinedShed(predefinedShed);
    }

    public void deletePredefinedShed(int id) {
        PredefinedShed predefinedShed = new PredefinedShed(id);
        predefinedShedMapper.deletePredefinedShed(predefinedShed);
    }
    public void eceviePredefinedShed(int id)throws Exception{
        PredefinedShed predefinedShed = new PredefinedShed(id);
        predefinedShedMapper.receviePredefinedShed(predefinedShed);
    }


    public void createPredefinedCarport(int width, int length) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(width, length);
        predefinedCarportMapper.createPredefinedCarport(predefinedCarport);
    }

    public void editPredefinedCarport(int id, int width, int length) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id, width, length);
        predefinedCarportMapper.editPredefinedCarport(predefinedCarport);
    }

    public void deletePredefinedCarport(int id) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id);
        predefinedCarportMapper.deletePredefinedCarport(predefinedCarport);
    }

    public void receviePredefinedCarport(int id) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id);
        predefinedCarportMapper.receviePredefinedCarport(predefinedCarport);
    }
}

