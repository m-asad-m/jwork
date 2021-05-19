package MuhammadAsadMuyassir.jwork;

/**
 * Enumeration class JobCategory
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public enum JobCategory
{
    WebDeveloper,
    FrontEnd,
    UI,
    UX,
    Devops,
    DataScientist,
    DataAnalyst;
    
    public String toString()
    {
        switch (this)
        {
            case WebDeveloper:
                return "Web Developer";
            case FrontEnd:
                return "Front End";
            case UI:
                return "User Interface";
            case UX:
                return "User Experience";
            case Devops:
                return "Development and Operation";
            case DataScientist:
                return "Data Scientist";
            case DataAnalyst:
                return "Data Analyst";
            default:
                return "Wrong Category";
        }
    }
}