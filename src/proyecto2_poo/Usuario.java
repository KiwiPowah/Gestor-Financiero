/*Grupo #5 (Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy)
Guatemala, Universidad del Valle de Guatemala
Programación Orientada a Objetos; Sección 60
Proyecto 2: Gestor Financiero [Fase Final]
Creación: 06 de octubre del 2023
Última modificación: 09 de noviembre del 2023*/

package proyecto2_poo;

//Importar los paquetes/librerías que harán falta
import java.util.ArrayList;
import java.util.Arrays;

/**
* Esta clase representará a cada usuario del programa
* @author Marco Carbajal, Carlos Aldana, Carlos Angel y Diego Monroy
* @version 20.0.1, 06/10/2023
*/
public class Usuario {
    
	//[Atributos]
	
    /**
	* Código de identificación (ID) del usuario.
	* Este código de 6 dígitos sirve para identificar de manera única a cada usuario dentro del sistema.
	*/
    private String codigoIdentificacion;
	
	/**
	* Nombre del usuario.
	*/
	private String nombre;
	
	/**
	* Apellido del usuario.
	*/
    private String apellido;
    
    /**
	* Sexo del usuario.
	*  Este atributo almacena el sexo del usuario. Las opciones disponibles son: Masculino ("m") y Femenino ("f").
	*/
    private String sexo;
    
    /**
	* Edad del usuario.
	* Este atributo será un valor numérico entero.
	*/
    private int edad;
    
    /**
	* Tipo de perfil del usuario.
	* Este atributo indica la categoría o rol al que pertenece el usuario. Las opciones disponibles son: "Padre/Madre", "Freelancer", "Estudiante".
	*/
    private String tipo_perfil;
    
    /**
	* Lista de registros financieros del usuario. 
	* Esta lista almacena registros financieros asociados al usuario. Estos registros pueden incluir ingresos, gastos o ahorros que el usuario haya registrado en su perfil.
	*/
    private ArrayList<Registro> registros;
    
    /**
	* Lista de distribución de porcentajes de categorías. 
	* Esta lista se utiliará para almacenar los porcentajes que le asignó el usuario a cada categoría. 
	*/
    public ArrayList<Double> lista_porcentajes;

    //[Constructor]

	/**
	* Constructor de la clase Usuario.
	* @param nombre El nombre del usuario.
	* @param apellido El apellido del usuario.
	* @param sexo El sexo del usuario.
	* @param edad La edad del usuario.
	* @param tipo_perfil El tipo de perfil del usuario.
	*/
    public Usuario(String id, String nombre, String apellido, String sexo, int edad, String tipo_perfil) {
        this.codigoIdentificacion = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.tipo_perfil = tipo_perfil;
        this.registros = new ArrayList<Registro>();
        this.lista_porcentajes = new ArrayList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));}

    //[Métodos]
   
    /**
   	* Modificar el porcentaje de alguna categoría de gastos (si se puede).
   	* @param categoria La categoría de la que se desea modificar el porcentaje.
   	* @param porcentaje El nevo porcentaje para dicha categoría.
   	* @return Este método no devuelve nada.
   	*/
    public void distribuirPorcentajes(String categoria, double porcentaje) {
    	
    	ArrayList<String> categorias = new ArrayList<String>(Arrays.asList("Alimentos y bebidas","Vivienda","Transporte","Salud","Educacion","Entretenimiento","Ropa y calzado","Comunicaciones","Otros"));
    	
    	//Obtener el índice de la categoría que desea modificar el usuario
    	int indice_categoria = categorias.indexOf(categoria);
    	
    	//Establecer el porcentaje indicado a la categoría
    	lista_porcentajes.set(indice_categoria, porcentaje);}
    
	/**
   	* Establece la lista de porcentajes del usuario.
   	* @param lista_porcentajes La lista de porcentajes que se le desea establecer al usuario.
   	* @return Este método no devuelve nada.
   	*/
	public void setLista_porcentajes(ArrayList<Double> lista_porcentajes) {
		this.lista_porcentajes = lista_porcentajes;}

    /**
     * Sumar todos los valores de la lista de distribución de porcentajes de categorías.
     * @return La suma de los valores de la lista de distribución de porcentajes de categorías.
     */
    public double sumaPorcentajes() {
    	double totalPorcentajes = 0;
    	
    	for(int i=0;i<lista_porcentajes.size();i++) {
    		totalPorcentajes += lista_porcentajes.get(i);}
    	
    	return totalPorcentajes;}

    /**
	 * Obtiene el código de identificación (ID) del usuario.
	 * @return El código de identificación (ID) del usuario.
	 */
	public String getCodigoIdentificacion() {
		return codigoIdentificacion;}

	/**
	 * Obtiene el nombre completo del ususario (nombre y apellido separados por un espacio). 
	 * @return El nombre completo del usuario.
	 */
	public String getNombre_completo() {
		return nombre + " " + apellido;}

	/**
	 * Obtiene el nombre completo del ususario (nombre y apellido separados por un guión bajo). 
	 * @return El nombre completo del usuario.
	 */
	public String getNombreCompletoCSV() {
		return nombre + apellido;}
	
	/**
	 * Obtiene el tipo de perfil del usuario.
	 * @return El tipo de perfil del usuario.
	 */
	public String getTipo_perfil() {
		return tipo_perfil;}

	/**
	 * Obtiene la lista de registros financieros del usuario.
	 * @return La lista de registros financieros del usuario.
	 */
	public ArrayList<Registro> getRegistros() {
		return registros;}
	
	/**
	 * Obtiene la lista de distribución de porcentajes de categorías. 
	 * @return La lista de distribución de porcentajes de categorías. 
	 */
	public ArrayList<Double> getLista_porcentajes() {
		return lista_porcentajes;}

	/**
	 * Modifica la lista de registros financieros del usuario.
	 * @param registros La nueva lista de registros financieros para el usuario.
	 * @return Este método no devuelve nada.
	 */
	public void setRegistros(ArrayList<Registro> registros) {
		this.registros = registros;}

	/**
	 * Obtiene el nombre del usuario.
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;}

	/**
	 * Obtiene el apellido del usuario.
	 * @return El apellido del usuario.
	 */
	public String getApellido() {
		return apellido;}
	
	/**
	 * Formatea la información del usuario al formato reconocido por el archivo csv.
	 * @return La información del usuario en el formato reconocido por el archivo csv.
	 */
	public String formatoCSV() {
		
		//Crear un array de 15 strings (cada uno corresponderá a un encabezado del csv de usuarios)
		String[] datos = new String[15];
						
		//Guardar cada atributo en su posición correspondiente en el array (convertir los atributos numéricos a strings)
		datos[0] = codigoIdentificacion;
		datos[1] = nombre;
		datos[2] = apellido;
		datos[3] = sexo;
		datos[4] = "" + edad;
		datos[5] = tipo_perfil;
		datos[6] = "" + lista_porcentajes.get(0);
		datos[7] = "" + lista_porcentajes.get(1);
		datos[8] = "" + lista_porcentajes.get(2);
		datos[9] = "" + lista_porcentajes.get(3);
		datos[10] = "" + lista_porcentajes.get(4);
		datos[11] = "" + lista_porcentajes.get(5);
		datos[12] = "" + lista_porcentajes.get(6);
		datos[13] = "" + lista_porcentajes.get(7);
		datos[14] = "" + lista_porcentajes.get(8);
				
		//Unificar todos los elementos del array en un solo string, separados por comas (,)
		String linea_datos = String.join(",", datos);
				
		return linea_datos;}
	
	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Alimentos y bebidas'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Alimentos y bebidas'.
	 */
	public double getPorcentajeAlimentosYBebidas() {
		return this.lista_porcentajes.get(0)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Vivienda'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Vivienda'.
	 */
	public double getPorcentajeVivienda() {
		return this.lista_porcentajes.get(1)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Transporte'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Transporte'.
	 */
	public double getPorcentajeTransporte() {
		return this.lista_porcentajes.get(2)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Salud'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Salud'.
	 */
	public double getPorcentajeSalud() {
		return this.lista_porcentajes.get(3)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Educación'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Educación'.
	 */
	public double getPorcentajeEducacion() {
		return this.lista_porcentajes.get(4)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Entretenimiento'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Entretenimiento'.
	 */
	public double getPorcentajeEntretenimiento() {
		return this.lista_porcentajes.get(5)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Ropa y calzado'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Ropa y calzado'.
	 */
	public double getPorcentajeRopaYCalzado() {
		return this.lista_porcentajes.get(6)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Comunicaciones'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Comunicaciones'.
	 */
	public double getPorcentajeComunicaciones() {
		return this.lista_porcentajes.get(7)/100;}

	/**
	 * Obtiene el porcentaje asignado por el usuario a la categoría 'Otros'.
	 * @return El porcentaje asignado por el usuario a la categoría 'Otros'.
	 */
	public double getPorcentajeOtros() {
		return this.lista_porcentajes.get(8)/100;}
}