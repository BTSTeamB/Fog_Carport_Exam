package ServiceLayer.Facades;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.UnitMapper;
import Entities.Unit;

public class UnitFacade
{
 UnitMapper unitMapper;

 public UnitFacade(Database database){
     unitMapper = new UnitMapper(database);
 }

 public Unit creatUnit(String name){
     Unit unit = new Unit(name);
     unitMapper.createUnit(unit);
     return unit;
 }

}
