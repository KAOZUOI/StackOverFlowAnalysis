package datastructures.algorithms;import java.io.IOException;import java.util.ArrayDeque;import java.util.Arrays;import java.util.Comparator;import java.util.HashSet;import java.util.List;import java.util.Scanner;import java.util.Set;public class PaintBucketCSMinesSolution {    public static void main(String[] args) throws IOException {        // maintain distinct list of points that have been visited//      Set<int[]> exploredSet = new TreeSet<>(//              Comparator.comparingInt((int[] el) -> el[1]).thenComparingInt(el -> el[0]));        Set<List<Integer>> exploredSet = new HashSet<>();        int W;        int H;        int X;        int Y;        int[][] picture;        Scanner sc = new Scanner(System.in);        W = sc.nextInt();        H = sc.nextInt();        X = sc.nextInt();        Y = sc.nextInt();        picture = new int[H][W];        for (int i = 0; i < H; i++) {            for (int j = 0; j < W; j++) {                picture[i][j] = sc.nextInt();            }        }        sc.close();        int color = picture[Y][X];        ArrayDeque<List<Integer>> toExploreStack = new ArrayDeque<>();        toExploreStack.add(Arrays.asList(X, Y));        while (!toExploreStack.isEmpty()) {            List<Integer> point = toExploreStack.pop();            int px = point.get(0);            int py = point.get(1);            // System.out.println(exploredSet.contains(point));            boolean execute = true;            if (exploredSet.contains(point)) {                execute = false;            }            if (execute) {                exploredSet.add(point);                if (px > 0 && picture[py][px - 1] == color) {                    toExploreStack.add(Arrays.asList(px - 1, py));                }                if (px < (W - 1) && picture[py][px + 1] == color) {                    toExploreStack.add(Arrays.asList(px + 1, py));                }                if (py > 0 && picture[py - 1][px] == color) {                    toExploreStack.add(Arrays.asList(px, py - 1));                }                if (py < (H - 1) && picture[py + 1][px] == color) {                    toExploreStack.add(Arrays.asList(px, py + 1));                }            }        }        // Sorting HashSet using List        // exploredSet.sort(Comparator.comparingInt((List<Integer> el) ->        // el.get(1)).thenComparingInt(el -> el.get(0)));        Comparator<List<Integer>> comp = Comparator.comparingInt((List<Integer> x) -> x.get(1))                .thenComparingInt(x -> x.get(0));        exploredSet.stream().sorted(comp).map(v -> v.get(0) + &quot; &quot; + v.get(1)).forEach(System.out::println);    }}