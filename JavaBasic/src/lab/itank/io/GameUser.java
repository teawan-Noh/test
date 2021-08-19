package lab.itank.io;

import java.io.Serializable;

public class GameUser implements Serializable{
	
	private static final long serialVersionUID = 3272071793562218253L;
	//역직렬화 할때 쓰는 ID
		
	private String id;
	private int level;
	
	transient private String netAddress;
	
	public GameUser(String id, int level, String netAddress) {
		this.id = id;
		this.level = level;
		this.netAddress = netAddress;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public String getNetAddress() {
		return netAddress;
	}

	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}

	@Override
	public String toString() {
		return "GameUser [id=" + id + ", level=" + level + ", netAddress=" + netAddress + "]";
	}
	
}
