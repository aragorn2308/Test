import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PackagingProblem {
	public static void main(String args[]) throws IOException{
		PackagingProblem packagingProblem = new PackagingProblem();
		String sCurrentLine;
		BufferedReader bufferReader = null;
		List<Item> items = null;
		bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String path = bufferReader.readLine().trim();
		bufferReader = new BufferedReader(new FileReader(path));
		while ((sCurrentLine = bufferReader.readLine()) != null) {
			int W = Integer.parseInt(sCurrentLine.split(" ")[0]);
			items = new ArrayList<>();
			String[] values = sCurrentLine.split(" ");
			String[] newValues = Arrays.copyOfRange(sCurrentLine.split(" "), 2, values.length);
			String tempString = null;
			Item tempItem = null;
			for(int i=0;i<newValues.length;i++){
				tempString = newValues[i].substring(1, newValues[i].length()-1);
				String[] tempArr = tempString.split(",");
				tempItem = new Item(Integer.parseInt(tempArr[0]), 
						Float.parseFloat(tempArr[1]), 
						Integer.parseInt(tempArr[2].substring(1, tempArr[2].length())));
				items.add(tempItem);
			}
			ArrayList<Integer> itemsList = new ArrayList<>();
			//			System.out.println(knapSack(items, items.size(), W, itemsList));
			packagingProblem.getPerfectPackaging(items, items.size(), W, itemsList);
			String listOfItems = itemsList.toString();
			// to Print in the Given Format
			if(listOfItems.length()==2)
				System.out.println("-");
			else
				System.out.println(listOfItems.substring(1, listOfItems.length()-1));
		}

	}
	/**
	 * 
	 * @param items 
	 * @param index of item
	 * @param max allowed W
	 * @param itemsList to track the items added
	 * @return max Value that can be obtained
	 */
	private int getPerfectPackaging(List<Item> items, int n, float W, ArrayList<Integer> itemsList){
		if(n==0||W<0)
			return 0;
		if(items.get(n-1).weight>W)
			return (getPerfectPackaging(items, n-1, W, itemsList));
		else{
			//return Math.max(items.get(n-1).value+knapSack(items, n-1, W-items.get(n-1).weight),knapSack(items, n-1, W));
			int previousLength = itemsList.size();
			int val1 = items.get(n-1).value+getPerfectPackaging(items, n-1, W-items.get(n-1).weight, itemsList);
			int afterLength = itemsList.size();
			int val2 = getPerfectPackaging(items, n-1, W, itemsList);
			if(val1>val2){
				if(itemsList.size() > afterLength){
					itemsList.subList(afterLength, itemsList.size()).clear();
				}
				itemsList.add(items.get(n-1).index);
				return val1;
			}else{
				if(afterLength>previousLength){
					itemsList.subList(previousLength, afterLength).clear();
				}
				return val2;
			}

		}	
	}

	private static class Item{
		int index;
		float weight;
		int value;
		Item(){

		}
		Item(int index, float weight, int value){
			this.index = index;
			this.value = value;
			this.weight = weight;
		}
	}
}
