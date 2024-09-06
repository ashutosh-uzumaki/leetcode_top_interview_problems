package array_string;

public class Gas {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;
        for(int i=0; i<n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas){
            return -1;
        }

        int startPlace = 0;
        int gasRequired = 0;
        for(int i=0; i<n; i++){
            gasRequired += (gas[i] - cost[i]);
            if(gasRequired < 0){
                startPlace = i + 1;
                gasRequired = 0;
            }
        }

        return startPlace;
    }
}
