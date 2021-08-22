package com.soumadri.rest.model;

class Main {

    public static String KUniqueCharacters(String str) {
        // code goes here
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        //2aabbacbaa
        
        int target = Integer.valueOf(str.substring(0,1));   //2
        String longest = "";
        int left =1; int right =1;
        boolean isRightIncremented = true;
        while(right < str.length()){
            if(isRightIncremented){
                char c = str.charAt(right);
                map.put(c,map.getOrDefault(c,0)+1);
            }

            //System.out.println(map);
            if(map.size() > target){
                isRightIncremented = false;
                longest = ( longest.length()<right-left)?str.substring(left,right):longest;
        /*while(map.size() > target && left < target){
              char k = str.charAt(left);
              int count = map.getOrDefault(k,0);
              if(count <= 0 && map.containsKey(k)) map.remove(k);
              else
                map.put(k,map.getOrDefault(k,0)-1);
              left++;
        }*/
                //  System.out.println(map);
                int count = map.getOrDefault(str.charAt(left),0);
                map.put(str.charAt(left) , count-1);

                if(count == 1) map.remove(str.charAt(left));
                left++;
            }else{
                right++;
                isRightIncremented= true;

            }
            //    System.out.println("l:"+left+" R:"+right);
        }
        //  System.out.println(map);
        if(map.size() == target){
            longest = ( longest.length()<right-left)?str.substring(left,right):longest;
        }
        return longest;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(KUniqueCharacters(s.nextLine()));
    }

}