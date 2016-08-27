package utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import model.Phrase;
import model.Phrases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class PdfUtil
{
    public static final Rectangle[] COLUMNS = {
            new Rectangle(36, 36, 290, 806),
            new Rectangle(305, 36, 559, 806)
    };

    public static void createPdf(String outPath, Phrases phrases) throws IOException, DocumentException
    {
        File file = new File(outPath);
        file.getParentFile().mkdirs();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outPath));
        document.open();
        PdfContentByte canvas = writer.getDirectContent();
        ColumnText ct = new ColumnText(canvas);
        int side_of_the_page = 0;
        ct.setSimpleColumn(COLUMNS[side_of_the_page]);
        int size = phrases.getPhrases().size();
        int paragraphs = 0;
        while (size > 0 && paragraphs < size)
        {
            Phrase phrase = phrases.getPhrases().get(paragraphs);
            //中文编码
            Font bf = new Font(BaseFont.createFont( "STSong-Light", "UniGB-UCS2-H",  BaseFont.EMBEDDED));
            Font fontChinese = new Font(bf);
            ct.addElement(new com.itextpdf.text.Phrase(phrase.getEng()));
            ct.addElement(new Paragraph(String.format("%s",phrase.getDefi()
            ), fontChinese));
            paragraphs++;
            while (ColumnText.hasMoreText(ct.go()))
            {
                if (side_of_the_page == 0)
                {
                    side_of_the_page = 1;
                    canvas.moveTo(297.5f, 36);
                    canvas.lineTo(297.5f, 806);
                    canvas.stroke();
                } else
                {
                    side_of_the_page = 0;
                    document.newPage();
                }
                ct.setSimpleColumn(COLUMNS[side_of_the_page]);
            }
        }
        document.close();
    }
}
