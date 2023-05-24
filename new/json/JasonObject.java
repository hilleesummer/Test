public class JasonObject {

	private int inputQueueCount;
	private List<String> inputQueueURIs;
	private String outputQueueURI;
	
	public Configuration(int inputQueueCount, List<String> inputQueueURIs, String outputQueueURI) {
		super();
		this.inputQueueCount = inputQueueCount;
		this.inputQueueURIs = inputQueueURIs;
		this.outputQueueURI = outputQueueURI;
	}
}
