package example.imrozquazi.cover_flow;

/**
 * Created by Imroz Quazi on 07-03-2018.
 */

public class IT_EVENT_1 {

    private String Name , Pathofimage;


    public IT_EVENT_1(String name , String path)
    {
        Name = name;

        Pathofimage = path;


    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPathofimage() {
        return Pathofimage;
    }

    public void setPathofimage(String pathofimage) {
        Pathofimage = pathofimage;
    }
}
