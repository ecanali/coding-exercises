quantidadeAtletas = int(input('Digite a quantidade de atletas: '))

nomesAtletas = []
idadeAtletas = []
alturasAtletas = []
somaAlturas = 0.0

for atleta in range(1, quantidadeAtletas + 1):
  nome = input('Qual o nome do atleta nº' + str(atleta) + '? ')
  nomesAtletas.append(nome)
  idade = int(input('Qual a idade do atleta nº' + str(atleta) + '? '))
  idadeAtletas.append(idade)
  altura = float(input('Qual a altura do atleta nº' + str(atleta) + '? '))
  alturasAtletas.append(altura)
  somaAlturas += altura

# Descobre atleta mais velho
atletaMaisVelho = idadeAtletas[0]
for idade in idadeAtletas:
  if idade > atletaMaisVelho:
    atletaMaisVelho = idade

# Descobre média de altura dos atletas
mediaAlturas = somaAlturas / quantidadeAtletas

# Descobre atleta mais baixo
atletaMaisBaixo = alturasAtletas[0]
for altura in alturasAtletas:
  if altura < atletaMaisBaixo:
    atletaMaisBaixo = altura

print('O nome do atleta mais velho é: ' + nomesAtletas[idadeAtletas.index(atletaMaisVelho)])
print('A média de altura dos atletas é: %.2f' % mediaAlturas)
print('O nome do atleta mais baixo é: ' + nomesAtletas[alturasAtletas.index(atletaMaisBaixo)])