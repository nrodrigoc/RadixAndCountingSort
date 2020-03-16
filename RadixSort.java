
public class RadixSort {

	private void countingSort(int[] array, int casaDecimal) {
		
		int size = array.length;
		int sizeAux = getHigherElement(array) + 1;
		
		
		int[] ordenado = new int[size];
		
		//Vetor auxiliar
		int[] auxAr = new int[sizeAux];
		
		//Laço de repetição responsável por zerar todos os elementos do array auxiliar
		for(int i = 0; i < sizeAux; i++)
			auxAr[i] = 0;
		
		//Laço de repetição responsável por transformar cada elemento do array inicial em um índice do array auxiliar
		//O índice relacionado aoelemento no array inicial será incrementado sempre que o mesmo a aparecer
		for(int i = 0; i < size; i++) {
			int indice = (array[i] / casaDecimal) % 10;
			auxAr[indice]++;
		}
		
		//Cada elemento do array auxiliar será somado com o elemento do índice anterior
		//Ao final, cada índice, que também é um elemento no array inicial, será associado à sua posição ordenada + 1
		for(int i = 1; i < 10; i++)
			auxAr[i] += auxAr[i-1];
		
		//Esse laço de repetição armazena a posição ordenada de cada índice do array auxiliar (seu elemento - 1) e 
		//coloca o elemento do array inicial em um array ordenado na posição encontrada
		for(int i = size - 1 ; i >= 0 ; i--) {
			int elemento = array[i]; 
			int posOrdenada = auxAr[(array[i] / casaDecimal) % 10] - 1;
			ordenado[posOrdenada] = elemento;
			auxAr[(array[i] / casaDecimal) % 10]--;
		}
		
		
		for(int i = 0; i < array.length; i++) {
			array[i] = ordenado[i];
		}
	}
	
	public void radixSort(int[] array) {
		int max = getHigherElement(array);
		
		for(int casaDecimal = 1; max / casaDecimal > 0; casaDecimal *= 10)
			countingSort(array, casaDecimal);
		
	}
	
	/*
	 * Retorna o maior elemento do array ar
	 */
	private int getHigherElement(int[] ar) {
		
		int max = ar[0];
		
		for(int i = 1; i < ar.length; i++) {
			max = ar[i] > max? ar[i] : max;
		}
			
		return max;
	}
}
