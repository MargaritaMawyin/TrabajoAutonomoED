package trabajoautonomo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Margarita Mawyin
 */
public class TrabajoAutonomo implements Serializable {

    String idCarrera;
    String fecha_hora_inicio;
    String fecha_hora_fin;
    int nPasajetos;
    double distanciaRecorrido;
    double valor;

    public TrabajoAutonomo(String idCarrera, String fecha_hora_inicio, String fecha_hora_fin, int nPasajetos, double distanciaRecorrido, double valor) {
        this.idCarrera = idCarrera;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.fecha_hora_fin = fecha_hora_fin;
        this.nPasajetos = nPasajetos;
        this.distanciaRecorrido = distanciaRecorrido;
        this.valor = valor;
    }


    public String getIdCarrera() {
        return idCarrera;
    }

    public String getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public String getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public int getnPasajetos() {
        return nPasajetos;
    }

    public double getDistanciaRecorrido() {
        return distanciaRecorrido;
    }

    public double getValor() {
        return valor;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public void setFecha_hora_inicio(String fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public void setFecha_hora_fin(String fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public void setnPasajetos(int nPasajetos) {
        this.nPasajetos = nPasajetos;
    }

    public void setDistanciaRecorrido(double distanciaRecorrido) {
        this.distanciaRecorrido = distanciaRecorrido;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    

   

    

    public static void cargarCSVconArray(String archivo) throws IOException {
        long TiempoInicio = System.currentTimeMillis();
        System.out.println("TIEMPO INICIO: "+ TiempoInicio);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ID de carrera: ");
        String resp = sc.nextLine();
        System.out.println("INFORMACION DE LA CARRERA: "+resp);
        ArrayList<TrabajoAutonomo> lineas = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] division = line.split(",");
//                lineas.add(new TrabajoAutonomo(division[0], division[1], division[2], Integer.parseInt(division[3]), Double.parseDouble(division[4]), Double.parseDouble(division[5])));
                if (division[0].equals(resp)) {
                    System.out.println(line);
                } }
            //Implementación del método de búsqueda 
            long TiempoFin = System.currentTimeMillis();
            System.out.println("TIEMPO FINAL: "+TiempoFin);
            long TiempoBusqueda = TiempoFin - TiempoInicio;
            System.out.println("TIEMPO BUSQUEDA: "+TiempoBusqueda);
//        System.out.println(lineas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static void cargarCSVconLL(String archivo) throws IOException {
        long TiempoInicio = System.currentTimeMillis();
        System.out.println("TIEMPO INICIO: "+ TiempoInicio);
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ID de carrera: ");
        String resp = sc.nextLine();
        System.out.println("INFORMACION DE LA CARRERA: "+resp);
        LinkedList <TrabajoAutonomo> lineas = new LinkedList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] division = line.split(",");
//                lineas.add(new TrabajoAutonomo(Integer.parseInt(division[0]), division[1], division[2], Integer.parseInt(division[3]), Double.parseDouble(division[4]), Double.parseDouble(division[5])));
                if (division[0].equals(resp)) {
                    System.out.println(line);
                } }
            //Implementación del método de búsqueda 
            long TiempoFin = System.currentTimeMillis();
            System.out.println("TIEMPO FINAL: "+TiempoFin);
            long TiempoBusqueda = TiempoFin - TiempoInicio;
            System.out.println("TIEMPO BUSQUEDA: "+TiempoBusqueda);
//        System.out.println(lineas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
        public static void cargarCSVconMap(String archivo) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ID de carrera: ");
        String resp = sc.nextLine();
        System.out.println("INFORMACION DE LA CARRERA: "+resp);
        Map <String,Object> mapa = new HashMap<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] division = line.split(",");
                List<Object> lista = new LinkedList<>();
                lista.add(new TrabajoAutonomo(division[0], division[1], division[2], Integer.parseInt(division[3]), Double.parseDouble(division[4]), Double.parseDouble(division[5])));
                mapa.put(division[0],lista);
                 }
            long TiempoInicio = System.currentTimeMillis();
            System.out.println("TIEMPO INICIO: "+ TiempoInicio);
            if (mapa.containsKey(resp)) 
                    System.out.println(mapa.values());
            else{
                System.out.println("No existe ID ingresado");
            }
            //Implementación del método de búsqueda 
            long TiempoFin = System.currentTimeMillis();
            System.out.println("TIEMPO FINAL: "+TiempoFin);
            long TiempoBusqueda = TiempoFin - TiempoInicio;
            System.out.println("TIEMPO BUSQUEDA: "+TiempoBusqueda);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
        public static void cargarCSVconTreeMap(String archivo) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ID de carrera: ");
        String resp = sc.nextLine();
        System.out.println("INFORMACION DE LA CARRERA: "+resp);
        Map <String,Object> mapa = new TreeMap<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] division = line.split(",");
                List<Object> lista = new LinkedList<>();
//                lista.add(new TrabajoAutonomo(division[0], division[1], division[2], Integer.parseInt(division[3]), Double.parseDouble(division[4]), Double.parseDouble(division[5])));
                mapa.put(division[0],lista);
                 }
            long TiempoInicio = System.currentTimeMillis();
            System.out.println("TIEMPO INICIO: "+ TiempoInicio);
            if (mapa.containsKey(resp)) 
                    System.out.println(mapa.values());
            else{
                System.out.println("No se ha encontrado el ID");
            }
            //Implementación del método de búsqueda 
            long TiempoFin = System.currentTimeMillis();
            System.out.println("TIEMPO FINAL: "+TiempoFin);
            long TiempoBusqueda = TiempoFin - TiempoInicio;
            System.out.println("TIEMPO BUSQUEDA: "+TiempoBusqueda);
//        System.out.println(lineas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
        public static void cargarCSVconBTree(String archivo) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ID de carrera: ");
        int resp = sc.nextInt();
        System.out.println("INFORMACION DE LA CARRERA: "+resp);
        BTree bTree = new BTree();

        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] division = line.split(",");
               bTree.insert(Integer.parseInt(division[0]));
                 }
            long TiempoInicio = System.currentTimeMillis();
            System.out.println("TIEMPO INICIO: "+ TiempoInicio);
            bTree.search(resp) ;
            System.out.println(bTree.search(resp));
            //Implementación del método de búsqueda 
            long TiempoFin = System.currentTimeMillis();
            System.out.println("TIEMPO FINAL: "+TiempoFin);
            long TiempoBusqueda = TiempoFin - TiempoInicio;
            System.out.println("TIEMPO BUSQUEDA: "+TiempoBusqueda);
//        System.out.println(lineas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
         public static void cargarCSVconRedBlackTree(String archivo) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese ID de carrera: ");
        int resp = sc.nextInt();
        System.out.println("INFORMACION DE LA CARRERA: "+resp);
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] division = line.split(",");
               rbt.insert(Integer.parseInt(division[0]));
                 }
            long TiempoInicio = System.currentTimeMillis();
            System.out.println("TIEMPO INICIO: "+ TiempoInicio);
            rbt.search(resp) ;
            System.out.println(rbt.search(resp));
            //Implementación del método de búsqueda 
            long TiempoFin = System.currentTimeMillis();
            System.out.println("TIEMPO FINAL: "+TiempoFin);
            long TiempoBusqueda = TiempoFin - TiempoInicio;
            System.out.println("TIEMPO BUSQUEDA: "+TiempoBusqueda);
//        System.out.println(lineas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
               
        
    @Override
    public String toString() {
        return "idCarrera=" + idCarrera + "\n"
                + ", fecha_hora_inicio=" + fecha_hora_inicio + "\n"
                + ", nPasajetos=" + nPasajetos + "\n"
                + ", distanciaRecorrido=" + distanciaRecorrido + "\n"
                + ", valor=" + valor + "\n";
    }
    public static void main(String[] args) throws IOException {
        
//        cargarCSVconArray("manhattan_inc.csv");
//        cargarCSVconLL("manhattan_inc.csv");
        cargarCSVconMap("manhattan_inc.csv");
//        cargarCSVconTreeMap("manhattan_inc.csv");
//        cargarCSVconRedBlackTree("manhattan_inc.csv");
//        cargarCSVconBTree("manhattan_inc.csv");
    }

}

//        ObjectInputStream ois = new ObjectInputStream(new  FileInputStream(archivo)); {
//            try {
//                lineas = (ArrayList<TrabajoAutonomo>) ois.readObject();
//                System.out.println(lineas);
//                ois.close();
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(TrabajoAutonomo.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));){
//            in.readObject();
//            TrabajoAutonomo  object1 = (TrabajoAutonomo)in.readObject(); 
//              
//            
//            System.out.println( object1.idCarrera); 
//            System.out.println( object1); 
//            in.close(); 
//        }
//          
//        catch(IOException ex) 
//        { 
//            System.out.println("IOException is caught"); 
//        } 
//          
//        catch(ClassNotFoundException ex) 
//        { 
//            System.out.println("ClassNotFoundException is caught"); 
//        } 
//  
//    }
