package core;

import com.itextpdf.text.DocumentException;
import model.Phrases;
import utils.PdfUtil;
import utils.XStreamUtil;

import java.io.IOException;


/**
 * Created by Dyakira on 2016/8/26
 */
public class ConvertToPdf
{
    public static void main(String[] args) throws IOException, DocumentException
    {
        Phrases phrases = XStreamUtil.toBean("C:\\word.xml", Phrases.class);
        new PdfUtil().createPdf("C:\\word.pdf", phrases);
    }
}
