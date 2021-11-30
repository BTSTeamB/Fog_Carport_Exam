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

    public Cladding creatCladding(Material material) {
        Cladding cladding = new Cladding(material);
        claddingMapper.createCladding(cladding);
        return cladding;
    }
}
