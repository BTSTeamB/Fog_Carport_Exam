package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.CladdingMapper;
import Entities.Cladding;
import Entities.Material;

public class CladdingFacade {
    CladdingMapper claddingMapper;

    public CladdingFacade(Database database) {
        claddingMapper = new CladdingMapper(database);
    }

    public Cladding createCladding(int material_id)throws Exception{
        Cladding cladding = new Cladding(material_id);
        claddingMapper.createCladding(cladding);
        return cladding;
    }
}
