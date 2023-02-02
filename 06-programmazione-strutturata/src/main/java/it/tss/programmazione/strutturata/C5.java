/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.programmazione.strutturata;

/**
 *
 * @author ospite
 */
public class C5 {

    private String x0, x1, x2, x3, x4, x5, x6, x7, x8, x9;
    private int n1, n2;

    private C5(Builder b) {
       this.x0 = b.x0;
       this.x1 = b.x1;
       this.x2 = b.x2;
       this.x3 = b.x3;
       this.x4 = b.x4;
       this.x5 = b.x5;
       this.x6 = b.x6;
       this.x7 = b.x7;
       this.x8 = b.x8;
       this.x9 = b.x9;
       this.n1 = b.n1;
       this.n2 = b.n2;       
    }

    public String getX0() {
        return x0;
    }

    public String getX1() {
        return x1;
    }

    public String getX2() {
        return x2;
    }

    public String getX3() {
        return x3;
    }

    public String getX4() {
        return x4;
    }

    public String getX5() {
        return x5;
    }

    public String getX6() {
        return x6;
    }

    public String getX7() {
        return x7;
    }

    public String getX8() {
        return x8;
    }

    public String getX9() {
        return x9;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    @Override
    public String toString() {
        return "C5{" + "x0=" + x0 + ", x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + ", x5=" + x5 + ", x6=" + x6 + ", x7=" + x7 + ", x8=" + x8 + ", x9=" + x9 + ", n1=" + n1 + ", n2=" + n2 + '}';
    }

    
    
    /**
     * Classe Builder, serve per costruire oggetti C5 in modo comodo
     * 
     */
    public static class Builder {

        private String x0, x1, x2, x3, x4, x5, x6, x7, x8, x9;
        private int n1, n2;

        public Builder(String x0, String x1) {
            this.x0 = x0;
            this.x1 = x1;
        }

        public Builder x2(String value) {
            this.x2 = value;
            return this;
        }

        public Builder x3(String value) {
            this.x3 = value;
            return this;
        }

        public Builder x4(String value) {
            this.x4 = value;
            return this;
        }

        public Builder x5(String value) {
            this.x5 = value;
            return this;
        }

        public Builder x6(String value) {
            this.x6 = value;
            return this;
        }

        public Builder x7(String value) {
            this.x7 = value;
            return this;
        }

        public Builder x8(String value) {
            this.x8 = value;
            return this;
        }

        public Builder x9(String value) {
            this.x9 = value;
            return this;
        }

        public Builder n1(int value) {
            this.n1 = value;
            return this;
        }

        public Builder n2(int value) {
            this.n2 = value;
            return this;
        }
        
        public C5 build(){
            return new C5(this);
        }
    }
    
    
}
