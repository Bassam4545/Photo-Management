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




















/*

//------------------------------------------------------------------------------------------------------------
//!!INVERTED INDEX ALBUM!!
public class Album_inverted_index {
  String name;
  String condition;
  InvIndexPhotoManager manager;

  // Constructor
  public Album_inverted_index(String name, String condition, InvIndexPhotoManager manager) {
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
  public InvIndexPhotoManager getManager() {
      return manager;
  }

  public boolean Photo_Exist(LinkedList<Photo> L, Photo p) {
      if (L.empty()) return false;
      L.findFirst();
      while (!L.last()) {
          if (L.retrieve().path.equals(p.path)) {
              return true;
          }
          L.findNext();
      }
      if (L.retrieve().path.equals(p.path)) {
          return true;
      }
      return false;
  }

  public LinkedList<Photo> getTagPhotos(String tag) {
      LinkedList<Photo> res = new LinkedList<Photo>();
      boolean found = manager.getPhotos().findKey1(tag);
      if (found) {
          res = manager.getPhotos().retrieve();
      }
      return res;
  }

  public LinkedList<Photo> And(LinkedList<Photo> A, LinkedList<Photo> B) {
      LinkedList<Photo> result = new LinkedList<Photo>();
      if (A.empty() || B.empty()) return result;
      A.findFirst();
      while (true) {
          boolean found = Photo_Exist(result, A.retrieve());
          if (!found) { // not found in result
              B.findFirst();
              while (true) {
                  if (B.retrieve().path.equals(A.retrieve().path)) {
                      result.insert(A.retrieve());
                      break;
                  }
                  if (!B.last())
                      B.findNext();
                  else
                      break;
              }
          }
          if (!A.last())
              A.findNext();
          else
              break;
      }
      return result;
  }

  // Return all photos that satisfy the album condition
  public LinkedList<Photo> getPhotos() {
      LinkedList<Photo> res = new LinkedList<Photo>();
      if (condition == null) return res;
      if (condition.equals("")) return manager.allPhotos;
      String a[] = condition.split("AND");
      for (int i = 0; i < a.length; i++) {
          a[i] = a[i].trim();
      }
      LinkedList<Photo> A = getTagPhotos(a[0]);
      for (int i = 1; i < a.length; i++) {
          System.out.println("a[i]=" + a[i]);
          LinkedList<Photo> B = getTagPhotos(a[i]);
          A = And(A, B);
      }
      return A;
  }

  // Return the number of tag comparisons used to find all photos of the album
  public int getNbComps() {
      return manager.index.num_comp;
  }
  
  */

