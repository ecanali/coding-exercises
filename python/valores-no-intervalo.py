programaAtivo = True

de0a100 = []
de101a200 = []
de201a400 = []
maiorDe400 = []

while programaAtivo:
  numeroInformado = int(input('Digite um inteiro positivo (negativo para encerrar): '))

  if numeroInformado >= 0 and numeroInformado <= 100:
    de0a100.append(numeroInformado)
  elif numeroInformado >= 101 and numeroInformado <= 200:
    de101a200.append(numeroInformado)
  elif numeroInformado >= 201 and numeroInformado <= 400:
    de201a400.append(numeroInformado)
  elif numeroInformado > 400:
    maiorDe400.append(numeroInformado)
  else:
    programaAtivo = False
    break

print('Foram digitados', len(de0a100), 'números no intervalo de 0 a 100')
print('Foram digitados', len(de101a200), 'números no intervalo de 101 a 200')
print('Foram digitados', len(de201a400), 'números no intervalo de 201 a 400')
print('Foram digitados', len(maiorDe400), 'números no intervalo de 401 a ∞')