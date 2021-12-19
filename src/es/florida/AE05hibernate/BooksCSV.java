package es.florida.AE05hibernate;

public class BooksCSV {
	
	//ATRIBUTOS
	int id;
	String Titulo;
	String Autor;
	String Anyo_nacimiento;
	String Anyo_publicacion;
	String Editorial;
	String Numero_de_paginas;
	
	//CONSTRUCTOR VACÍO
	public BooksCSV() {}
	//CONSTRUCTOR SIN ID	
	public BooksCSV(String Titulo,String Autor,String Anyo_nacimiento,String Anyo_publicacion,String Editorial,String Numero_de_paginas) {
		this.Titulo=Titulo;
		this.Autor=Autor;
		this.Anyo_nacimiento=Anyo_nacimiento;
		this.Anyo_publicacion=Anyo_publicacion;
		this.Editorial=Editorial;
		this.Numero_de_paginas=Numero_de_paginas;
	}
	//CONSTRUCTOR CON ID
	public BooksCSV(int id,	String Titulo,String Autor,String Anyo_nacimiento,String Anyo_publicacion,String Editorial,String Numero_de_paginas) {
		this.id= id;
		this.Titulo=Titulo;
		this.Autor=Autor;
		this.Anyo_nacimiento=Anyo_nacimiento;
		this.Anyo_publicacion=Anyo_publicacion;
		this.Editorial=Editorial;
		this.Numero_de_paginas=Numero_de_paginas;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getAnyo_nacimiento() {
		return Anyo_nacimiento;
	}
	public void setAnyo_nacimiento(String anyo_nacimiento) {
		Anyo_nacimiento = anyo_nacimiento;
	}
	public String getAnyo_publicacion() {
		return Anyo_publicacion;
	}
	public void setAnyo_publicacion(String anyo_publicacion) {
		Anyo_publicacion = anyo_publicacion;
	}
	public String getEditorial() {
		return Editorial;
	}
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}
	public String getNumero_de_paginas() {
		return Numero_de_paginas;
	}
	public void setNumero_de_paginas(String numero_de_paginas) {
		Numero_de_paginas = numero_de_paginas;
	}
	public String ToStringIdyTitulo() {		
		    return ("Libro: "+id+"-"+Titulo);
	}	
	public String ToStringLarga() {		
	    return ("Libro: ID-"+id+" Titulo-"+Titulo+" Autor-"+Autor+
	    		" Año de nacimiento-"+Anyo_nacimiento+" Año de publicación-"+Anyo_publicacion+
	    		" Editorial-"+Editorial+" Número de páginas-"+Numero_de_paginas);
}	
	public String ToString() {		
	    return ("Libro: "+id+"-"+Titulo+"-"+Autor+
	    		"-"+Anyo_nacimiento+"-"+Anyo_publicacion+
	    		"-"+Editorial+"-"+Numero_de_paginas);
}
	
}
