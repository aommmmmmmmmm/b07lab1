import java.io.BufferedReader;
import java.io.FileReader;

public class Polynomial {
    double[] coefs;
    int[] expos;
	
	//methods
    public Polynomial(){
        this.coefs = new double[0];
		this.expos = new int[0];
    }

    public Polynomial(double[] a, int[] b){
        coefs = a;
		expos = b;
    }

//
    public Polynomial add(Polynomial a){
		if(coefs.length == 0) return a;
		if(a.coefs.length == 0) return this;
		int alen = a.expos.length;
		int plen = this.expos.length;
		int[] tempe = new int[alen + plen];
		double[] tempc = new double[alen + plen];
		System.arraycopy(this.expos, 0, tempe, 0, plen);
		System.arraycopy(this.coefs, 0, tempc, 0, plen);
        for(int i = 0; i < plen; i++){
            for(int j = 0; j < alen; j++){
				if(a.expos[j] == this.expos[i]){
					tempc[i] += a.coefs[j];
				}
			}
        }
		int k = 0;
        int j = 0;
        for(int i = 0; i < alen; i++){
            for(j = 0; j < plen; j++){
				if(a.expos[i] == tempe[j]){
					break;
				}
			}
			if(a.expos[i] == tempe[j]){
				continue;
			}
			tempe[plen+k] = a.expos[i];
			tempc[plen+k] = a.coefs[i];
			k++;
        }
		int[] e = new int[plen+k];
		double[] c = new double[plen+k];
		System.arraycopy(tempe, 0, e, 0, plen+k);
		System.arraycopy(tempc, 0, c, 0, k+plen);		
        return new Polynomial(c, e);
    }

//
    public Polynomial multiply(Polynomial m){
		int len1 = m.coefs.length;
		int len2 = this.coefs.length;
		Polynomial p = new Polynomial();	
        for(int i = 0; i < len1; i++){	
            double[] c = new double[len2];
            int[] e = new int[len2];		
            for(int j = 0; j < len2; j++){
				c[j] = m.coefs[i] * this.coefs[j];
				e[j] = this.expos[j] + m.expos[i];
			}   
			Polynomial a = new Polynomial(c, e);
			p = a.add(p);
         
        }
		return p;
	}

    public double evaluate(double x){
        double result = 0;
        for(int i = 0; i < expos.length; i++){
            result += coefs[i] * Math.pow(x, expos[i]);
        }
        return result;
    }

    public boolean hasRoot(double x){
        double result = this.evaluate(x);
        return result == 0;
    }
	
	public Polynomial(File file) throws Exception{
		BufferedReader input = new BufferedReader(new FileReader(file));
		String line = input.readLine();
		input.close();
		String[] s = line.split("");
		
	}
}