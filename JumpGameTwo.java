public class JumpGameTwo {
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int reach = 0;
        int lastPoint = 0;
        int jumps = 0;
        for(int i=0; i<nums.length; i++){
            reach = Math.max(i + nums[i], reach);

            if(i == lastPoint){
                jumps++;
                lastPoint = reach;
                if(lastPoint >= nums.length - 1){
                    break;
                }
            }
        }

        return jumps;
    }
}

//MISTAKE -> DIDN'T CONSIDER FOR THE CASE WHEN N = 1.
//LASTPOINT TO BE UPDATED WAS MAXIMUM REACH WHEN I REACHED THE LASTPOINT BEFORE MAKING JUMP.
