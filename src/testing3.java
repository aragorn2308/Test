import java.util.Stack;
public class testing3 {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		testing3 t = new testing3();
		t.reverseStack(s);
	}
	
	public void reverseStack(Stack s){
		if(!s.isEmpty()){
			int temp = (int) s.pop();
			reverseStack(s);
			s.push(temp);	
		}
	}

}
