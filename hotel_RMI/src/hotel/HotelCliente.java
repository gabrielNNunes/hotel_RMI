package hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelCliente {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);	
		Hotel hotel;
		try {
		hotel = (Hotel) Naming.lookup("rmi://localhost:2335/hotel");	
		
		boolean rodando = true;
		
		do {		
		
			System.out.println(""
					+ hotel.getDisponibilidade(0)+" quartos do tipo 0 estão disponíveis por "+hotel.getPreco(0)+" euros por noite \r\n"
					+ hotel.getDisponibilidade(1)+" quartos do tipo 1 estão disponíveis por "+hotel.getPreco(1)+" euros por noite \r\n"
					+ hotel.getDisponibilidade(2)+" quartos do tipo 2 estão disponíveis por "+hotel.getPreco(2)+" euros por noite \r\n"
					+ hotel.getDisponibilidade(3)+" quartos do tipo 3 estão disponíveis por "+hotel.getPreco(3)+" euros por noite \r\n"
					+ hotel.getDisponibilidade(4)+" quartos do tipo 4 estão disponíveis por "+hotel.getPreco(4)+" euros por noite \r\n");
		
			System.out.println("Escolha uma opção: \r\n"
					+ "0 => Alugar quarto tipo 0 \r\n"
					+ "1 => Alugar quarto tipo 1 \r\n"
					+ "2 => Alugar quarto tipo 2 \r\n"
					+ "3 => Alugar quarto tipo 3 \r\n"
					+ "4 => Alugar quarto tipo 4 \r\n"
					+ "5 => Listar Hospedes \r\n"
					+ "6 => Sair \r\n");
		
			int opcao = sc.nextInt();
		
			if(opcao >= 0 && opcao <= 4){
				int tipoQuarto = opcao;
				
				System.out.println("Digite o nome do hóspede!");
				String nomeHospede = sc.next();
		
				boolean testeAluga = hotel.alugar(tipoQuarto, nomeHospede);
		
				if(testeAluga == true){
					System.out.println("Quarto do tipo "+tipoQuarto+" alugado com sucesso!\n");
				}else {
					System.out.println("Não foi possível alugar o quarto do tipo "+tipoQuarto+"!");
				}
			}else if(opcao == 5){
				ArrayList<String> listaHospedes = hotel.retornaHospedes();
				if(listaHospedes.size()>0) {
					for (int i = 0; i < listaHospedes.size(); i++) {			
						System.out.println(listaHospedes.get(i));
					}
					System.out.println("");
				}else{
					System.out.println("Não há nenhum hóspede!\n");
				}
			}else if(opcao == 6){
				rodando = false;
			}
		
		} while (rodando);
			
	
		}
		catch(MalformedURLException e) {
		System.out.println( "nao eh um URI RMI valida");
		}
		catch(RemoteException re) {
		System.err.println("Objeto Remoto tratou a execucao " + re);
		}
		catch(NotBoundException e) {
		System.out.println( "Nao foi possivel achar o objeto remoto no servidor");
		}
		sc.close();
		}
}
