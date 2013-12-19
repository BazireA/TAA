package tp3.srv;

import java.util.List;

import tp3.TypeSport;

public interface TypeSportService {

	public long creerTypeSport();
	public TypeSport getTypeSport(long id);
	public List<TypeSport> getTypesSport();
	public void modifier(long id, String nom);
	public void supprimerSport(long id);
}
