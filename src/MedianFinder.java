import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->a-b);
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }

    public void addNum(int num) {
        if(minHeap.size()==0 && maxHeap.size()==0) maxHeap.add(num);
        if(minHeap.size()>maxHeap.size()){
            if(num >minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else maxHeap.add(num);
        }
        else if(maxHeap.size()>minHeap.size()){
            if(num<maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else minHeap.add(num);
        }
        else {
            if (num>minHeap.peek()) minHeap.add(num);
            else maxHeap.add(num);
        }
    }

    public double findMedian() {
        if(minHeap.size()==0 && maxHeap.size()==0) return 0.0;
        if(minHeap.size()> maxHeap.size()) return (double)minHeap.peek();
        if(minHeap.size()< maxHeap.size()) return (double)maxHeap.peek();
        return ((double)(minHeap.peek()+maxHeap.peek()))/2.0;

    }
}