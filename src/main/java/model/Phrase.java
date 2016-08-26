package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Dyakira on 2016/8/26.
 */
@XStreamAlias("Phrase")
public class Phrase
{
    @XStreamAlias("Eng")
    private String eng;

    @XStreamAlias("Phonetic")
    private String phonetic;

    @XStreamAlias("Defi")
    private String defi;

    @XStreamAlias("Date")
    private String date;

    @XStreamAlias("Note")
    private String note;

    public String getEng()
    {
        return eng;
    }

    public void setEng(String eng)
    {
        this.eng = eng;
    }

    public String getPhonetic()
    {
        return phonetic;
    }

    public void setPhonetic(String phonetic)
    {
        this.phonetic = phonetic;
    }

    public String getDefi()
    {
        return defi;
    }

    public void setDefi(String defi)
    {
        this.defi = defi;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
}
