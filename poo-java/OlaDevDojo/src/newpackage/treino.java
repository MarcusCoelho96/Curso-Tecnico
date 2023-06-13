package newpackage;

import java.awt.BorderLayout;
import java.util.Scanner;


public class treino {
    
        public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        String[][] agenda = new String[12][];
        int escolha = 0;
        float media = 0;
        
        agenda[0] = new String[31];
        agenda[1] = new String[28];
        agenda[2] = new String[31];
        agenda[3] = new String[30];
        agenda[4] = new String[31];
        agenda[5] = new String[30];
        agenda[6] = new String[31];
        agenda[7] = new String[31];
        agenda[8] = new String[30];
        agenda[9] = new String[31];
        agenda[10] = new String[30];
        agenda[11] = new String[31];
        
        while(escolha != 99){
        
        System.out.println("\nEscolha uma opcao");
        System.out.println("1 - Vizualizar dias");
        System.out.println("99 - sair");
        System.out.println("Escolha: ");
        escolha = ler.nextInt();
        
            switch(escolha){
                case 1:
                    for(int i = 0; i < agenda.length; i++){
                        System.out.println("\nMes " + (i + 1));
                        for(int j = 0; j < agenda[i].length; j++){
                            System.out.println("dia "+ (j + 1) + " " + agenda[i][j]);
                        }   
                    }
                break;
                case 99:
                    System.out.println("Voce saiu!");
                break;
                default:
                    System.out.println("Inserir uma opcao valida...:");
            }
        }
    }
}
