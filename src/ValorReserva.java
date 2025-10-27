public class ValorReserva {
        private int entrada;
        private int saida;
        private int quarto;
        public ValorReserva(int entrada, int saida, int quarto) {
            this.entrada = entrada;
            this.saida = saida;
            this.quarto = quarto;
        }
        public double calculo(int entrada, int saida, int quarto) {
            int dias = saida - entrada;
            switch(quarto){
                case 1:
                    return dias * 119.90;
                case 2:
                    return dias * 349.90;
                case 3:
                    return dias * 689.90;
                case 4:
                    return dias * 1245.90;
                default:
                    return 0;
            }
        }

}
