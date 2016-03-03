
public class testting {

	public static void main(String[] args) {
		testting t = new testting();
		node n = t.getNode(10);
		n.next = t.getNode(20);
		n.next.next = t.getNode(30);
		node p = n;
		while(p != null){
			System.out.println(p.data);
			p=p.next;
		}
		node xxx = t.reverseList(n);
		System.out.println(xxx.data);
		p = xxx;
		while(p != null){
			System.out.println(p.data);
			p=p.next;
		}
	}
	
	public node getNode(int x){
		return this.new node(x);
	}
	
	public node reverseList(node z){
		node p = null;
		node c = z;
		node n = z.next;
		while(n!=null){
			c.next = p;
			p = c;
			c = n;
			n = n.next;
		}
		c.next = p;
		return c;
	}
	
	
	public class node{
		int data;
		node next;
		public node(int x){
			data = x;
			next = null;
		}
	}

}
