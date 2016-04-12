package codingforjob;



/*
 * 删除单链表中的某一特定值元素
 */

public class ListDelEqualNumCtrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList llist = new LinkList(1);
//		llist.next = new LinkList(2);
//		llist.next.next = new LinkList(2);
//		llist.next.next.next = new LinkList(3);
		LinkList dellist = delEqualNum(llist, 1);
		while(dellist!=null){
//			System.out.println(del);
			System.out.println(dellist.val);
			dellist = dellist.next;
		}
		
	}
	
	public static LinkList delEqualNum(LinkList head, int x){
		
		LinkList pnode = head, pre = null;
		while(pnode!=null){
			if(pnode.val == x){
				if(pre == null){
					head = pnode.next;
					pnode = pnode.next;
				}
				else{
					pnode = pnode.next;
					pre.next = pnode;
				}
			}
			else{
				pre = pnode;
				pnode = pnode.next;
			}
		}
		return head;
	}
}

class LinkList{
	int val;
	LinkList next;
	
	public LinkList(int val){
		this.val = val;
		this.next = null;
	}
	
}
