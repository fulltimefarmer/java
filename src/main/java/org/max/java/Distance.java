package org.max.java;

/**
 * @description:
 * @author: Max Zhou
 * @create: 2020-09-24 16-06
 */
public class Distance {

    private Integer dist;

    public Distance(String dist) {
        // n s e w
        switch (dist) {
            case "n":
                this.dist = 0;
                break;
            case "e":
                this.dist = 1;
            case "s":
                this.dist = 2;
            case "w":
                this.dist = 3;
            default:
                this.dist = 0;
        }
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public void turnRight(){
        if(this.dist == 3){
            this.dist = 0;
        } else {
            this.dist += 1;
        }
        String displayDis = transferDist(this.dist);
        System.out.println(displayDis);
    }

    private String transferDist(Integer dist) {
        String result = "";
        if(dist == 0){
            result = "n";
        } else if(dist == 1){
            result = "e";
        } else if(dist == 2){
            result = "s";
        } else if(dist == 3){
            result = "w";
        }
        return result;
    }
//turn right
    //2020 09 Max r
    public void turnLeft(){
        if(this.dist == 0){
            this.dist = 3;
        } else {
            this.dist -= 1;
        }
        String displayDis = transferDist(this.dist);
        System.out.println(displayDis);
    }

    public static void main(String[] args) {
        Distance d = new Distance("s");
        d.turnLeft();
        // turnn 45



        d.turnLeft();
        d.turnLeft();
        d.turnLeft();
        d.turnRight();
        d.turnRight();
        d.turnRight();
        d.turnRight();
    }


}
