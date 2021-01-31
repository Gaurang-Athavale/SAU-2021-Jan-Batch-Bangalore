package com.assignment.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MockitoApplicationTests {

	Mock1 mock1 = new Mock1();
	Mock2 mock2 = new Mock2();

	@Test
	public void testToUpperCase() {
		Mock1 mock1 = mock(Mock1.class);
		when(mock1.getName()).thenReturn("GAURANG");
		String str = mock2.convertToLowerCase(mock1);
		assertEquals("gaurang", str);
	}

	@Test
	public void testSum() {
		Mock1 demo1 = mock(Mock1.class);
		int arr[] = {1, 2, 3, 4};
		when(demo1.getMarks()).thenReturn(arr);
		int sum = mock2.sum(mock1);
		assertEquals(62, sum);
	}

	@Test
	public void testgetMax(){
		Mock2 obj = mock(Mock2.class);
		int arr[] = {64, 128, 256, 512, 1024};
		when(obj.getNumbers()).thenReturn(arr);
		int res = mock1.getMax(obj);
		assertEquals(1024,res);
	}

	@Test
	public void testSubstring(){
		Mock2 obj = mock(Mock2.class);
		String str = "Gaurang Athavale";
		when(obj.getDepartment()).thenReturn(str);
		String res = mock1.subStringCalc(obj);
		assertEquals("Gaur",res);
	}
}
