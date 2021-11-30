package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.MaterialMapper;
import Entities.Material;
import Entities.Unit;

public class MaterialFacade {
    MaterialMapper materialMapper;

    public MaterialFacade(Database database) {
        materialMapper = new MaterialMapper(database);
    }

    public Material creatMaterial(String name, String description, double price, Unit unit, Double length, Double height, Double width) {
        Material material = new Material(name, description, price, unit, length, height, width);
        materialMapper.createMaterial(material);
        return material;

    }

}
