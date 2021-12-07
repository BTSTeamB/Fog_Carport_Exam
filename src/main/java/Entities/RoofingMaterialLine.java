package Entities;

public class RoofingMaterialLine
{
    int roofingMaterialLine_id;
    int roofingId;
    int materialId;

    public RoofingMaterialLine(int roofingMaterialLine_id, int roofingId, int materialId)
    {
        this.roofingMaterialLine_id = roofingMaterialLine_id;
        this.roofingId = roofingId;
        this.materialId = materialId;
    }

    public RoofingMaterialLine(int roofingId, int materialId)
    {
        this.roofingId = roofingId;
        this.materialId = materialId;
    }

    public int getRoofingMaterialLine_id()
    {
        return roofingMaterialLine_id;
    }

    public void setRoofingMaterialLine_id(int roofingMaterialLine_id)
    {
        this.roofingMaterialLine_id = roofingMaterialLine_id;
    }

    public int getRoofingId()
    {
        return roofingId;
    }

    public void setRoofingId(int roofingId)
    {
        this.roofingId = roofingId;
    }

    public int getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(int materialId)
    {
        this.materialId = materialId;
    }
}
