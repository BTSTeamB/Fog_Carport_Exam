package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    CladdingMapper claddingMapper;
    RoofingMapper roofingMapper;
    MaterialMapper materialMapper;
    UnitMapper unitMapper;
    OrderMapper orderMapper;
    UserMapper userMapper;
    PredefinedShedMapper predefinedShedMapper;
    PredefinedCarportMapper predefinedCarportMapper;

    public Facade(Database database) throws ClassNotFoundException {
        claddingMapper = new CladdingMapper(database);
        roofingMapper = new RoofingMapper(database);
        materialMapper = new MaterialMapper(database);
        unitMapper = new UnitMapper(database);
        orderMapper = new OrderMapper(database);
        userMapper = new UserMapper(database);
        predefinedCarportMapper = new PredefinedCarportMapper(database);
        predefinedShedMapper = new PredefinedShedMapper(database);

    }


    //Cladding
    public Cladding createCladding(int material_id) throws Exception {
        Cladding cladding = new Cladding(material_id);
        claddingMapper.createCladding(cladding);
        return cladding;
    }

    public void deleteCladding(int cladding_id) {
        Cladding cladding = new Cladding(cladding_id);
        claddingMapper.deleteCladding(cladding);
    }

    public Cladding editCladding(int cladding_id, int material_id) {
        Cladding cladding = new Cladding(cladding_id, material_id);
        claddingMapper.editCladding(cladding);
        return cladding;
    }

    public Cladding receiveCladdingByObject(Cladding cladding)
    {
        Cladding tmpCladding = claddingMapper.receiveCladdingByObject(cladding);
        return tmpCladding;
    }

    public Cladding receiveCladdingById(int cladding_id) {
        Cladding cladding = claddingMapper.receiveCladdingById(cladding_id);
        return cladding;
    }

    public List<Cladding> receiveAllCladding()
    {
        List<Cladding> claddingList = claddingMapper.getAllCladding();
        return claddingList;
    }


    //Roofing
    public Roofing createRoofing(int material_id) throws Exception {
        Roofing roofing = new Roofing(material_id);
        roofingMapper.createRoofing(roofing);
        return roofing;
    }

    public void deleteRoofing(int roofing_id) {
        Roofing roofing = new Roofing(roofing_id);
        roofingMapper.deleteRoofing(roofing);
    }

    public Roofing editRoofing(int roofing_id) {
        Roofing roofing = new Roofing(roofing_id);
        roofingMapper.editRoofing(roofing);
        return roofing;
    }

    public Roofing receiveRoofingByObject(Roofing roofing) throws Exception
    {
        Roofing tmpRoofing = roofingMapper.receiveRoofingByObject(roofing);
        return tmpRoofing;
    }

    public Roofing receiveRoofingById(int roofing_id) throws Exception {
        Roofing roofing = roofingMapper.receiveRoofingById(roofing_id);
        return roofing;
    }

    public List<Roofing> receiveAllRoofing()
    {
        List<Roofing> roofingList = roofingMapper.getAllRoofing();
        return roofingList;
    }


    //Material
    public Material createMaterial(int materialId,String name, String description, double price, int unit_id, Double length, Double height, Double width) throws Exception
    {
        Material material = new Material(materialId, name, description, price, unit_id, length, height, width);
        materialMapper.createMaterial(material);
        return material;
    }

    public Material deleteMaterial(int material_id) throws Exception {
        Material material = new Material(material_id);
        materialMapper.createMaterial(material);
        return material;
    }

    public Material editMaterial(String name, String description, double price, int unit_id, double length, double height, double width) throws Exception {
        Material material = new Material(name, description, price, unit_id, length, height, width);
        materialMapper.createMaterial(material);
        return material;
    }

    public Material getMaterialById(int material_id) throws Exception {
        Material material = materialMapper.receiveMaterialById(material_id);
        return material;
    }


    //Order
    public void createOrder(Order order) throws Exception {
        orderMapper.createOrder(order);
    }

    //Unit
    public Unit createUnit(String name) throws Exception {
        Unit unit = new Unit(name);
        unitMapper.createUnit(unit);

        return unit;
    }


    //User
    public void createUser(String name, String address, String zipCode, String phoneNumber, String email, String password) throws Exception {
        User user = new User(name, address, zipCode, phoneNumber, email, password);
        userMapper.createUser(user);
    }

    public User getUser(String email, String password) throws Exception
    {
        User user = null;
        user = userMapper.getUser(email, password);
        return user;
    }

    public void editUser(int user_id,String name, String address, String zipCode, String email, String password, String phoneNumber){
        User user = new User(user_id, name, address, zipCode, email, password, phoneNumber);
        userMapper.editUser(user);
    }

    public User getUserById(int search_id) throws Exception
    {
        return userMapper.getUserByID(search_id);
    }


    //Predefined Shed
    public void createPredefinedShed(int width, int length, double price, String imgUrl) throws Exception {
        PredefinedShed predefinedShed = new PredefinedShed(width, length, price, imgUrl);
        predefinedShedMapper.createPredefinedShed(predefinedShed);
    }

    public List<PredefinedShed> getAllPredefinedShed() throws Exception
    {
        List<PredefinedShed> pdSheds = new ArrayList<>();
        pdSheds = predefinedShedMapper.receiveAllPredefinedShed();
        return pdSheds;
    }

    public void editPredefinedShed(int id, int width, int length, double price, String imgUrl) throws Exception {
        PredefinedShed predefinedShed = new PredefinedShed(id, width, length, price, imgUrl);
        predefinedShedMapper.editPredefinedShed(predefinedShed);
    }

    public void deletePredefinedShed(int id) {
        PredefinedShed predefinedShed = new PredefinedShed(id);
        predefinedShedMapper.deletePredefinedShed(predefinedShed);
    }



    //Predefined Carport
    public void createPredefinedCarport(int width, int length, double price, String imgUrl) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(width, length, price, imgUrl);
        predefinedCarportMapper.createPredefinedCarport(predefinedCarport);
    }

    public List<PredefinedCarport> getAllPredefinedCarport() throws Exception
    {
        List<PredefinedCarport> pdCarports;
        pdCarports = predefinedCarportMapper.receiveAllPredefinedCarport();
        return pdCarports;
    }

    public void editPredefinedCarport(int id, int width, int length, double price, String imgUrl) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id, width, length, price, imgUrl);
        predefinedCarportMapper.editPredefinedCarport(predefinedCarport);
    }

    public void deletePredefinedCarport(int id) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id);
        predefinedCarportMapper.deletePredefinedCarport(predefinedCarport);
    }


}
