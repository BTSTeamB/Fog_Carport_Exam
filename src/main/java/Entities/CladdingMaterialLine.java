package Entities;

public class CladdingMaterialLine
{
    int claddingMaterialLine_id;
    int claddingId;
    int materialId;

    public CladdingMaterialLine(int claddingMaterialLine_id, int claddingId, int materialId)
    {
        this.claddingMaterialLine_id = claddingMaterialLine_id;
        this.claddingId = claddingId;
        this.materialId = materialId;
    }

    public CladdingMaterialLine(int claddingId, int materialId)
    {
        this.claddingId = claddingId;
        this.materialId = materialId;
    }

    public int getCladdingMaterialLine_id()
    {
        return claddingMaterialLine_id;
    }

    public void setCladdingMaterialLine_id(int claddingMaterialLine_id)
    {
        this.claddingMaterialLine_id = claddingMaterialLine_id;
    }

    public int getCladdingId()
    {
        return claddingId;
    }

    public void setCladdingId(int claddingId)
    {
        this.claddingId = claddingId;
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
