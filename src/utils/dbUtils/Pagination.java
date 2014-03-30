package utils.dbUtils;

public class Pagination {
	
	public static int getPaginationNext(int start,int end,int all){
		int diff = all-(start+10);
		if(diff>10){
			return end+10;
		}else{
			return end+diff;
		}
	}
	
	public static int getPaginationPrevious(int start){
		
		return start-10;
	}
	
	public static Boolean hasNext(int end,int all){
		if(end<all){
			return true;
		}else{
			return false;
		}
	}
	
	public static Boolean hasPrevious(int start){
		if(start==0){
			return false;
		}else{
			return true;
		}
	}
	

}
