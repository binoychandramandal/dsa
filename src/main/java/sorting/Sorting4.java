package sorting;

import java.util.*;

public class Sorting4 {
    public static void main(String[] args) {
        int[] a = new int[]{10, 3, 8, 15, 6, 12, 2, 18, 7, 1};

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l = new ArrayList<>();
        l.toArray(new Integer[]{});
        
       
                
        l.add(1);
        l.add(3);
        list.add(l);
        l = new ArrayList<>();
        l.add(-2);
        l.add(2);
        list.add(l);
        System.out.println(list);
        System.out.println(solve(list, 2));
        System.out.println(countKDifference(new int[]{7,10,10,6,10,1,9,10,4,9},7));
    }

   static public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> m=new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int target = Math.abs(k-nums[i]);
            int target1 = Math.abs(k+nums[i]);
            if(m.containsKey(target)){
                count+=m.get(target);
            }
            if(m.containsKey(target1)){
                count+=m.get(target1);
            }
            m.put(nums[i],m.getOrDefault(m.get(nums[i]),0)+1);
        }
        return count;
    }

    public int majorityElement(int[] nums) {

        Map<Integer,Integer> m=new HashMap<>();
        for(int a:nums){
            m.put(a,m.getOrDefault(a,0)+1);
        }

        int target = nums.length/2;


        for(Map.Entry<Integer,Integer> e:m.entrySet()){
            if(e.getValue()>=target){
                return e.getKey();
            }
        }
        return nums[0];
    }


    static public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        Collections.sort(A, (ArrayList<Integer> o1, ArrayList<Integer> o2) -> {
                    Double l1 = Math.sqrt(o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1));
                    Double l2 = Math.sqrt(o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1));
                    return l1.compareTo(l2);
                }
        );
        Set<String> s = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int count = 1;
        for (ArrayList<Integer> l : A) {
            String key = "" + l.get(0) + l.get(1);
            if (s.contains(key)) {
                continue;
            }
            result.add(l);
            if (count <= B) {
                break;
            }
        }
        return result;
    }

}