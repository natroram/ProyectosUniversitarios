package aspectos;

public aspect Log{
	pointcut controlAspect(): call(* *.setOnAction*());
	before() : controlAspect() {
	    System.out.println("CAMBIANDO DE ACCIÓN");
    } 
}
