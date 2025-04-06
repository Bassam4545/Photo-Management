package PhotoManagement;

public class Photo {
    String path;
    LinkedList<String> tags;

    // Constructor
    public Photo(String path, LinkedList<String> tags) {
        this.path = path;
        this.tags = tags;
    }

    // Return the path (full file name) of the photo
    public String getPath() {
        return path;
    }

    // Return all tags associated with the photo[All names]
    public LinkedList<String> getTags() {
        return tags;
    }






    public void displayPhoto() {
        System.out.println("path=" + path);
        System.out.print("tags is: ");
        tags.display();
    }









}
