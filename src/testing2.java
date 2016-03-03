import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class testing2 {
	public static void main(String[] args){
		testing2 tt = new testing2();
		node root = tt.getNode(20);
		root.left = tt.getNode(15);
		root.right = tt.getNode(35);
		root.left.left = tt.getNode(10);
		root.left.right = tt.getNode(16);
		root.right.left = tt.getNode(30);
		root.right.right = tt.getNode(40);
		tt.inorder(root);
		System.out.println("---------------------");
		tt.bfs(root);
		System.out.println("---------------------");
		tt.dfs(root);
		System.out.println("---------------------");
		tt.spiralOrder(root);
		Stack<node> ss = new Stack<node>();
		System.out.println("---------------------next");
		tt.findNodePath(ss, 16, root);
		System.out.println("---------------------");
		System.out.println(tt.lca(root, 15, 40));
	}
	
	public void inorder(node root){
		if(root!=null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	
	public void spiralOrder(node root){
		Stack<node> q1 =  new Stack<node>();
		Stack<node> q2 = new Stack<node>();
		q1.add(root);
		node temp = null;
		while(!q1.isEmpty() || !q2.isEmpty()){
			while(!q1.isEmpty()){
				temp = q1.pop();
				System.out.println(temp.data);
				if(temp.left != null)
					q2.add(temp.left);
				if(temp.right != null)
					q2.add(temp.right);
					
			}
			while(!q2.isEmpty()){
				temp = q2.pop();
				System.out.println(temp.data);
				if(temp.right != null)
					q1.add(temp.right);
				if(temp.left != null)
					q1.add(temp.left);
			}
		}
	}
	
	public boolean findNodePath(Stack<node> s ,int k, node root){
		if(root==null)
			return false;
		s.push(root);
		if(root.data==k)
			return true;
		if (findNodePath(s,k,root.left) || findNodePath(s,k,root.right))
			return true;
			s.pop();
		return false;
	}
	public void bfs(node root){
		Queue<node> q = new LinkedList<node>();
		q.add(root);
		node temp = null;
		while(!q.isEmpty()){
			temp = q.element();
			q.remove();
			System.out.println(temp.data);
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	
	public void dfs(node root){
		Stack<node> s = new Stack<node>();
		s.push(root);
		node temp = null;
		while(!s.isEmpty()){
			temp = s.pop();
			System.out.println(temp.data);
			if(temp.left!=null)
				s.push(temp.left);
			if(temp.right!=null)
				s.push(temp.right);
		}
	}
	public int lca(node root, int x, int y){
		if(root.data>x && root.data>y){
			return lca(root.left, x, y);
		}
		if(root.data<x && root.data<y){
			return lca(root.right,x,y);
		}
		return root.data;
	}
	public node getNode(int x){
		return new node(x);
	}
	public class node{
		public node left;
		public node right;
		int data;
		node(int x){
			this.left = null;
			this.right = null;
			this.data = x;
		}
	}	
}	
