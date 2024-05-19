public class Polynomial {
    private double[] coefs;
    private int deg;

    public  Polynomial(){
        deg = 0;
        double [] c = {0};
        coefs = c;
    }

    public  Polynomial(double[] a){
        deg = a.length - 1;
        coefs = a;
    }

    public Polynomial add(Polynomial a){
        int d = Math.max(this.deg, a.deg);
        double[] c = new double[d + 1];
        for(int i = 0; i < this.deg; i++){
            c[i] += this.coefs[i];
        }
        for(int i = 0; i < a.deg; i++){
            c[i] += a.coefs[i];
        }
        return new Polynomial(c);
    }

    public double evaluate(double x){
        double result = 0;
        for(int i = 0; i < this.deg; i++){
            result += coefs[i] * Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double x){
        double result = this.evaluate(x);
        return result == 0;
    }
        
}