package ServiceLayer.PageUtility;


import java.io.FileNotFoundException;
import java.util.List;
import Entities.Material;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;


public class Pdf
{
    List<Material> claddingMaterials;
    List<Material> roofingMaterials;

    public Pdf(List<Material> claddingMaterials, List<Material> roofingMaterials)
    {
        this.claddingMaterials = claddingMaterials;
        this.roofingMaterials = roofingMaterials;
    }

    public void generatePdf() throws FileNotFoundException
    {
        String path = "/Users/oliverrasoli/IntellJWork/Eksamen_FogCarport/src/main/webapp/Resources/invoice-pdf/MaterialList.pdf";

        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        document.add(new Paragraph("Thanks for ordering at Fog!"));
        document.add(new Paragraph("Here is your material-lists:"));
        float columnWidth[] = {75f, 250f, 75f, 75f, 75f, 75f, 400f};
        Table claddingTable = new Table(columnWidth);
        Table roofingTable = new Table(columnWidth);

        String[] claddingTableHeader = {"Material ID", "Name", "Quantity", "Length", "Height/Depth", "Width", "Description"};


        claddingTable.addCell(new Cell().add(claddingTableHeader[0]));
        claddingTable.addCell(new Cell().add(claddingTableHeader[1]));
        claddingTable.addCell(new Cell().add(claddingTableHeader[2]));
        claddingTable.addCell(new Cell().add(claddingTableHeader[3]));
        claddingTable.addCell(new Cell().add(claddingTableHeader[4]));
        claddingTable.addCell(new Cell().add(claddingTableHeader[5]));
        claddingTable.addCell(new Cell().add(claddingTableHeader[6]));

        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            claddingTable.addCell(new Cell().add(String.valueOf(claddingMaterials.get(i).getMaterial_id())));
            claddingTable.addCell(new Cell().add(claddingMaterials.get(i).getName()));
            claddingTable.addCell(new Cell().add(String.valueOf(claddingMaterials.get(i).getQuantity())));
            claddingTable.addCell(new Cell().add(String.valueOf(claddingMaterials.get(i).getLength())));
            claddingTable.addCell(new Cell().add(String.valueOf(claddingMaterials.get(i).getHeight())));
            claddingTable.addCell(new Cell().add(String.valueOf(claddingMaterials.get(i).getWidth())));
            claddingTable.addCell(new Cell().add(claddingMaterials.get(i).getDescription()));
        }

        String[] roofingTableHeader = {"Material ID", "Name", "Quantity", "Length", "Height/Depth", "Width", "Description"};

        roofingTable.addCell(new Cell().add(roofingTableHeader[0]));
        roofingTable.addCell(new Cell().add(roofingTableHeader[1]));
        roofingTable.addCell(new Cell().add(roofingTableHeader[2]));
        roofingTable.addCell(new Cell().add(roofingTableHeader[3]));
        roofingTable.addCell(new Cell().add(roofingTableHeader[4]));
        roofingTable.addCell(new Cell().add(roofingTableHeader[5]));
        roofingTable.addCell(new Cell().add(roofingTableHeader[6]));

        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            roofingTable.addCell(new Cell().add(String.valueOf(roofingMaterials.get(i).getMaterial_id())));
            roofingTable.addCell(new Cell().add(roofingMaterials.get(i).getName()));
            roofingTable.addCell(new Cell().add(String.valueOf(roofingMaterials.get(i).getQuantity())));
            roofingTable.addCell(new Cell().add(String.valueOf(roofingMaterials.get(i).getLength())));
            roofingTable.addCell(new Cell().add(String.valueOf(roofingMaterials.get(i).getHeight())));
            roofingTable.addCell(new Cell().add(String.valueOf(roofingMaterials.get(i).getWidth())));
            roofingTable.addCell(new Cell().add(roofingMaterials.get(i).getDescription()));
        }
        document.add(new Paragraph(""));
        document.add(new Paragraph("Cladding Materials"));
        document.add(claddingTable);
        document.add(new Paragraph(""));
        document.add(new Paragraph("Roofing Materials"));
        document.add(roofingTable);
        document.close();

    }
}