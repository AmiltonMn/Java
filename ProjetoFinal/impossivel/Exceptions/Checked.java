package impossivel.Exceptions;

public class Checked extends Exception 
{
    String title;

    public Checked(String title)
    {
        this.title = title;
    }
}
