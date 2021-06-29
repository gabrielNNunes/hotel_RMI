package hotel;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import hotel.Quarto;


public class HotelServer extends UnicastRemoteObject implements Hotel{
	
	public HotelServer() throws RemoteException{
		super();
	}
	public static void main(String[] args) {

		try {
			LocateRegistry.createRegistry(2335);
			HotelServer f = new HotelServer();
			Naming.rebind("//localhost:2335/hotel", f);
			System.out.println("Servidor hotel pronto.");
		}
		catch (RemoteException re) {
			System.out.println(" Exception in " + re);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		
		
		for(int i=0;i<10;i++){			
			Quarto qt = new Quarto(quartoTipo0.getNomeHospede(), quartoTipo0.getStatus(), quartoTipo0.getTipo(), quartoTipo0.getPreco());
			listaQuartosTipo0.add(qt);
		}
		for(int i=0;i<20;i++){
			Quarto qt = new Quarto(quartoTipo1.getNomeHospede(), quartoTipo1.getStatus(), quartoTipo1.getTipo(), quartoTipo1.getPreco());
			listaQuartosTipo1.add(qt);
		}
		for(int i=0;i<5;i++){
			Quarto qt = new Quarto(quartoTipo2.getNomeHospede(), quartoTipo2.getStatus(), quartoTipo2.getTipo(), quartoTipo2.getPreco());
			listaQuartosTipo2.add(qt);
		}
		for(int i=0;i<3;i++){
			Quarto qt = new Quarto(quartoTipo3.getNomeHospede(), quartoTipo3.getStatus(), quartoTipo3.getTipo(), quartoTipo3.getPreco());
			listaQuartosTipo3.add(qt);
		}
		for(int i=0;i<2;i++){
			Quarto qt = new Quarto(quartoTipo4.getNomeHospede(), quartoTipo4.getStatus(), quartoTipo4.getTipo(), quartoTipo4.getPreco());
			listaQuartosTipo4.add(qt);	
		}
				
		
			
		
	}
	@Override
	public int getPreco(int tipo) throws RemoteException {
		
		switch (tipo) {
		case 0:
			System.out.println("Preço do quarto tipo 0: "+quartoTipo0.getPreco());
			return quartoTipo0.getPreco();
		case 1:
			System.out.println("Preço do quarto tipo 1: "+quartoTipo1.getPreco());
			return quartoTipo1.getPreco();
		case 2:
			System.out.println("Preço do quarto tipo 2: "+quartoTipo2.getPreco());
			return quartoTipo2.getPreco();
		case 3:
			System.out.println("Preço do quarto tipo 3: "+quartoTipo3.getPreco());
			return quartoTipo3.getPreco();
		case 4:
			System.out.println("Preço do quarto tipo 4: "+quartoTipo4.getPreco());
			return quartoTipo4.getPreco();
		
		}
		return 0;
	}
	@Override
	public boolean alugar(int tipo, String nome) throws RemoteException {
			boolean testeAluguel = false;
			
		if(getDisponibilidade(tipo)>0) {
			ArrayList<Quarto> lista = retornaListTipo(tipo);
			System.out.println("");
			
			
			for (int i = 0; i < lista.size() && testeAluguel == false; i++) {
				Quarto quarto = lista.get(i);
				if(quarto.getStatus()==false){
					System.out.println("Alugando quarto do tipo "+tipo+" para "+nome);
					quarto.setStatus(true);
					quarto.setNomeHospede(nome);
					testeAluguel =  true;
				}
			}
			
		} 
		 
		return testeAluguel;
		
	}
	@Override
	public ArrayList<String> retornaHospedes() throws RemoteException {		
		ArrayList<String> listaHospedes = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			ArrayList<Quarto> lista = retornaListTipo(i);
			
			for (int j = 0; j < lista.size(); j++) {
				Quarto quarto = lista.get(j);
				if(quarto.getStatus()==true) {
					System.out.println("Hóspede: "+quarto.getNomeHospede()+" | Tipo do Quarto: "+quarto.getTipo()+" | Preço: "+quarto.getPreco());
					 listaHospedes.add("Hóspede: "+quarto.getNomeHospede()+" | Tipo do Quarto: "+quarto.getTipo()+" | Preço: "+quarto.getPreco());
				}
			}
		}	
		
		return listaHospedes;
		
	}
	@Override
	public int getDisponibilidade(int tipo) throws RemoteException {
		
		ArrayList<Quarto> lista = retornaListTipo(tipo);
		int cont=0;
		
		for(int i=0;i<lista.size();i++) {
			
			if(lista.get(i).getStatus()== false){
				cont++;
				
				
			}
		}
		System.out.println("disponibilidade: "+cont+" Tipo: "+tipo);
		return cont;
	}
	@Override
	public ArrayList<Quarto> retornaListTipo(int tipo) throws RemoteException {
		System.out.println("");
		switch (tipo) {
		case 0:
			System.out.println("retorno lista tipo 0");
			return listaQuartosTipo0;					
		case 1:
			System.out.println("retorno lista tipo 1");
			return listaQuartosTipo1;
		case 2:
			System.out.println("retorno lista tipo 2");
			return listaQuartosTipo2;
		case 3:
			System.out.println("retorno lista tipo 3");
			return listaQuartosTipo3;
		case 4:
			System.out.println("retorno lista tipo 4");
			return listaQuartosTipo4;
		
		}
		return null;
	}
	
	
	
	
	
	

	//.getNomeHospede());
	//.getStatus());
	//.getTipo());
	//.getPreco()


}
