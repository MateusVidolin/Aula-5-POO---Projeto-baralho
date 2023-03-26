import java.util.ArrayList;
import java.util.List;

public class Baralho {
     private List<Carta> cartas = new ArrayList<>();
    Carta carta = new Carta();


    public void montar(){
        System.out.println("cartas = " + cartas.size());
        for (Valor i: Valor.values())
        {
            for (Naipe j: Naipe.values())
            {
                carta.setValor(i);
                carta.setNaipe(j);
                cartas.add(carta);
            }
        }
        System.out.println("cartas pos 10 = " + cartas.get(10));
    exibir();
    }
    public void embaralhar(){

    }
    public void exibir(){
        System.out.println("cartas. = " + cartas.size());
            for(int i=0; i < cartas.size(); i++) {
                System.out.println(cartas.get(i));
            }
    }

}
