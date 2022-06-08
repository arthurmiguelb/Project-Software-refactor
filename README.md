# Projeto OO: Iface

## CODE SMELLS
## Long Method 
- Metodo ``performAction`` na classe `MenuLogin` possui nuitas condiçoes com switch case e chama varias funções
- Metodo ``performActionEdit`` na classe `MenuLogin` possui nuitas condiçoes com switch case


## Large Class 
- Classe ``MenuLogin`` faz muita coisa em apenas uma classe. Muitos métodos.
- Classe ``Menu`` faz muita coisa, e possui muitas condições.


## Lazy Class 
- Classe ``Users`` é uma Superclasse que possui apenas uma Subclasse.

 
## Indecent Exposure
- Classe ``Users`` é uma Superclasse, mas na maior parte se utiliza sua Subclasse ``UsersDo`` 


## Primitive Obsession 
- Classe ``Users`` é uma Superclasse que possui muitos arraylist dentro do objeto para armazenar dados
