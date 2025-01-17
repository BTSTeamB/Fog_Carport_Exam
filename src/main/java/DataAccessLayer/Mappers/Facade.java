package DataAccessLayer.Mappers;

import DataAccessLayer.Database;
import PresentationLayer.Entities.*;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    CladdingMapper claddingMapper;
    RoofingMapper roofingMapper;
    MaterialMapper materialMapper;
    UnitMapper unitMapper;
    OrderMapper orderMapper;
    UserMapper userMapper;
    PredefinedCarportMapper predefinedCarportMapper;
    CML_Mapper cml_mapper;
    RML_Mapper rml_mapper;
    Database database = new Database();

    public Facade() throws ClassNotFoundException {
        claddingMapper = new CladdingMapper(this.database);
        roofingMapper = new RoofingMapper(this.database);
        materialMapper = new MaterialMapper(this.database);
        unitMapper = new UnitMapper(this.database);
        orderMapper = new OrderMapper(this.database);
        userMapper = new UserMapper(this.database);
        predefinedCarportMapper = new PredefinedCarportMapper(this.database);
        cml_mapper = new CML_Mapper(this.database);
        rml_mapper = new RML_Mapper(this.database);

    }


    //Cladding
    public Cladding createCladding(String type) throws Exception {
        Cladding cladding = new Cladding(type);
        claddingMapper.createCladding(cladding);
        return cladding;
    }

    public void deleteCladding(int cladding_id) {
        Cladding cladding = new Cladding(cladding_id);
        claddingMapper.deleteCladding(cladding);
    }

    public Cladding editCladding(int cladding_id, String type) {
        Cladding cladding = new Cladding(cladding_id, type);
        claddingMapper.editCladding(cladding);
        return cladding;
    }

    public Cladding receiveCladdingByObject(Cladding cladding)
    {
        Cladding tmpCladding = claddingMapper.receiveCladdingByObject(cladding);
        return tmpCladding;
    }

    public Cladding receiveCladdingById(int cladding_id) {
        return claddingMapper.receiveCladdingById(cladding_id);
    }

    public List<Cladding> receiveAllCladding()
    {
        return claddingMapper.getAllCladding();
    }


    //Cladding Material Line
    public void createCML(int claddingId, int materialId) throws Exception
    {
        CladdingMaterialLine cml = new CladdingMaterialLine(claddingId, materialId);
        cml_mapper.createLine(cml);
    }

    public List<CladdingMaterialLine> getAllCMLBySpecificId(int id)
    {
        List<CladdingMaterialLine> cmlList = new ArrayList<>();
        cmlList = cml_mapper.getAllCMLBySpecificId(id);
        return cmlList;
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
       return roofingMapper.receiveRoofingByObject(roofing);
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

    //Roofing Material Line
    public void createRML(int roofId, int materialId) throws Exception
    {
        RoofingMaterialLine rml = new RoofingMaterialLine(roofId, materialId);
        rml_mapper.createLine(rml);
    }

    public List<RoofingMaterialLine> getAllRMLBySpecificId(int id)
    {
        List<RoofingMaterialLine> rmlList = new ArrayList<>();
        rmlList = rml_mapper.getAllRMLBySpecificId(id);
        return rmlList;
    }


    //Material
    public Material createMaterial(int materialId,String name, String description, double price, int quantity ,int unit_id, Double length, Double height, Double width) throws Exception
    {
        Material material = new Material(materialId, name, description, price, quantity, unit_id, length, height, width);
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
    public List<Order> getOrderListById(int user_id)
    {
        return orderMapper.getOrderListById(user_id);
    }

    public List<Order> getAllOrders()
    {
        return orderMapper.getAllOrders();
    }

    //Unit
    public Unit createUnit(String name) throws Exception {
        Unit unit = new Unit(name);
        unitMapper.createUnit(unit);

        return unit;
    }

    public Order getOrderByOrderId(int id)
    {
        return orderMapper.getOrderByOrderId(id);
    }


    //User
    public void createUser(String name, String address, String zipCode, String phoneNumber, String email, String password) throws Exception {
        User user = new User(name, address, zipCode, phoneNumber, email, password);
        userMapper.createUser(user);
    }

    public void createGuestUser(String name, String address, String zipCode, String phoneNumber, String email) throws Exception
    {
        User user = new User(name, address, zipCode, phoneNumber, email);
        userMapper.createGuestUser(user);

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

    public User getUserByCredentials(String name, String address, String zipCode, String phoneNum, String email) throws Exception
    {
        return userMapper.getUserByCredentials(name, address, zipCode, phoneNum, email);
    }

    public List<User> getAllUsers() throws Exception
    {
        return userMapper.getAllUsers();
    }


    //Predefined Carport
    public void createPredefinedCarport(int width, int length, double price, String imgUrl, String seeMoreUrl1, String seeMoreUrl2) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(width, length, price, imgUrl, seeMoreUrl1, seeMoreUrl2);
        predefinedCarportMapper.createPredefinedCarport(predefinedCarport);
    }

    public List<PredefinedCarport> getAllPredefinedCarport() throws Exception
    {
        return predefinedCarportMapper.receiveAllPredefinedCarport();
    }

    public void editPredefinedCarport(int id, int width, int length, double price, String imgUrl, String seeMoreUrl1, String seeMoreUrl2) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id, width, length, price, imgUrl, seeMoreUrl1, seeMoreUrl2);
        predefinedCarportMapper.editPredefinedCarport(predefinedCarport);
    }

    public void deletePredefinedCarport(int id) throws Exception {
        PredefinedCarport predefinedCarport = new PredefinedCarport(id);
        predefinedCarportMapper.deletePredefinedCarport(predefinedCarport);
    }

}
