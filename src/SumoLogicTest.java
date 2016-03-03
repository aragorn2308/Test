import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.xalan.xsltc.compiler.sym;

public class SumoLogicTest {

	public static void main(String[] args) throws IOException {
		HashSet hs = new HashSet();
		int q;
		int x[] = new int[1000000];
		Integer y[] = new Integer[1000000];
		Integer most_recent = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		q = Integer.parseInt(line);
		for(int i=0;i<q;i++){
			String line2 = br.readLine();
			String[] variables = line2.split(" ");
			x[i]=Integer.parseInt(variables[0]);
			if(x[i]!=4){
				y[i] = Integer.parseInt(variables[1]);
			}
			
		}
		int x1,y1;
		for(int i=0;i<q;i++){
			x1 = x[i];
			switch(x1){
			case 1:
				hs.add(y[i]);
				most_recent = y[i];
				break;
			case 2:
				hs.remove(y[i]);
				break;
			case 3:
				if(hs.contains(y[i]))
					System.out.println("1");
				else
					System.out.println("0");
				break;
			case 4:
				System.out.println(most_recent);
			}
		
		}
		

	}

}
