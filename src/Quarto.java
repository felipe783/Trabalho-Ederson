public class Quarto {
     int ID;
     String tipo;
     double preco;
     int entrada;
     int saida;
    public Quarto(int ID, String tipo, double preco,int entrada,int saida) {
        this.ID = ID;
        this.tipo = tipo;
        this.preco = preco;
        this.entrada = entrada;
        this.saida = saida;
    }

    public int getID(){
        return ID;
    }

    public String getTipo(){
        return tipo;
    }

    public int getEntrada(){
        return entrada;
    }

    public int getSaida(){
        return saida;
    }

   public double calculo(int entrada, int saida, int quarto){
        double valorTotal;
       int dias = saida - entrada;
       switch(quarto){
           case 1:
               valorTotal = dias * 119.90;
               return valorTotal;
           case 2:
               valorTotal =  dias * 349.90;
               return valorTotal;
           case 3:
               valorTotal =  dias * 689.90;
               return valorTotal;
           case 4:
               valorTotal =  dias * 1245.90;
               return valorTotal;
           default:
               return 0;
       }
   }
}
