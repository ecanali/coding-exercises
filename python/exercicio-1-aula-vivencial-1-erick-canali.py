programaAtivo = True

while programaAtivo:

  quantidadeIndices = int(input('Digite a quantidade de índices de audiência que serão analisados: '))

  listaIndices = [0]
  listaAnalisada = []
  somaAudiencia = 0

  for indice in range(1, quantidadeIndices + 1):
    indiceInformado = float(input('Digite o ' + str(indice) + 'º índice: '))
    if indiceInformado > listaIndices[-1]:
      listaAnalisada.append(True)
    else:
      listaAnalisada.append(False)
    listaIndices.append(indiceInformado)
    somaAudiencia += indiceInformado

  mediaAudiencia = somaAudiencia / quantidadeIndices

  if False in listaAnalisada:
    print('AUDIÊNCIA NEM SEMPRE CRESCENTE. Média de audiência:', round(mediaAudiencia, 1))
  else:
    print('AUDIÊNCIA SEMPRE CRESCENTE. Média de audiência:', round(mediaAudiencia, 1))
  
  resposta = input('Deseja continuar? (S/N) ')
  if resposta == 's' or resposta == 'S':
    programaAtivo = True
  elif resposta == 'n' or resposta == 'N':
    programaAtivo = False
  else:
    programaAtivo = False
    print('Opção inválida.')

print('Programa finalizado.')
