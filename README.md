# Trabalho de Avaliação — Algoritmos e Estruturas de Dados

## 1. Identificação

**Alunos:** Gabriel Oliveira Faraco, Larissa Mariana Fontes Reis e Emanuel da Silva Teixeira
**Disciplina:** Algoritmos e Estruturas de Dados  
**Linguagem:** Java 25

## 2. Introdução

Este trabalho tem como objetivo aplicar os conhecimentos adquiridos sobre estruturas de dados, por meio da implementação manual de pilhas, filas, listas simplesmente ligadas e listas duplamente ligadas. Essas estruturas são importantes para organizar, armazenar e manipular informações de maneira eficiente. Sua implementação permite compreender melhor o funcionamento da memória, das referências entre objetos e dos ponteiros que conectam os elementos, além de desenvolver o raciocínio lógico e a capacidade de resolver problemas utilizando algoritmos.

## 3. Implementação

O projeto foi desenvolvido em Java 25 e dividido em classes, com o objetivo de organizar o código e separar as responsabilidades de cada estrutura.

### 3.1. Sistema de gerenciamento de pedidos

O primeiro exercício consiste em um sistema de gerenciamento de pedidos para uma cafeteria, utilizando uma fila e uma pilha implementadas com listas simplesmente ligadas.

A fila é responsável por armazenar os pedidos pendentes, seguindo o princípio FIFO (*First In, First Out*), no qual o primeiro pedido inserido é o primeiro a ser removido. Ela permite adicionar novos pedidos, atender o pedido mais antigo e exibir todos os pedidos pendentes.

A pilha armazena os pedidos cancelados e segue o princípio LIFO (*Last In, First Out*), no qual o último elemento inserido é o primeiro a ser removido. Dessa forma, é possível cancelar pedidos e restaurar o cancelamento mais recente.

Cada pedido possui um identificador e uma descrição. Os nós armazenam as referências para os pedidos e para os próximos nós da estrutura.

As principais classes utilizadas são:

- **Pedido:** armazena o identificador e a descrição de cada pedido.
- **NoPedido:** representa o nó utilizado para conectar os elementos.
- **FilaPedidos:** implementa as operações de inserção, remoção e exibição dos pedidos pendentes.
- **PilhaCancelados:** implementa as operações de adicionar, remover e exibir os pedidos cancelados.

### 3.2. Gerenciamento de playlist

O segundo exercício consiste em um gerenciador de playlists musicais, utilizando uma lista duplamente ligada. Cada música possui título, artista, álbum e duração em segundos.

A lista duplamente ligada permite percorrer os elementos nos dois sentidos, utilizando referências para o nó anterior e para o próximo nó. Isso possibilita navegar entre as músicas, mantendo a indicação da música atual.

O sistema permite adicionar músicas no início, no final ou em uma posição específica, remover músicas pela posição ou pelo título, listar as músicas cadastradas, pesquisar por título, artista ou álbum e simular a reprodução da música atual. Também é possível ordenar a playlist alfabeticamente pelo título ou pelo nome do artista.

As principais classes utilizadas são:

- **Musica:** armazena as informações de cada música.
- **NoMusica:** representa o nó que contém uma música e as referências para os nós anterior e próximo.
- **ListaMusicas:** implementa manualmente as operações de inserção, remoção, navegação, busca, ordenação e listagem.
- **PlaylistMenu:** organiza o menu interativo e permite que o usuário escolha as operações disponíveis.

### 3.3. Tratamento de casos críticos

Durante a implementação, foram considerados casos que poderiam causar erros durante a execução do programa.

Na fila e na pilha, as operações de remoção verificam se a estrutura está vazia antes de tentar remover um elemento. Na fila, quando o último pedido é removido, as referências de início e fim são atualizadas corretamente.

Na lista duplamente ligada, as operações verificam se as posições informadas são válidas. Durante as inserções e remoções, as referências para os nós anterior e próximo são atualizadas para manter a estrutura consistente. Quando a lista fica vazia, as referências de início, fim e música atual são redefinidas.

Esses cuidados permitem que o programa trate situações como estruturas vazias, posições inválidas e tentativas de remoção de elementos inexistentes.

## 4. Conclusão

O desenvolvimento deste trabalho permitiu aprofundar os conhecimentos sobre pilhas, filas e listas ligadas, compreendendo na prática como essas estruturas funcionam e como podem ser implementadas sem o uso de classes prontas para sua manipulação.

Uma das principais dificuldades foi manter as referências entre os nós atualizadas durante as operações de inserção e remoção, especialmente nos casos em que a estrutura estava vazia ou possuía apenas um elemento. Essas situações foram tratadas por meio de verificações e atualizações das referências envolvidas.

Também foi possível compreender melhor as diferenças entre os princípios FIFO e LIFO, além da importância das listas duplamente ligadas para permitir a navegação nos dois sentidos.

Conclui-se que a atividade contribuiu para o desenvolvimento do raciocínio lógico e para a compreensão do funcionamento interno das estruturas de dados, conhecimentos importantes para a construção de programas organizados e eficientes.
