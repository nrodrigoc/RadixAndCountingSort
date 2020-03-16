
public class CountingSort {
	
	public CountingSort(int[] ar) {
		
		int tam = ar.length;
		//Array com o resultado da ordenação
		int[] ordenado = new int[tam];
		
		//tamanho do array auxiliar com tamanho igual ao maior elemento do Array principal + 1
		int tamAux = getHigherElement(ar) + 1;
		
		//Vetor auxiliar
		int[] auxAr = new int[tamAux];
		
		//Laço de repetição responsável por zerar todos os elementos do array auxiliar
		for(int i = 0; i < auxAr.length; i++)
			auxAr[i] = 0;
		
		//Laço de repetição responsável por transformar cada elemento do array inicial em um índice do array auxiliar
		//O índice relacionado aoelemento no array inicial será incrementado sempre que o mesmo a aparecer
		for(int i = 0; i < ar.length; i++) {
			int element = ar[i];
			auxAr[element]++;
		}
		
		//Cada elemento do array auxiliar será somado com o elemento do índice anterior
		//Ao final, cada índice, que também é um elemento no array inicial, será associado à sua posição ordenada + 1
		for(int i = 1; i < auxAr.length; i++) {
			auxAr[i] += auxAr[i-1];
		}
		
		//Esse laço de repetição armazena a posição ordenada de cada índice do array auxiliar (seu elemento - 1) e 
		//coloca o elemento do array inicial em um array ordenado na posição encontrada
		for(int i = 0; i < ar.length; i++) {
			int elemento = ar[i]; 
			int posOrdenada = auxAr[elemento] - 1;
			auxAr[elemento]--;
			ordenado[posOrdenada] = elemento;
		}
		
		
		for(int i = 0; i < ar.length; i++) {
			ar[i] = ordenado[i];
		}
	}
	
	/*
	 * Retorna o maior elemento do array ar
	 */
	public int getHigherElement(int[] ar) {
		
		int higher = ar[0];
		
		for(int i = 1; i < ar.length; i++) {
			higher = ar[i] > higher? ar[i] : higher;
		}
			
		return higher;
	}
	
}
