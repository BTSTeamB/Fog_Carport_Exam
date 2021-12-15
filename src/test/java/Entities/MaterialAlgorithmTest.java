package Entities;

import ServiceLayer.PageUtility.OrderUtility;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaterialAlgorithmTest
{

    @Test
    void calculateCarport() throws ClassNotFoundException
    {
        OrderUtility orderUtility = new OrderUtility();
        List<Material> claddingMaterials = orderUtility.getCladdingMaterial(1);
        List<Material> roofingMaterials = orderUtility.getRoofingMaterial(1);

        MaterialAlgorithm materialAlgorithm = new MaterialAlgorithm(240,240);

        System.out.println("Length Percentile: " + materialAlgorithm.lengthPercentile+ "\n " + "Width Percentile: " + materialAlgorithm.widthPercentile);

        System.out.println("Cladding Materials before math: ");
        System.out.println("Material ID - Name - Price - Quantity - Length - Height/Depth - Width");
        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            System.out.println(claddingMaterials.get(i).getMaterial_id() +"\t\t\t"+  claddingMaterials.get(i).getName() +"\t "+claddingMaterials.get(i).getPrice()+"\t "+claddingMaterials.get(i).getQuantity()+"\t "+claddingMaterials.get(i).getLength() +"\t "+claddingMaterials.get(i).getHeight() + "\t " + claddingMaterials.get(i).getWidth());
        }

        claddingMaterials = materialAlgorithm.calculateCladdingMaterialList(claddingMaterials, materialAlgorithm.getWidthPercentile(), materialAlgorithm.getLengthPercentile());

        materialAlgorithm.printCladdingMaterialList(claddingMaterials);


        System.out.println("Roofing Materials before math: ");
        System.out.println("Material ID - Name - Price - Quantity - Length - Height/Depth - Width");
        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            System.out.println(roofingMaterials.get(i).getMaterial_id() +"\t\t\t"+  roofingMaterials.get(i).getName() +"\t "+roofingMaterials.get(i).getPrice()+"\t "+roofingMaterials.get(i).getQuantity()+"\t "+roofingMaterials.get(i).getLength() +"\t "+roofingMaterials.get(i).getHeight() + "\t " + roofingMaterials.get(i).getWidth());
        }

        roofingMaterials =  materialAlgorithm.calculateRoofingMaterialList(roofingMaterials, materialAlgorithm.getWidthPercentile(), materialAlgorithm.getLengthPercentile());

        materialAlgorithm.printRoofingMaterialList(roofingMaterials);






    }
}