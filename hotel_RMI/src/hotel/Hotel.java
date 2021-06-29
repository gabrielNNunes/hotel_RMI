package hotel;

import java.rmi.*;
import java.util.ArrayList;

import hotel.Quarto;

public interface Hotel extends Remote {
			
	ArrayList<Quarto> listaQuartosTipo0 = new ArrayList<>();
	ArrayList<Quarto> listaQuartosTipo1 = new ArrayList<>();
	ArrayList<Quarto> listaQuartosTipo2 = new ArrayList<>();
	ArrayList<Quarto> listaQuartosTipo3 = new ArrayList<>();
	ArrayList<Quarto> listaQuartosTipo4 = new ArrayList<>();
	
	
	Quarto quartoTipo0 = new Quarto("", false, "Individual", 55);
	Quarto quartoTipo1 = new Quarto("", false, "Duplo", 75);
	Quarto quartoTipo2 = new Quarto("", false, "Duplo", 80);
	Quarto quartoTipo3 = new Quarto("", false, "Triplo", 150);
	Quarto quartoTipo4 = new Quarto("", false, "Quadruplo", 230);
	
		public int getPreco(int tipo) throws RemoteException;
		public boolean alugar(int tipo, String nome) throws RemoteException;
		public ArrayList<String> retornaHospedes() throws RemoteException;		
		public int getDisponibilidade (int tipo) throws RemoteException;
		public ArrayList<Quarto> retornaListTipo (int tipo) throws RemoteException;
}
	

