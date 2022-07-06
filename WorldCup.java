public class WorldCup {
    public static void main(String[] args) {
        India IND = new India("MS Dhoni", "Suresh Raina", "Yuvraj Singh");
        IND.display();
  
        England ENG = new England("Joe Root", "Jos Butler", "Ben Stokes");
        ENG.display();
  
        Australia AUS = new Australia("Steve Smith", "David Warner", "Glenn Maxwell");
        AUS.display();
    }
}

class Team {
    String name;
    String plyr1, plyr2, plyr3;

    public void display() {
        System.out.println("");
        System.out.println("Team "+ this.name);
        System.out.println("Player1: " + this.plyr1);
        System.out.println("Player2: " + this.plyr3);
        System.out.println("Player3: " + this.plyr2);
        System.out.println("...");
        System.out.println("");
    }
}

class India extends Team {
    India(String p1, String p2, String p3) {
        this.name = "India";
        this.plyr1 = p1;
        this.plyr2 = p2;
        this.plyr3 = p3;
    }
}

class England extends Team {
    England(String p1, String p2, String p3) {
        this.name = "England";
        this.plyr1 = p1;
        this.plyr2 = p2;
        this.plyr3 = p3;
    }
}

class Australia extends Team {
    Australia(String p1, String p2, String p3) {
        this.name = "Australia";
        this.plyr1 = p1;
        this.plyr2 = p2;
        this.plyr3 = p3;
    }
}
