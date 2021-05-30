while True:
  quantidadeIndices = int(input('Digite a quantidade de índices de audiência que serão analisados: '))

  audienciaSempreCrescente = True
  somaAudiencia = 0

  for indice in range(0, quantidadeIndices):
    indiceInformado = float(input('Digite o ' + str(indice + 1) + 'º índice: '))

    if indice == 0:
      maiorIndice = indiceInformado
    else:
      if indiceInformado <= maiorIndice:
        audienciaSempreCrescente = False

    somaAudiencia += indiceInformado

  mediaAudiencia = somaAudiencia / quantidadeIndices

  if audienciaSempreCrescente:
    print('AUDIÊNCIA SEMPRE CRESCENTE. Média de audiência: %.1f' % mediaAudiencia)
  else:
    print('AUDIÊNCIA NEM SEMPRE CRESCENTE. Média de audiência: %.1f' % mediaAudiencia)
  
  resposta = input('Deseja continuar? (S/N) ')
  if resposta == 's' or resposta == 'S':
    continue
  elif resposta == 'n' or resposta == 'N':
    break
  else:
    print('Opção inválida.')
    break

print('Programa finalizado.')