package string ;

public class shortestpath {

    public static float getShortestPath(String path) {

        int x = 0, y = 0;

        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);

            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
        }

        int X2 = x * x;
        int Y2 = y * y;

        return (float) Math.sqrt(X2 + Y2);
    }

    public static void main(String[] args) {
        String path = "WNSEWSNN";
        System.out.println(getShortestPath(path));
    }
}
