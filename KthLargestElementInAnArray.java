//Using MinHeap
//time Complexity: nlog(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums, (a,b)-> b-a); overwrite the comparator to sort in descending order
        /*Arrays.sort(nums, (a,b) ->{ //this is for ascending. for descending reverse
            if(a > b) //a-b, bring b forward
                return true;
            else if(a < b){
                return false;
            }
        });*/
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){ // n elements
            pq.add(num); //log(k)
            if(pq.size() > k){
                pq.poll(); //log(k)
            }
        }
        return pq.peek();
    }
}

//using MaxHeap
//TimeComplexity: nlog(n-k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Arrays.sort(nums, (a,b)-> b-a); overwrite the comparator to sort in descending order
        /*Arrays.sort(nums, (a,b) ->{ //this is for ascending. for descending reverse
            if(a > b) //a-b, bring b forward
                return true;
            else if(a < b){
                return false;
            }
        });*/
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num: nums){ // n elements
            pq.add(num); //log(k)
            if(pq.size() > n-k){
                result = Math.min(pq.poll(), result);
            }
        }
        return result;
    }
}