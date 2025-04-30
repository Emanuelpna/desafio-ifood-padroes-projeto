# Sistema Clone Ifood

Implementar um sistema de entrega de pedidos usando:

- Factory Method
- Singleton
- State
- Observer

Fazer:

- Diagrama de Estado
- Diagrama de Classe
- Código
- Testes

Cada estado é um singleton
Factory de pedidos gera pedido de mercado, restaurante, e etc


## Mudanças de Estados

- Pedido começa como Pendente, aguardando a confirmação do estabelecimento. Podendo ser cancelado por ambas as partes.
- Pedido pode então passar para preparando, após confirmação
- Um pedido em preparação pode ter seu cancelamento solicitado pelo cliente ou pelo estabelecimento
- Caso contrário, Pedido é enviado para entrega
- Um Pedido em rota de entrega pode ser cancelado pelo usuário, em caso de demora excessiva por exemplo
- Caso ele não seja cancelado é marcado como `chegou` ao chegar endereço no destinatário
- A partir daí o pedido pode ser:
  - Rejeitado, como ao ter itens faltando ou errados. Podendo então ser cancelado ou voltar para em preparação aonde voltará ao restaurante para ser corrigido ou refeito
  - Não Atendido, caso o cliente não tenha atendido o chamado do entregador
  - Recebido com sucesso pelo cliente

Os estados finais de um pedido são, então: `Recebido`, `NãoAtendido` e `Cancelado`

Porque `NãoAtendido` e `Cancelado` são estados diferentes? 
A ideia é que `Cancelado` é um estado que demanda uma ação, o cliente ou o restaurante deve explicitamente solicitar um cancelamento
Já `NãoAtendido` é um estado passivo, no caso o Cliente falhou em receber o pedido ou contactar o estabelecimento/entregador sobre aquela entrega num determinado prazo de tempo 