package data.models;

public class Officer {
   private String id;
   private String name;
   private String rank;

public Officer(){}

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }






//    private String generateId(){
//        String id;
//        do {
//            int number = random.nextInt(Integer.MAX_VALUE);
//            id = "Ofc" + number;
//        } while (usedIds.contains(id));
//        usedIds.add(id);
//        return id;
//    }
}
