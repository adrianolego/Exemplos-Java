# O programa foi feito da seguinte forma

Uma classe Forma onde a classe círculo e retângulo a implementam,
também foi criado um enum de cores.

Da forma como estava toda forma não tinha que ter uma cor, então foi criado a interface abstrata obrigando quem a estendesse
 a implementar apenas o método de cálculo de área e a cor

 Se fosse criado uma forma com o atributo cor toda subClasse de Forma seria obrigado a ter uma cor o que não é o nosso escopo

 A classe AbstractForma implementa a interface Forma porém precisaria implementar o método area que esta descrito na
 interface Forma, para não fazer essa implementação a classe AbstractForma passou a ser abstrata, ela passou a ser uma
 implementação abstrata de Forma não sendo obrigada a implementar o método área e contendo um atributo Cor.

 Agora toda classe que implemente AbstractForma passa a ter um método cor da classe Abstrata e um método Area da interface Forma

 Se alguma classe implementar a interface Forma ela precisa apenas implementar o metodo Área não sendo obrigada a ter
 uma cor, sendo assim a interface Forma pode ser reutilizada para outros fins fora do nosso escopo


