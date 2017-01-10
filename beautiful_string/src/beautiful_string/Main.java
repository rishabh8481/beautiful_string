package beautiful_string;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
public class Main {
	public static void main(String args[]){
		int a[]=new int[26],n=0,len,i,max=26;
		try{
			int sum = 0;
			String s=null;
			File f1=new File("Beautiful_Strings.txt");
			FileReader fr=new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			while((s=br.readLine())!=null){
				s=s.toLowerCase();
				s=s.replaceAll("\\s+","");
				s=s.replaceAll("[^a-z]","");
				len=s.length();
				for(i=0;i<len;i++){
					n=Integer.valueOf(s.charAt(i))-97;
					a[n]=a[n]+1;
				}
				Arrays.sort(a);
				sum=0;
				for(i=25;i>=0;i--){
					sum+=a[i]*max;
					max--;
					a[i]=0;
				}
				System.out.println(sum);
				sum=0;
				max=26;
			}
			br.close();
			fr.close();
		}catch(Exception e){
		}
	}
}