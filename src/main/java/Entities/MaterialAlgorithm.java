package Entities;

import ServiceLayer.PageUtility.OrderUtility;

import java.util.ArrayList;
import java.util.List;

public class MaterialAlgorithm
{
    double maxWidth = 600.00;
    double maxLength = 780.00;

    double lengthPercentile;
    double widthPercentile;

    public MaterialAlgorithm(double usersWantedWidth, double usersWantedLength) throws ClassNotFoundException
    {
        this.widthPercentile = (maxWidth - usersWantedWidth ) / maxWidth * 100 / 100;
        this.lengthPercentile = (maxLength - usersWantedLength) / maxLength * 100 / 100;
    }

    public List<Material> calculateCladdingMaterialList(List<Material> claddingMaterials,double widthPercentile, double lengthPercentile)
    {
        //Decreases all values in material list by percentile

        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            claddingMaterials.get(i).setLength((double) Math.round((claddingMaterials.get(i).getLength() - claddingMaterials.get(i).getLength() * lengthPercentile) * 100) / 100);
            claddingMaterials.get(i).setWidth((double) Math.round((claddingMaterials.get(i).getWidth() - claddingMaterials.get(i).getWidth() * widthPercentile) * 100) / 100);
        }

        //Cheap way to get 'Quantity' calculated into our list.
        double averagePercentile = (lengthPercentile + widthPercentile) / 2;
        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            claddingMaterials.get(i).setQuantity((int) (claddingMaterials.get(i).getQuantity() - claddingMaterials.get(i).getQuantity() * averagePercentile));
            if(claddingMaterials.get(i).getQuantity() < 1)
            {
                claddingMaterials.get(i).setQuantity(1);
            }

            if (claddingMaterials.get(i).getName().equals("Pressure Impregnated Post"))
            {
                if (claddingMaterials.get(i).getQuantity() < 4)
                {
                    claddingMaterials.get(i).setQuantity(4);
                }
            }
            claddingMaterials.get(i).setPrice((double) Math.round((claddingMaterials.get(i).getPrice() - claddingMaterials.get(i).getPrice() * averagePercentile) * 100) / 100);
        }

        return claddingMaterials;
    }

    public List<Material> calculateRoofingMaterialList(List<Material> roofingMaterials,double widthPercentile, double lengthPercentile)
    {
        //Decreases all values in material list by percentile

        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            roofingMaterials.get(i).setLength((double) Math.round((roofingMaterials.get(i).getLength() - roofingMaterials.get(i).getLength() * lengthPercentile) * 100) / 100);
            roofingMaterials.get(i).setWidth((double) Math.round((roofingMaterials.get(i).getWidth() - roofingMaterials.get(i).getWidth() * widthPercentile) * 100) / 100);
        }

        //Cheap way to get 'Quantity' calculated into our list.
        double averagePercentile = (lengthPercentile + widthPercentile) / 2;
        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            roofingMaterials.get(i).setQuantity((int) (roofingMaterials.get(i).getQuantity() - roofingMaterials.get(i).getQuantity() * averagePercentile));
            if(roofingMaterials.get(i).getQuantity() < 1)
            {
                roofingMaterials.get(i).setQuantity(1);
            }

            roofingMaterials.get(i).setPrice((double) Math.round((roofingMaterials.get(i).getPrice() - roofingMaterials.get(i).getPrice() * averagePercentile) * 100) / 100);
        }

        return roofingMaterials;
    }

    public void printCladdingMaterialList (List<Material> claddingMaterialList)
    {
        System.out.println("CLADDING MATERIALS");
        System.out.println("Material ID - Name - Price - Quantity - Length - Height/Depth - Width");
        for (int i = 0; i < claddingMaterialList.size(); i++)
        {
            System.out.println(claddingMaterialList.get(i).getMaterial_id() +"\t\t\t"+  claddingMaterialList.get(i).getName() +"\t "+claddingMaterialList.get(i).getPrice()+"\t "+claddingMaterialList.get(i).getQuantity()+ "\t "+claddingMaterialList.get(i).getLength() +"\t "+claddingMaterialList.get(i).getHeight() + "\t " + claddingMaterialList.get(i).getWidth());
        }
    }

    public void printRoofingMaterialList (List<Material> roofingMaterialList)
    {
        System.out.println("ROOFING MATERIALS");
        System.out.println("Material ID - Name - Price - Quantity - Length - Height/Depth - Width");
        for (int i = 0; i < roofingMaterialList.size(); i++)
        {
            System.out.println(roofingMaterialList.get(i).getMaterial_id() +"\t\t\t"+  roofingMaterialList.get(i).getName() +"\t "+roofingMaterialList.get(i).getPrice()+"\t "+ roofingMaterialList.get(i).getQuantity()+"\t "+roofingMaterialList.get(i).getLength() +"\t "+roofingMaterialList.get(i).getHeight() + "\t " + roofingMaterialList.get(i).getWidth());
        }
    }

    public double getLengthPercentile()
    {
        return lengthPercentile;
    }

    public double getWidthPercentile()
    {
        return widthPercentile;
    }
}
