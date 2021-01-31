package com.assignment.mockito;

public class Mock2 {
    public Mock1 mock1;

    public int sum(Mock1 mock1) {
        this.mock1 = mock1;
        int a[] = mock1.getMarks();
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public String convertToLowerCase(Mock1 mock1) {
        this.mock1 = mock1;
        String str = mock1.getName();
        return str.toLowerCase();
    }

    public int[] getNumbers() {
        int a[] = {64, 128, 256, 512, 1024};
        return a;
    }

    public String getDepartment() {
        return "Computer Engineering";
    }
}
