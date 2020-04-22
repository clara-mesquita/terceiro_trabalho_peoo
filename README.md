# Trabalho da disciplina de PEOO
###### Semestre 2019.2 - UECE

#### **Data de entrega:** 22 de abril.
#### Valor: 5 pontos.

|   Alunas             | Matrícula |   E-mail UECE                 |
|----------------------|-----------|-------------------------------|
| Maria Clara Mesquita |  1514909  |  clara.mesquita@aluno.uece.br |
| Danielle Santos      |  1514780  | danielle.santos@aluno.uece.br |

### Trabalho da Implementação da Televião e Controle Remotos
Enviado por professor Paulo Henrique.

> Este trabalho é a continuação do exercício sobre implementação da televisão e controle remotos passado em classe, porém com algumas alterações.
>
>1. Crie a classe Canal, que representa um canal de TV, que possui como atributos um número, um nome e um booleano HD, que indica se o canal é digital ou não, e métodos de get e set para cada atributo. Exemplos de objetos canais: 8 – Record – False; 10 – Globo -False; 12 – Band – True.
>
>2. Crie uma classe Televisão que contém como atributos um id (pode ser o nome do fabricante e um número de modelo qualquer, ex: LG345), o volume, o canal atual, uma lista de canais cadastrados, e uma lista de canais disponíveis. Crie uma constante com o volume máximo = 10 e outra com o volume mínimo = 0. Crie um construtor que receba como parâmetro a lista de canais disponíveis, atribua-a à sua lista interna, e configure o volume para 5. Crie métodos de get e set para o volume e para canal atual.
> 
>3. Incremente a classe Televisão com os seguintes métodos:
> a) alterar volume: recebe como parâmetro se aumenta ou diminui. No primeiro caso, incrementa o volume da TV em 1 unidade, mas não pode ultrapassar o máximo. No segundo caso, decrementa o volume da TV em 1 unidade, mas não pode ultrapassar o mínimo.
> b) cadastrar canais: método abstrato.
>
> c) verificar canal existente: recebe como um parâmetro um canal e retorna verdadeiro, caso o canal já exista na programação da TV, e falso caso contrário.
>
> d) sintonizar: recebe como parâmetro um número, representando o canal da TV desejado, busca na lista de canais o canal com esse número e, caso exista, altera o canal atual para este.  Caso não exista, dispara uma exceção de canal inexistente (você deve criar essa exceção).
>
> e) alterar canal: recebe como parâmetro “próximo” ou “anterior” e altera o canal atual de acordo com o parâmetro solicitado. Se o canal atual for o último da lista e for solicitado próximo canal, deve-se voltar ao início da lista. Já se for o primeiro canal e solicitar o anterior, deve-se pular para o último canal da lista.
>
> f) informar dados: mostra os dados do canal atual (nome, número e se é HD) e do volume. 
>
> g) mostrar grade: apresenta a lista ordenada por número de canais disponíveis, mostrando todos os dados de cada canal.
>
>4. Crie as classes SmartTV e TVHD que especializam a Televisão. A primeira possui como atributo a quantidade de polegadas, enquanto a segunda possui como atributo o modelo de TV (LED, Plasma, HD). Crie um construtor para cada uma para inicializar seus atributos. A SmartTV implementa o método de cadastrar canais inserindo na lista de canais todos os canais existentes na lista de canais disponíveis e, ao final, seta como canal atual o primeiro da lista.  A segunda classe cadastra novos canais apenas se eles forem HD e, ao final, seta como canal atual o último da lista.
>5. Crie uma classe ControleRemoto que pode manipular uma lista de televisões, sejam elas SmartTvs ou TVHDs (use polimorfismo, ou seja, considere todas do tipo Televisão), ao mesmo tempo. Portanto, o controle tem como atributo a lista de TVs que ele controla. Crie um método para adicionar TV, que recebe um objeto do tipo Televisão e o adiciona na lista de TVs apenas se a TV não estiver cadastrada. Se já estiver, dispare uma exceção de TV já cadastrada. Essa classe também disponibiliza ao usuário as seguintes funcionalidades da TV por meio de métodos (que simulam os botões do controle físico): aumentar volume, diminuir volume, sintonizar canal específico, próximo canal, canal anterior, informar dados, e mostrar grade. 
>
>**OBS:** Esse item (5) não pede pro controle ter a função de cadastrar canais.
>
>6. Crie uma classe Principal na qual vários canais são criados (varie entre HDs e não HDs). Em seguida, crie pelo menos 2 TVs (uma de cada tipo), e cadastre os canais criados. Crie um objeto do controle remoto, associe a ele as TVs criadas, e ofereça ao usuário um menu com as opções disponíveis. Toda vez que o usuário escolhe uma opção, o método correspondente nas TVs é executado e o resultado é apresentado no console.

### Informações sobre a pasta "código":
- *Main.java*: classe principal, como solicitada no item 6.
- *ControleRemoto.java*: classe do controle remoto, como solicitado no item 6.
- Pasta *televisoes*: possui as classes *Canal.java* (colicitado no item 1), *Televisao.java* (requisitado no item 2 e com os incrementos do item 3), *TVHD.java* e *SmartTV.java* (solicitados no item 4).
- Pasta *exceptions*: com as exceções personalizadas para os canais existentes (item 3, d) e para TV já cadastrada (item 5).
- Pasta *sort*: possui a classe *SortByNumber*, auxiliar para a orednação do método mostrar grade.
