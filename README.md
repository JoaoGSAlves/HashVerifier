# HashVerifier
Avaliação Final da Matéria de Segurança da Informação:
## Questão

Malware são as aplicações maliciosas que possuem uma grande evolução nas últimas décadas. 
Possuindo diversos formatos diferenciados, a evolução destes softwares maliciosos demonstrou a grande capacidade de desenvolvimento que os seus desenvolvedores sempre tiveram.
Da mesma forma, as empresas desenvolvedoras de antivírus sempre tem conseguido frustrar as evoluções destes maléficos desenvolvedores. 

Os primeiros malwares alteravam os códigos binários de aplicações legítimas acrescentando dezenas de linhas de código com ações maliciosas. 
Rapidamente as empresas de segurança desenvolveram técnicas para verificar se algum arquivo havia sido modificado de forma maliciosa. 
E não apenas isso, eles também conseguiam identificar quais vírus haviam infectado o arquivo, com uma assinatura característica do malware.

Você faz parte desta história e agora poderá demonstrar como esta técnica de proteção pode ter sido desenvolvida. 
Implemente uma ferramenta usando a linguagem Java, e as bibliotecas de segurança necessárias, que permita verificar se os arquivos no computador foram infectados ou não. É importante fazer isso para todos os arquivos em uma pasta do computador.
Como você já é um desenvolvedor que possui conhecimentos avançados, você utilizará o Github para armazenar o seu projeto.
E você enviará para esta avaliação um arquivo no formato PDF contendo o endereço do seu projeto. Embora estejamos falando de aplicações de segurança, como estamos tratando de atividades acadêmicas, o seu projeto deverá estar público para que a avaliação seja realizada.
Não envie código ou projeto. Apenas o endereço do repositório.

### O código apresentado cumpre todos os requisitos acima:
* O código percorre todos os arquivos na pasta especificada e realiza as seguintes verificações:
* Verifica se a pasta fornecida é válida e existe.
* Obtém a lista de arquivos na pasta.
* Para cada arquivo encontrado, verifica se é um arquivo regular.
* Se for um arquivo regular, obtém o seu nome e procura pelo hash correspondente na lista de hashes conhecidos.
* Se o hash correspondente for encontrado, calcula o hash do arquivo atual e o compara com o hash conhecido.
* Se os hashes coincidirem, o arquivo é considerado íntegro. Caso contrário, é considerado modificado ou infectado.
* Dessa forma, o código verifica a integridade dos arquivos na pasta fornecida, identificando qualquer modificação em relação aos hashes conhecidos.
