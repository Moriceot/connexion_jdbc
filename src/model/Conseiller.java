package model;



public class Conseiller {
	//Attributs**************************************
	private int id;
	private String nom;
	private String prenom;
	private int age;
	//Constructeurs**************************************
	public Conseiller(int id, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	public Conseiller() {
		super();
	}
	//Getters & Setters**************************************
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//ToString**************************************
	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	

}
