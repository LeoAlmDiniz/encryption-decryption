#JSON-DATABASE#

###Descrição###
Esta aplicação consiste em um programa simples de criptografia/descriptografia baseado em chave. A ideia do aplicativo é mostrar como um algoritmo simples desse funciona, de modo a esclarecer a mecânica sem necessariamente se aprofundar em algoritmos matemáticos complexos.
O programa recebe os parâmetros de funcionamento via JBeust, ou seja, na forma de argumentos CLI, nomeadamente -mode, -key, -data, -in, -out, -alg.

| CLI arg     | Obligatory? |    Values   |    Description                                                                                                                   |
| ----------- | ----------- | ----------- | -------------------------------------------------------------------------------------------------------------------------------- |
| -mode       |     yes     | enc or dec  | Defines whether it is encrypting or decrypting                                                                                   |
| -key        |     yes     | an integer  | Defines enc/dec key                                                                                                              |
| -data       | when no in  | a string    | Message to be encrypted/decrypted. Use either this argument or the -in argument, not both.                                       |
| -in         | when no data| a string    | Filename of a file containing a message in the source folder. Use either this argument or the -data argument, not both           |
| -out        |     no      | a string    | Filename of a file in the source folder that will receive result. If no file is especified, the answer is printed in the console |
| -alg        |     no      |shift/unicode| A algorithm of encryption/decryption. Two avaliable: alphabet shift or unicode.                                                  | 


###RELEASE 0.0.1###
JBeust args. Ainda vai ser alterado por um sistema frontend de interação.