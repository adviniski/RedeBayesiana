package redebayesiana;

import java.io.Serializable;

public class Objeto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;
	private Double[][] pi = new Double[2][2];
	private Double[][] lambda = new Double[2][1];
	private Double[][] lambdaOld = new Double[2][1];
	private Double[][] belief = new Double[2][1];

	@Override
	public String toString() {
		return getLabel();
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double[][] getPi() {
		return pi;
	}

	public void setPi(Double[][] pi) {
		this.pi = pi;
	}

	public Double[][] getLambda() {
		return lambda;
	}

	public void setLambda(Double[][] lambda) {
		this.lambda = lambda;
	}

	public Double[][] f() {
		return belief;
	}

	public void setBelief(Double[][] belief) {
		this.belief = belief;
	}

	public Double[][] getLambdaOld() {
		return lambdaOld;
	}

	public void setLambdaOld(Double[][] lambdaOld) {
		this.lambdaOld = lambdaOld;
	}

	public Double[][] getBelief() {
		return belief;
	}

}
