package laboratorioClinica.clinica;
import java.util.Iterator;

import laboratorioClinica.listas.UnorderedSimpleLinkedList;
//import listasSimples.*;

public class Clinica {

	/*
	 * Una clinica consta de una lista de pacientes y una lista de medicamentos
	 */

	private UnorderedSimpleLinkedList<Paciente> laListaPac;
	private UnorderedSimpleLinkedList<Medicamento> laListaMed;

	public Clinica() {
		laListaPac = new UnorderedSimpleLinkedList<Paciente>();
		laListaMed = new UnorderedSimpleLinkedList<Medicamento>();
	}

	public void addPaciente(String nom, int c) {
		Paciente nuevo = new Paciente(nom, c, new UnorderedSimpleLinkedList<Medicamento>());
		laListaPac.addToFront(nuevo);
	}

	public void escribirMedClinica() {
		// post: visualiza todos los medicamentos de la clinica junto con la
		// cantidad
		// de pacientes que los toman

		System.out.println("Medicamentos de la Clinica: ");
		System.out.println(laListaMed.toString());
		Iterator<Medicamento> it = laListaMed.iterator();
		while (it.hasNext()) {
			Medicamento med = it.next();
			System.out.print(med.getNombre() + ": "
					+ med.getCantidad() + "     ");
		}
		System.out.println();
		System.out.println();
	}

	public void escribirPacClinica() {
		// pre: true (no hay restricciones).
		// post: visualiza todos los pacientes de la clinica con sus respectivos
		// medicamentos
		System.out.println("Pacientes de la Clinica: ");
		System.out.println(laListaPac.toString());

		// COMPLETAR CODIGO-- RECUERDA COMENTAR LA COMPLEJIDAD
	}

	public void addMedicina(Medicamento med) {
		laListaMed.addToRear(med);
	}

	public void addMedicinaPaciente(String pPac, String nMed) {
		// Pre: pPac es un paciente de la clinica y no toma la medicina nMed
		// Post: se ha insertado la medicina nMed al paciente pPac. Si la
		// clinica tenía la medicina, entonces la cantidad de pacientes
		// que toman nMed ha aumentado. Si no, nMed se ha añadido a los
		// medicamentos de la clinica.


		// COMPLETAR CÓDIGO Y CALCULAR COSTE
	}
	// Coste: 

	public void removeMedicinaPaciente(String pPac, String nMed) {
		// pre: true. (No hay restricciones. Puede que no exista pPac, que no
		// tome nMed, que la medicina no esté en la clinica, etc. En estos
		// casos el método no hará nada.)
		// post: Se ha eliminado la medicina nMed del paciente pPac y ha quedado
		// reflejado en la lista de medicinas de la clinica. Este metodo no
		// elimina medicinas de la clinica.

				// COMPLETAR CÓDIGO Y CALCULAR COSTE

	}
}