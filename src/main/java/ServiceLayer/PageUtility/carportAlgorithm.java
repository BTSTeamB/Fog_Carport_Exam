package ServiceLayer.PageUtility;

import PresentationLayer.Entities.Material;

import java.util.List;

public class carportAlgorithm
{
    double maxWidth = 600.00;
    double maxLength = 780.00;

    double lengthPercentile;
    double widthPercentile;

    public carportAlgorithm(double usersWantedWidth, double usersWantedLength) throws ClassNotFoundException
    {
        this.widthPercentile = (maxWidth - usersWantedWidth ) / maxWidth * 100 / 100;
        this.lengthPercentile = (maxLength - usersWantedLength) / maxLength * 100 / 100;
    }

    public List<Material> calculateCladdingMaterialList(List<Material> claddingMaterials)
    {
        //Decreases all values in material list by percentile

        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            claddingMaterials.get(i).setLength((double) Math.round((claddingMaterials.get(i).getLength() - claddingMaterials.get(i).getLength() * this.lengthPercentile) * 100) / 100);
            claddingMaterials.get(i).setWidth((double) Math.round((claddingMaterials.get(i).getWidth() - claddingMaterials.get(i).getWidth() * this.widthPercentile) * 100) / 100);
        }

        //Cheap way to get 'Quantity' calculated into our list.
        double averagePercentile = (this.lengthPercentile + this.widthPercentile) / 2;
        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            if (claddingMaterials.get(i).getName().equals("Pressure Impregnated Post"))
            {
                claddingMaterials.get(i).setQuantity((int) (claddingMaterials.get(i).getQuantity() - claddingMaterials.get(i).getQuantity() * this.lengthPercentile));
            }
            else
            {
            claddingMaterials.get(i).setQuantity((int) (claddingMaterials.get(i).getQuantity() - claddingMaterials.get(i).getQuantity() * averagePercentile));
            }
            if(claddingMaterials.get(i).getQuantity() < 1)
            {
                claddingMaterials.get(i).setQuantity(1);
            }

            if (claddingMaterials.get(i).getName().equals("Pressure Impregnated Post"))
            {
                if(claddingMaterials.get(i).getDescription().equals("Post, dig 90 cm into earth, for shed"))
                {
                    claddingMaterials.get(i).setQuantity(5); //Skurets stolper
                }
                if (claddingMaterials.get(i).getQuantity() < 4)
                {
                    claddingMaterials.get(i).setQuantity(4); //Carports minimum stolper
                }
            }
            claddingMaterials.get(i).setPrice((double) Math.round((claddingMaterials.get(i).getPrice() - claddingMaterials.get(i).getPrice() * averagePercentile) * 100) / 100);
        }

        return claddingMaterials;
    }

    public List<Material> calculateRoofingMaterialList(List<Material> roofingMaterials)
    {
        //Decreases all values in material list by percentile

        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            roofingMaterials.get(i).setLength((double) Math.round((roofingMaterials.get(i).getLength() - roofingMaterials.get(i).getLength() * this.lengthPercentile) * 100) / 100);
            roofingMaterials.get(i).setWidth((double) Math.round((roofingMaterials.get(i).getWidth() - roofingMaterials.get(i).getWidth() * this.widthPercentile) * 100) / 100);
        }

        //Cheap way to get 'Quantity' calculated into our list.
        double averagePercentile = (this.lengthPercentile + this.widthPercentile) / 2;
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
        System.out.println("Material ID - Name - Price - Quantity - Length - Height/Depth - Width - Description");
        for (int i = 0; i < claddingMaterialList.size(); i++)
        {
            System.out.println(claddingMaterialList.get(i).getMaterial_id() +"\t\t\t"+  claddingMaterialList.get(i).getName() +"\t "+claddingMaterialList.get(i).getPrice()+"\t "+claddingMaterialList.get(i).getQuantity()+ "\t "+claddingMaterialList.get(i).getLength() +"\t "+claddingMaterialList.get(i).getHeight() + "\t " + claddingMaterialList.get(i).getWidth() + "\t " + claddingMaterialList.get(i).getDescription());
        }
    }

    public void printRoofingMaterialList (List<Material> roofingMaterialList)
    {
        System.out.println("ROOFING MATERIALS");
        System.out.println("Material ID - Name - Price - Quantity - Length - Height/Depth - Width - Description");
        for (int i = 0; i < roofingMaterialList.size(); i++)
        {
            System.out.println(roofingMaterialList.get(i).getMaterial_id() +"\t\t\t"+  roofingMaterialList.get(i).getName() +"\t "+roofingMaterialList.get(i).getPrice()+"\t "+ roofingMaterialList.get(i).getQuantity()+"\t "+roofingMaterialList.get(i).getLength() +"\t "+roofingMaterialList.get(i).getHeight() + "\t " + roofingMaterialList.get(i).getWidth() + "\t " + roofingMaterialList.get(i).getDescription());
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
