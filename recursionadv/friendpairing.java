package recursionadv;

public class friendpairing {
    public static int friendpairing(int n){
        if(n==2|| n==1){
            return n;
        }
        //single
        int fnm1 = friendpairing(n-1);
        //pairing
        int fnm2 = friendpairing(n-2);
        int pairways = (n-1)*fnm2; //n-1 is the number of ways to choose a friend for pairing
        //total pairing
        int totalpairing= fnm1+ pairways;
        return totalpairing;
    }

    public static void main (String args[]){
        System.err.println("Number of ways to pair friends: "+friendpairing(3));
    }

}
