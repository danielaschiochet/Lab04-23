package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
	
		return this.corsoDAO.getTuttiICorsi();
	}
		
	public List<Studente> getTuttiGliStudenti(){
			
		return this.studenteDAO.getTuttiGliStudenti();
	}
		
	public List<Studente> getStudentiIscrittiCorso(Corso c){
		
		return this.corsoDAO.getStudentiIscrittiAlCorso(c);
	}
	
	public List<Corso> getCorsiStudente(int m){
		
		return this.studenteDAO.getCorsiStudente(m);
	}
	
	public boolean getIscritto(Studente s, Corso c) {
		
		return this.corsoDAO.inscriviStudenteACorso(s, c);
	}
	

}
