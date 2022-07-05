# Projeto OO: Iface

## CODE SMELLS
### Long Method 
- Metodo ``performAction`` na classe `MenuLogin` possui muitas condiçoes com switch case e chama varias funções.
#### Solução 
- Metodo ``perfomaction´´ da classe `menuLogin` foi fragmentado em outros metodos mais objetivos


### Large Class 
- Classe ``MenuLogin`` faz muita coisa em apenas uma classe. Muitos métodos.
#### Solução 
- Classe ``MenuLogin`` foi fragmentada em outras classes mais específicas como: ``Friend``, ``CommunityEdit``.

### Large Method 
- Metodo ``performAction`` na classe `MenuLogin` possui muitas condições de menu com switch case
#### Solução
- Aplicação de padrão `Command` implementada com interface e polimorfismo para substituir o Menu

