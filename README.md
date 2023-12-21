## graphicSortingMethods

O repositório em questão implementa a visualização e a comparação de algoritmos que implementam
métodos de ordenação.
É possível ter informação visual de como opera cada um dos métodos de ordenação, além de ter uma
noção comparativa do tempo requisitado por cada um.

## Compilando e executando o programa

O arquivo principal com a implementação e chamada dos métodos é o Main.java. Para executar o programa
no VSCode, basta ir no arquivo Main.java, procurar pela chamada 

    public static void main(String args[])

Acima da main, haverá a opção de rodar ou debugar, selecione a opção Run e o código será compilado.
No VSCode também é possível executar o programa clicando no arquivo com o botão direito do mouse e selecionando a opção Run Java.
Na compilação por linha de comando, digite

    javac Main.java

E logo em seguida

    java Main

## Métodos de Ordenação

### Bubble Sort

Percorre a lista diversas vezes, compara elementos adjacentes e os troca se estiverem na ordem errada.
É chamado "Bubble" porque os elementos menores "sobem" para suas posições corretas, assim como as bolhas na água.

### Cocktail Sort

É uma variação do Bubble Sort.
Percorre a lista em ambas as direções, movendo o maior elemento para o final e o menor para o início, alternadamente.

### Comb Sort

É uma melhoria do Bubble Sort e Cocktail Sort.
Usa um fator de redução para determinar a distância entre os elementos comparados e trocados, reduzindo essa distância ao longo do tempo.

### Heap Sort

Constrói uma árvore binária chamada heap e, em seguida, converte a heap em uma árvore binária completa.
Repetidamente remove o maior elemento (raiz) e reconstrói a heap até que toda a lista esteja ordenada.

### Insertion Sort

Percorre a lista e insere cada elemento na posição correta em relação aos elementos já ordenados.
Eficiente para listas pequenas ou quase ordenadas.

### Merge Sort

Divide a lista pela metade, ordena cada metade recursivamente e, em seguida, combina as duas metades ordenadas.
Usa a estratégia "dividir para conquistar".

### Quick Sort

Escolhe um elemento pivô, rearranja os elementos de forma que os menores fiquem à esquerda e os maiores à direita do pivô.
Aplica a recursão nas duas sublistas resultantes.

### Selection Sort

Divide a lista em uma parte ordenada e outra não ordenada.
Encontra o menor elemento na parte não ordenada e o coloca no final da parte ordenada, repetindo esse processo.

### Shell Sort

É uma variação de inserção que compara elementos distantes entre si e troca elementos que estão fora de ordem.
Usa uma sequência de lacunas ou incrementos que reduzem à medida que o algoritmo avança, até que o último passo seja uma simples ordenação por inserção.

