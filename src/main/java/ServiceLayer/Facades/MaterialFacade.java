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

    public Material creatMaterial(String name, String description, double price, int unit_id, Double length, Double height, Double width) throws Exception {
        Material material = new Material(name, description, price, unit_id, length, height, width);
        materialMapper.createMaterial(material);
        return material;

    }

}
