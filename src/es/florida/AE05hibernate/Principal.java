package es.florida.AE05hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("unused")
public class Principal {
	@SuppressWarnings("rawtypes")
	static List listaLibros;
	static Session session;
	static int ID;
	static Scanner teclado;
	
	//MÉTODO PARA CARGAR CONFIGURACIÓN, CREAR SESSION-FACTORY y ABRIR SESION DE LA SESSION FACTORY.
	public static void CargarConfiguracion() {
		//1º CARGAR LA CONFIGURACIÓN	
		Configuration configuration;
		configuration = new Configuration().configure("hibernate.cfg.xml");
		//2ª CREAR UNA SESSION-FACTORY
		configuration.addClass(BooksCSV.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(registry);
		//3º ABRIR LA NUEVA SESION DE LA SESSION FACTORY QUE NOS PERMITE HACER OPERACIONES DE TIPO CRUD.
		session=sessionFactory.openSession();
		session.beginTransaction();
		//RECUPERAR TODOS LOS OBJETOS
		listaLibros=session.createQuery("FROM BooksCSV").list();		
	}
	
	//MÉTODO PARA CERRAR SESION.
	public static void CerrarSession() {
		session.getTransaction().commit();	
		session.close();
		System.out.println("COMMIT DE LA TRANSACTION Y CIERRE DE SESSION");	
	}
		
	//MÉTODO PARA MOSTRAR TODOS LOS TÍTULOS DE LA BIBLIOTECA 
	public static void MostrarTitulos() {
		System.out.println("\n TÍTULOS DE LA BIBLIOTECA");		
		for(Object obj:listaLibros) {
			BooksCSV book=(BooksCSV)obj;
			System.out.println(book.ToStringIdyTitulo());
		}		
	}

	//MÉTODO PARA MOSTRAR LA INFO DETALLADA DE UN LIBRO A PARTIR DE SU ID
	public static void MostrarTitulo() {	
		try {
			//System.out.println("\n MOSTRAR UN LIBRO A PARTIR DE ID");	
			teclado=new Scanner(System.in);
			System.out.print("DIME ID DEL LIBRO A MOSTRAR: ");
			ID=teclado.nextInt();
			BooksCSV book=(BooksCSV) session.get(BooksCSV.class,ID);
			//BooksCSV book=(BooksCSV) listaLibros.get(3);
			System.out.println(book.ToStringLarga());		
			//teclado.close();
		}catch(Exception e) {
			System.out.println("NO EXISTE ESTE LIBRO ");
		}
	}	

	//MÉTODO PARA AÑADIR UN NÚEVO LIBRO A LA BIBLIOTECA
	public static void AddLibro() {
		
		teclado=new Scanner(System.in);
				
		System.out.print("TÍTULO DEL LIBRO: ");
		String Titulo=teclado.next();
		
		System.out.print("AUTOR DEL LIBRO: ");
		String Autor=teclado.next();
		
		System.out.print("AÑO DE NACIMIENTO DEL AUTOR/A: ");
		String Anyo_n=teclado.next();
		
		System.out.print("AÑO DE PUBLICACIÓN DEL LIBRO: ");
		String Anyo_p=teclado.next();
		
		System.out.print("EDITORIAL DEL LIBRO: ");
		String Editorial=teclado.next();
		
		System.out.print("NÚMERO DE PÁGINAS DEL LIBRO: ");
		String N_paginas=teclado.next();
		
		
		BooksCSV book =new BooksCSV(Titulo,Autor,Anyo_n,Anyo_p,Editorial,N_paginas);
		
		System.out.println("LIBRO AÑADIDO: "+book.Titulo);		
		
		session.persist(book);
	}

	//MÉTODO PARA MODIFICAR UN LIBRO DE LA BIBLIOTECA
	public static void ModificarLibro() {
		try {
		teclado=new Scanner(System.in);  //¿Podrái abrirlo en otro sitio?

		System.out.print("INDICAR EL ID DEL LIBRO A MODIFICAR: ");
		
		ID=teclado.nextInt();
				
		BooksCSV book=(BooksCSV) session.load(BooksCSV.class, ID);
		System.out.println("VA MODIFICAR EL LIBRO "+book.getTitulo());
		
		System.out.print("NUEVO TÍTULO DEL LIBRO: ");		
		book.setTitulo(teclado.next());			
		
		System.out.print("NUEVO AUTOR DEL LIBRO: ");
		book.setAutor(teclado.next());	
		
		System.out.print("NUEVO AÑO DE NACIMIENTO DEL AUTOR/A: ");
		book.setAnyo_nacimiento(teclado.next());	

		System.out.print("NUEVO AÑO DE PUBLICACIÓN DEL LIBRO: ");
		book.setAnyo_publicacion(teclado.next());
		
		System.out.print("NUEVA EDITORIAL DEL LIBRO: ");
		book.setEditorial(teclado.next());
		
		System.out.print("NUEVO NÚMERO DE PÁGINAS DEL LIBRO: ");
		book.setNumero_de_paginas(teclado.next());

		System.out.print("¡LIBRO ACTUALIZADO! ");
		System.out.print(book.getTitulo());
		}catch(Exception e) {
			System.out.println("NO EXISTE ESTE ID DE LIBRO ");
		}
	}
	
	//MÉTODO PARA BORRAR UN LIBRO DE LA BIBLIOTECA
	public static void BorrarLibro() {	
		try {
			//System.out.println("BORRAR UN TÍTULO A PARTIR DE ID");	
			teclado=new Scanner(System.in);
			System.out.print("INDICAR ID DEL LIBRO A BORRAR: ");
			ID=teclado.nextInt();
			//BooksCSV book=(BooksCSV) session.get(BooksCSV.class,ID);  //esta lo coge de la BDD
			//BooksCSV book=(BooksCSV) listaLibros.get(3); //Esta lo coge de la lista de libros.
			BooksCSV book=(BooksCSV) session.load(BooksCSV.class, ID); //Esta lo carga de la BDD.	
			
			System.out.println(book.ToStringLarga());	
			book=(BooksCSV) session.load(BooksCSV.class, ID);	
			session.delete(book);			
			//BooksCSV book=new BooksCSV();
			//book.setId(15);	
			System.out.println("LIBRO BORRADO: "+book.getTitulo());
		}catch(Exception e) {
			System.out.println("NO EXISTE ESTE ID DE LIBRO");
		}
	}
	
	public static void main(String[] args) {			
		teclado=new Scanner(System.in);
		
		int opcion=0;
				
		CargarConfiguracion(); 		//CARGAR CARGAR CONFIGURACIÓN, CREAR Y ABRIR SESSION-FACTORY		
		
		while(opcion!=6) {
			System.out.println("\n MENÚ LIBRERÍA");
			System.out.println("-------------");
			System.out.println("1. MOSTRAR TODOS LOS LIBROS");
			System.out.println("2. MOSTRAR UN LIBRO A PARTIR DE UN ID");
			System.out.println("3. AÑADIR LIBRO");
			System.out.println("4. MODIFICAR LIBRO A PARTIR DE UN ID");
			System.out.println("5. BORRAR LIBRO A PARTIR DE UN ID");
			System.out.println("6. CERRAR SESIÓN");
			System.out.println("");			
			System.out.print("ELEGIR UNA OPCIÓN: ");
			
			opcion=Integer.parseInt(teclado.next());  //¿? Convierte en integer (int) lo introducido por teclado.
			
			switch(opcion) {
			case 1:
				MostrarTitulos();  //MOSTRAR TODOS LOS TÍTULOS DE LA BIBLIOTECA
								   //Como muestra la lista sacada de la BDD inicial, no actualiza lo borrado.¿?
				break;
			case 2:
				MostrarTitulo();  //MOSTRAR LIBRO
				break;
			case 3:
				AddLibro(); //AÑADIR UN LIBRO
				break;
			case 4:
				ModificarLibro(); //MODIFICAR LIBRO
				break;
			case 5:
				BorrarLibro();  //BORRAR LIBRO
				break;
			case 6:
				System.out.println("CERRAMOS SESIÓN");
				CerrarSession(); //COMMITS TRANSACTION AND CLOSE SESSION
//				teclado.close();
				break;				
			default:
				break;
			}	
		}
		
		teclado.close();

	}
}