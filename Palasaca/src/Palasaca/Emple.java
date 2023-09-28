package Palasaca;

public interface Emple extends DatosPers{
	public String getFcontratacion();
	public String getPuesto();
	public Double getSueldo();
	public Double getExperiencia();
	public void AumentoSalarial(Double porcentaje);
	public void Ascenso(String puesto, Double sueldo);
	
}
