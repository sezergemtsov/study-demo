public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};

        int[][] bTree = binaryTree(arr);
        printArr(bTree);

    }

    public static int[][] mark(int[] arr, int[][] arr1, int start, int stop, int lvl, int deep) {


        if (start <= stop) {
            if (start == stop) {
                arr1[lvl][start] = arr[start];
            } else {
                int index = (start + stop) / 2;
                arr1[lvl][index] = arr[index];
            }

            if (lvl < deep - 1 && start < stop) {
                mark(arr, arr1, start, ((start + stop) / 2) - 1, lvl + 1, deep); //left
                mark(arr, arr1, ((start + stop) / 2) + 1, stop, lvl + 1, deep); //right
            }
        }

        return arr1;
    }


    public static void printArr(int[][] arr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    str.append(arr[i][j]);
                } else {
                    str.append(' ');
                    str.append(' ');
                }
            }
            str.append('\n');
        }
        System.out.println(str);
    }

    public static int[][] binaryTree(int[] arr) {

        int deep = (int) (Math.log(arr.length + 1) / Math.log(2));
        int[][] arr1 = new int[deep][arr.length];

        mark(arr, arr1, 0, arr.length - 1, 0, deep);

        return arr1;
    }
}
