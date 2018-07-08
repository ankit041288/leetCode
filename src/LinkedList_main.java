import java.util.ArrayList;
import java.util.List;

public class LinkedList_main {
    static class RandomListNode {
        int label;
  RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }

    public static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }







    public static void main(String arsg[]){
/*        RandomListNode h1 = new RandomListNode(-1);
        h1.random=null;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        mergeTwoLists(l1,l2);
        copyRandomList(h1);*/
        ListNode l1 = new ListNode(5);
       // l1.next = new ListNode(4);
        //l1.next.next=new ListNode(3);

        ListNode l2 = new ListNode(5);
      //  l2.next = new ListNode(6);
       // l2.next.next=new ListNode(4);
        //addTwoNumbers(l1,l2);
        RandomListNode r1 = new RandomListNode(-1);
        copyRandomList1(r1);

    }

    public static  RandomListNode copyRandomList1(RandomListNode h) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode temp = head;
        RandomListNode temp1=head;
        if(h==null) return h;
        while(h!=null){
            temp.next=h;

            temp.next.random=h;
            h=h.next;
            temp=temp.next;
        }
        temp1=temp1.next;
        while(temp1!=null){
            temp1.random = temp1.random.random;
            temp1=temp1.next;
        }
        return head.next;


    }




    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 ==null && l2 ==null) return null;
        if(l1==null && l2 !=null) return l2;
        if(l1!=null && l2 ==null) return l1;
        ListNode head = new ListNode(0);
        ListNode temp=head;
        int carry=0;
        int sum =0;
        while(l1 !=null || l2 !=null || carry!=0){
            int n1=0,n2=0;
            if(l1 !=null)  n1=l1.val;
            if(l2 !=null)  n2=l2.val;
            sum = carry+ n1 + n2 ;
            carry=0;
            if(sum >=10) carry =1;
            sum = sum %10;
            ListNode temp1 = new ListNode(sum);
            sum=0;
            temp.next=temp1;
            temp=temp.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return head.next;


    }


    public  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp1= new ListNode(0);
        ListNode temp = temp1;
        while(l1 !=null && l2 !=null){
            if(l1.val<=l2.val){
                temp.next =new ListNode(l1.val);
                temp=temp;
                l1 = l1.next;
            }
            else {
                temp.next =new ListNode(l2.val);
                l2=l2.next;
            }
        }
        if(l1 !=null){
            temp.next=l1;
        }
        if(l2 !=null){
            temp.next=l2;
        }
        return temp1.next;


    }
    public static  RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = new RandomListNode(0);

        RandomListNode copy=temp;
        while(head !=null){
            copy.next=head;
            copy.next.random=head;
            copy=copy.next;
            head=head.next;
        }
        RandomListNode temp1=temp;
        temp1=temp1.next;
        while(temp1!=null){
            temp1.random = temp1.random.random;
            temp1 = temp1.next;
        }
        return temp.next;


    }





    private LNode deleteDups(LNode head){
        List<Integer> LSet = new ArrayList<>();
        LNode prev = null;
        LNode h = head;
        while(h!=null){
            if(LSet.contains(h.data)) {
                prev.next=h.next;
            }
            else LSet.add(h.data);
            prev=h;
            h = h.next;
        }
        return head;
    }



}
