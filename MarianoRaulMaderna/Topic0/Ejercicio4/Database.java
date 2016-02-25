package Topic0.Ejercicio4;

public class Database {
	private String ip;
	private String port;
	
	public String getIp(){
		return ip;
	}
	
	public void setIp(String ip){
		this.ip=ip;
	}
	
	public String getPort(){
		return port;
	}
	
	public void setPort(String port){
		this.port=port;
	}
	
	public String toString(){
		return "Ip: " +ip + " and Port "+port;
	}
}
