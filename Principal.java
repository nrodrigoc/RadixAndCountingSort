
public class Principal {
	public static void main(String[] args) {
		int[] ar = {56, 1, 2, 34, 0, 700, 44, 13, 21, 12, 4};
		RadixSort rs = new RadixSort();
		System.out.print("Array inicial: " );
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		
		rs.radixSort(ar);
		System.out.print("\nArray ordenado: " );
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		
	}
}
