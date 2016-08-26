package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by Dyakira on 2016/8/26.
 */
@XStreamAlias("Phrases")
public class Phrases
{
    @XStreamImplicit
    private List<Phrase> phrases;

    public List<Phrase> getPhrases()
    {
        return phrases;
    }

    public void setPhrase(List<Phrase> phrases)
    {
        this.phrases = phrases;
    }
}
