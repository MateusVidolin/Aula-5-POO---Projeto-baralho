import java.util.*;

public class Baralho {
   public Baralho(){
        montar();
        embaralhar();
        vinteUm();
    }
    Random numeroAleatorio = new Random();
    private List<Carta> cartas = new ArrayList();


    public void montar() {
        System.out.println(" ****Baralho Montado*** ");
        for (Valor i : Valor.values()) {
            for (Naipe j : Naipe.values()) {
                Carta cartaAtual = new Carta();
                cartaAtual.setValor(i);
                cartaAtual.setNaipe(j);
                cartas.add(cartaAtual);
            }
        }
        exibir();
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
        System.out.println("\n\n ***Baralho Embaralhado*** ");
        exibir();
    }

    public void exibir() {
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println(cartas.get(i));
        }
    }

    public void vinteUm() {
        int pontosAcumuladosJogador = 0;
        int pontosAcumuladosComputdor = 0;
        String teste;
        Carta cartaAtual;
        String opcao;
        Scanner sc = new Scanner(System.in);
        System.out.println(" *** Jogo Vinte Um *** ");
        System.out.println("\n");
        while (true) {
            System.out.println(" Pontuacao atual ");
            System.out.println(" Jogador: " + pontosAcumuladosJogador);
            System.out.println(" Computador: " + pontosAcumuladosComputdor);
            System.out.println(" Para comprar uma carta digite C, para parar digite P: ");
            opcao = sc.nextLine();
            opcao = opcao.toUpperCase();
            if (opcao.equals("C")) {
                cartaAtual = cartas.get(numeroAleatorio.nextInt(52));
                teste = String.valueOf(cartaAtual.getValor());
                pontosAcumuladosJogador += verificaValor(teste);
                if (pontosAcumuladosJogador > 21) {
                    System.out.println(" Perdeu!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                    break;
                } else if (pontosAcumuladosComputdor <= pontosAcumuladosJogador) {
                    cartaAtual = cartas.get(numeroAleatorio.nextInt(52));
                    teste = String.valueOf(cartaAtual.getValor());
                    pontosAcumuladosComputdor += verificaValor(teste);
                    if (pontosAcumuladosComputdor > 21) {
                        System.out.println(" Voce ganhou!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                        break;
                    }
                } else {
                    if (pontosAcumuladosComputdor < pontosAcumuladosJogador) {
                        cartaAtual = cartas.get(numeroAleatorio.nextInt(52));
                        teste = String.valueOf(cartaAtual.getValor());
                        pontosAcumuladosComputdor += verificaValor(teste);
                        if (pontosAcumuladosComputdor > 21) {
                            System.out.println(" Voce ganhou!!!, o total de pontos acumulados do computador foi: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                            break;
                        } else if (pontosAcumuladosComputdor > pontosAcumuladosJogador) {
                            System.out.println(" Voce perdeu!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                            break;
                        } else {
                            System.out.println(" Empate!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                            break;
                        }
                    }
                }

            }else{
                if (pontosAcumuladosComputdor < pontosAcumuladosJogador) {
                    cartaAtual = cartas.get(numeroAleatorio.nextInt(52));
                    teste = String.valueOf(cartaAtual.getValor());
                    pontosAcumuladosComputdor += verificaValor(teste);
                    if (pontosAcumuladosComputdor > 21) {
                        System.out.println(" Voce ganhou!!!, o total de pontos acumulados do computador foi: " + pontosAcumuladosComputdor);
                        break;
                    } else if (pontosAcumuladosComputdor > pontosAcumuladosJogador) {
                        System.out.println(" Voce perdeu!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                        break;
                    }else if (pontosAcumuladosComputdor < pontosAcumuladosJogador) {
                        System.out.println(" Voce perdeu!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                        break;
                    }
                    else {
                        System.out.println(" Empate!!!, o total de pontos acumulados do computador: " + pontosAcumuladosComputdor + " Total de pontos acumulados do jogador: " + pontosAcumuladosJogador);
                        break;
                    }
                }

            }


        }
    }

    public int verificaValor(String teste) {
        return switch (teste) {
            case "As" -> 1;
            case "Dois" -> 2;
            case "Tres" -> 3;
            case "Quatro" -> 4;
            case "Cinco" -> 5;
            case "Seis" -> 6;
            case "Sete" -> 7;
            case "Oito" -> 8;
            case "Nove" -> 9;
            case "Dez" -> 10;
            case "Dama" -> 11;
            case "Valete" -> 12;
            case "Reis" -> 13;
            default -> 0;
        };
    }
}

