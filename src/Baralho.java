import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
    Random numeroAleatorio = new Random();
     private List<Carta> cartas = new ArrayList();
    //Carta carta = new Carta();


    public void montar(){
        System.out.println(" ****Baralho Montado*** ");
        for (Valor i: Valor.values())
        {
            for (Naipe j: Naipe.values())
            {   Carta cartaAtual = new Carta();
                cartaAtual.setValor(i);
                cartaAtual.setNaipe(j);
                cartas.add(cartaAtual);
            }
        }
    exibir();
    }
    public void embaralhar(){
        Carta auxTrocaCartas = null;
        int posTroca=0;
        for(int i=0; i<52; i++){
            auxTrocaCartas = cartas.get(i);
            posTroca = numeroAleatorio.nextInt(52);
            cartas.set(i, cartas.get(posTroca));
            cartas.set(posTroca, auxTrocaCartas);
        }
        System.out.println("\n\n ***Baralho Embaralhado*** ");
        exibir();
    }
    public void exibir(){
            for(int i=0; i < cartas.size(); i++) {
                System.out.println(cartas.get(i));
            }
    }

}
