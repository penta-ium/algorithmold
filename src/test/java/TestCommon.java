import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestCommon {

    public static void main(String[] args) {
        System.out.println(true ^ true);
        System.out.println(true ^ false);
        System.out.println(false ^ false);
        System.out.println(false ^ true);

        Double d = new Double("100.01");

        System.out.println(d.doubleValue() > 100.00);

        Double rate =8.2995;
        NumberFormat num = NumberFormat.getPercentInstance();
        num.setMaximumFractionDigits(2);
        String rates = num.format(rate);
        System.out.println(rates);

        System.out.println(readableFileSize(1000000000000000000L));
    }

    public static String readableFileSize(long size) {
        if (size <= 0) return "0";

        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    @Test
    public void entry() {
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
