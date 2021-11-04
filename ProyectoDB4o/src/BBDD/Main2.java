package BBDD;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.CellEditor;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Main2 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> dni= new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instanciamos la base de datos
		
		ObjectContainer db = conexion();
		//ObjectContainer db = Db4oEmbedded.openFile(DB4OFILENAME);
		int menu=0;
		do {
			System.out.println("\n MENÚ \n 1️⃣Añadir datos   \n 2️⃣Mostrar datos \n 3️⃣Select(Ejercicio 2.i) \n 4️⃣Insert(Ejercicio 2.ii)\n 5️⃣Update(Ejercicio 2.iii)\n 6️⃣Delete(Ejercicio 2.IV)\n 7️⃣Relación Cliente-Pedido   \n 8️⃣️Salir");
			int usuario=sc.nextInt();
			
			switch(usuario) {
			case 1: anadirDatos(db);
				break;
			case 2: mostrar(db);
			
				break;
			case 3: select(db);
				break;
			case 4: insert(db);
				break;
			case 5: update(db);
				break;
				
			case 6: delete(db);
				break;
			case 7:  c(db);
				break;
				
			case 8: System.exit(0);
				break;
			}
		}while(menu==0);
		
		db.close();
		
		
		
	}

	private static ObjectContainer conexion() {
		String DB4OFILENAME="/Users/adolfo/Documents/db4o/pruebaaaa.db4o";
		
		//Creo un fichero para poder borrarlo y que no se dupliquen los objetos
		File f=new File(DB4OFILENAME);
		f.delete();
		 ObjectContainer db = Db4o.openFile(Db4o.newConfiguration(),DB4OFILENAME);
		return db;
	}
	
	private static void anadirDatos(ObjectContainer db) {
		//AÑADIR CLIENTES
		Cliente c1 = new Cliente("Z0811995P","Ramon","Mateos");
		Cliente c2 = new Cliente("Y2865921C","Gonzalo","Ruiz");
		Cliente c3 = new Cliente("Y3826803P","Sofia","Rodriguez");
		Cliente c4 = new Cliente("Z0139648C","Maria","Perez");
		
		
		
		
		
		//AÑADIR PEDIDOS
		Calendar cal=Calendar.getInstance();
		Date fecha;
		cal.set(1990,12,17);
		fecha=cal.getTime();
		Pedido p1 = new Pedido("Z0811995P", 12.25f,fecha , "calle falsa 123");
		
		cal.set(1990,2,20);
		fecha=cal.getTime();
		Pedido p2 = new Pedido("Z0811995P", 45.54f,fecha , "742 Evergreen Terrace");
		
		cal.set(1991,2,22);
		fecha=cal.getTime();
		Pedido p3 = new Pedido("Z0811995P", 84.23f,fecha , "Shelbyville");
		
		cal.set(1991,9,29);
		fecha=cal.getTime();
		Pedido p4 = new Pedido("Y2865921C", 23.74f,fecha , "Capital City");
		
		cal.set(1991,5,1);
		fecha=cal.getTime();
		Pedido p5 = new Pedido("Y2865921C", 83.67f,fecha , "Bronson, Missouri");
		
		cal.set(1991,6,9);
		fecha=cal.getTime();
		Pedido p6 = new Pedido("Y2865921C", 12.94f,fecha , "Ogdenville");
		
		cal.set(1991,1,9);
		fecha=cal.getTime();
		Pedido p7 = new Pedido("Z0139648C", 98.85f,fecha , "North Havenbrook");
		
		cal.set(1991,11,17);
		fecha=cal.getTime();
		Pedido p8 = new Pedido("Z0139648C", 284.25f,fecha , "error Lake");
		
		cal.set(1991,9,8);
		fecha=cal.getTime();
		Pedido p9 = new Pedido("Z0139648C", 1763.50f,fecha , "Little Pwagmattasquarmsettport");
		
		cal.set(1991,9,23);
		fecha=cal.getTime();
		Pedido p10 = new Pedido("Z0139648C", 95.78f,fecha , "Pequeña Lisa planta de reciclaje");
		
		cal.set(1991,12,3);
		fecha=cal.getTime();
		Pedido p11 = new Pedido("Y3826803P", 2.25f,fecha , "Krusty Burger");
		
		cal.set(1991,12,3);
		fecha=cal.getTime();
		Pedido p12 = new Pedido("Y3826803P", 65.78f,fecha , "Planta de energía nucelar");
		
		cal.set(1991,1,23);
		fecha=cal.getTime();
		Pedido p13 = new Pedido("Y3826803P", 6.25f,fecha , "Cypress Creek");
		
		//Guardamos los objetos
		//Clientes
		db.store(c1);
		db.store(c2);
		db.store(c3);
		db.store(c4);
		
		
		//Pedidos
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		db.store(p5);
		db.store(p6);
		db.store(p7);
		db.store(p8);
		db.store(p9);
		db.store(p10);
		db.store(p11);
		db.store(p12);
		db.store(p13);
		
		
		
		
		
		//añadir dni a arrayList
		Cliente c= new Cliente(null,null,null);
		ObjectSet<Cliente> result = db.queryByExample(c);
		while(result.hasNext()) {
			dni.add(result.next().getNif());
		}
		
		
		
		
		
	}

	private static void mostrar(ObjectContainer db) {
		Cliente c= new Cliente(null,null,null);
		ObjectSet<Cliente> result = db.queryByExample(c);
		
		
		
		Pedido p= new Pedido(0,null, 0, null, null);
		ObjectSet<Pedido> pedido = db.queryByExample(p);
		
		
		
		System.out.println("--------------------------------------------------------------------------------------------------------------\nCLIENTES");
		while(result.hasNext()) {
			System.out.println();
			System.out.println(result.next());
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------------------\nPEDIDOS");
		while(pedido.hasNext()) {
			System.out.println();
			System.out.println(pedido.next());
		}
		
		
		//añadir dni a arrayList
		
		
		
		
		
	}
	
	private static void select(ObjectContainer db) {
		
		
		
		
		Pedido pConsulta= new Pedido(0,"Z0811995P", 0, null, null);
		ObjectSet<Pedido> pedido = db.queryByExample(pConsulta);
		System.out.println("--------------------------------------------------------------------------------------------------------------\nSELECT EJERCICIO 2.1");
		while(pedido.hasNext()) {
			System.out.println();
			System.out.println(pedido.next());
			
		}
		
		
		
		
		
	}
	
	private static void insert(ObjectContainer db) {
		
		String  nif;
		sc.nextLine();	
		do {
			System.out.println("Escribe el NIF del cliente");
			nif=sc.nextLine();
		}while(comparadorDni(nif)==false);
		
		System.out.println("Escribe el nombre del cliente");
		String  nombre=sc.nextLine();
		System.out.println("Escribe el apellido del cliente");
		String  apellido=sc.nextLine();
		
		Cliente c=new Cliente(nif,nombre,apellido);
		db.store(c);
	}
	
	private static void update(ObjectContainer db) {
		Pedido p= new Pedido(0,null, 0, null, null);
		ObjectSet<Pedido> result = db.queryByExample(p);
		
		while(result.hasNext()) {
			Pedido pAct= result.next();
			
			if(pAct.getTotal()>30) {
				pAct.setTotal(pAct.getTotal()+(pAct.getTotal()*0.05f));
				db.set(pAct);
			}
			
			
		}
		
	}
	
	private static void delete(ObjectContainer db) {
		Scanner sc=new Scanner(System.in);
		String idPedido;
		System.out.println("Escribe el ID del pedido a borrar");
		idPedido=sc.next();
		System.out.println("Escribe el código del pedido a borrar");
		int cod=sc.nextInt();
		
		
		Pedido p= new Pedido(cod,idPedido, 0, null, null);
		ObjectSet<Pedido> pedido = db.queryByExample(p);
		
		while(pedido.hasNext()) {
			db.delete(pedido.next());
			
			
		}
		
	}
	
	private static void c(ObjectContainer db){
		Cliente c= new Cliente(null,null,null);
		ObjectSet<Cliente> cliente = db.queryByExample(c);
		
		
		
		Pedido p= new Pedido(0,null, 0, null, null);
		ObjectSet<Pedido> pedido = db.queryByExample(p);
		
		
		ArrayList<Cliente>clientes=new ArrayList<Cliente>();
		ArrayList<Pedido>pedidos=new ArrayList<Pedido>();
		
		//Inserto objetos en los arraylists
		while(cliente.hasNext()) {
			clientes.add(cliente.next());
		}
		while(pedido.hasNext()) {
			pedidos.add(pedido.next());
		}
		
		
		//Mostrar pedidos de cada cliente
		for(Cliente cl : clientes) {
			System.out.println("\n"+cl.toString());
			for(Pedido pe : pedidos) {
				if(cl.getNif()==pe.getIdCliente()) {
					System.out.println("\nPedido de "+cl.getNombre());
					System.out.println(pe.toString());
				}
			}
		}
		
		
		
		
		
		
	}

	
	private static boolean comparadorDni(String dniCliente) {
		boolean cliente=false;
		int cont=0;
		
		for(int i=0;i<dni.size();i++) {
			if(dniCliente.equalsIgnoreCase(dni.get(i))) {
				cont++;
			}
		}
		//Si el cont es mayor que 0, existe el dni
		if(cont>0) {
			cliente=false;
		}
		else {
			cliente=true;
		}
		return cliente;
	}
}
