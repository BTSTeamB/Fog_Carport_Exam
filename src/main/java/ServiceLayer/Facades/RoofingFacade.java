package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.RoofingMapper;
import Entities.Material;
import Entities.Roofing;

public class RoofingFacade
{
    RoofingMapper roofingMapper;

    public RoofingFacade(Database database){
        roofingMapper = new RoofingMapper(database);
    }
    public Roofing createRoofing(Material material,int material_id) throws Exception {
        Roofing roofing = new Roofing(material,material_id);
            roofingMapper.createRoofing(roofing);

        return roofing;
    }
}
