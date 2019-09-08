package test;

public class ArithemeticCalculateImpl implements ArithemeticCalculate{

	@Override
	public int add(int i, int j) {
		System.out.println(i + j);
		return i + j;
	}

}
