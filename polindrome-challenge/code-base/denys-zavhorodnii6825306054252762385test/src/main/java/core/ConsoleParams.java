package core;

import reports.DestinationParams;
import sources.SourceParams;

public class ConsoleParams implements SourceParams, DestinationParams {

	private String inputFileName;
	private String resultFileName;

	private Boolean parallel;
	private Boolean line;

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public String getResultFileName() {
		return resultFileName;
	}

	public void setResultFileName(String resultFileName) {
		this.resultFileName = resultFileName;
	}

	public Boolean getParallel() {
		return parallel;
	}

	public void setParallel(Boolean parallel) {
		this.parallel = parallel;
	}

	public Boolean getLine() {
		return line;
	}

	public void setLine(Boolean line) {
		this.line = line;
	}

	@Override
	public String getSource() {
		return this.inputFileName;
	}

	@Override
	public String getDestination() {
		return this.resultFileName;
	}
}
