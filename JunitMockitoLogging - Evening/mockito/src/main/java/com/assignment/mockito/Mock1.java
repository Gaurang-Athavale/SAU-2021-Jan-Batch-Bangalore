package com.assignment.mockito;

public class Mock1 {
    public Mock2 mock2;

    public int[] getMarks() {
        int a[] = {2, 4, 8, 16, 32};
        return a;
    }

    public String getName() {
        return "Gaurang";
    }

    public int getMax(Mock2 mock2) {
        int a[] = mock2.getNumbers();
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public String subStringCalc(Mock2 mock2){
        String str = mock2.getDepartment();
        return str.substring(0,4);
    }
}
