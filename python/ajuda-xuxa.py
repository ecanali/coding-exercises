patinhosInformado = int(input('Digite a quantidade de patinhos: '))

penultimoVerso = '1 patinho foi passear\nAlém das montanhas\nPara brincar\nA mamãe gritou\nQuack quack quack\nMas nenhum patinho\nVoltou de lá\n'

ultimoVerso = 'A mamãe patinha\nFoi procurar\nAlém das montanhas\nNa beira do mar\nA mamãe gritou\nQuack quack quack\nE os ' + str(patinhosInformado) + ' patinhos\nVoltaram de lá'

if patinhosInformado <= 1:
  print('Erro: digite uma quantidade maior que 1, tente novamente')

else:
  patinhos = patinhosInformado

  while patinhos > 1:
    print(str(patinhos) + ' patinhos\nForam passear\nAlém das montanhas\nPara brincar\nA mamãe gritou\nQuack quack quack\nMas só ' + str(patinhos - 1) + ' patinhos\nVoltaram de lá\n')
    patinhos -= 1

  print(penultimoVerso)
  print(ultimoVerso)
