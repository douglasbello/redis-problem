<h2>Redis Problem</h2>

<p>
Aqui está um problema interessante para resolver utilizando Redis:

Problema: Implementar um Sistema de Rate Limiting (Limitação de Taxa)
Cenário: Você está desenvolvendo uma API que serve milhares de solicitações por segundo. Para evitar abuso do sistema e garantir que os usuários não sobrecarreguem o serviço com requisições excessivas, você deseja implementar uma solução de rate limiting.

O sistema deve permitir que:

Cada usuário autenticado possa fazer até 100 solicitações por minuto.
Se o limite for excedido, a API deve retornar uma mensagem de erro informando que o usuário atingiu o limite de requisições, e ele deverá aguardar até o próximo minuto para continuar.
Requisitos:

Use Redis para armazenar o número de solicitações de cada usuário.
Implemente uma política que reinicie o contador de requisições a cada minuto.
Forneça uma mensagem clara de quando o limite de requisições for atingido.
Como resolver:
Quando um usuário fizer uma requisição, verifique se ele já fez mais do que o limite permitido de requisições (100 requisições/minuto).
Use o Redis para armazenar um contador para cada usuário, onde a chave pode ser algo como rate_limit:user_id.
Defina uma expiração de 1 minuto no Redis para esse contador, de modo que o número de requisições seja zerado a cada novo minuto.
Se o usuário ultrapassar o limite, retorne uma resposta de erro (HTTP 429 - Too Many Requests).
Caso contrário, incremente o contador e permita a solicitação.
Esse tipo de problema é comum em sistemas que oferecem APIs públicas e precisam gerenciar um grande volume de tráfego de maneira controlada.

Redis é ideal porque:
Ele é rápido, armazenando dados na memória, o que é ótimo para checar limites de requisições em tempo real.
Possui funcionalidades nativas como INCR e EXPIRE, que facilitam a implementação do contador e a definição de tempo de expiração.
Próximos passos:
Implementar a solução utilizando Redis para gerenciar o contador de requisições.
Testar o sistema com diferentes cenários, como múltiplas requisições de usuários em diferentes momentos.
Interessado em implementar ou quer discutir algum detalhe da arquitetura dessa solução?
</p>