import java.util.List;

public class ServerRequest {
	private String command;
	private List<String> targetDevice;
	private String param;
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command){
		this.command = command;
	}
	
	public List<String> getTargetDevice(){
		return targetDevice;
	}
	
	public void setTargetDevice(List<String> targetDevice) {
		this.targetDevice = targetDevice;
	}
	
	public String getParam() {
		return param;
	}
	
	public void setParam(String param) {
		this.param = param;
	}
}
