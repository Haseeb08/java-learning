package sorting_algorithms;

import java.util.logging.Logger;

public class Utils {
    private Utils(){}
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static void printArray(int[] arr) {
        printArray(arr, "");
    }

    public static void printArray(int[] arr, String msg) {
        StringBuilder sb = new StringBuilder(msg);
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        LOGGER.info(sb.toString());
    }

}