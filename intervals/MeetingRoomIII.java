public class MeetingRoomIII {
    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
            PriorityQueue<Integer> roomsInIdle = new PriorityQueue<>();
            PriorityQueue<int[]> roomsInBusy = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            int[] countRooms = new int[n];
            int i = 0;
    
            for(i=0; i<n; i++){
                roomsInIdle.add(i);
            }
            i = 0;
            while(i < meetings.length){
                int startTime = meetings[i][0];
                int endTime = meetings[i][1];
    
                while(!roomsInBusy.isEmpty() && roomsInBusy.peek()[1] <= startTime){
                    roomsInIdle.add(roomsInBusy.poll()[0]);
                }
    
                int roomForCurrMeet = -1;
                if(!roomsInIdle.isEmpty()){
                    roomForCurrMeet = roomsInIdle.poll();
                    roomsInBusy.add(new int[] {roomForCurrMeet, endTime}); 
                }else{
                    int[] busyCurrRoom = roomsInBusy.poll();
                    roomForCurrMeet = busyCurrRoom[0];
                    roomsInBusy.add(new int[] {roomForCurrMeet, busyCurrRoom[1] + endTime - startTime});
                }
                countRooms[roomForCurrMeet] += 1;
                i += 1;
            }
            int mostBookedRoom = 0;
            for(i=1; i<n; i++){
                if(countRooms[mostBookedRoom] < countRooms[i]){
                    mostBookedRoom = i;
                }
            }
            return mostBookedRoom;
        }
    }
}
