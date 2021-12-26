package ServiceLayer.PageUtility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PdfTest
{
    @Test
    public void pathTest()
    {
        String path = String.format("%s/%s", System.getProperty("user.dir"), this.getClass().getPackage().getName().replace(".", "/"));
        System.out.println(path);
        System.out.println(System.getProperty("user.dir"));
        String materialListPath = String.format("%s/%s", System.getProperty("user.dir"), "src/main/webapp/Resources/invoice-pdf/MaterialList.pdf".replace(".", "/"));
        System.out.println(materialListPath);
    }
}