package ServiceLayer.PageUtility;

import Entities.SVG;

public class drawCarport
{
    int længde = 0;//brugernes valg
    int brede = 0;//brugerens valg
    int stolper = 0;
    int lægter = 0;
    int shedLængde;
    int shedbrede;
    int shedStolper = 0;
    int lægterShed;
    boolean shed;
    SVG svg;

    public drawCarport(int brede, int længde, int shedbrede, int shedLængde)
    {
        this.længde = længde;
        this.brede = brede;
        this.shedbrede = shedbrede;
        this.shedLængde = shedLængde;

        svg = new SVG(0, 0, "0 0 "+(længde + 300)+" " +(brede + 200)+"", 100, 100);

        if(shedbrede > 0 && shedLængde > 0)
        {
            shed = true;
        }
        else
        {
            shed = false;
        }
    }

    public void drawCarportProduct()
    {
        // Post initializer
        if (this.længde >= 720 && this.længde <= 780)
        {
            this.stolper = 5;
        } else if (this.længde >= 570 && this.længde < 720)
        {
            this.stolper = 4;
        } else if (this.længde >= 450 && this.længde < 570)
        {
            this.stolper = 3;
        } else if (this.længde < 450)
        {
            this.stolper = 2;
        }

        //Limit setters
        if (this.længde < 240) {
            this.længde = 240;
        }
        if (this.længde > 780) {
            this.længde = 780;
        }
        if (this.brede < 240) {
            this.brede = 240;

        }
        if (this.brede > 600) {
            this.brede = 600;
        }


        //Draws carport
        if (!shed) {

            this.svg.addRect(155, 0, this.brede, this.længde);
            this.svg.addRect(155, 35, 4.5, this.længde);
            this.svg.addRect(155, this.brede - 35, 4.5, this.længde);


            this.lægter = (this.længde / 55) + 1;


            //lægter
            for (int x = 1; x < this.lægter; x++) {
                this.svg.addRect(155 + 55 * x, 0, this.brede, 4.8);
            }

            //stolper up
            for (int x = 1; x <= this.stolper; x++) {

                this.svg.addRect(55 + ((this.længde / this.stolper) * x), 32, 10.0, 10.0);
            }

            //stopler down
            for (int x = 1; x <= this.stolper; x++) {

                this.svg.addRect(55 + ((this.længde / this.stolper) * x), this.brede - 38, 10.0, 10.0);
            }

            this.svg.text2(155 + (this.længde / 2), this.brede + 75, this.længde + "cm");
            this.svg.text(75, this.brede / 2, this.brede + "cm");


            //striped-lines
            this.svg.addLine(55 + ((this.længde / this.stolper) * 1), 35, 55 + ((this.længde / this.stolper) * this.stolper), this.brede - 38);
            this.svg.addLine(55 + ((this.længde / this.stolper) * 1), brede - 38, 55 + ((this.længde / this.stolper) * this.stolper), 32);

            //arrow-lines
            this.svg.addLine1(100, 0, 100, this.brede);
            this.svg.addLine1(150, this.brede + 30, this.længde + 155, this.brede + 30);

            this.svg.addArrowsEnd("endArrow", 10, 10, 12, 6);
            this.svg.addArrowsStart("beginArrow", 10, 10, 0, 6);
        }

        //Adds Shed to carport
        if (this.shed)
        {
            this.svg.addRect(155, 0, this.brede, this.længde);
            this.svg.shed(55 + ((this.længde / this.stolper) * this.stolper), 35, this.shedbrede - 70, this.shedLængde - 60);
            this.svg.addRect(155, 35, 4.5, this.længde);
            this.svg.addRect(155, this.brede - 35, 4.5, this.længde);


            this.lægterShed = (this.shedLængde /55);
            for (int x = 1; x <= this.lægterShed; x++) {
                this.svg.shed( ((this.længde / this.stolper) * this.stolper)+55 * x, 35, this.shedbrede-70, 4);
            }


            for (int x = 1; x <= 1; x++) {
                this.svg.addRect(55 + ((this.længde / this.stolper) * this.stolper), this.shedbrede / 2, 10.0, 10.0);
                this.svg.addRect(55 + ((this.længde / this.stolper) * (this.stolper) + (this.shedLængde - 60)), this.shedbrede / 2, 10.0, 10.0);
            }

            for (int x = 1; x <= 1; x++) {
                this.svg.addRect(55 + ((this.længde / this.stolper) * this.stolper) + (this.shedLængde - 60), this.shedbrede - 35, 10.0, 10.0);
                this.svg.addRect(55 + ((this.længde / this.stolper) * this.stolper) + (this.shedLængde - 60), 35, 10.0, 10.0);
            }

            this.lægter = (this.længde / 55) + 1;
            //lægter
            for (int x = 1; x < this.lægter; x++) {
                this.svg.addRect(155 + 55 * x, 0, this.brede, 4.8);
            }

            //stolper up
            for (int x = 1; x <= this.stolper; x++) {

                this.svg.addRect(55 + ((this.længde / this.stolper) * x), 32, 10.0, 10.0);
            }


            if (this.shedbrede != this.brede) {
                for (int x = 1; x <= this.stolper; x++) {

                    this.svg.addRect(55 + ((this.længde / this.stolper) * x), this.brede - 38, 10.0, 10.0);
                    this.svg.addRect(55 + ((this.længde / this.stolper) * this.stolper), this.shedbrede - 32, 10.0, 10.0);
                }
            }

            //stopler down
            if (this.shedbrede == this.brede) {
                for (int x = 1; x <= this.stolper; x++) {

                    this.svg.addRect(55 + ((this.længde / this.stolper) * x), this.brede - 38, 10.0, 10.0);
                }
            }


            this.svg.text2(155 + (this.længde / 2), this.brede + 75, this.længde + "cm");
            this.svg.text(75, this.brede / 2, this.brede + "cm");


            //striped-lines
            this.svg.addLine(55 + ((this.længde / this.stolper) * 1), 35, 55 + ((this.længde / this.stolper) * (this.stolper)), this.brede - 32);
            this.svg.addLine(55 + ((this.længde / this.stolper) * 1), this.brede - 38, 55 + ((this.længde / this.stolper) * (this.stolper)), 38);

            //arrow-lines
            this.svg.addLine1(100, 0, 100, this.brede);
            this.svg.addLine1(150, this.brede + 30, this.længde + 155, this.brede + 30);

            this.svg.addArrowsEnd("endArrow", 10, 10, 12, 6);
            this.svg.addArrowsStart("beginArrow", 10, 10, 0, 6);
        }

    }

    public SVG getSvg()
    {
        return svg;
    }
}
