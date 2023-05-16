package strategy;

public class Contexto {
	
	public Contexto() {
		
	}
	
	public void Automotriz(EstrategiaAutomotriz e) {
		
	}
	
	public void Ciclista(EstrategiaCiclista e) {
		
	}
	
	public void Ferrea(EstrategiaFerrea e) {
		
	}
	
	public void Aerea(EstrategiaAerea e) {
		
	}
	
	public void Fluvial(EstrategiaFluvial e) {
		
	}
	
	public interface EstrategiaAutomotriz{
		public void Algoritmo();
	}
	
	public interface EstrategiaCiclista{
		public void Algoritmo();
	}
	
	public interface EstrategiaFerrea{
		public void Algoritmo();
	}
	
	public interface EstrategiaAerea{
		public void Algoritmo();
	}
	
	public interface EstrategiaFluvial{
		public void Algoritmo();
	}
}
