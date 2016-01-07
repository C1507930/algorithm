package test.sort;

public class RedType implements Comparable<RedType>{

	public int key;
	
	public String otherInfo;
	
	public RedType(int key, String otherInfo) {
		super();
		this.key = key;
		this.otherInfo = otherInfo;
	}

	@Override
	public int compareTo(RedType o) {
		if(this.key > o.key){
			return 1;
		}else if(this.key < o.key){
			return -1;
		}else{
			return 0;
		}
	}
}
