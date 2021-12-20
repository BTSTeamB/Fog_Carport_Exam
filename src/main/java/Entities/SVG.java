package Entities;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;
    private String beginArrow;
    private int markerWidth;
    private int markerHeight;
    private double refX;
    private double refY;
    private String orient;
    private String endArrow;
    private String path;
    private String id;
    private String text;
    private int rotate;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%s\" width=\"%s\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String lineTemplate = "<line x1=\"%d\" y1=\"%d\"x2=\"%d\"y2=\"%d\" style=\"stroke:#000000; fill: #ffffff\" stroke-dasharray=\"5\" />";
    private final String line1Template = "<line x1=\"%d\" y1=\"%d\"x2=\"%d\"y2=\"%d\" style=\"stroke:#ffffff;marker-start: url(#beginArrow) ;marker-end: url(#endArrow);\" />";

    private final String innerSVGTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";
    private final String beginArrowTemplate = "<defs> <marker id=\"%s\" markerWidth=\"%d%%\" markerHeight=\"%d%%\" refX=\"%s\" refY=\"%s\" orient=\"auto\"> <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #ffffff;\" /> </marker>";
    private final String endArrowTemplate = "<defs> <marker id=\"%s\" markerWidth=\"%d%%\" markerHeight=\"%d%%\" refX=\"%s\" refY=\"%s\" orient=\"auto\"> <path d=\"M0,0 L12,6 L0,12 L0,0\" style=\"fill: #ffffff;\" /> </marker>";
    private final String textTemplate = "<text style=\"text-anchor: middle; stroke: #ffffff;\" transform=\"translate(%s,%s) rotate(-90)\">%s</text>";
    private final String text2Template = "<text style=\"text-anchor: middle; stroke: #ffffff;\" transform=\"translate(%s,%s) \">%s</text>";
    private final String shedTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%s\" width=\"%s\" style=\"stroke:#000000; fill: #ffffff\" stroke-dasharray=\"5\"/>";

    //%M0,0 L12,6 L0,12 L0,0
    //  M0,6 L12,0 L12,12 L0,6
    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y));
    }

    public void addRect(int x, int y, double height, double width) {
        svg.append(String.format(rectTemplate, x, y, height, width));

    }

    public void addLine(int x1, int y1, int x2, int y2) {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2));
    }

    public void addLine1(int x1, int y1, int x2, int y2) {
        svg.append(String.format(line1Template, x1, y1, x2, y2));
    }

    public void addSvg(SVG innerSVG) {
        svg.append(innerSVGTemplate);
        svg.append(innerSVG.toString());
    }

    public void addArrowsStart(String id, int markerWidth, int markerHeight, double refX, double refY) {
        this.id = id;
        this.markerWidth = markerWidth;
        this.markerHeight = markerHeight;
        this.refX = refX;
        this.refY = refY;


        svg.append(String.format(beginArrowTemplate, id, markerWidth, markerHeight, refX, refY));
    }

    public void addArrowsEnd(String id, int markerWidth, int markerHeight, double refX, double refY) {
        this.id = id;
        this.markerWidth = markerWidth;
        this.markerHeight = markerHeight;
        this.refX = refX;
        this.refY = refY;


        svg.append(String.format(endArrowTemplate, id, markerWidth, markerHeight, refX, refY));
    }

    public void text(int x, int y, String text) {
        this.text = text;
        this.x = x;
        this.y = y;

        svg.append(String.format(textTemplate, x, y, text));

    }

    public void text2(int x, int y, String text) {
        this.text = text;
        this.x = x;
        this.y = y;

        svg.append(String.format(text2Template, x, y, text));
    }
    public void shed(int x, int y, int height,int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        svg.append(String.format(shedTemplate,x,y,height,width));
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
