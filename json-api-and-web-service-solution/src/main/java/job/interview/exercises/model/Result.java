package job.interview.exercises.model;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = -4902676973289000860L;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + "]";
	}

}
