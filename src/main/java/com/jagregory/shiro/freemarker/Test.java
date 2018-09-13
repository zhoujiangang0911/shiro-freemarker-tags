package com.jagregory.shiro.freemarker;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhoujg77
 * Time: 2018/9/13 12:02
 * Email: zhoqjg77@163.com
 */
public class Test {
    private  static  Ball[] ball = {
            new Ball("red","iron",15,1),
            new Ball("red","iron",26,2),
            new Ball("or","iron",25,3),
            new Ball("ye","iron",18,4),
            new Ball("ye","iron",13,5),
            new Ball("blue","iron",33,6),
            new Ball("red","wood",31,7),
            new Ball("red","wood",36,8),
            new Ball("or","wood",11,9),
            new Ball("or","wood",25,10),
            new Ball("ye","wood",7,11),
            new Ball("ye","wood",18,12),
            new Ball("blue","wood",10,13),
            new Ball("red","glass",3,14),
            new Ball("or","glass",21,15),
            new Ball("or","glass",16,16),
            new Ball("ye","glass",45,17),
            new Ball("ye","glass",29,18),
            new Ball("blue","glass",3,19),
            new Ball("blue","glass",7,20)
    };

    public static void main(String[] args) {
        int[][] init = new int[7][3];
        int [][] max = getMaxWeight(init,ball);
        int num=0;
        String ids="";

        for (int i = 0; i <max.length ; i++) {
            for (int j = 0; j <max[i].length ;j++) {
                ids+=max[i][j]+",";
            }
        }
        String ss[] =ids.split(",");
        String sss = "";
        for (Ball b :ball){
            sss+= b.getId()+",";
        }
        String all[] =sss.split(",");
        String[] we = substract(all,ss);
        Ball[] b =new Ball[we.length];
        for (int i = 0; i <b.length ; i++) {
            b[i]=getball(Integer.valueOf(we[i]));
        }
        int [][]max2 =getWeight(init,b);
        for (int i = 0; i <max2.length ; i++) {
            for (int j = 0; j <max2[i].length ;j++) {
                System.out.print(max2[i][j]+",");
            }
            System.out.println();
        }
    }
    public static  class Ball{
        private int id;
        private String color;
        private  int weight;
        private  String material;

        public Ball(String color, String material,int weight,int id) {
            this.color = color;
            this.weight = weight;
            this.material = material;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }
    }


    public static String[] substract(String[] arr1, String[] arr2) {
        LinkedList<String> list = new LinkedList<String>();
        for (String str : arr1) {
            if(!list.contains(str)) {
                list.add(str);
            }
        }
        for (String str : arr2) {
            if (list.contains(str)) {
                list.remove(str);
            }
        }
        String[] result = {};
        return list.toArray(result);
    }

    public  static int[][] getWeight(int[][] max ,Ball[] balls){

        /*
            0 red
            1 or
            2 ye
            3 blue
            4 iron
            5 wood
            6 glass
         */
        for (int i = 0; i <balls.length ; i++) {
            if(balls[i].getMaterial().equals("iron")){
                if(max[4][2]!=0){
                    getmin(max,0,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[4][redindex]==0){
                        max[4][redindex] = balls[i].getId();
                        break;
                    }
                }
            }
            if(balls[i].getMaterial().equals("wood")){
                if(max[5][2]!=0){
                    getmin(max,1,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[5][redindex]==0){
                        max[5][redindex] = balls[i].getId();
                        break;
                    }
                }
            }
            if(balls[i].getMaterial().equals("glass")){
                if(max[6][2]!=0){
                    getmin(max,2,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[6][redindex]==0){
                        max[6][redindex] = balls[i].getId();
                        break;
                    }
                }
            }

        }

        return max;
    }



    public  static int[][] getMaxWeight(int[][] max,Ball[] balls){
        /*
            0 red
            1 or
            2 ye
            3 blue
            4 iron
            5 wood
            6 glass
         */
        for (int i = 0; i <balls.length ; i++) {
            if(balls[i].getColor().equals("red")){
                if(max[0][2]!=0){
                    getmin(max,0,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[0][redindex]==0){
                        max[0][redindex] = balls[i].getId();
                        break;
                    }
                }
            }
            if(balls[i].getColor().equals("or")){
                if(max[1][2]!=0){
                    getmin(max,1,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[1][redindex]==0){
                        max[1][redindex] = balls[i].getId();
                        break;
                    }
                }
            }
            if(balls[i].getColor().equals("ye")){
                if(max[2][2]!=0){
                    getmin(max,2,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[2][redindex]==0){
                        max[2][redindex] = balls[i].getId();
                        break;
                    }
                }
            }
            if(balls[i].getColor().equals("blue")){
                if(max[3][2]!=0){
                    getmin(max,3,balls[i]);
                }
                for(int redindex = 0;redindex<max[0].length;redindex++){
                    if(max[3][redindex]==0){
                        max[3][redindex] = balls[i].getId();
                        break;
                    }
                }
            }
        }

        return max;
    }
    public static int[][] getmin(int [][] all,int num, Ball ball){
        int index = 0;
        boolean flag = false;
        int temp = ball.getWeight();
        for (int i = 0; i <all[num].length ; i++) {
            if(getweight(all[num][i])<temp){
                index = i;
                temp = getweight(all[num][i]);
                flag = true;
            }
        }

        if(flag){
            all[num][index]=ball.getId();
        }
        return all;
    }

    public static Ball getball(int id){
        for (Ball b :ball){
            if(id==b.getId()){
                return b;
            }
        }
        return null;
    }
    public static int getweight(int id){
        for (Ball b :ball){
            if(id==b.getId()){
                return b.getWeight();
            }
        }
        return 0;
    }
}
