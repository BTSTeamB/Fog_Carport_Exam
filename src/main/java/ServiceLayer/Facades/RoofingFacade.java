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
    public Roofing createRoofing(Material material)
    {
        Roofing roofing = new Roofing(material);
        roofingMapper.createRoofing(roofing);
        return roofing;
    }
}
