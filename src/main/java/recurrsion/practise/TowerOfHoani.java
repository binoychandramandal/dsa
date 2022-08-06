package recurrsion.practise;

public class TowerOfHoani {
    public static void main(String[] args) {
        toh1(3, "A", "B", "C");
    }

    static void toh(int noOfDisk, String A, String B, String C) {
        if (noOfDisk == 0)
            return;
        //take n-1 disk o A to B using C as temporary tower
        toh(noOfDisk - 1, A, C, B);
        //move nth tower from A to C using C as temporary
        System.out.println(noOfDisk+" Disk move from "+A + " to " + C);
        //take n-1 disk o B to C using A as temporary tower
        toh(noOfDisk - 1,  B,A,C);
    }

    static void toh1(int noOfDisk, String src, String temp, String dest) {
        if (noOfDisk == 0)
            return;
        //take n-1 disk o A to B using C as temporary tower
        toh1(noOfDisk - 1, src, dest, temp);
        //move nth tower from A to C using C as temporary
        System.out.println(noOfDisk+" Disk move from "+src + " to " + dest +" using "+temp);
        //take n-1 disk o B to C using A as temporary tower
        toh1(noOfDisk - 1,  temp,src,dest);
    }
}
