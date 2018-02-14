package example.imrozquazi.cover_flow;

/**
 * Created by Imroz Quazi on 26-01-2018.
 */

public class Event {

    private String Name , Pathofimage;


    public Event(String name , String path)
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
