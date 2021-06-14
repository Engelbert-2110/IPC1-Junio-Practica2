
package src;
import java.util.*;
public class Memorabilia {
     
    // ARREGLO PELICULAS
    String[] nombresPeliculas =  new String[25] ;
    Scanner entrada = new Scanner (System.in);
    int[] idPeliculas =  new int[25];
    int[] anioPeliculas =  new int[25];
    String[] categoriaPeliculas = new String[25];
    boolean disponible[] = new boolean[25];
    
    // ARREGLOS DE CLIENTE
    int[] idClientes = new int[25];
    String[] nombreClientes = new String[25];
    int[] telefonoClientes = new int[25];
    
    public static void main ( String[] args){
    Memorabilia practica2 = new Memorabilia();
    }
    
    public Memorabilia (){
        menu();
        
    }
    
    public  void menu(){
            int opcion;
        do {
            
             System.out.println("\t\t--------- BIENVENIDO AL CONTROL DE PELICULAS --------------");
             System.out.println ("Ingrese una Opcion");
             System.out.println ("1.- Prestamos de Peliculas");
             System.out.println ("2.- Devolucion de Peliculas");
             System.out.println ("3.- Mostrar las peliculas");
             System.out.println ("4.- Ingreso de Peliculas");
             System.out.println ("5.- Ingresar Clientes Nuevos");
             System.out.println ("6.- Mostrar Clientes");
             System.out.println ("7.- Reportes");
             System.out.println ("8.- SALIR");
             System.out.println ("¿QUE VAS A ELEGIR?");
             
             opcion = entrada.nextInt();
             
                switch ( opcion){
                    case 1 :
                       

                        break;
                    
                    case 2 :
                        break;
                        
                    case 3 :
                        
                        mostrarPeliculas(idPeliculas, nombresPeliculas, anioPeliculas, categoriaPeliculas);
                        //ordenarPeliculasMiedo(nombresPeliculas);
                        break;
                    
                        
                    case 4 :
                       ingresarPeliculas(); 
                        break;
                        
                    case 5 :
                        ingresarClientes();
                        
                        break;
                        
                    case 6 :
                       
                        mostrarClientes(idClientes, nombreClientes, telefonoClientes);
                        break;
                        
                    case 7 :
                        break;
                        
                    case 8 :
                        System.out.println(" FIN ");
                        break;
                         
          
                }
             
          }while( opcion !=8 );
   
   }
    
    //falta terminarlo
    /*public void prestarPeliculas(){
        int cantidadDisponible = 0; 
        System.out.println("Peliculas Disponibles");
        
        for (int i = 0; i < 25; i++) {
            if (nombresPeliculas[i] != null && disponible[i] == false ) {
                System.out.println("|" + idPeliculas[i] + "  " + nombresPeliculas[i] + " " + anioPeliculas + "  " + " |\n");
                cantidadDisponible++;
            }
        }
    }*/
    
    
        public void ordenarPeliculasMiedo(String[] nombresPeliculas){
        for(int i=0; i<nombresPeliculas.length-1;i++){
             for(int j=i+1;j<nombresPeliculas.length;j++){
                if(nombresPeliculas[i].compareToIgnoreCase(nombresPeliculas[j])>0){
                     String variableauxiliar=nombresPeliculas[i];
                        nombresPeliculas[i]=nombresPeliculas[j];
                        nombresPeliculas[j]=variableauxiliar;
                     }
                }
             }
  
        }
    
    public void ingresarPeliculas() {
        int idAuxiliar = 0;
        int opcion = 2;
        
        while (nombresPeliculas[25 - 1] == null && opcion == 2) {
            System.out.print("\nDigite el ID de la pelicula que decea agregar: ");
            idAuxiliar = entrada.nextInt();
            if (validar(idAuxiliar, idPeliculas)) {
                for (int i = 0; i < 25; i++) {
                    if (nombresPeliculas[i] == null) {
                        idPeliculas[i] = idAuxiliar;
                        ingresarDatosPeliculas(i);
                        break;
                    }

                }

            } else {
                System.out.println("ERROR, LA PELICULA YA EXISTE :( \n");

            }
           
            System.out.println("\n1.- Volver al menú Principal ");
            System.out.println("2.- Agregar otra pelicula ");
            System.out.print("Digite la opción a elegir: ");
            opcion = entrada.nextInt();

        }
    }
    
    
    public boolean validar(int id, int arreglo[]){
    boolean vald = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == id) {
                vald = false;
                break;
            }

        }
        return vald;

    }
    
   
    public void ingresarDatosPeliculas(int posicion) {
        
        int categorias = 0;
        disponible[posicion] = false;
        System.out.print("\nRegistre el nombre de la pelicula:: ");
        nombresPeliculas[posicion] = entrada1.nextLine();
        System.out.print("\nRegistre el año de la Pelicula: ");
        anioPeliculas[posicion] = entrada.nextInt();
        
        
        
        
        System.out.println("\n***CATEGORIAS DISPONIBLES*** \n");
        System.out.println("1. Acción"
                + "\n2. Comedia"
                + "\n3. Romance"
                + "\n4. Terror"
                + "\n5. Infantiles");
        System.out.print("Digite el número de la categoriar en donde lo deceas agregar: ");
       
        categorias = entrada.nextInt();
        switch (categorias) {
            case 1:
                categoriaPeliculas[posicion] = "Acción";
                break;
            case 2:
                categoriaPeliculas[posicion] = "Comedia";
                break;
            case 3:
                categoriaPeliculas[posicion] = "Romanticas";
                break;
            case 4:
                categoriaPeliculas[posicion] = "Miedo";
                break;
            case 5:
                categoriaPeliculas[posicion] = "Infantiles";
                break;
        }

    }
     
     //Metodo mostrar peliculas ingresadas
   public void mostrarPeliculas(int[] idP, String[] nombreP, int[] anioP, String[] categoria ){
        for( int i = 0; i< 25; i++){
             if (nombresPeliculas[i] != null) {
                 System.out.println("ID: "+idP[i]+" ---PELICULA: "+nombreP[i]+" ---AÑO: "+anioP[i]+" ---CATEGORIA: "+categoria[i]+"\n");
            }
           
        }
    }
    
    
    //Este método nos sirve para ingresar clientes  
    public void ingresarClientes(){
        int op = 2;
        int idAuxiliar;
        
        while(nombreClientes[25-1] == null && op == 2){
            System.out.print("\n Registre el ID del cliente: ");
            idAuxiliar = entrada.nextInt();
            
            if (validar(idAuxiliar,idClientes)) {
                for (int i = 0; i < 25; i++) {
                    if (nombreClientes[i] == null ) {
                        idClientes[i] = idAuxiliar;
                    ingresarDatosClientes(i);
                    break;
                    }
                }
                
            }else {
                System.out.println("Ya contamos con esos datos del cliete");
            
            }
           
            System.out.println("\n1.-volver al menú principal");
            System.out.println("2.-Agregar nuevo cliente");
            System.out.print("SELECCIONE UNA OPCION!!: ");
            op = entrada.nextInt();
            
        }
  
    }

    Scanner entrada1 = new Scanner(System.in);
    public void ingresarDatosClientes (int posicion){
        System.out.print("\nRegistre el nombre del cliente: ");
        nombreClientes[posicion] = entrada1.nextLine();
        System.out.print("\nRegistre el numero de teléfono: ");
        telefonoClientes[posicion] = entrada.nextInt();
    }
    
    public void mostrarClientes(int[] idClientes, String[] nombreClientes, int[] telefonoClientes){
        for( int i =0; i< 25; i++){
             if (nombreClientes[i] != null) {
                 System.out.println("ID: "+idClientes[i]+" --- NOMBRE: "+nombreClientes[i]+" --- TELÉFONO: "+telefonoClientes[i]+"\n");
                 
             }
                
            
           
        }
    } 
    
}