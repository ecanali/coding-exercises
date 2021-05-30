quantidadeLinhas = int(input('Quantas linhas? '))
quantidadeColunas = int(input('Quantas colunas? '))

for linha in range(0, quantidadeLinhas):
  for coluna in range(0, quantidadeColunas):
    print('*', end="")
  print('\n', end="")
