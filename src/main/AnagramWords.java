package main;

public class AnagramWords {
	
	public static boolean isAnagram(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		
		int N = 256;
		int count[] = new int[N];
		for(int i=0; i<N; i++){
			count[i] = 0;
		}
		
		for(int i=0; i<s1.length(); i++){
			count[s1.charAt(i)] ++;
			count[s2.charAt(i)] --;
		}
		
		for(int i=0; i<N; i++)
			if(count[i] != 0){
				return false;
			}
				
		
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isAnagram("silent", "listen"));
 	}

}
