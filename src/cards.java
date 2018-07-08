public class cards {
    enum suit {
        HEARTS("hearts"), SPADES("spades"), DIAMONDS("diamonds"), CLUBS("clubs");

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
       private suit(String a)
       {this.type=a;}

       private  String type;

    }


}
