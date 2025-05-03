package PhotoManagement;
public class Album {
    String name;
    String condition;
    PhotoManager manager;
    int totalnbcomp = 0;

    // Constructor
    public Album(String name, String condition, PhotoManager manager) {
        this.name = name;
        this.condition = condition;
        this.manager = manager;
    }

    // Return the name of the album
    public String getName() {
        return name;
    }

    // Return the condition associated with the album
    public String getCondition() {
        return condition;
    }

    // Return the manager
    public PhotoManager getManager() {
        return manager;
    }

    public boolean Tag_Exist_in_photo(LinkedList<String> L, String tag) {
        if (L.empty()) return false;
        L.findFirst();
        while (!L.last()) {
            totalnbcomp++;
            if (L.retrieve().equals(tag)) {
                System.out.println(tag + " Exist, total num of comp=" + totalnbcomp);
                return true;
            }
            L.findNext();
        }
        totalnbcomp++;
        if (L.retrieve().equals(tag)) {
            System.out.println(tag + " Exist, totaal num of comp=" + totalnbcomp);
            return true;
        }
        System.out.println(tag + " Does not Exist, total num of comp=" + totalnbcomp);
        return false;
    }

    public boolean subset(String[] A, LinkedList<String> B) {
        if (A.length == 0) return true;
        if (B.empty()) return false;
        for (int i = 0; i < A.length; i++) {
            if (!Tag_Exist_in_photo(B, A[i])) {
                return false;
            }
        }
        return true;
    }

    // Return all photos that satisfy the album condition
    public LinkedList<Photo> getPhotos() {
        LinkedList<Photo> res = new LinkedList<Photo>();
        if (condition == null) return res;
        if (condition.equals("")) return manager.getPhotos();

        String[] a = condition.split("AND");
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i].trim();
        }

        LinkedList<Photo> allPhotos = manager.getPhotos();
        if (allPhotos.empty()) return res;

        allPhotos.findFirst();
        while (!allPhotos.last()) {
            if (subset(a, allPhotos.retrieve().getTags())) {
                res.insert(allPhotos.retrieve());
            }
            allPhotos.findNext();
        }

        if (subset(a, allPhotos.retrieve().getTags())) {
            res.insert(allPhotos.retrieve());
        }

        return res;
    }

    // Return the number of tag comparisons used to find all photos of the album
    public int getNbComps() {
        return totalnbcomp;
    }
}























  
  

