package MuhammadAsadMuyassir.jwork.enumeration;

/**
 * Enumeration JobCategory adalah class yang digunakan sebagai enumerasi kategori pekerjaan
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

    /**
     * Metode untuk mendapatkan enum dalam bentuk string
     * @return  string dari enum
     */
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
                return "Development and Operations";
            case DataScientist:
                return "Data Scientist";
            case DataAnalyst:
                return "Data Analyst";
            default:
                return "Wrong Category";
        }
    }
}